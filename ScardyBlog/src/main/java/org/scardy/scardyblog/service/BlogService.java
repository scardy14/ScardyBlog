package org.scardy.scardyblog.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.scardy.scardyblog.entity.Blog;
import org.scardy.scardyblog.entity.Category;

public interface BlogService {
	public boolean wirteBlogPost(String id, String category, String title, StringBuilder content, String thumbnail );
	
	public Blog findBlogInfoByPostNo(int postNo) throws SQLException, IOException;
	
	public StringBuilder findBlogContentByPostNo(int postNo) throws SQLException, IOException;
	
	public List<Blog> findListByCategoryForBlogMode(String category);
	
	public List<Blog> findBlogPostList(String postNo);
	
	public List<Blog> findListByCategoryForBlog(String category);
	
	public List<Blog> findListByRecent4();

	public String writeCategory(Category category);
	
}
