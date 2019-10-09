import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {person} from '../model/person';
import { Observable } from 'rxjs';
import { location } from '../model/location';
@Injectable({
  providedIn: 'root'
})
export class SignupcontrollerService {

  constructor(private http:HttpClient) { }
  addPerson(person :person): Observable<person>{
    return this.http.post<person>("http://localhost:8080/persons",person)
    }
    addLocation(location:location):Observable<location>{
      return this.http.post<location>("http://localhost:8080/locations",location)
    }
}
