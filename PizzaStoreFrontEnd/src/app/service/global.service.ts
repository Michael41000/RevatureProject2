import { Injectable } from '@angular/core';
import { person } from '../model/person';
import { porder } from '../model/porder';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {

  constructor() { 
    if (this.isProduction) {
      this.hostName = "http://ec2-18-191-172-174.us-east-2.compute.amazonaws.com:8888"
    }
    else {
      this.hostName = "http://localhost:8080";
    }
  }

  currentPerson: person;
  currentOrder: porder;
  hostName: string;
  isProduction: boolean = false;

  
}
