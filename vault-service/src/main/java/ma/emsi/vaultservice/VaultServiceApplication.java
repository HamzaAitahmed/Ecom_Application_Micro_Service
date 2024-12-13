package ma.emsi.vaultservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.vault.core.VaultTemplate;

import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
public class VaultServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaultServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(VaultTemplate vaultTemplate) {
        return args -> {
            vaultTemplate.opsForVersionedKeyValue("secret")
                    .put("another-service", Map.of("user.email", "Hamza@gmail.com", "user.phone", "06123456789") );

        };
    }
}
