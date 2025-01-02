import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Billing} from '../model/billing.model';

@Injectable({
  providedIn: 'root'
})
export class BillingService {
  public billsNotFilter: any;

  constructor(private http: HttpClient) { }

  public getBillings(): Observable<Array<Billing>>{
    return this.http.get<Array<Billing>>("http://localhost:9999/BILLING-SERVICE/bills/All");
  }

  public getBillByCustomer(id:number): Observable<Array<Billing>>{
    return this.http.get<Array<Billing>>(`http://localhost:9999/BILLING-SERVICE/bills/search/byCustomerId?customerId=${id}&projection=Bill`);
  }
  public getBillDetails(id:number): Observable<Billing>{
    return this.http.get<Billing>(`http://localhost:9999/BILLING-SERVICE/bills/full/${id}`);
  }

  public addBilling(bill:Billing): Observable<Billing>{
    return this.http.post<Billing>(`http://localhost:9999/BILLING-SERVICE/bills`,{bill});
  }

  public deleteBilling(bill:Billing): Observable<Billing>{
    return this.http.delete<Billing>(`http://localhost:9999/BILLING-SERVICE/bills/${bill.id}`);
  }
}
