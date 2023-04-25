package org.scardy.scardyblog.service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

import org.scardy.scardyblog.entity.Community;
import org.scardy.scardyblog.repository.CategoryRepository;
import org.scardy.scardyblog.repository.CommunityRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {
	private final CommunityRepository communityRepository;
	private final CategoryRepository categoryRepository;

	@Transactional
	public boolean wirteCommunityPost(String id, String category, String title, StringBuilder content, String thumbnail ) {
		Community board = new Community();
		board.setId(id);
		board.setCategory(category);
		board.setTitle(title);
		board.setThumbnail(thumbnail);
		SerialClob clobContent;
		try {
			clobContent = new SerialClob(content.toString().toCharArray());
			board.setContent(clobContent);
			LocalDateTime now = LocalDateTime.now();
			board.setPost_date(Date.valueOf(now.toLocalDate()));;
			communityRepository.save(board);
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
