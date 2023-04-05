package org.scardy.scardyblog.controller;

import java.sql.SQLException;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

import org.scardy.scardyblog.entity.Board;
import org.scardy.scardyblog.repository.BlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@Transactional
public class BlogController {
	private final BlogRepository blogRepositry;
	private final EntityManager entityManager;
	
	@PostMapping("/writeBlogPost")
	public String writeBlogPost(@RequestParam("id")String id, @RequestParam("category")String category, @RequestParam("title")String title, @RequestParam("content")StringBuilder content) {
		Board board = new Board();
		board.setId(id);
		board.setCategory(category);
		board.setTitle(title);
		SerialClob clobContent;
		try {
			clobContent = new SerialClob(content.toString().toCharArray());
			board.setContent(clobContent);
			System.out.println(board);
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		entityManager.persist(board);
		entityManager.close();
		return "redirect:/moveBlog";
	}


}
