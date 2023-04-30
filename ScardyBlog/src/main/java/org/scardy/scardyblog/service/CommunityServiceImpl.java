package org.scardy.scardyblog.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

import org.scardy.scardyblog.entity.Blog;
import org.scardy.scardyblog.entity.Community;
import org.scardy.scardyblog.repository.CommunityRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {
	private final CommunityRepository communityRepository;
	
	@Override
	public List<Community> findCommunityList() {
		List<Community> communityList = communityRepository.findCommunityList();
		return communityList;
	}
	
	@Override
	public List<Community> findCommunityListByRecent4() {
		List<Community> communityList= communityRepository.findCommunityListByRecent4();
		return communityList;
	}
	
	@Override
	public Community findCommunityInfoByPostNo(int postNo) {
		Community d_community = communityRepository.findById(postNo).get();
		Community community = new Community(
				d_community.getPostNo(),
				d_community.getCategory(),
				d_community.getTitle(),
				d_community.getId(),
				d_community.getPost_date(),
				d_community.getUpdate_date(),
				d_community.getThumbnail()				
				);
		;
		return community;
	}
	
	@Override
	public StringBuilder findCommunityContentByPostNo(int postNo) throws SQLException, IOException {
		Clob clob = communityRepository.findById(postNo).get().getContent();	
		Reader finder = clob.getCharacterStream();
		BufferedReader bufferedfinder = new BufferedReader(finder);
		StringBuilder contentStringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedfinder.readLine()) != null) {
			contentStringBuilder.append(line);
		}
		return contentStringBuilder;
	}

	


	@Transactional
	public boolean wirteCommunityPost(String id, String title, StringBuilder content, String thumbnail ) {
		Community community = new Community();
		community.setId(id);
		community.setTitle(title);
		community.setThumbnail(thumbnail);
		SerialClob clobContent;
		try {
			clobContent = new SerialClob(content.toString().toCharArray());
			community.setContent(clobContent);
			LocalDateTime now = LocalDateTime.now();
			community.setPost_date(Date.valueOf(now.toLocalDate()));;
			communityRepository.save(community);
		} catch (SerialException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
