package ma.emsi.billingservice.Controllers;

import ma.emsi.billingservice.Entities.Bill;
import ma.emsi.billingservice.Repository.*;
import ma.emsi.billingservice.Services.*;
import ma.emsi.billingservice.Repository.BillRepository;
import ma.emsi.billingservice.Repository.ProductItemRepository;
import ma.emsi.billingservice.Services.CustomerServiceClient;
import ma.emsi.billingservice.Services.InventoryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
