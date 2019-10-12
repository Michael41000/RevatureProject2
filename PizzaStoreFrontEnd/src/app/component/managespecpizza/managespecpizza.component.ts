import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { PizzaService } from 'src/app/service/pizza.service';
import { GlobalService } from 'src/app/service/global.service';
import { pizza } from 'src/app/model/pizza';
import { psize } from 'src/app/model/psize';
import { inventoryItem } from 'src/app/model/inventoryItem';
import { pizzaInventoryItem } from 'src/app/model/pizzaInventoryItem';

@Component({
  selector: 'app-managespecpizza',
  templateUrl: './managespecpizza.component.html',
  styleUrls: ['./managespecpizza.component.css']
})
export class ManagespecpizzaComponent implements OnInit {

  constructor(private pizzaService : PizzaService, private globalService : GlobalService) { }

  pizzaId : number;
  pizzaSubscription : Subscription;
  pizzas : pizza[] = [];
  clickedPizzaId : number;
  clickedPizza : pizza;
  i : number = 0;
  newSize : number;
  newTopping : number;
  newIIId : number;
  // newPII : pizzaInventoryItem;
  psizes : psize[] = [];
  inventoryItems : inventoryItem[] = [];
  sauces : inventoryItem[] = [];
  cheeses : inventoryItem[] = [];
  meats : inventoryItem[] = [];
  vegetables : inventoryItem[] = [];
  herbs : inventoryItem[] = [];

  ngOnInit() {
    this.initialize();
    this.getPSizes();
    this.getInventoryItems();
  }

  createSpecialtyPizza() {
    this.clear();
  }

  updateSpecialtyPizza() {
    this.clear();
    document.getElementById("updateSP").style.display = 'block';
    console.log("update button works");
    this.findPizza();
    console.log(this.clickedPizza);
  }

  findPizza() {
    for (this.i = 0; this.i < this.pizzas.length; this.i++){
      if (this.pizzas[this.i].pizzaId == this.clickedPizzaId){
        this.clickedPizza = this.pizzas[this.i];
      }
    }
  }

  updateSpecialtyPizzaSize(){
    this.newSize = parseInt((<HTMLInputElement> document.getElementById("newSize")).value);
    if (this.newSize == 1){
      this.clickedPizza.psize = this.psizes[0]
    }
    else if (this.newSize == 2){
      this.clickedPizza.psize = this.psizes[1]

    }
    else if (this.newSize == 3){
      this.clickedPizza.psize = this.psizes[2]

    }
    this.pizzaSubscription = this.pizzaService.updatePizza(this.clickedPizzaId, this.clickedPizza)
      .subscribe(
        (response) => {
          console.log(response);
          // this.initialize();
        },
        (response) => {
          console.log("didnt work");
        }
      );
  }
  updateSpecialtyPizzaTopping(){
    if(this.newTopping == 1){
      this.newIIId = parseInt((<HTMLInputElement> document.getElementById("addSauce")).value);
      this.newSize = parseInt((<HTMLInputElement> document.getElementById("sauceToppingSize")).value);
    }
    else if(this.newTopping == 2){
      this.newIIId = parseInt((<HTMLInputElement> document.getElementById("addCheese")).value);
      this.newSize = parseInt((<HTMLInputElement> document.getElementById("cheeseToppingSize")).value);
    }
    else if(this.newTopping == 3){
      this.newIIId = parseInt((<HTMLInputElement> document.getElementById("addMeat")).value);
      this.newSize = parseInt((<HTMLInputElement> document.getElementById("meatToppingSize")).value);
    }
    else if(this.newTopping == 4){
      this.newIIId = parseInt((<HTMLInputElement> document.getElementById("addVegetable")).value);
      this.newSize = parseInt((<HTMLInputElement> document.getElementById("vegetableToppingSize")).value);
    }
    else if(this.newTopping == 5){
      this.newIIId = parseInt((<HTMLInputElement> document.getElementById("addHerb")).value);
      this.newSize = parseInt((<HTMLInputElement> document.getElementById("herbToppingSize")).value);
    }
    // this.newPII.inventoryItem = this.findIIById(this.newIIId);
    // this.newPII.amount = this.psizes[this.newSize - 1];
    // this.newPII.piiId = 0;
    var newPII = new pizzaInventoryItem(null, this.findIIById(this.newIIId),  this.psizes[this.newSize - 1]);
    this.clickedPizza.inventoryItems.push(newPII);
    this.pizzaSubscription = this.pizzaService.updatePizza(this.clickedPizzaId, this.clickedPizza)
      .subscribe(
        (response) => {
          console.log(response);
          // this.initialize();
        },
        (response) => {
          console.log("didnt work");
        }
      );
  }

