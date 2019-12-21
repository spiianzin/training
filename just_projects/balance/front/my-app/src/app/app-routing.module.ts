import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RowDetailComponent } from './row-detail/row-detail.component';
import { RouterModule, Routes } from '@angular/router';
import { BalanceRowComponent } from './balance-row/balance-row.component';


const routes: Routes = [
  { path: 'rows', component: BalanceRowComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
