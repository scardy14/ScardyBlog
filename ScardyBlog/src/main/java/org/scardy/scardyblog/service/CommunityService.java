package org.scardy.scardyblog.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.scardy.scardyblog.entity.Category;
import org.scardy.scardyblog.entity.Community;

public interface CommunityService {
	public boolean wirteCommunityPost(String id, String category, String title, StringBuilder content, String thumbnail );
	

	
}
