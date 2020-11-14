package org.zdjavapol12.springcourse.carCompany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Utils {

    @Bean
    @Primary
    public Logger getLogger(){
        return LoggerFactory.getLogger("Logger samochodowy");
    }

    @Bean("fuelLogger")
    public Logger getOtherLogger(){
        return LoggerFactory.getLogger("Logger paliwowy");
    }
}
