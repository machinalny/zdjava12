package org.zdjavapol12.springcourse.carCompany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class Engine {

    private boolean on = false;
    private Integer revs = 0;
    private Integer accelerate = 0;
    private Integer capacity = 0;
    private Double fuelConsumption = 0.0;

    public void startEngine(){
        this.on = true;
        this.dealWithAcceleration(5);

    }

    public void stopEngine(){
        this.on = false;
        this.dealWithAcceleration(0);
    }

    public void setAccelerate(Integer accelerate){
        this.dealWithAcceleration(accelerate);
    }
    private void dealWithAcceleration(Integer accelerateBy){
        this.accelerate = accelerateBy;
        this.revs = this.accelerate * 160;
        this.fuelConsumption = this.revs * 0.003;
    }

    public boolean isOn() {
        return on;
    }

    public Integer getRevs() {
        return revs;
    }

    public Integer getAccelerate() {
        return accelerate;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }
}
