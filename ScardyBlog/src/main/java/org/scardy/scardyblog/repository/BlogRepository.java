package org.scardy.scardyblog.repository;

import org.scardy.scardyblog.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BlogRepository extends JpaRepository<Board, Integer>{
	@Query("SELECT MAX(postNo) FROM Board")
	int findMaxNo();
	

}
