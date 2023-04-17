package org.scardy.scardyblog.controller;

import org.scardy.scardyblog.entity.Account;
import org.scardy.scardyblog.service.GradeService;
import org.scardy.scardyblog.service.LogService;
import org.scardy.scardyblog.vo.Verification;
import org.springframework.data.web.PageableHandlerMethodArgumentResolverSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AccountController{
	private final LogService logService;
	private final GradeService gradeService;
	
	@GetMapping("/sendMassage")
	@ResponseBody
	public boolean sendMassage(@RequestParam("tel")String tel) {
		boolean result = logService.setExistsByTel(tel);
		if(!result) {
			logService.sendMassage(tel);
		}
		return !result;
	}
	
	@GetMapping("/checkVerificateCode")
	@ResponseBody
	public boolean checkVerificateCode(@RequestParam("code")int code) {
		boolean result = logService.compareCode(code);
		return result;
	}
	
	@GetMapping("/existsById")
	@ResponseBody
	public boolean existsById(@RequestParam("id")String id) {
		return logService.setExistsById(id);
	}
	
	@GetMapping("/existsByNickName")
	@ResponseBody
	public boolean existsByNickName(@RequestParam("nickname")String nickname) {
		return logService.existsByNickName(nickname);
	}
	
	@GetMapping("/checkPassword")
	@ResponseBody
	public void checkPassword(@RequestParam("result")boolean result) {
		logService.setPasswordCheck(result);
	}
	
	@GetMapping("/checkVerification")
	@ResponseBody
	public boolean checkVerification() {
		return logService.checkVerification();
	}
	
	@PostMapping("/register")
	public String register(Account account) {
		boolean accountResult = logService.register(account);
		boolean gradeResult = gradeService.register(account.getId());
		String resultPath;
		if(accountResult&&gradeResult) {
			resultPath = "redirect:/moveRegisterSuccess";
		} else {
			resultPath = "redirect:/moveRegisterFail";
		}
		return resultPath;
	}
}
