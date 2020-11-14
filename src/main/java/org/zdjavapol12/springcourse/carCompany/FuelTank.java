package org.zdjavapol12.springcourse.carCompany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class FuelTank {
    private Double capacity = 65.0;
    private Double fuelLevel = 65.0;

    public Double getCapacity() {
        return capacity;
    }

    public Double getFuelLevel() {
        return fuelLevel;
    }

    public boolean getFuelToEngine(Double amountOfFuel){
        if (this.fuelLevel - amountOfFuel > 0){
            this.fuelLevel = fuelLevel - amountOfFuel;
            return true;
        }
        return false;
    }


}
