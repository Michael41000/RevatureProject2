import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MakeOrderComponent } from './make-order.component';
import { MakeOrderStoresComponent } from './make-order-stores/make-order-stores.component';
import { MakeOrderStoreComponent } from './make-order-store/make-order-store.component';
import { MakeOrderSpecialtyPizzaComponent } from './make-order-specialty-pizza/make-order-specialty-pizza.component';
import { MakeOrderCurrentOrderComponent } from './make-order-current-order/make-order-current-order.component';
import { MakeOrderCustomPizzaComponent } from './make-order-custom-pizza/make-order-custom-pizza.component';
import { MakeOrderUpdateCustomPizzaComponent } from './make-order-update-custom-pizza/make-order-update-custom-pizza.component';
import { AddCouponComponent } from './add-coupon/add-coupon.component';

const makeOrderRoutes: Routes = [
    {
        path: 'makeOrder', component: MakeOrderComponent, children: [
            { path: 'stores', component: MakeOrderStoresComponent },
            {
                path: 'store/:id', component: MakeOrderStoreComponent, children: [
                    { path: 'specialtyPizza', component: MakeOrderSpecialtyPizzaComponent },
                    { path: 'customPizza', component: MakeOrderCustomPizzaComponent },
                ]
            },
            {
                path: 'currentOrder', component: MakeOrderCurrentOrderComponent
            },
            {
                path: 'customPizza/:id', component: MakeOrderUpdateCustomPizzaComponent
            },
            {
                path: 'coupons', component: AddCouponComponent
            }
        ]
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(makeOrderRoutes)
    ],
    exports: [
        RouterModule
    ]
})
export class MakeOrderRoutingModule { }