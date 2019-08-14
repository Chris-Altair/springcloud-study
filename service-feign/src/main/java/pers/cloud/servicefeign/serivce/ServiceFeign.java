package pers.cloud.servicefeign.serivce;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-provider",fallbackFactory = serviceFeignFallback.class)
public interface ServiceFeign {
    @GetMapping("/welcome")
    String service(@RequestParam(value = "name") String name);//value必须有，不可默认，否则会报错
}
