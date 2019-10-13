import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { SignupComponent } from './component/signup/signup.component';
import { ProfileComponent } from './component/profile/profile.component';
import { StoresComponent } from './component/stores/stores.component';
import { CouponsComponent } from './component/coupons/coupons.component';
import { MakeOrderComponent } from './component/make-order/make-order.component';
import { HomepageComponent } from './component/homepage/homepage.component';
import { OrderhistoryComponent } from './component/orderhistory/orderhistory.component';
import { ManageSpecialtyPizzaComponent } from './component/manage-specialty-pizza/manage-specialty-pizza.component';
import { FavoritesComponent } from './component/favorites/favorites.component';


const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "signup", component: SignupComponent },
  { path: "profile", component: ProfileComponent },
  { path: "stores", component: StoresComponent },
  { path: "coupons", component: CouponsComponent },
  { path: "makeOrder", component: MakeOrderComponent },
  { path: "homepage", component: HomepageComponent },
  { path: "orderhistory", component: OrderhistoryComponent },
  { path: 'managespecialtypizzas', component: ManageSpecialtyPizzaComponent },
  { path: 'favorites', component: FavoritesComponent },
  { path: "", redirectTo: "/login", pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
