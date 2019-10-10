import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GlobalService } from './global.service';
import { Observable } from 'rxjs';
import { location } from '../model/location';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private http : HttpClient, private globalService : GlobalService) { }

  updateLocation(location: location) : Observable<location> {
    return this.http.put<location>(`${this.globalService.hostName}/locations/${location.locationId}`, location);
  };
}
