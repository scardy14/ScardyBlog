package org.scardy.scardyblog.repository;

import java.util.List;

import org.scardy.scardyblog.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommunityRepository extends JpaRepository<Community, Integer>{
	@Query("SELECT MAX(postNo) FROM Community")
	int findMaxNo();
	
	@Query("SELECT c FROM Community c where category= ?1 AND rownum <=4 ORDER BY rownum DESC")
	List<Community> findListByCategoryForMain(String category);
	
	@Query("SELECT c FROM Community c where  category= ?1 ORDER BY c.postNo DESC")
	List<Community> findListByCategoryForCommunity(String category);
	
	@Query("SELECT c FROM Community c where  rownum<=4 ORDER BY c.postNo DESC")
	List<Community> findListByRecent4();

}
