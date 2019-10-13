import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FavoritesComponent } from './favorites.component';
import { ListFavoritesComponent } from './list-favorites/list-favorites.component';
import { EditFavoritesComponent } from './edit-favorites/edit-favorites.component';

const favoritesRoutes: Routes = [
    {
        path: 'favorites', component: FavoritesComponent, children: [
            { path: 'listpizzas', component: ListFavoritesComponent},
            { path: 'editpizza/:id', component: EditFavoritesComponent}
        ]
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(favoritesRoutes)
    ],
    exports: [
        RouterModule
    ]
})
export class FavoritesRoutingModule { }