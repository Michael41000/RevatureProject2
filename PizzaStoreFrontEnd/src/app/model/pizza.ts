import { psize } from './psize';
import { pizzaInventoryItem } from './pizzaInventoryItem';

export class pizza {

    pizzaId: number;
    psize: psize;
    specialty: boolean;
    inventoryItems: pizzaInventoryItem[];

    constructor(pizzaId: number, psize: psize, isSpecialty: boolean, inventoryItems: pizzaInventoryItem[]) {
        this.pizzaId = pizzaId;
        this.psize = psize;
        this.specialty = isSpecialty;
        this.inventoryItems = inventoryItems;
    }

}