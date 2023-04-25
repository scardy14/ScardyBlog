package org.scardy.scardyblog.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.scardy.scardyblog.entity.Blog;
import org.scardy.scardyblog.entity.Category;

public interface BlogService {
	public boolean wirteBlogPost(String id, String category, String title, StringBuilder content, String thumbnail );
	
	public Blog findBlogPostInfoDetail(int postNo) throws SQLException, IOException;
	
	public StringBuilder findBlogPostContentDetail(int postNo) throws SQLException, IOException;
	
	//public List<Board> findBlogPostListByCategoryForBlog(String category);
	
	public List<Blog> findListByCategoryForBlogMode(String category);
	
	public List<Blog> findBlogPostList(String postNo);
	
	public List<Blog> findListByCategoryForBlog(String category);
	
	public List<Blog> findListByRecent4();

	public String writeCategory(Category category);
	
}
