package ma.emsi.billingservice;

import ma.emsi.billingservice.Entities.*;
import ma.emsi.billingservice.Models.*;
import ma.emsi.billingservice.Repository.*;
import ma.emsi.billingservice.Services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.lang.Math;

@EnableFeignClients
@SpringBootApplication
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository,
                            InventoryServiceClient inventoryServiceClient, CustomerServiceClient customerServiceClient){
        return args -> {
            Customer customer=customerServiceClient.findCustomerById(1L);
            if(customer==null) throw new RuntimeException("Customer Not found");
            System.out.println("# CUSTOMER : "+customer);
            Bill bill=new Bill();
            bill.setBillingDate(new Date());
            System.out.println("# CUSTOMER 2 : "+customer);
            bill.setCustomerID(customer.getId());
            System.out.println("# CUSTOMER 3 : "+customer);
            Bill savedBill = billRepository.save(bill);
            System.out.println("# Saved BILL : "+savedBill);
            inventoryServiceClient.allProducts().getContent().forEach(product->{
                System.out.println(" Product ====> "+product);
                productItemRepository.save(new ProductItem(null,product.getId(),product.getPrice(),(int)(1+Math.random()*1000),savedBill,product) );
            });
        };
    }
}



