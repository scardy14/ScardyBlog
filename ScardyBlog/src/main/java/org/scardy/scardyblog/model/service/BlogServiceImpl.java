package org.scardy.scardyblog.model.service;

import java.sql.SQLException;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

import org.scardy.scardyblog.entity.Board;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
	private final EntityManager entityManager;

	@Transactional
	public boolean wirteBlogPost(String id, String category, String title, StringBuilder content ) {
		Board board = new Board();
		board.setId(id);
		board.setCategory(category);
		board.setTitle(title);
		SerialClob clobContent;
		try {
			clobContent = new SerialClob(content.toString().toCharArray());
			board.setContent(clobContent);
			entityManager.persist(board);
			entityManager.close();
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
