package br.com.siberius.restwithspringboot.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class WebConfig implements WebMvcConfigurer{


    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer ) {

        // Via EXTENSION. localhost:8080/person.x-yaml
        /*
         * configurer.favorParameter(false) .ignoreAcceptHeader(false)
         * .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
         * MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML);
         */

        // Via QUERY PARAM. localhost:8080/person?mediaType=xml
        /*
         * configurer.favorPathExtension(false) .favorParameter(true)
         * .parameterName("mediaType") .ignoreAcceptHeader(true)
         * .useRegisteredExtensionsOnly(false)
         * .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
         * MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML);
         */

        configurer.favorPathExtension(false)
                .favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);
    }

}
