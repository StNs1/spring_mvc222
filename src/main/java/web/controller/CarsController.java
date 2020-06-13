package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarsController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String printCars(ModelMap model) {
        /*Car car1 = new Car("audi", 1);
        Car car2 = new Car("bmw", 2);
        Car car3 = new Car("reno", 3);
        carService.addCar(car1);
        carService.addCar(car2);
        carService.addCar(car3);*/
        List<Car> list = carService.getAllCar();
        model.addAttribute("cars", list);
        return "cars";
    }
}
