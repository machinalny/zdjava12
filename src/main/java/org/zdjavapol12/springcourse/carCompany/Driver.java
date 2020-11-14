package org.zdjavapol12.springcourse.carCompany;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Driver implements CommandLineRunner {

    private final Car car;
    private final Car car2;
    private final List<Car> cars;
    private final Logger logger;

    public Driver(Car car, Car car2, List<Car> cars, Logger logger) {
        this.car = car;
        this.car2 = car2;
        this.cars = cars;
        this.logger = logger;
    }

    @Override
    public void run(String... args) throws Exception {
        this.car.startCar();
        this.car2.startCar();
        this.cars.get(0).startCar();
        logger.info("Dzialaja samochody");
    }
}
