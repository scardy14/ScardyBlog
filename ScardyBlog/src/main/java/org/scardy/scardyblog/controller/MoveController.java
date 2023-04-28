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
		model.addAttribute("recentList", blogService.findListByRecent4());
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
			hashMap.put(category, blogService.findListByCategory4(category));
		}
		model.addAttribute("hashMap", hashMap);
		model.addAttribute("mode", "blog");
		return "content/blog/blog";
	}

	@GetMapping("/moveBlogMode")
	public String blogJavaMove(String blogMode, Model model) throws IOException, SQLException {
		model.addAttribute("list", blogService.findListByCategoryAll(blogMode));
		return "content/blog/blogMode";
	}
	@GetMapping("/moveBlogDetail")
	public String moveBlogDetail(Model model, int postNo) {
		try {
			model.addAttribute("board",blogService.findBlogInfoByPostNo(postNo));
			model.addAttribute("content",blogService.findBlogContentByPostNo(postNo).toString());
			return "content/blog/blogDetail";
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return "content/blog/blogDetail-fail";			
		}
	}
	@GetMapping("/moveWriteBlogForm")
	public String moveWriteBlogForm(Model model) {
		model.addAttribute("categoryList",categoryService.findAllCategory());
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
		model.addAttribute("categoryList", categoryService.findAllCategory());
		return "content/blog/updateCategory";
	}
	@GetMapping("/moveUpdateBlog")
	public String moveUpdateBlog(Model model, int postNo) {
		try {
			model.addAttribute("categoryList", categoryService.findAllCategory());
			model.addAttribute("board",blogService.findBlogInfoByPostNo(postNo));
			model.addAttribute("content",blogService.findBlogContentByPostNo(postNo).toString());
			return "content/blog/updateBlog";
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return "content/blog/blogDetail-fail";	
		}
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
