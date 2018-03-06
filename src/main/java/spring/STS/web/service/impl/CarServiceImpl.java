package spring.STS.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.STS.web.entity.Car;
import spring.STS.web.repository.CarRepository;
import spring.STS.web.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;
	
	@Override
	public void saveCar(Car car) {

		carRepository.save(car);
	}

	@Override
	public List<Car> findAllCars() {
		return carRepository.findAll();
	}

	@Override
	public Car findCarByModel(String model) {
		return carRepository.findCarByModel(model);
	}

}
