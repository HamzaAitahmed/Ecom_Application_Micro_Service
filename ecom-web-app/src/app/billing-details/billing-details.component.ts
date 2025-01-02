import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BillingService} from '../Services/billing.service';
import {ActivatedRoute} from '@angular/router';
import {Billing} from '../model/billing.model';
import {ProductItem} from '../model/ProductItem.model';

@Component({
  selector: 'app-billing-details',
  standalone: false,

  templateUrl: './billing-details.component.html',
  styleUrl: './billing-details.component.css'
})
export class BillingDetailsComponent implements OnInit{
  public billId: number
  public billDetails: Billing;
  public prdIt: ProductItem[];
  constructor(private http:HttpClient, private billService:BillingService, private route:ActivatedRoute) {
    this.billId = route.snapshot.params['billId']
  }

  ngOnInit(): void {
    this.getBillDetails(this.billId)
  }

  getBillDetails(billId:number){
    console.log("1 - getBillDetails")
    this.billService.getBillDetails(billId).subscribe({
      next : data => {
        console.log(data)
        this.billDetails = data;
        this.prdIt = this.billDetails.productItems;
        console.log(this.prdIt)
      },
      error : (err)=>{}
    });
  }

}
