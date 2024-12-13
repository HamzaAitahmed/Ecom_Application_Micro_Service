package ma.emsi.billingservice.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import ma.emsi.billingservice.Models.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductItem{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long productID;
    private double price;
    private double quantity;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;

    @Transient
    private Product product;

//    public ProductItem(Long id, Long productID, double price, int quantity, Bill bill, Product product) {
//    }
}
