import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Customer} from '../model/customer.model';
import {CustomerService} from '../Services/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customers',
  standalone: false,

  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{
  public customersNotFiltred: any;
  public customers: Array<Customer> = [];
  public keyWord: string=""
  constructor(private http:HttpClient, private customerService:CustomerService, private router:Router) {}

  ngOnInit(): void {
    this.getCustomer();

  }

  getCustomer(){
    this.customerService.getCustomers().subscribe({
      next : data => {
        this.customersNotFiltred = data;
        this.customers = this.customersNotFiltred._embedded.customers; // remove embbed and to initialize list of customers directly
      },
      error : (err)=>{}
    });
  }

  gotoBills(customer:Customer)
  {
    this.router.navigateByUrl("/billing-Customer/"+customer.id)
  }

  deleteCustomer(p: Customer) {
    this.customerService.deleteCustomer(p).subscribe({
      next : data => {
        let index = this.customers.indexOf(data)
        this.customers.splice(index,1) ;
      },
      error : (err)=>{ }
    });
  }

  searchCustomers() {
    let result= [];
    if(this.keyWord=="")
    {
      this.getCustomer();
    }
    for(let p of this.customers)
    {
      if(p.name.includes(this.keyWord)){
        result.push(p);
      }
    }
    this.customers = result;
  }
}
