package org.scardy.scardyblog.repository;

import java.util.List;

import org.scardy.scardyblog.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemoRepository extends JpaRepository<Memo, Integer>{
	@Query("SELECT MAX(postNo) FROM Memo")
	int findMaxNo();
	
	@Query("SELECT m FROM Memo m where category= ?1 AND rownum <=4 ORDER BY rownum DESC")
	List<Memo> findListByCategoryForMain(String category);
	
	@Query("SELECT m FROM Memo m where  category= ?1 ORDER BY m.postNo DESC")
	List<Memo> findListByCategoryForMemo(String category);
	
	@Query("SELECT m FROM Memo m where  rownum<=4 ORDER BY m.postNo DESC")
	List<Memo> findListByRecent4();

}
