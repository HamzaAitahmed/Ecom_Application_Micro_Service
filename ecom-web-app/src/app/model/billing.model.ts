import {Product} from './product.model';
import {Customer} from './customer.model';

export interface Billing{
  id: number,
  billingDate: Date;
  customerID: number;
  customer:Customer;
  productItem:Array<Product>;
}
