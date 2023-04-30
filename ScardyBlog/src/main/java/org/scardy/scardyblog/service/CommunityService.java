package org.scardy.scardyblog.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.scardy.scardyblog.entity.Community;

public interface CommunityService {
	public boolean wirteCommunityPost(String id, String title, StringBuilder content, String thumbnail );
	
	public List<Community> findCommunityListByRecent4();
	
	public StringBuilder findCommunityContentByPostNo(int postNo) throws SQLException, IOException;
	
	public Community findCommunityInfoByPostNo(int postNo);
	
	public List<Community> findCommunityList();
	
	

	
}
