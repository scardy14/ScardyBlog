package org.scardy.scardyblog.controller;

import org.scardy.scardyblog.entity.Account;
import org.scardy.scardyblog.service.LogService;
import org.scardy.scardyblog.vo.Verification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AccountController {
	private final LogService logService; 
	private Verification verification = Verification.getVerificationInstance();
	
	
	@GetMapping("/sendMassage")
	@ResponseBody
	public boolean sendMassage(@RequestParam("tel")String tel) {
		boolean result = logService.setExistsByTel(tel);
		if(!result) {
			logService.sendMassage(tel);
		}
		return !result;
	}
	
	@GetMapping("/checkVerification")
	@ResponseBody
	public boolean checkVerification(@RequestParam("code")int code) {
		boolean result = logService.compareCode(code);
		return result;
	}
	
	@GetMapping("/existsById")
	@ResponseBody
	public boolean existsById(@RequestParam("id")String id) {
		return logService.setExistsById(id);
	}
	
	@PostMapping("/register")
	@ResponseBody
	public boolean register(Account account) {
		System.out.println(account);
		return false;
	}
}
