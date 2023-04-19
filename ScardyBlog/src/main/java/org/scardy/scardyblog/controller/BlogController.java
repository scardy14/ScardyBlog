package org.scardy.scardyblog.controller;

import org.scardy.scardyblog.entity.Category;
import org.scardy.scardyblog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@Transactional
@RestController
public class BlogController {
	private final BlogService blogService;
	
	@PostMapping("/writeBlogPost")
	public String writeBlogPost(@RequestParam("id")String id, @RequestParam("category")String category, @RequestParam("title")String title, @RequestParam("content")StringBuilder content, @RequestParam("thumbnail")String thumbnail) {
		boolean result = blogService.wirteBlogPost(id, category, title, content, thumbnail);
		String resultPath;
		if(result) {
			resultPath = "redirect:/moveWriteBlogSuccess";
		} else {
			resultPath = "redirect:/moveWriteBlogFail";
		}
		return resultPath;
	}
	
	@PostMapping("/writeCategory")
	@ResponseBody
	public String writeCategory(@RequestParam("category") String category, Model model) {
		Category E_category = new Category(category);
		System.out.println(category);
		String result =  blogService.writeCategory(E_category);
		return result;
	}
	

}
