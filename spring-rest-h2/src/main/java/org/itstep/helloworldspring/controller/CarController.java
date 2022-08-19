package org.itstep.helloworldspring.controller;

import org.itstep.helloworldspring.Model.Car;
import org.itstep.helloworldspring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping(value = "/cars")
    public Car save(@Valid @RequestBody Car car) {
        return carService.save(car);
    }

    @GetMapping("/cars")
    public List<Car> fetchCarList() {
        return carService.fetchCarList();
    }

    @PutMapping("/cars/{id}")
    public Car updateCar(@RequestBody Car car, @PathVariable("id") Long carId) {
        return carService.updateCar(car, carId);
    }

    @DeleteMapping("/cars/{id}")
    public String deleteCarById(@PathVariable("id") Long carId) {
        carService.deleteCarById(carId);
        return "Deleted Successfully";
    }
}