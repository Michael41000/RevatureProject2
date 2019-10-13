import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { person } from '../model/person';
import { Observable } from 'rxjs';
import { location } from '../model/location';
import { GlobalService } from './global.service';
@Injectable({
  providedIn: 'root'
})
export class SignupcontrollerService {

  constructor(private http: HttpClient, private globalService: GlobalService) { }

  addPerson(person: person): Observable<person> {
    return this.http.post<person>(`${this.globalService.hostName}/persons`, person)
  }

  addLocation(location: location): Observable<location> {
    return this.http.post<location>(`${this.globalService.hostName}/locations`, location)
  }
}
