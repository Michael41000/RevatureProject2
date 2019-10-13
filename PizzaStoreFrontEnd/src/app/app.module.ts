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
import { HomepageComponent } from './component/homepage/homepage.component';
import { OrderhistoryComponent } from './component/orderhistory/orderhistory.component';
import { PizzaComponent } from './component/pizza/pizza.component';
import { ManageSpecialtyPizzaComponent } from './component/manage-specialty-pizza/manage-specialty-pizza.component';
import { AddPizzaComponent } from './component/manage-specialty-pizza/add-pizza/add-pizza.component';
import { ListPizzasComponent } from './component/manage-specialty-pizza/list-pizzas/list-pizzas.component';
import { ManageSpecialtyPizzaRoutingModule } from './component/manage-specialty-pizza/manage-specialty-pizza-routing.module';
import { EditPizzaComponent } from './component/manage-specialty-pizza/edit-pizza/edit-pizza.component';
import { AddCouponComponent } from './component/make-order/add-coupon/add-coupon.component';
import { FavoritesComponent } from './component/favorites/favorites.component';
import { FavoritesRoutingModule } from './component/favorites/favorites-routing.module';
import { ListFavoritesComponent } from './component/favorites/list-favorites/list-favorites.component';
import { EditFavoritesComponent } from './component/favorites/edit-favorites/edit-favorites.component';

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
    MakeOrderUpdateCustomPizzaComponent,
    HomepageComponent,
    OrderhistoryComponent,
    PizzaComponent,
    ManageSpecialtyPizzaComponent,
    AddPizzaComponent,
    ListPizzasComponent,
    EditPizzaComponent,
    AddCouponComponent,
    FavoritesComponent,
    ListFavoritesComponent,
    EditFavoritesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    StoreRoutingModule,
    MakeOrderRoutingModule,
    ManageSpecialtyPizzaRoutingModule,
    FavoritesRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
