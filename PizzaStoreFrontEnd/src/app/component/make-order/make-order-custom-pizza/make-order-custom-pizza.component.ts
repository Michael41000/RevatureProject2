import { Component, OnInit } from '@angular/core';
import { PsizeService } from 'src/app/service/psize.service';
import { psize } from 'src/app/model/psize';
import { ActivatedRoute, Router } from '@angular/router';
import { InventoryitemService } from 'src/app/service/inventoryitem.service';
import { ToppingTypeService } from 'src/app/service/topping-type.service';
import { toppingtype } from 'src/app/model/toppingtype';
import { inventoryItem } from 'src/app/model/inventoryItem';
import { pizza } from 'src/app/model/pizza';
import { pizzaInventoryItem } from 'src/app/model/pizzaInventoryItem';
import { GlobalService } from 'src/app/service/global.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-make-order-custom-pizza',
  templateUrl: './make-order-custom-pizza.component.html',
  styleUrls: ['./make-order-custom-pizza.component.css']
})
export class MakeOrderCustomPizzaComponent implements OnInit {

  constructor(private psizeService: PsizeService,
    private route: ActivatedRoute,
    private inventoryItemService: InventoryitemService,
    private toppingtypeService: ToppingTypeService,
    private globalService: GlobalService,
    private router: Router) { }

  ngOnInit() {
    this.route.parent.params.subscribe(params => {
      this.storeId = +params.id;
      this.getToppingTypes();

    })
    this.getSizes();

  }

  psizes: psize[] = [];
  toppingtypes: toppingtype[] = [];
  allInventoryItems: inventoryItem[] = [];
  toppingTypeInventoryItem: Map<number, inventoryItem[]> = new Map();
  pizzaIngredients: pizzaInventoryItem[] = [];

  storeId: number;

  subs: Subscription = new Subscription();

  getSizes() {
    this.subs.add(this.psizeService.getPSizes().subscribe(
      (response) => {
        console.log(response);
        this.psizes = response;
      }
    ));
  }

  getInventoryItemsByStore() {
    this.subs.add(this.inventoryItemService.getInventoryItemsByStore(this.storeId).subscribe(
      (response) => {
        console.log(response);
        this.allInventoryItems = response;

        for (let i = 0; i < this.toppingtypes.length; i++) {
          this.toppingTypeInventoryItem.set(this.toppingtypes[i].ttId, []);
          for (let j = 0; j < response.length; j++) {
            if (response[j].topping.type.ttId === this.toppingtypes[i].ttId) {
              this.toppingTypeInventoryItem.get(this.toppingtypes[i].ttId).push(response[j]);
            }
          }
        }

        console.log(this.toppingTypeInventoryItem);


      }
    ));
  }

  showInventoryItemsByTopping(toppingtype: any) {
    toppingtype.visible = true;

  }

  hideInventoryItemsByTopping(toppingtype: any) {
    toppingtype.visible = undefined;

  }

  getToppingTypes() {
    this.subs.add(this.toppingtypeService.getToppingTypes().subscribe(
      (response) => {
        console.log(response);
        this.toppingtypes = response;
        this.getInventoryItemsByStore();
      }
    ));
  }

  addToPizza(inventoryItemPassed: any, psizeIndex: number) {
    console.log("AddtoPizza");
    console.log(inventoryItemPassed);
    console.log(psizeIndex);
    inventoryItemPassed.buttonAdd = true;
    const newInventoryItem = new inventoryItem(inventoryItemPassed.iiId, inventoryItemPassed.topping, inventoryItemPassed.amountLeft, inventoryItemPassed.price, inventoryItemPassed.location, inventoryItemPassed.store)
    const newPizzaInventoryItem = new pizzaInventoryItem(null, newInventoryItem, this.psizes[psizeIndex])
    this.pizzaIngredients.push(newPizzaInventoryItem);
    console.log(this.pizzaIngredients);
  }

  removeToPizza(inventoryItemPassed: any) {
    console.log("Removetopizza");
    inventoryItemPassed.buttonAdd = undefined;
    this.pizzaIngredients = this.pizzaIngredients.filter(item => item.inventoryItem.iiId != inventoryItemPassed.iiId);
    console.log(this.pizzaIngredients);
  }

  addPizzaToOrder(pizzaSizeIndex: number) {
    const newPizza = new pizza(null, this.psizes[pizzaSizeIndex], false, this.pizzaIngredients)
    this.globalService.currentOrder.pizzasInOrder.push(newPizza);
    this.router.navigate([`makeOrder/currentOrder`]).then((e) => {
      if (e) {
        console.log("Navigation is successful!");
      } else {
        console.log("Navigation has failed!");
      }
    });
  }

  calculatePizzaPrice(pizzaSizeIndex: number) {

    let basePrice = 0;

    for (let i = 0; i < this.pizzaIngredients.length; i++) {
      basePrice += this.pizzaIngredients[i].inventoryItem.price * this.pizzaIngredients[i].amount.multiplier;
    }

    if (this.psizes[pizzaSizeIndex] !== undefined) {
      basePrice *= this.psizes[pizzaSizeIndex].multiplier;
    }

    return basePrice;
  }

  calculateCalories(pizzaSizeIndex: number) {

    let baseCalories = 0;

    for (let i = 0; i < this.pizzaIngredients.length; i++) {
      baseCalories += this.pizzaIngredients[i].inventoryItem.topping.calories * this.pizzaIngredients[i].amount.multiplier;
    }
    if (this.psizes[pizzaSizeIndex] !== undefined) {
      baseCalories *= this.psizes[pizzaSizeIndex].multiplier;
    }

    return baseCalories;
  }

  calculateInventoryItemPrice(inventoryItem: inventoryItem, psizeIndex: number) {
    console.log(psizeIndex);
    return inventoryItem.price * this.psizes[psizeIndex].multiplier;
  }

  ngOnDestory() {
    this.subs.unsubscribe();
  }
}
