import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RowDetailComponent } from './row-detail/row-detail.component';
import { RouterModule, Routes } from '@angular/router';
import { BalanceRowComponent } from './balance-row/balance-row.component';
import { DashboardComponent } from './dashboard/dashboard.component'

const routes: Routes = [
  { path: 'rows', component: BalanceRowComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'detail/:uuid2', component: RowDetailComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
