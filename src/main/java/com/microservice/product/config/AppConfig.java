package com.microservice.product.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Main configuration class: enables component scanning so Spring
 * automatically discovers @Repository, @Service and @Configuration classes.
 */
@Configuration
@ComponentScan(basePackages = "com.microservice.product")
public class AppConfig {
}
