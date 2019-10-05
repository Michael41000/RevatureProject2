import { topping } from './topping';
import { location } from './location';
import { store } from './store';

export class inventoryItem {

    iiId: number;
    topping: topping;
    amountLeft: number;
    price: number;
    location: location;
    store: store;

    constructor(iiId: number, topping: topping, amountLeft: number, price: number, location: location, store: store) {
        this.iiId = iiId;
        this.topping = topping;
        this.amountLeft = amountLeft;
        this.price = price;
        this.location = location;
        this.store = store;
    }


}