package web.service;

import web.models.Car;

import java.util.LinkedList;
import java.util.List;


public class returnListCarsService {
    List<Car> listCar = new LinkedList<>();

    public List<Car> getListCars() {
        listCar.add(new Car("ваз", "шоха", 1985));
        listCar.add(new Car("Kia", "Rio", 2001));
        listCar.add(new Car("Mersedes", "A100", 2005));

        return listCar;
    }
}
