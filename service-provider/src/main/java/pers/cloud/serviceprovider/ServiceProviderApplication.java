package pers.cloud.serviceprovider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceProviderApplication {
    private static Logger logger = LoggerFactory.getLogger(ServiceProviderApplication.class);

    @GetMapping("/welcome")
    public String service(@RequestParam(name = "name") String name) {
        logger.info("name:{}", name);
        String result = "Hello " + name + "!";
        return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication.class, args);
    }

}
