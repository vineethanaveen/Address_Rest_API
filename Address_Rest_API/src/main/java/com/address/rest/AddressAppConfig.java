package com.address.rest;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * auto configuration is enabled 
 * component scanning is done for package com.address.rest
 
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AddressAppConfig extends WebMvcConfigurerAdapter {
	
	
    

    public static void main(String[] args) {
        SpringApplication.run(AddressAppConfig.class, args);
    }
    
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }
    
   
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

//    @Bean
//    public ReloadableResourceBundleMessageSource messageSource() {
//            ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//            messageSource.setBasename("/lang/messages");
//            messageSource.setCacheSeconds(10); //reload messages every 10 seconds
//            return messageSource;
//    }
//    
    
    @Bean
    public ResourceBundleMessageSource messageSource() {
     ResourceBundleMessageSource source = new ResourceBundleMessageSource();
     source.setBasenames("lang/messages");  // name of the resource bundle 
     source.setUseCodeAsDefaultMessage(true);
     return source;
    }
   
}
