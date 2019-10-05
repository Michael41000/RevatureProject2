import { location } from './location';

export class store {

    storeId: number;
    location: location;

    constructor(storeId: number, location: location) {
        this.storeId = storeId;
        this.location = location;
    }

}