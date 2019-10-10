import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { InventoryitemService } from 'src/app/service/inventoryitem.service';
import { inventoryItem } from 'src/app/model/inventoryItem';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-store-inventory',
  templateUrl: './store-inventory.component.html',
  styleUrls: ['./store-inventory.component.css']
})
export class StoreInventoryComponent implements OnInit {

  constructor(private route: ActivatedRoute, private inventoryitemService: InventoryitemService) { }

  ngOnInit() {
    this.parentParamSub = this.route.parent.params.subscribe(params => {
      this.storeId = +params["id"];
      this.showInventory();
    });
  }

  inventoryItems: inventoryItem[];
  parentParamSub: Subscription;
  inventoryItemsByStoreSub: Subscription;
  inventoryItemsUpdateSubs: Subscription = new Subscription();
  storeId: number;

  showInventory() {
    this.inventoryItemsByStoreSub = this.inventoryitemService.getInventoryItemsByStore(this.storeId).subscribe(
      (response) => {
        console.log(response);
        this.inventoryItems = response;
      },
      (response) => {

      }
    )
  }

  changeReorder(inventoryItem: any) {
    inventoryItem.reorder = !inventoryItem.reorder;
  }

  confirmOrder(gotInventoryItem: any) {
    console.log(gotInventoryItem.newPrice);
    console.log(gotInventoryItem.orderAmount);
    let updatedInventoryItem: inventoryItem = new inventoryItem();
    updatedInventoryItem.iiId = gotInventoryItem.iiId;
    updatedInventoryItem.topping = gotInventoryItem.topping;
    if (gotInventoryItem.orderAmount !== undefined && gotInventoryItem.orderAmount !== null) {
      if (gotInventoryItem.orderAmount >= 0) {
        updatedInventoryItem.amountLeft = gotInventoryItem.amountLeft + gotInventoryItem.orderAmount;
        console.log("orderamt greater than 0")
      }
    }
    else {
      updatedInventoryItem.amountLeft = gotInventoryItem.amountLeft;
      console.log("orderamt is undefined")
    }
    if (gotInventoryItem.newPrice !== undefined && gotInventoryItem.newPrice !== null) {
      if (gotInventoryItem.price >= 0) {
        updatedInventoryItem.price = gotInventoryItem.newPrice;
        console.log("price greater than 0")
      }
    }
    else {
      updatedInventoryItem.price = gotInventoryItem.price;
      console.log("price is undefined")
    }
    updatedInventoryItem.location = gotInventoryItem.location;
    updatedInventoryItem.store = gotInventoryItem.store;
    


    if ((gotInventoryItem.newPrice !== null || gotInventoryItem.orderAmount !== null) &&
      (gotInventoryItem.newPrice !== undefined || gotInventoryItem.orderAmount !== undefined)) {
        console.log(updatedInventoryItem);
        this.inventoryItemsUpdateSubs.add(this.inventoryitemService.updateInventoryItem(updatedInventoryItem).subscribe(
          (response) => {
            console.log("response");
            console.log(response);
            gotInventoryItem.price = response.price;
            gotInventoryItem.amountLeft = response.amountLeft;
            gotInventoryItem.newPrice = undefined;
            gotInventoryItem.orderAmount = undefined;
            gotInventoryItem.reorder = false;
            
          }
        ))
    }
  }

  ngOnDestroy() {
    this.parentParamSub.unsubscribe();
    this.inventoryItemsByStoreSub.unsubscribe();
    this.inventoryItemsUpdateSubs.unsubscribe();
  }

}
