package ma.emsi.billingservice.Entities;

import ma.emsi.billingservice.Models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private long customerID;

    @Transient
    private Customer customer;

    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;

}
