export class location {

    locationId: number;
    latitude: number;
    longitude: number;
    name: string;

    constructor(locationId: number, latitude: number, longitude: number, name: string) {
        this.locationId = locationId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }
}