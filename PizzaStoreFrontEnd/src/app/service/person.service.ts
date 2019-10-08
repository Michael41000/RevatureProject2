import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { person } from '../model/person';
import { GlobalService } from './global.service';

@Injectable({
  providedIn: 'root'
})
export class PersonService {


  constructor(private http : HttpClient, private globalService : GlobalService) { }

  getPersonByUsernameAndPassword(person: person) : Observable<person> {
    return this.http.post<person>(`${this.globalService.hostName}/persons/login`, person);
  };

}
