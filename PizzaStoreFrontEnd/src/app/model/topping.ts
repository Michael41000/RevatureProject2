import { toppingtype } from './toppingtype';

export class topping {

    toppingId: number;
    toppingName: string;
    calories: number;
    type: toppingtype;

    constructor(toppingId: number, toppingName: string, calories: number, type: toppingtype) {
        this.toppingId = toppingId;
        this.toppingName = toppingName;
        this.calories = calories;
        this.type = type;
    }

}