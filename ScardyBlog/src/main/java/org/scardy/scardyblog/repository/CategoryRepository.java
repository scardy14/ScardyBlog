package org.scardy.scardyblog.repository;

import org.scardy.scardyblog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String>{

}
