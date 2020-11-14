package org.zdjavapol12.springcourse.beany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Random;

//@Service
//Nazwa testRunner
public class TestRunner implements CommandLineRunner {

    private final FirstBean firstBean;
    private final Random random;
    private final ClassInterface classInterface;

    @Autowired
public TestRunner(@Qualifier("mojPierwszyBean") FirstBean firstBean, Random random, ClassInterface classInterface) {
        this.firstBean = firstBean;
        this.random = random;
        this.classInterface = classInterface;
    }

    @Override
    public void run(String... args) throws Exception {
        firstBean.whoAmI();
        System.out.println(random.nextInt());
        System.out.println(random);
        classInterface.stuff();

    }
}
