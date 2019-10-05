import { person } from './person';
import { store } from './store';
import { coupon } from './coupon';
import { pizza } from './pizza';

export class porder {

    porderId: number;
    person: person;
    store: store;
    minutesToMake: number;
    timeOrdered: Date;
    coupon: coupon;
    pizzasInOrder: pizza[];

    constructor(porderId: number, person: person, store: store, minutesToMake: number, timeOrdered: Date, coupon: coupon, pizzasInOrder: pizza[]) {
        this.porderId = porderId;
        this.person = person;
        this.store = store;
        this.minutesToMake = minutesToMake;
        this.timeOrdered = timeOrdered;
        this.coupon = coupon;
        this.pizzasInOrder = pizzasInOrder;
    }

}