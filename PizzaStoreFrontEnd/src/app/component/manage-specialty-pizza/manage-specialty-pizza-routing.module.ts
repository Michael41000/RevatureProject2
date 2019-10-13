import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPizzaComponent } from './add-pizza/add-pizza.component';
import { ManageSpecialtyPizzaComponent } from './manage-specialty-pizza.component';
import { ListPizzasComponent } from './list-pizzas/list-pizzas.component';
import { EditPizzaComponent } from './edit-pizza/edit-pizza.component';

const manageSpecialtyPizzaRoutes: Routes = [
    {
        path: 'managespecialtypizzas', component: ManageSpecialtyPizzaComponent, children: [
            { path: 'addpizza', component: AddPizzaComponent },
            { path: 'listpizzas', component: ListPizzasComponent},
            { path: 'editpizza/:id', component: EditPizzaComponent}
        ]
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(manageSpecialtyPizzaRoutes)
    ],
    exports: [
        RouterModule
    ]
})
export class ManageSpecialtyPizzaRoutingModule { }