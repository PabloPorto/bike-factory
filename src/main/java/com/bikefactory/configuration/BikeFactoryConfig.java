package com.bikefactory.configuration;

import com.bikefactory.repository.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = {
        CustomerRepository.class,
        PersonRepository.class,
        ProductRepository.class,
        SalesOrderDetailRepository.class,
        SalesOrderHeaderRepository.class,
        SpecialOfferProductRepository.class
})
public class BikeFactoryConfig {
}
