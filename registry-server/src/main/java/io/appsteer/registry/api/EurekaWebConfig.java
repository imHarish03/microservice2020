package io.appsteer.registry.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class EurekaWebConfig extends WebMvcConfigurerAdapter {

    @Value("${server.servlet.context-path:/}")
    private String contextPath;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(contextPath + "/eureka/status")
                .setViewName("forward:/eureka/status.html");
    }

    @Bean
    public FilterRegistrationBean<HiddenHttpMethodFilter> hiddenHttpMethodFilter() {
        FilterRegistrationBean<HiddenHttpMethodFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new HiddenHttpMethodFilter());
        registration.addUrlPatterns(contextPath + "/eureka/*");
        return registration;
    }
}