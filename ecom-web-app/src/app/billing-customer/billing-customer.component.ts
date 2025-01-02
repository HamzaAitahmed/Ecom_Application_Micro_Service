import {Component, OnInit} from '@angular/core';
import {Billing} from '../model/billing.model';
import {HttpClient} from '@angular/common/http';
import {BillingService} from '../Services/billing.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-billing-customer',
  standalone: false,

  templateUrl: './billing-customer.component.html',
  styleUrl: './billing-customer.component.css'
})
export class BillingCustomerComponent implements OnInit{
  public billsNotFiltred: any;
  public bills: Array<Billing> = [];
  public customerId: number

  constructor(private http:HttpClient, private billService:BillingService, private router:Router ,private route:ActivatedRoute) {
    this.customerId = route.snapshot.params['customerId']
  }

  ngOnInit(): void {
    this.getBillByCustomer(this.customerId);
  }

  getBillByCustomer(customerId:number){
    this.billService.getBillByCustomer(customerId).subscribe({
      next : data => {
        console.log("data : ")
        console.log(data)
        this.billsNotFiltred = data;
        this.bills = this.billsNotFiltred._embedded.bills;
        console.log("this.bills : ")
        console.log(this.bills)
      },
      error : (err)=>{}
    });
  }

  gotoBillDetails(bill:Billing)
  {
    this.router.navigateByUrl("/billing-Details/"+bill.id)
  }

  deleteBill(bill: Billing) {
    this.billService.deleteBilling(bill).subscribe({
      next : data => {
        let index = this.bills.indexOf(data)
        this.bills.splice(index,1) ;
      },
      error : (err)=>{ }
    });
  }

}
