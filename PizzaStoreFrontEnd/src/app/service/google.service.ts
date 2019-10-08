import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GoogleService {

  constructor(private http: HttpClient) { }

  apiKey: string = "AIzaSyDTztgokgTSMkNvFVhnxkDLGbRwCH5oFik";

  addressToCoordinates(streetAddress: string = "", city: string = "", state: string = "", zipcode: number = 0): Observable<any> {
    return this.http.get<any>(`https://maps.googleapis.com/maps/api/geocode/json?address=${streetAddress.replace(/ /g, "+")},+${city.replace(/ /g, "+")},+${state.replace(/ /g, "+")}+${zipcode}&key=${this.apiKey}`)
  }

  coordinatesToAddress(latitude: number = 0, longitude: number = 0): Observable<any> {
    return this.http.get<any>(`https://maps.googleapis.com/maps/api/geocode/json?latlng=${latitude},${longitude}&key=${this.apiKey}`)
  }
}