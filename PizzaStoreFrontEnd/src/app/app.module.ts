import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { SignupComponent } from './component/signup/signup.component';
import { ProfileComponent } from './component/profile/profile.component';
import { StoresComponent } from './component/stores/stores.component';
import { StoreComponent } from './component/store/store.component';
import { StoreOrdersComponent } from './component/store/store-orders/store-orders.component';
import { StoreRoutingModule } from './component/store/store-routing.module';
import { StoreInventoryComponent } from './component/store/store-inventory/store-inventory.component';
import { CouponsComponent } from './component/coupons/coupons.component';
import { MakeOrderComponent } from './component/make-order/make-order.component';
import { MakeOrderRoutingModule } from './component/make-order/make-order-routing.module';
import { MakeOrderStoresComponent } from './component/make-order/make-order-stores/make-order-stores.component';
import { MakeOrderStoreComponent } from './component/make-order/make-order-store/make-order-store.component';
import { MakeOrderSpecialtyPizzaComponent } from './component/make-order/make-order-specialty-pizza/make-order-specialty-pizza.component';
import { MakeOrderCurrentOrderComponent } from './component/make-order/make-order-current-order/make-order-current-order.component';
import { MakeOrderCustomPizzaComponent } from './component/make-order/make-order-custom-pizza/make-order-custom-pizza.component';
import { MakeOrderUpdateCustomPizzaComponent } from './component/make-order/make-order-update-custom-pizza/make-order-update-custom-pizza.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    ProfileComponent,
    StoresComponent,
    StoreComponent,
    StoreOrdersComponent,
    StoreInventoryComponent,
    CouponsComponent,
    MakeOrderComponent,
    MakeOrderStoresComponent,
    MakeOrderStoreComponent,
    MakeOrderSpecialtyPizzaComponent,
    MakeOrderCurrentOrderComponent,
    MakeOrderCustomPizzaComponent,
    MakeOrderUpdateCustomPizzaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    StoreRoutingModule,
    MakeOrderRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
