package org.scardy.scardyblog.repository;

import java.util.List;

import org.scardy.scardyblog.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommunityRepository extends JpaRepository<Community, Integer>{
	@Query("SELECT c FROM Community c where c.status = 'visible' ORDER BY c.postNo DESC")
	List<Community> findCommunityList();
	
	@Query("SELECT c FROM Community c where c.status = 'visible' AND c.category= ?1 ORDER BY c.postNo DESC")
	List<Community> findCommunityListByCategory(String category);
	
	@Query("SELECT c FROM Community c where c.status = 'visible' AND rownum<=4 ORDER BY c.postNo DESC")
	List<Community> findCommunityListByRecent4();

}
