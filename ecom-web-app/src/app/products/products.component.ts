import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../model/product.model';
import {ProductService} from '../Services/product.service';

@Component({
  selector: 'app-products',
  standalone: false,

  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit{
  public productsNotFiltred: any;
  public products: Array<Product> = [];
  public keyWord: string=""
  constructor(private http:HttpClient, private productService:ProductService) {}

  ngOnInit(): void {
    this.getProduct();

  }

  getProduct(){
    this.productService.getProducts().subscribe({
      next : data => {
        this.productsNotFiltred = data;
        this.products = this.productsNotFiltred._embedded.products; // remove embbed and to initialize list of products directly
      },
      error : (err)=>{}
    });
  }

  deleteProduct(p: Product) {
    this.productService.deleteProduct(p).subscribe({
      next : data => {
        let index = this.products.indexOf(data)
        this.products.splice(index,1) ;
      },
      error : (err)=>{ }
    });
  }

  searchProducts() {
    let result= [];
    if(this.keyWord=="")
    {
      this.getProduct();
    }
    for(let p of this.products)
    {
      if(p.name.includes(this.keyWord)){
        result.push(p);
      }
    }
    this.products = result;
  }
}
