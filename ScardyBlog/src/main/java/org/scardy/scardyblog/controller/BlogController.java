package org.scardy.scardyblog.controller;

import org.scardy.scardyblog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@Transactional
public class BlogController {
	private final BlogService blogService;
	
	@PostMapping("/writeBlogPost")
	public String writeBlogPost(@RequestParam("id")String id, @RequestParam("category")String category, @RequestParam("title")String title, @RequestParam("content")StringBuilder content) {
		boolean result = blogService.wirteBlogPost(id, category, title, content);
		String resultPath;
		if(result) {
			resultPath = "redirect:/moveWriteBlogSuccess";
		} else {
			resultPath = "redirect:/moveWriteBlogFail";
		}
		return resultPath;
	}
	

}
