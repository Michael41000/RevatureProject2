import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { inventoryItem } from '../model/inventoryItem';
import { GlobalService } from './global.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InventoryitemService {

  constructor(private http: HttpClient, private globalService: GlobalService) { }

  getInventoryItemsByStore(storeId: number) : Observable<inventoryItem[]> {
    return this.http.get<inventoryItem[]>(`${this.globalService.hostName}/inventoryitems?store=${storeId}`);
  }

  updateInventoryItem(inventoryItem: inventoryItem) : Observable<inventoryItem> {
    return this.http.put<inventoryItem>(`${this.globalService.hostName}/inventoryitems/${inventoryItem.iiId}`, inventoryItem);
  }

}
