import { Component } from '@angular/core';
import { GlobalService } from './service/global.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private globalService: GlobalService){}

  title = 'Locally Sourced Organic Pizza Store';

  logout(){
    this.globalService.currentPerson = undefined;
  }



}


