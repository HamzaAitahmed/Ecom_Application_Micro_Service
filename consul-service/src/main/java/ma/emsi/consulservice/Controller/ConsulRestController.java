package ma.emsi.consulservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConsulRestController {
    @Value("${token.accessTokenTimeout}")
    private String accessTokenTimeout;
    @Value("${token.refreshTokenTimeout}")
    private String refreshTokenTimeout;

    @Autowired private ConsulConfig consulConfig;

    @GetMapping("/Config1")
    public Map<String, String> params1(){
        return Map.of("accessTokenTimeout",accessTokenTimeout,"refreshTokenTimeout",refreshTokenTimeout);
    }

    @GetMapping("/Config2")
    public ConsulConfig params2(){
        return consulConfig;
    }

    @GetMapping("/Config3")
    public Map<String, Object> params3(){
        return Map.of("myConsulConfig",consulConfig);
    }


}