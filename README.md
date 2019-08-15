# springcloud学习
* config-profiles   分布式配置仓库
* config-server     配置中心
* gateway-zuul      路由网关  
* eureka-server     服务注册
* service-provider  服务提供
* service-feign     服务调用

## 1.打包
    在各个子模块目录中执行mvn clean package，在对应target目录生成jar包
## 2.部署顺序
    执行各个服务命令java -jar xxx.jar
    1）eureka-server (--spring.profiles.active=dev|s1|s2)
    2) config-server
    3) gateway-zuul
    4) service-provider
    5) service-feign
## 3.对应端口
 |model|port|
 |:-----|:----|
 |eureka-server|8761(8762)|
 |config-server|8888|
 |gateway-zuul|8769|
 |service-provider|8000|
 |service-feign|8090|
