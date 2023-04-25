package org.scardy.scardyblog.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.scardy.scardyblog.entity.Blog;
import org.scardy.scardyblog.service.BlogService;
import org.scardy.scardyblog.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MoveController{
	private final BlogService blogService;
	private final CategoryService categoryService;
	///////////////////////////////////////////////////////////////////////////
	@GetMapping(value= {"/","/index","/home",""})
	public String homeMove(Model model) {
		model.addAttribute("mode", "home");
		List<Blog> list = blogService.findListByRecent4();
		model.addAttribute("recentList", list);
		return "content/index";
	}
	///////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////
	@GetMapping("/moveBlog")
	public String blogMove(Model model) {
		HashMap<String, List<Blog>> hashMap = new HashMap<String, List<Blog>>();
		List<String> categoryList = categoryService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		for(String category : categoryList) {
			hashMap.put(category, blogService.findListByCategoryForBlog(category));
		}
		model.addAttribute("hashMap", hashMap);
		model.addAttribute("mode", "blog");
		return "content/blog/blog";
	}

	@GetMapping("/moveBlogMode")
	public String blogJavaMove(String blogMode, Model model) throws IOException, SQLException {
		model.addAttribute(blogMode+"List", blogService.findListByCategoryForBlogMode(blogMode));
		return "content/blog/blogMode";
	}
	@GetMapping("/moveBlogDetail")
	public String moveBlogDetail(Model model, int postNo) {
		String path;
		try {
			model.addAttribute("board",blogService.findBlogPostInfoDetail(postNo));
			model.addAttribute("content",blogService.findBlogPostContentDetail(postNo).toString());
			path = "content/blog/blogDetail";
		} catch (SQLException | IOException e) {
			path = "content/blog/blogDetail-fail";
			e.printStackTrace();
		}
		return path;
	}
	@GetMapping("/moveWriteBlogForm")
	public String moveWriteBlogForm(Model model) {
		List<String> cList = categoryService.findAllCategory();
		model.addAttribute("cList",cList);
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
	@GetMapping("/moveUpdateCategory")
	public String moveUpdateCategory(Model model) {
		List<String> categoryList = categoryService.findAllCategory();
		model.addAttribute("categoryList", categoryList);
		return "content/blog/updateCategory";
	}
	///////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////
	
	
	@GetMapping("/moveAbout")
	public String aboutMove(Model model) {
		model.addAttribute("mode", "abount");
		return "content/about";
	}
	@GetMapping("/moveMemo")
	public String moveMemo(Model model) {
		model.addAttribute("mode", "memo");
		return "content/memo";
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////
	@GetMapping("/moveCommunity")
	public String moveCommunity(Model model) {
		model.addAttribute("mode", "community");
		return "content/community";
	}
	///////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////
	@GetMapping("/moveLogin")
	public String loginMove(Model model) {
		model.addAttribute("mode", "log");
		return "log/login";
	}
	@GetMapping("/moveRegisterFrom")
	public String moveRegisterFrom() {
		return "log/registerForm";
	}
	@GetMapping("/moveRegisterSuccess")
	public String moveRegisterSuccess() {
		return "log/registerSuccess";
	}
	@GetMapping("/moveRegisterFail")
	public String moveRegisterFail() {
		return "log/registerFail";
	}
	@GetMapping("/moveUpdateAccountForm")
	public String moveUpdateAccountForm() {
		return "log/updateForm";
	}
	///////////////////////////////////////////////////////////////////////////
	
	
	
}
