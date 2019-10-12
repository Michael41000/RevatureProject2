import { inventoryItem } from './inventoryItem';
import { psize } from './psize';
​
export class pizzaInventoryItem {
    piiId: number;
    inventoryItem: inventoryItem;
    amount: psize;
​
​
    constructor(piiId: number, inventoryItem: inventoryItem, amount: psize) {
        this.piiId = piiId;
        this.inventoryItem = inventoryItem;
        this.amount = amount;
    }
}
