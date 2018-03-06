package spring.STS.web.service;

import java.util.List;



import spring.STS.web.entity.Car;

public interface CarService {

	
	void saveCar(Car car);
	
	List<Car> findAllCars();

	Car findCarByModel(String model);
}
