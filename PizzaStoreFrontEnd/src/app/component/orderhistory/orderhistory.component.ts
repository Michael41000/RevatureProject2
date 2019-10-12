import { Component, OnInit } from '@angular/core';
import { GlobalService } from 'src/app/service/global.service';
import { porder } from 'src/app/model/porder';
import { Observable } from 'rxjs';
import { PorderService } from 'src/app/service/porder.service';
import { inventoryItem } from 'src/app/model/inventoryItem';
import { InventoryitemService } from 'src/app/service/inventoryitem.service';
import { pizza } from 'src/app/model/pizza';

@Component({
  selector: 'app-orderhistory',
  templateUrl: './orderhistory.component.html',
  styleUrls: ['./orderhistory.component.css']
})
export class OrderhistoryComponent implements OnInit {

  constructor(private globalService: GlobalService, private personOrder: PorderService, private inventoryitem  : InventoryitemService) { }

  ngOnInit() {
    this.allPersonOrder();
  }

  allOrders : porder[] = [];
  allPOrder : Observable<porder[]> = this.personOrder.getPOrdersByPersonId(this.globalService.currentPerson.personId);

  allPizzaInventoryItem : inventoryItem[] = [];
  allPIItem : Observable<inventoryItem[]> = this.inventoryitem.getInventoryItems();


  allPersonOrder(){
    this.allPOrder.subscribe(
      (response)=>{
        console.log(response);
        this.allOrders = response; 
      }
    );
  }

  allInventoryItems(){
    this.allPIItem.subscribe(
      (response)=>{
        console.log(response);
        this.allPizzaInventoryItem = response;
      }
    );
  }

  show(porder : any){
    porder.visible = true;
  }

  hide(porder : any){
    porder.visible = undefined;
  }

  toppingTotalCalories(calories : pizza){
    let totalCalories : number = 0;

    for (let c of calories.inventoryItems){
      totalCalories += (c.inventoryItem.topping.calories * c.amount.multiplier);
    }
    return totalCalories * calories.psize.multiplier;
  }

  toppingTotalPrice(pizzaPast : pizza){
    let total : number = 0; 

    for (let i of pizzaPast.inventoryItems){
      total = total + (i.amount.multiplier * i.inventoryItem.price); 
    }

    return total * pizzaPast.psize.multiplier; 
  }

}
