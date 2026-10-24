package com.microservice.product;

import com.microservice.product.config.AppConfig;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Smoke test: checks that the Spring container starts and that
 * the Hibernate SessionFactory is created (i.e. the database is reachable).
 */
public class TestHibernate {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        SessionFactory sf = context.getBean(SessionFactory.class);
        System.out.println("Spring context started. SessionFactory open: " + !sf.isClosed());

        context.close();
    }
}
