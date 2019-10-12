import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { SignupComponent } from './component/signup/signup.component';
import { ProfileComponent } from './component/profile/profile.component';
import { StoresComponent } from './component/stores/stores.component';
import { HomepageComponent } from './component/homepage/homepage.component';
import { OrderhistoryComponent } from './component/orderhistory/orderhistory.component';


const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "signup", component: SignupComponent },
  { path: "profile", component: ProfileComponent },
  { path: "stores", component: StoresComponent },
  { path: "homepage", component: HomepageComponent },
  { path: "orderhistory", component: OrderhistoryComponent },
  { path: "", redirectTo: "/login", pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
