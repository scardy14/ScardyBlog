package org.scardy.scardyblog.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

import org.scardy.scardyblog.repository.BlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class moveController{
///////////////////////////////////////////////////////////////////////////
	@GetMapping(value= {"/","/index","/home",""})
	public String homeMove(Model model) {
		model.addAttribute("mode", "home");
		return "content/index";
	}
///////////////////////////////////////////////////////////////////////////
	
///////////////////////////////////////////////////////////////////////////
	@GetMapping("/moveBlog")
	public String blogMove(Model model) {
		model.addAttribute("mode", "blog");
		return "content/blog/blog";
	}
	private final BlogRepository blogRepository;
	@GetMapping("/moveBlogMode")
	public String blogJavaMove(String blogMode, Model model) throws IOException, SQLException {
		Clob clob = blogRepository.findById(7).get().getContent();
		Reader reader = clob.getCharacterStream();
		BufferedReader bufferedReader = new BufferedReader(reader);
		StringBuilder contentStringBuilder = new StringBuilder();
		String line;
		 while ((line = bufferedReader.readLine()) != null) {
		        contentStringBuilder.append(line);
		    }
		model.addAttribute("content", contentStringBuilder.toString());
		model.addAttribute("blogMode");
		return "content/blog/blogMode";
	}
	@GetMapping("/writeBlog")
	public String writeBlog() {
		return "content/blog/writeBlog";
	}
	@GetMapping("/moveWriteBlogSuccess")
	public String moveWriteBlogSuccess() {
		return "writeblog-success";
	}
	@GetMapping("/moveWriteBlogFail")
	public String moveWriteBlogFail() {
		return "writeblog-fail";
	}
///////////////////////////////////////////////////////////////////////////
	
	
	
	
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
	
	
	@GetMapping("/moveLogin")
	public String loginMove(Model model) {
		model.addAttribute("mode", "login");
		return "log/login";
	}
	@GetMapping("/moveUpdateAccountForm")
	public String moveUpdateAccountForm() {
		return "log/update-form";
	}
	
	
	
}
