package pers.cloud.servicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.cloud.servicefeign.serivce.ServiceFeign;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class ServiceFeignApplication {
    @Autowired
    private ServiceFeign serviceFeign;

    @GetMapping("/test")
    public String test(@RequestParam(name = "name") String name) {
        return serviceFeign.service(name);
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class, args);
    }

}
