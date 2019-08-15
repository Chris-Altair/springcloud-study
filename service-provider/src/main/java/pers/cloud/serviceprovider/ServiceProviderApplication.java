package pers.cloud.serviceprovider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class ServiceProviderApplication {
    private static Logger logger = LoggerFactory.getLogger(ServiceProviderApplication.class);
    @Value("${test-bus}")
    private String testBus;
    @GetMapping("/welcome")
    public String service(@RequestParam(name = "name") String name) {
        logger.info("name:{}", name);
        String result = "Hello " + name + "! "+testBus;
        return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication.class, args);
    }

}
