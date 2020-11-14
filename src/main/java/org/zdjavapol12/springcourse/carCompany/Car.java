package org.zdjavapol12.springcourse.carCompany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Service
@Scope(SCOPE_PROTOTYPE)
public class Car {

//    private Doors doors;
    private final ExecutorService pool = Executors.newFixedThreadPool(1);
    private final EmbeddedComputer embeddedComputer;

    public Car(EmbeddedComputer embeddedComputer) {
        this.embeddedComputer = embeddedComputer;
        this.pool.submit(embeddedComputer);
    }

    public void startCar(){
        this.embeddedComputer.startEngine();
    }

}
