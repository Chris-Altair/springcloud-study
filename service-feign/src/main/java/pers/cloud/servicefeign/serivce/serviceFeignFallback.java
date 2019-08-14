package pers.cloud.servicefeign.serivce;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 服务调用失败时执行此类，必须先在配置文件声明feign.hystrix.enabled=true
 */
@Component
public class serviceFeignFallback implements FallbackFactory<ServiceFeign> {
    private static Logger logger = LoggerFactory.getLogger(serviceFeignFallback.class);

    @Override
    public ServiceFeign create(Throwable throwable) {
        return new ServiceFeign() {
            @Override
            public String service(String name) {
                logger.error("Fallback reason = {}", throwable.getMessage());
                return null;
                // 常用写法2：throw 异常，统一处理
//                throw new SampleException(throwable, "Get User error.", null);
            }
        };
//        lambda写法，适用于接口中只有一个方法
//        return (name)->{
//            logger.error("Fallback reason = {}", throwable.getMessage());
//            return null;
//        };
    }
}
