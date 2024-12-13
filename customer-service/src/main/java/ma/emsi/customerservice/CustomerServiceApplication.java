package ma.emsi.customerservice;

import ma.emsi.customerservice.Entities.Customer;
import ma.emsi.customerservice.Repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import ma.emsi.customerservice.Controller.ConfigParams;
@EnableConfigurationProperties(ConfigParams.class)
@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){

        return args -> {

            customerRepository.save(new Customer(null,"Hamza","Hamza@gmail.ma"));
            customerRepository.save(new Customer(null,"Aitahmed","Aitahmed@gmail.ma"));
            customerRepository.save(new Customer(null,"Karim","Karim@gmail.ma"));
            customerRepository.findAll().forEach(System.out::println);

        };

    }
}