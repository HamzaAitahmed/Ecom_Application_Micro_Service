package ma.emsi.consulservice;

import ma.emsi.consulservice.Controller.ConsulConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.vault.core.VaultTemplate;

import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(ConsulConfig.class)
public class ConsulServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(VaultTemplate vaultTemplate) {
        return args -> {
            vaultTemplate.opsForVersionedKeyValue("secret")
                    .put("vault-service", Map.of("user.username", "Hamza AitAhmed", "user.password", "P@ssw0rd") );

        };
    }
}
