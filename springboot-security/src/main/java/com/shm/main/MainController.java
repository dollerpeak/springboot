package com.shm.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
//@RequestMapping("/")
@Slf4j
public class MainController {

	//@GetMapping({ "", "/" })
	@GetMapping("")
	public String main() {
		log.info("=====> main");
		return "/main";
	}

}
