import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsComponent} from './products/products.component';
import {CustomersComponent} from './customers/customers.component';
import {BillingsComponent} from './billings/billings.component';
import {BillingDetailsComponent} from './billing-details/billing-details.component';
import {BillingCustomerComponent} from './billing-customer/billing-customer.component';

const routes: Routes = [
  { path : "products", component : ProductsComponent },
  { path : "customers", component : CustomersComponent },
  { path : "billing", component : BillingsComponent },
  { path : "billing-Customer/:customerId", component : BillingCustomerComponent },
  { path : "billing-Details/:billId", component : BillingDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
