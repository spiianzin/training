import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { BalanceRowComponent } from './balance-row/balance-row.component';
import { AppRoutingModule } from './app-routing.module';
import { MessagesComponent }    from './messages/messages.component';
import { RowDetailComponent } from './row-detail/row-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    BalanceRowComponent,
    MessagesComponent,
    RowDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