  findIIById(id : number) : inventoryItem {
    for (this.i = 0; this.i < this.inventoryItems.length; this.i++){
      if (id == this.inventoryItems[this.i].iiId){
        return this.inventoryItems[this.i];
      }
    }
    return;
  }

  getPSizes(){
    this.pizzaSubscription = this.pizzaService.getPSizes()
      .subscribe(
        (response) => {
          this.psizes = <psize[]> response;
          console.log(this.psizes);
        },
        (response) => {
          console.log("didnt work");
        }
      );
  }

  getInventoryItems() {
    this.pizzaSubscription = this.pizzaService.getInventoryItems()
      .subscribe(
        (response) => {
          this.inventoryItems = <inventoryItem[]> response;
          console.log(this.inventoryItems);
          this.sortInventoryItems();
        },
        (response) => {
          console.log("didnt work");
        }
      );
  }

  sortInventoryItems() {
    for (this.i = 0; this.i < this.inventoryItems.length; this.i++){
      if (this.inventoryItems[this.i].topping.type.ttId == 1){
        this.sauces.push(this.inventoryItems[this.i]);
      }
      else if (this.inventoryItems[this.i].topping.type.ttId == 2){
        this.cheeses.push(this.inventoryItems[this.i]);
      }
      else if (this.inventoryItems[this.i].topping.type.ttId == 3){
        this.meats.push(this.inventoryItems[this.i]);
      }
      else if (this.inventoryItems[this.i].topping.type.ttId == 4){
        this.vegetables.push(this.inventoryItems[this.i]);
      }
      else if (this.inventoryItems[this.i].topping.type.ttId == 5){
        this.herbs.push(this.inventoryItems[this.i]);
      }
    }
    // console.log(this.sauces);
    // console.log(this.cheeses);
    // console.log(this.meats);
    // console.log(this.vegetables);
    // console.log(this.herbs);
  }

  deleteSpecialtyPizza() {
    this.clear();
    // document.getElementById("deleteSP").style.display = 'block';
    // console.log("delete button works");
    this.deleteSpecialtyPizzaSubmit();
    
  }


  deleteSpecialtyPizzaSubmit() {
    console.log("here");
    // this.pizzaId = parseFloat((<HTMLInputElement>document.getElementById("pizzaId")).value);
    this.pizzaSubscription = this.pizzaService.deletePizzaById(this.clickedPizzaId)
      .subscribe(
        (response) => {
          // console.log("worked");
          this.initialize();
        },
        (response) => {
          console.log("didnt work");
        }
      );
  }

  onClick(event) {
    // console.log(event);
    // console.log(event.srcElement.attributes.id);
    var idAttr = event.srcElement.attributes.id;
    var value = idAttr.nodeValue;
    // console.log(value);
    this.clickedPizzaId = <number> value.substr(1); 
    // console.log(this.clickedPizzaId);
    if (value[0] == 'u'){
      this.updateSpecialtyPizza();
    }
    else if (value[0] == 'd'){
      this.deleteSpecialtyPizza();
    }
  }
  onClick2(event) {
    // console.log(event);
    // console.log(event.srcElement.attributes.id);
    var idAttr = event.srcElement.attributes.id;
    var value = idAttr.nodeValue;
    // console.log(value);
    this.newTopping = <number> value.substr(1); 
    // console.log(this.clickedPizzaId);
    this.updateSpecialtyPizzaTopping();
  }

  initialize() {
    this.clear();
    document.getElementById("init").style.display = 'block';
    this.pizzaSubscription = this.pizzaService.getAllSpecialtyPizzas()
      .subscribe(
        (response) => {
           this.pizzas = <pizza[]> response;
          console.log(this.pizzas);
        },
        (response) => {
          console.log("didnt work")
        }
      );
  }

  clear() {
    document.getElementById("init").style.display = 'none';
    document.getElementById("createSP").style.display = 'none';
    document.getElementById("updateSP").style.display = 'none';
    document.getElementById("deleteSP").style.display = 'none';
  }

}
