package org.scardy.scardyblog.controller;

import org.scardy.scardyblog.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommunityController {
	private final CommunityService communityService;
	
	@PostMapping("/writeCommunityPost")
	public String writeCommunityPost(@RequestParam("id")String id, @RequestParam("title")String title, @RequestParam("content")StringBuilder content, @RequestParam("thumbnail")String thumbnail) {
		try {
			communityService.wirteCommunityPost(id, title, content, thumbnail);
			return "redirect:/moveWriteBlogSuccess";
		} catch (Exception e) {
			return "redirect:/moveWriteBlogFail";
		}
	}

}
