package org.zdjavapol12.springcourse.beany;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

//@Configuration
public class BeanConfiguration {

    @Bean
    @Scope(SCOPE_PROTOTYPE)
    public Random randomClass(){
        return new Random();
    }

}
