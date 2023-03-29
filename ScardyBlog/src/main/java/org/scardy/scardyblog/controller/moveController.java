package org.scardy.scardyblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class moveController {
	@GetMapping(value= {"/","index","home","//"})
	public String homeMove(Model model) {
		model.addAttribute("mode", "home");
		return "content/index";
	}
	@GetMapping("moveBlog")
	public String blogMove(Model model) {
		model.addAttribute("mode", "blog");
		return "content/blog";
	}
	@GetMapping("moveAbout")
	public String aboutMove(Model model) {
		model.addAttribute("mode", "about");
		return "content/about";
	}
	@GetMapping("movePortfolio")
	public String portfolioMove(Model model) {
		model.addAttribute("mode", "portfolio");
		return "content/portfolio";
	}
	@GetMapping("moveContact")
	public String contactMove(Model model) {
		model.addAttribute("mode", "contact");
		return "content/contact";
	}
	@GetMapping("moveLogin")
	public String loginMove(Model model) {
		model.addAttribute("mode", "login");
		return "content/login";
	}
	@GetMapping("blogMode")
	public String blogJavaMove(String blogMode, Model model) {
		model.addAttribute("blogMode", blogMode);
		return "content/blogMode";
	}
	@GetMapping("wrtieBlog")
	public String writeBlog() {
		return "content/writeBlog";
	}
}
