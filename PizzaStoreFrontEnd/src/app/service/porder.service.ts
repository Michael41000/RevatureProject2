import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GlobalService } from './global.service';
import { porder } from '../model/porder';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PorderService {

  constructor(private http: HttpClient, private globalService: GlobalService) { }

  getPOrdersByStore(storeId: number) : Observable<porder[]> {
    return this.http.get<porder[]>(`${this.globalService.hostName}/porders?store=${storeId}`);
  }

  createPOrder(porder: porder) : Observable<porder> {
    return this.http.post<porder>(`${this.globalService.hostName}/porders`, porder);
  }
}
