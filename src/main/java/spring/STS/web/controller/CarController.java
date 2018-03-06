package spring.STS.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.STS.web.entity.Car;
import spring.STS.web.service.CarService;
import spring.STS.web.service.ColorService;

@Controller
@RequestMapping("/car")
public class CarController {

	
	private CarService carService;
	private ColorService colorService;
	
	
	@Autowired
	public CarController(CarService carService, ColorService colorService) {
		super();
		this.carService = carService;
		this.colorService = colorService;
	}

	@GetMapping("/create")
	public String showAddCarForm(Model model) {
		model.addAttribute("colorsList", colorService.findAllColors());
		model.addAttribute("carModel", new Car());
		return "car/create";
	}
	
	@PostMapping("/create")
	public String saveCar(@ModelAttribute("carModel") @Valid Car car,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "car/create";
		}
		
		carService.saveCar(car);
		return "redirect:/";
	}
	
}
