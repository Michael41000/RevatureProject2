import { Component, OnInit } from "@angular/core";
import { GoogleService } from "src/app/service/google.service";
import { SignupcontrollerService } from "src/app/service/signupcontroller.service";
import { location } from "src/app/model/location";
import { person } from "src/app/model/person";
import { Router } from '@angular/router';

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
  ) {}

  ngOnInit() {}

  streetAddress: string;
  city: string;
  zipcode: number;
  state: string;
  invalidInputs: boolean = false;
  validation: string = "Some fields are empty";
  lat: number;
  long: number;
  locationid: number;
  name: string;
  location: location;
  person: person = new person();

  createAccount() {
    this.validateInputs();
    this.googleService
      .addressToCoordinates(
        this.streetAddress,
        this.city,
        this.state,
        this.zipcode
      )
      .subscribe(response => {
        console.log(response);
        this.lat = response.results[0].geometry.location.lat;
        this.long = response.results[0].geometry.location.lng;
        this.name = `${this.streetAddress}, ${this.city} ${this.state} ${this.zipcode}`;
        this.location = new location(null, this.lat, this.long, this.name);
        console.log(this.name);
        this.locationService.addLocation(this.location).subscribe(response => {
          console.log(response);
          this.person.location = response;
          console.log(this.person);
          this.locationService.addPerson(this.person).subscribe(response => {
            console.log(response);
            this.router.navigate(["login"]).then( (e) => {
              if (e) {
                console.log("Navigation is successful!");
              } else {
                console.log("Navigation has failed!");
              }
            });
          });
        });
      });
  }

  validateInputs() {
    if (
      this.person.username == undefined ||
      this.person.password == undefined ||
      this.person.firstName == undefined ||
      this.person.lastName == undefined ||
      this.streetAddress == undefined ||
      this.city == undefined ||
      this.zipcode == undefined ||
      this.state == undefined ||
      this.person.username === "" ||
      this.person.password === "" ||
      this.person.firstName === "" ||
      this.person.lastName === "" ||
      this.streetAddress === "" ||
      this.city === "" ||
      this.state === "" ||
      this.zipcode == null
    ) {
      this.invalidInputs = true;
    } else {
      this.invalidInputs = false;
    }
  }
}
