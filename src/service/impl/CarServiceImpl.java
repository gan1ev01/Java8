package service.impl;

import classes.Car;
import classes.Person;
import service.CarService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarServiceImpl implements CarService {
    List<Car> cars = new ArrayList<>();
    @Override
    public String createCar(List<Car> cars) {
        this.cars = cars;
        return "Cars  successfully created!";
    }

    @Override
    public String removeCar(String name, List<Car> cars) {
        for (Car car : cars) {
            if (car.getName().equals(name)) {
                cars.remove(cars);
            }
        }
        return "Cars  successfuly deleted!";
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }


    @Override
    public List<Car> findByCountry(String name, List<Car> cars) {
        List<Car> cars1 = new LinkedList<>();
        for (Car car : this.cars) {
            if (car.getCountryOfOrigin().name().equals(name))
                cars1.add(car);
        }
        return cars1;
    }
}
