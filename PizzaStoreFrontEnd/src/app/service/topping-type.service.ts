import { Injectable } from '@angular/core';
import { GlobalService } from './global.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { toppingtype } from '../model/toppingtype';

@Injectable({
  providedIn: 'root'
})
export class ToppingTypeService {

  constructor(private globalService: GlobalService, private http: HttpClient) { }

  getToppingTypes(): Observable<toppingtype[]> {
    return this.http.get<toppingtype[]>(`${this.globalService.hostName}/toppingtypes`)
  }
}
