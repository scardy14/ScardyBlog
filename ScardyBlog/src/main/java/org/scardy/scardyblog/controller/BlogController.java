package org.scardy.scardyblog.controller;


import org.scardy.scardyblog.entity.Category;
import org.scardy.scardyblog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@Transactional
public class BlogController {
	private final BlogService blogService;
	
	@PostMapping("/writeBlogPost")
	public String writeBlogPost(@RequestParam("id")String id, @RequestParam("category")String category, @RequestParam("title")String title, @RequestParam("content")StringBuilder content, @RequestParam("thumbnail")String thumbnail) {
		try {
			blogService.wirteBlogPost(id, category, title, content, thumbnail);
			System.out.println(content);
			return "redirect:/moveWriteBlogSuccess";
		} catch (Exception e) {
			return "redirect:/moveWriteBlogFail";
		}
	}
	
	@PostMapping("/updateBlogPost")
	public String updateBlogPost(@RequestParam("postNo")int postNo, @RequestParam("id")String id, @RequestParam("category")String category, @RequestParam("title")String title, @RequestParam("content")StringBuilder content, @RequestParam("thumbnail")String thumbnail) {
		try {
			blogService.updateBlogPost(id, postNo, category, title, content, thumbnail);
			return "redirect:/moveWriteBlogSuccess";
		} catch (Exception e) {
			return "redirect:/moveWriteBlogFail";
		}
	}
	
	@PostMapping("/writeCategory")
	@ResponseBody
	public String writeCategory(@RequestParam("category") String category, Model model) {
		Category newCategory = new Category(category);
		try {
			blogService.writeCategory(newCategory);
			return "success";
		} catch (Exception e) {
			return "fail";
		}
	}
	

}
