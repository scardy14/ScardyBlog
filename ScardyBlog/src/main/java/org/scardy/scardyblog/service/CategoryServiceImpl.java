package org.scardy.scardyblog.service;

import java.util.ArrayList;
import java.util.List;

import org.scardy.scardyblog.entity.Category;
import org.scardy.scardyblog.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
	private final CategoryRepository categoryRepository;
	@Override
	public List<String> findAllCategory() {
		List<Category> cList = categoryRepository.findAll();
		List<String> sList = new ArrayList<>();
		for(Category category: cList) {
			sList.add(category.getCategory());
		}
		return sList;
	}
	

}
