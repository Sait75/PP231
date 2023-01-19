package web.config.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpI implements CarService{
    private List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car("Audi", "A6", 1111));
        carList.add(new Car("BMW", "X5", 2222));
        carList.add(new Car("Citroen", "C4", 3333));
        carList.add(new Car("Mercedes", "ML500", 4444));
        carList.add(new Car("Volvo", "S60", 5555));
    }

    public List<Car> getCars(int count) {
        return carList.stream().limit(count).toList();
    }
}
