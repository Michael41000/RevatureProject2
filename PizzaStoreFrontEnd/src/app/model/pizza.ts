import { psize } from './psize';

export class pizza {

    pizzaId: number;
    psize: psize;
    isSpecialty: boolean;

    constructor(pizzaId: number, psize: psize, isSpecialty: boolean) {
        this.pizzaId = pizzaId;
        this.psize = psize;
        this.isSpecialty = isSpecialty;
    }

}