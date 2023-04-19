package org.scardy.scardyblog.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.scardy.scardyblog.entity.Board;
import org.scardy.scardyblog.entity.Category;

public interface BlogService {
	public boolean wirteBlogPost(String id, String category, String title, StringBuilder content, String thumbnail );
	
	public Board findBlogPostInfoDetail(int postNo) throws SQLException, IOException;
	
	public StringBuilder findBlogPostContentDetail(int postNo) throws SQLException, IOException;
	
	//public List<Board> findBlogPostListByCategoryForBlog(String category);
	
	public List<Board> findListByCategoryForBlogMode(String category);
	
	public List<Board> findBlogPostList(String postNo);
	
	public List<Board> findListByCategoryForBlog(String category);

	public String writeCategory(Category category);
	
}
