package org.scardy.scardyblog.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BlogController {
	@PostMapping("/writeBlogPost")
	public String writeBlogPost(@RequestParam("content") StringBuilder content) {
		 System.out.println("글내용: "+ content);
		return "redirect:/moveBlog";
	}
	@PostMapping("/writeBlogPostImage")
	public String writeBlogPostImage(@RequestParam("file") MultipartFile file) {
		 System.out.println("사진내용: "+file);
		return "redirect:/moveBlog";
	}


}
