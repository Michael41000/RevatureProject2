import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GlobalService } from './global.service';
import { Observable } from 'rxjs';
import { store } from '../model/store';
import { porder } from '../model/porder';

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  constructor(private http: HttpClient, private globalService: GlobalService) { }

  getAllStores() : Observable<store[]> {
    return this.http.get<store[]>(`${this.globalService.hostName}/stores`);
  };

  getStore(storeId: number) : Observable<store> {
    return this.http.get<store>(`${this.globalService.hostName}/stores/${storeId}`);
  };
}
