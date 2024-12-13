package ma.emsi.consulservice;

import ma.emsi.consulservice.Controller.ConsulConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(ConsulConfig.class)
public class ConsulServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulServiceApplication.class, args);
    }


}
