package ma.emsi.customerservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestRestController {
    @Value("${customer.params.x}")
    private String x;
    @Value("${customer.params.y}")
    private String y;

    @Autowired private ConfigParams configParams;

    @GetMapping("/config1")
    public Map<String, String> params1(){
        return Map.of("x",x,"y",y);
    }

    @GetMapping("/config2")
    public ConfigParams params2(){
        return configParams;
    }
}