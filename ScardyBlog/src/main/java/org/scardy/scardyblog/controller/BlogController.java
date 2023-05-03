package org.scardy.scardyblog.controller;


import org.scardy.scardyblog.entity.Category;
import org.scardy.scardyblog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String writeCategory(@RequestParam("category") String category, Model model) {
		Category newCategory = new Category(category);
		blogService.writeCategory(newCategory);
		return "redirect:/moveUpdateCategory";
	}
	
	@GetMapping("/deleteCategory")
	public String deleteCategory() {
		return "redirect:/moveUpdateCategory";
	}
	

}
