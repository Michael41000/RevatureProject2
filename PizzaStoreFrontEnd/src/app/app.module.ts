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
import { HomepageComponent } from './component/homepage/homepage.component';
import { OrderhistoryComponent } from './component/orderhistory/orderhistory.component';
import { PizzaComponent } from './component/pizza/pizza.component';

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
    HomepageComponent,
    OrderhistoryComponent,
    PizzaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    StoreRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
