package ma.emsi.billingservice.Controllers;

import ma.emsi.billingservice.Entities.Bill;
import ma.emsi.billingservice.Models.Customer;
import ma.emsi.billingservice.Repository.*;
import ma.emsi.billingservice.Services.*;
import ma.emsi.billingservice.Repository.BillRepository;
import ma.emsi.billingservice.Repository.ProductItemRepository;
import ma.emsi.billingservice.Services.CustomerServiceClient;
import ma.emsi.billingservice.Services.InventoryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class BillRestController{
    @Autowired
    BillRepository billRepository;
    @Autowired
    ProductItemRepository productItemRepository;
    @Autowired
    CustomerServiceClient customerServiceClient;
    @Autowired
    InventoryServiceClient inventoryServiceClient;
    @GetMapping("/bills/full/{id}")
    Bill getBill(@PathVariable("id") Long id){
        return FullBill(id);
    }

    Bill FullBill(Long id)
    {
        Bill bill=billRepository.findById(id).get();
        bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerID()));
        bill.setProductItems(productItemRepository.findByBillId(id));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(inventoryServiceClient.findProductById(pi.getProductID()));
        });
        return bill;

    }

    @GetMapping("/bills/All")
    List<Bill> getBills(){
        return AllFullBill();
    }

    List<Bill> AllFullBill()
    {
        List<Bill> bill=billRepository.findAll();
        for(Bill b:bill)
        {
            Customer customer = customerServiceClient.findCustomerById(b.getCustomerID());
            b.setCustomer(customer);
        }

        return bill;

    }

}
