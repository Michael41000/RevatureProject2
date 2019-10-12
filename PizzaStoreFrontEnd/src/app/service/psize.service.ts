import { Injectable } from '@angular/core';
import { GlobalService } from './global.service';
import { Observable } from 'rxjs';
import { psize } from '../model/psize';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PsizeService {

  constructor(private globalService: GlobalService, private http: HttpClient) { }

  getPSizes(): Observable<psize[]> {
    return this.http.get<psize[]>(`${this.globalService.hostName}/psizes`)
  }
}
