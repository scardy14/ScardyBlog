package org.scardy.scardyblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class moveController {
	@GetMapping(value= {"/","index","home","//"})
	public String homeMove(Model model) {
		model.addAttribute("mode", "home");
		return "main";
	}
	@GetMapping("moveBlog")
	public String blogMove(Model model) {
		model.addAttribute("mode", "blog");
		return "contant/blog";
	}
	@GetMapping("moveAbout")
	public String aboutMove(Model model) {
		model.addAttribute("mode", "about");
		return "contant/about";
	}
	@GetMapping("movePortfolio")
	public String portfolioMove(Model model) {
		model.addAttribute("mode", "portfolio");
		return "contant/portfolio";
	}
	@GetMapping("moveContact")
	public String contactMove(Model model) {
		model.addAttribute("mode", "contact");
		return "contant/contact";
	}
	@GetMapping("moveLogin")
	public String loginMove(Model model) {
		model.addAttribute("mode", "login");
		return "contant/login";
	}
	@GetMapping("blogMode")
	public String blogJavaMove(String blogMode, Model model) {
		model.addAttribute("blogMode", blogMode);
		return "contant/blogMode";
	}
	@GetMapping("wrtieBlog")
	public String writeBlog() {
		return "contatn/writeBlog";
	}
}
