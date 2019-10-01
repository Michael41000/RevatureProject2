import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  username: string;
  password: string;
  firstName: string;
  lastName: string;
  streetAddress: string;
  city: string;
  zipcode: number;
  state: string;
  invalidInputs: boolean = false;
  validation: string = "Some fields are empty";

  createAccount() {
    console.log(this.username);
    console.log(this.password);
    console.log(this.firstName);
    console.log(this.lastName);
    console.log(this.streetAddress);
    console.log(this.city);
    console.log(this.zipcode);
    console.log(this.state);
    this.validateInputs();
  }

  validateInputs() {
    if (this.username == undefined || this.password == undefined || this.firstName == undefined || this.lastName == undefined || this.streetAddress == undefined ||
      this.city == undefined || this.zipcode == undefined || this.state == undefined || this.username === "" ||
      this.password === "" || this.firstName === "" || this.lastName === "" || this.streetAddress === "" ||
      this.city === "" || this.state === "" || this.zipcode == null) {
      this.invalidInputs = true;
    }
    else {
      this.invalidInputs = false;
    }
  }


}
