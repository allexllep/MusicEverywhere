package com.lepeshkin.servlet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

//	@GetMapping("/")
//	public String index() {
//		return "Greetings from Spring Boot!";
//	}
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "Hello World" );
		return "helloworld";
	}
}