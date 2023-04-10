package org.scardy.scardyblog.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.scardy.scardyblog.entity.Board;

public interface BlogService {
	public boolean wirteBlogPost(String id, String category, String title, StringBuilder content );
	
	public Board readBlogPostInfoDetail(int postNo) throws SQLException, IOException;
	
	public StringBuilder readBlogPostContentDetail(int postNo) throws SQLException, IOException;
	
	public List<Board> readBlogPostList(String postNo);
	
}
