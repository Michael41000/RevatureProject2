import { Component, OnInit } from '@angular/core';
import { person } from 'src/app/model/person';
import { PersonService } from 'src/app/service/person.service';
import { Subscription } from 'rxjs';
import { GlobalService } from 'src/app/service/global.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private personService: PersonService, private globalService: GlobalService) { }

  ngOnInit() {
  }

  invalidCredentials: boolean = false;
  person: person = new person();
  loginSubscription: Subscription;

  login() {
    this.invalidCredentials = false;
    console.log(this.person.username);
    console.log(this.person.password);
    this.loginSubscription = this.personService.getPersonByUsernameAndPassword(this.person)
      .subscribe(
        (response) => {
          this.globalService.currentPerson = response;
          console.log(this.globalService.currentPerson);
        },
        (response) => {
          this.invalidCredentials = true;
        }
      );
  }

  ngOnDestory() {
    this.loginSubscription.unsubscribe();
  }

}
