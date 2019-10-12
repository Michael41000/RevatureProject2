import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { SignupComponent } from './component/signup/signup.component';
import { ManagespecpizzaComponent } from './component/managespecpizza/managespecpizza.component';



const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "signup", component: SignupComponent},
  { path: "managespecpizza", component: ManagespecpizzaComponent},
  { path: "", redirectTo: "/login", pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
