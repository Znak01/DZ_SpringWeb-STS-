package spring.STS.web.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import spring.STS.web.entity.MyUser;
import spring.STS.web.entity.UploadFile;
import spring.STS.web.service.UploadService;
import spring.STS.web.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	
	private UserService userService;
	private UploadService uploadService;
	
	
	@Autowired
	public UserController(UserService userService, UploadService uploadService) {
		super();
		this.userService = userService;
		this.uploadService = uploadService;
	}

	@GetMapping("/register")
	private String UserRegister(Model model) {
		model.addAttribute("userM", new MyUser());
		return "register";
	}
	
	@GetMapping("/login")
	private String UserLogin(Model model) {
		model.addAttribute("userM", new MyUser());
		return "login";
	}
	
	@PostMapping("/register")
	private String saveUser(@ModelAttribute("userM") @Valid MyUser user,
			BindingResult result) {
		if(result.hasErrors()) {
			return "register";
		}
		userService.save(user);
		
		String rootPath = System.getProperty("user.dir");
		File uploadDirUsers = new File(rootPath + File.separator + 
				"src" + File.separator + 
				"main" + File.separator + 
				"webapp" + File.separator + 
				"users" + File.separator +
				"user_" + user.getId());
		
		if(!uploadDirUsers.exists()) uploadDirUsers.mkdir();
		
		
		
		return "redirect:/";
	}
	
	@PostMapping("/login")
	private String login(@ModelAttribute("userM") @Valid MyUser user,
			BindingResult result) {
		if(result.hasErrors()) {
			return "login";
		}
		return "redirect:{userId}/edit";
	}
	
	@GetMapping("{userId}/edit")
	public String editUser(Model model, @PathVariable("userId") int id) {
		MyUser user = userService.findById(id);
		model.addAttribute("userM", user);
		System.out.println(user);
		
		return "edit-user";
	}
	
	@PostMapping("{userId}/edit")
	public String editItem(@ModelAttribute("userM") MyUser user,
			@RequestParam("fileUpload") MultipartFile file) throws IOException {
		if(file != null) {
			UploadFile uploadFile = new UploadFile();
			uploadFile.setFileName(file.getOriginalFilename());
			uploadFile.setFileData(file.getBytes());
			uploadService.saveFile(uploadFile);
		}
		String rootPath = System.getProperty("user.dir");
		File uploadDirUsers = new File(rootPath + File.separator + 
				"src" + File.separator + 
				"main" + File.separator + 
				"webapp" + File.separator + 
				"users" + File.separator +
				"user_" + user.getId());
		
		if(!uploadDirUsers.exists()) uploadDirUsers.mkdir();
		
		if(file != null && !file.isEmpty()) {
			BufferedImage bufferedImage = 
					ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			File destination = 
					new File(uploadDirUsers.getAbsolutePath() + 
							File.separator +
							file.getOriginalFilename());
			ImageIO.write(bufferedImage, "png", destination);
		}
		
		userService.save(user);
		return "redirect:/edit-user";
	}
	
}
