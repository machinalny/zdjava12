package org.zdjavapol12.springcourse.beany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

//@Component("mojPierwszyBean")
public class FirstBean {
    Logger logger = LoggerFactory.getLogger(FirstBean.class);

    private final Random random;

    public FirstBean(Random random) {
        this.random = random;
    }

    @PostConstruct
    public void init() {
        logger.info("Pierwszy bean zostal stworzony");
    }

    @PreDestroy
    public void cleanUp() {
        logger.info("Pierwszy bean zostanie zniszczony");
    }

    public void whoAmI(){
        System.out.println("Jestem beanem numer ." + random.nextInt());
        System.out.println(random);
    }

}
