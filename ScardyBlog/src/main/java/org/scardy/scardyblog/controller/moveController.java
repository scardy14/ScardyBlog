package org.scardy.scardyblog.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.scardy.scardyblog.entity.Board;
import org.scardy.scardyblog.repository.BlogRepository;
import org.scardy.scardyblog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class moveController{
	private final BlogService blogService;
	private final BlogRepository blogRepository;
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
		model.addAttribute("javaList", blogService.findListByCategoryForBlog("java"));
		model.addAttribute("springbootList", blogService.findListByCategoryForBlog("springboot"));
		model.addAttribute("cssList", blogService.findListByCategoryForBlog("css"));
		return "content/blog/blog";
	}

	@GetMapping("/moveBlogMode")
	public String blogJavaMove(String blogMode, Model model) throws IOException, SQLException {
		//model.add
		//model.addAttribute("content", contentStringBuilder.toString());
		//model.addAttribute("blogMode");
		//return "content/blog/blogMode";
		return"redirect:/moveBlogDetail";
	}
	@GetMapping("/moveBlogDetail")
	public String moveBlogDetail(Model model, int postNo) {
		String path;
		try {
			model.addAttribute("board",blogService.readBlogPostInfoDetail(postNo));
			model.addAttribute("content",blogService.readBlogPostContentDetail(postNo).toString());
			System.out.println(blogService.readBlogPostContentDetail(postNo).toString());
			path = "content/blog/blogDetail";
		} catch (SQLException | IOException e) {
			path = "content/blog/blogDetail-fail";
			e.printStackTrace();
		}
		return path;
	}
	@GetMapping("/moveWriteBlogForm")
	public String moveWriteBlogForm() {
		return "content/blog/writeBlogForm";
	}
	@GetMapping("/moveWriteBlogSuccess")
	public String moveWriteBlogSuccess() {
		return "content/blog/writeblog-success";
	}
	@GetMapping("/moveWriteBlogFail")
	public String moveWriteBlogFail() {
		return "content/blog/writeblog-fail";
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
