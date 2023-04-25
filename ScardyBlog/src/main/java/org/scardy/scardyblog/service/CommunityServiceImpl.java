package org.scardy.scardyblog.service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

import org.scardy.scardyblog.entity.Community;
import org.scardy.scardyblog.repository.CommunityRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {
	private final CommunityRepository communityRepository;

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
