import { Routes } from '@angular/router';
import { TaskComponent } from './task/task.component';
import { DepartamentComponent } from './departament/departament.component';

export const routes: Routes = [
    { path: '', loadChildren: () => import('./appbar/appbar.module.module').then(m => m.AppbarModuleModule) },  
];
