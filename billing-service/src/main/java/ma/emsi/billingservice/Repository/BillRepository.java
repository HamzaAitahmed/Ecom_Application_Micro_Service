package ma.emsi.billingservice.Repository;

import ma.emsi.billingservice.Entities.Bill;
import ma.emsi.billingservice.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill,Long> {
    @RestResource(path = "/byCustomerId")
    List<Bill> findByCustomerID(@PathVariable(name="customerId") Long customerId);
}
