import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StoreComponent } from './store.component';
import { StoreOrdersComponent } from './store-orders/store-orders.component';
import { StoreInventoryComponent } from './store-inventory/store-inventory.component';

const storeRoutes: Routes = [
    { path: 'store/:id', component: StoreComponent, children: [
            { path: 'orders', component: StoreOrdersComponent },
            { path: 'inventory', component: StoreInventoryComponent }
        ]
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(storeRoutes)
    ],
    exports: [
        RouterModule
    ]
})
export class StoreRoutingModule { }