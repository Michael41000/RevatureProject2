import { Component, OnInit } from '@angular/core';
import { GlobalService } from './service/global.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  constructor(private globalService: GlobalService, private router: Router){}

  ngOnInit() {
    if (this.globalService.currentPerson === undefined) {
      this.router.navigate([`login`]).then( (e) => {
        if (e) {
          console.log("Navigation is successful!");
        } else {
          console.log("Navigation has failed!");
        }
      });
    }
  }

  title = 'Locally Sourced Organic Pizza Store';

  logout(){
    this.globalService.currentPerson = undefined;
    this.globalService.currentOrder = undefined;
  }



}


