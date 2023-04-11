package org.scardy.scardyblog.repository;

import java.util.List;

import org.scardy.scardyblog.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BlogRepository extends JpaRepository<Board, Integer>{
	@Query("SELECT MAX(postNo) FROM Board")
	int findMaxNo();
	
	@Query("SELECT b FROM Board b where rownum <=4 AND category= ?1 ORDER BY rownum DESC")
	List<Board> findListByCategoryForBlog(String category);

}
