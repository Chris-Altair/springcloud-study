package pers.cloud.eurekaserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 */
@Configuration
@EnableWebSecurity(debug = false)
public class SecurityResourceServerConfig extends WebSecurityConfigurerAdapter {
    /**
     * cxrf 跨站请求攻击
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().ignoringAntMatchers("/eureka/**");//放行eureka请求
        http.csrf().ignoringAntMatchers("/actuator/**");//放行actuator请求
        super.configure(http);
    }
}
