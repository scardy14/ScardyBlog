package org.scardy.scardyblog.controller;

import org.scardy.scardyblog.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AccountController {
	private final LogService logService;
	
	@GetMapping("/sendMassage")
	public String sendMassage() {
		long tel = 1234;
		logService.sendMassage(tel);
		System.out.println("1");
		return "content/index";
	}

}
