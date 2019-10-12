import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GlobalService } from './global.service';
import { porder } from '../model/porder';
import { Observable } from 'rxjs';
import { inventoryItem } from '../model/inventoryItem';

@Injectable({
  providedIn: 'root'
})
export class PorderService {

  constructor(private http: HttpClient, private globalService: GlobalService) { }

  getPOrdersByStore(storeId: number) : Observable<porder[]> {
    return this.http.get<porder[]>(`${this.globalService.hostName}/porders?store=${storeId}`);
  }

  getPOrdersByPersonId(personId: number) : Observable<porder[]>{
    // return this.http.get<porder[]>(`${this.globalService.hostName}/porders?personId=${personId}`);
    return this.http.get<porder[]>(`http://localhost:8080/porders?personId=1`);
  }


}
