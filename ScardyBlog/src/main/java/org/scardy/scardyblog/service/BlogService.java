package org.scardy.scardyblog.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.scardy.scardyblog.entity.Blog;
import org.scardy.scardyblog.entity.Category;

public interface BlogService {
	
	public void wirteBlogPost(String id, String category, String title, StringBuilder content, String thumbnail ) throws SerialException, SQLException;
	
	public void updateBlogPost(String id, int postNo, String category, String title, StringBuilder content, String thumbnail ) throws SerialException, SQLException;
	
	public Blog findBlogInfoByPostNo(int postNo) throws SQLException, IOException;
	
	public StringBuilder findBlogContentByPostNo(int postNo) throws SQLException, IOException;
	
	public List<Blog> findListByCategory4(String category);
	
	public List<Blog> findListByCategoryAll(String category);
	
	public List<Blog> findListByRecent4();

	public void writeCategory(Category category);
	
}
