import { Component, OnInit } from '@angular/core';
import { GlobalService } from 'src/app/service/global.service';
import { SpecialtypizzaService } from 'src/app/service/specialtypizza.service';
import { pizza } from 'src/app/model/pizza';
import { Observable } from 'rxjs';
import { HighlightDelayBarrier } from 'blocking-proxy/built/lib/highlight_delay_barrier';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private globalService: GlobalService, private specialtyPizza : SpecialtypizzaService) { }

  ngOnInit() {
    this.SpecialtyPizza();
  }

  allSPizza : pizza[] = [];
  allSpecialty : Observable<pizza[]> = this.specialtyPizza.getAllSpecialtyPizza();

  SpecialtyPizza(){
    this.allSpecialty.subscribe(
      (response)=>{
        console.log(response);
        this.allSPizza = response;
      }
    );
  }

  toppingTotalCalories(pizzaC : pizza){
    let totalCalories : number = 0;

    for (let c of pizzaC.inventoryItems){
      totalCalories += (c.inventoryItem.topping.calories * c.amount.multiplier);
    }
    return totalCalories * pizzaC.psize.multiplier;
  }

  toppingTotalPrice(pizzaT : pizza){
    let total : number = 0; 

    for (let i of pizzaT.inventoryItems){
      total = total + (i.amount.multiplier * i.inventoryItem.price); 
    }

    return total * pizzaT.psize.multiplier; 
  }

  show(pizza : any){
    pizza.visible = true;
  }
  
  
  hide(pizza : any){
    pizza.visible = undefined;
  }
}


