package org.scardy.scardyblog.repository;

import java.util.List;

import org.scardy.scardyblog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	@Query("SELECT MAX(postNo) FROM Blog")
	int findMaxNo();
	
	@Query("SELECT b FROM Blog b where b.category= ?1 AND b.status = 'visible' AND rownum <=4 ORDER BY b.postNo DESC")
	List<Blog> findListByCategoryForBlog(String category);
	
	@Query("SELECT b FROM Blog b where b.status = 'visible' AND category= ?1 ORDER BY b.postNo DESC")
	List<Blog> findListByCategoryForBlogMode(String category);
	
	@Query("SELECT b FROM Blog b where b.status = 'visible' AND rownum<=4 ORDER BY b.postNo DESC")
	List<Blog> findListByRecent4();

}
