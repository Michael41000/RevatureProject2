import { psize } from './psize';
import { pizzaInventoryItem } from './pizzaInventoryItem';

export class pizza {

    pizzaId: number;
    psize: psize;
    isSpecialty: boolean;
    inventoryItems: pizzaInventoryItem[];

    constructor(pizzaId: number, psize: psize, isSpecialty: boolean, inventoryItems: pizzaInventoryItem[]) {
        this.pizzaId = pizzaId;
        this.psize = psize;
        this.isSpecialty = isSpecialty;
        this.inventoryItems = inventoryItems;
    }

}