package ma.emsi.vaultservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class VaultRestController {
    @Value("${user.username}")
    private String username;
    @Value("${user.password}")
    private String password;

    @Autowired private VaultConfig vaultConfig;

    @GetMapping("/Config")
    public Map<String, String> params3(){
        return Map.of("username",username,"password",password);
    }

    @GetMapping("/Config2")
    public VaultConfig params4(){
        return vaultConfig;
    }

    @GetMapping("/Config3")
    public Map<String, Object> params5(){
        return Map.of("myVaultConfig", vaultConfig);
    }
}
