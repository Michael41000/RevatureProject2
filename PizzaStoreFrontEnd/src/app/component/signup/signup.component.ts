import { Component, OnInit } from "@angular/core";
import { GoogleService } from "src/app/service/google.service";
import { SignupcontrollerService } from "src/app/service/signupcontroller.service";
import { person } from "src/app/model/person";
import { Router } from '@angular/router';
import { location } from 'src/app/model/location';
import { Subscription } from 'rxjs';

@Component({
  selector: "app-signup",
  templateUrl: "./signup.component.html",
  styleUrls: ["./signup.component.css"]
})
export class SignupComponent implements OnInit {
  constructor(
    private googleService: GoogleService,
    private locationService: SignupcontrollerService,
    private router: Router
  ) { }

  ngOnInit() {
    this.person = new person();
    this.person.location = new location();
  }

  invalidInputs: boolean = false;
  validation: string = "Some fields are empty";
  person: person;
  usernameTaken: boolean = false;

  subs: Subscription = new Subscription();


  createAccount() {
    this.validateInputs()
    if (this.invalidInputs === false) {
      this.subs.add(this.googleService
        .addressToCoordinates(
          this.person.location.streetAddress,
          this.person.location.city,
          this.person.location.state,
          this.person.location.zipcode
        )
        .subscribe(response => {
          console.log(response);
          this.person.location.latitude = response.results[0].geometry.location.lat;
          this.person.location.longitude = response.results[0].geometry.location.lng;
          this.person.location.name = `${this.person.location.streetAddress}, ${this.person.location.city} ${this.person.location.state}, ${this.person.location.zipcode}`;
          this.subs.add(this.locationService.addPerson(this.person).subscribe(
            (response) => {
              console.log(response);
              this.router.navigate(["login"]).then((e) => { });
            },
            (response) => {
              this.usernameTaken = true;
            }
          ));
        }));
    }
  }

  validateInputs() {
    if (
      this.person.username == undefined ||
      this.person.password == undefined ||
      this.person.firstName == undefined ||
      this.person.lastName == undefined ||
      this.person.location.streetAddress == undefined ||
      this.person.location.city == undefined ||
      this.person.location.zipcode == undefined ||
      this.person.location.state == undefined ||
      this.person.username === "" ||
      this.person.password === "" ||
      this.person.firstName === "" ||
      this.person.lastName === "" ||
      this.person.location.streetAddress === "" ||
      this.person.location.city === "" ||
      this.person.location.state === "" ||
      this.person.location.zipcode == null
    ) {
      this.invalidInputs = true;
    } else {
      this.invalidInputs = false;
    }
  }

  ngOnDestory() {
    this.subs.unsubscribe();
  }
}
