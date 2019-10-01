import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  username: string;
  password: string;
  validation: string = "All 2 fields are required";
  invalidInputs: boolean = false;

  login() {
    console.log("It works");
    console.log(this.username);
    console.log(this.password);
    this.validateInputFields();
  }

  validateInputFields() {
    if (this.username == undefined || this.password == undefined ||
      this.username === "" || this.password === "") {
      this.invalidInputs = true;
    }
    else {
      this.invalidInputs = false;
    }
  }

}
