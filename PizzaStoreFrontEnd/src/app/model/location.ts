export class location {

    locationId: number;
    latitude: number;
    longitude: number;
    streetAddress: string;
    city: string;
    state: string;
    zipcode: number;
    name: string;

    constructor(locationId?: number, latitude?: number, longitude?: number, streetAddress?: string, city?: string, state?: string, zipcode?: number, name?: string) {
        this.locationId = locationId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.name = name;
    }
}