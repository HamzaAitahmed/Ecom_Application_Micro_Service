package ma.emsi.consulservice.Controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "token")
@Data
public class ConsulConfig {
    private String accessTokenTimeout;
    private String refreshTokenTimeout;
}
