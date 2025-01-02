import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductsComponent } from './products/products.component';
import {provideHttpClient} from '@angular/common/http';
import { CustomersComponent } from './customers/customers.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { BillingsComponent } from './billings/billings.component';
import { BillingDetailsComponent } from './billing-details/billing-details.component';
import { BillingCustomerComponent } from './billing-customer/billing-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    CustomersComponent,
    BillingsComponent,
    BillingDetailsComponent,
    BillingCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [provideHttpClient()],
  bootstrap: [AppComponent]
})
export class AppModule { }
