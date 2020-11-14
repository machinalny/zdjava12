package org.zdjavapol12.springcourse.carCompany;

import org.slf4j.Logger;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Service
@Scope(SCOPE_PROTOTYPE)
public class EmbeddedComputer implements Runnable {

    private final Engine engine;
    private final FuelTank fuelTank;
    private final List<Logger> logger;


    public EmbeddedComputer(Engine engine, FuelTank fuelTank, List<Logger> logger) {
        this.engine = engine;
        this.fuelTank = fuelTank;
        this.logger = logger;
    }

    public boolean isEngineWorking(){
        return this.engine.isOn();
    }

    public boolean startEngine(){
        if(!this.engine.isOn() && fuelTank.getFuelLevel() > 0.0){
            this.engine.startEngine();
            logger.get(0).info("Silnik wystartowal");
            return true;
        } else if(!this.engine.isOn()){
            logger.get(1).info("Lack of fuel");
            return false;
        }
        return false;
    }

    public void accelerate(Integer by){
        this.engine.setAccelerate(by);
    }


    @Override
    public void run() {
        logger.get(0).info("Komputer zostal wlaczony");
        while(true){
            if (isEngineWorking()){
                injectFuelToEngine();
                logger.get(1).info("Brum");
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void injectFuelToEngine(){
        if (!this.fuelTank.getFuelToEngine(this.engine.getFuelConsumption())){
            this.engine.stopEngine();
            logger.get(0).info("Lack of fuel engine stopped.");
        }
    }
}
