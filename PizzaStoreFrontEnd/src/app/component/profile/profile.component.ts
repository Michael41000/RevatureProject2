import { Component, OnInit } from '@angular/core';
import { person } from 'src/app/model/person';
import { location } from 'src/app/model/location';
import { GlobalService } from 'src/app/service/global.service';
import { GoogleService } from 'src/app/service/google.service';
import { LocationService } from 'src/app/service/location.service';
import { PersonService } from 'src/app/service/person.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private globalService: GlobalService,
    private googleService: GoogleService,
    private locationService: LocationService,
    private personService: PersonService) { }

  ngOnInit() {

  }

  invalidInputs: boolean = false;
  validation: string = "Some fields are empty";

  updateProfile() {
    this.validateInputs();
    if (this.invalidInputs === false) {
      this.googleService
        .addressToCoordinates(
          this.globalService.currentPerson.location.streetAddress,
          this.globalService.currentPerson.location.city,
          this.globalService.currentPerson.location.state,
          this.globalService.currentPerson.location.zipcode
        )
        .subscribe(response => {
          console.log(response);
          this.globalService.currentPerson.location.latitude = response.results[0].geometry.location.lat;
          this.globalService.currentPerson.location.longitude = response.results[0].geometry.location.lng;
          this.globalService.currentPerson.location.name = `${this.globalService.currentPerson.location.streetAddress}, ${this.globalService.currentPerson.location.city} ${this.globalService.currentPerson.location.state}, ${this.globalService.currentPerson.location.zipcode}`;
          this.personService.updatePerson(this.globalService.currentPerson).subscribe(
            (response) => {
              console.log(response);
            });
        });
    }
  }

  validateInputs() {
    if (
      this.globalService.currentPerson.username == undefined ||
      this.globalService.currentPerson.password == undefined ||
      this.globalService.currentPerson.firstName == undefined ||
      this.globalService.currentPerson.lastName == undefined ||
      this.globalService.currentPerson.location.streetAddress == undefined ||
      this.globalService.currentPerson.location.city == undefined ||
      this.globalService.currentPerson.location.zipcode == undefined ||
      this.globalService.currentPerson.location.state == undefined ||
      this.globalService.currentPerson.username === "" ||
      this.globalService.currentPerson.password === "" ||
      this.globalService.currentPerson.firstName === "" ||
      this.globalService.currentPerson.lastName === "" ||
      this.globalService.currentPerson.location.streetAddress === "" ||
      this.globalService.currentPerson.location.city === "" ||
      this.globalService.currentPerson.location.state === "" ||
      this.globalService.currentPerson.location.zipcode == null
    ) {
      this.invalidInputs = true;
    } else {
      this.invalidInputs = false;
    }
  }

}
