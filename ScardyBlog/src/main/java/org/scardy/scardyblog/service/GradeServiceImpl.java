package org.scardy.scardyblog.service;

import org.scardy.scardyblog.entity.Grade;
import org.scardy.scardyblog.repository.GradeRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService{
	private final GradeRepository gradeRepository;
	@Override
	public boolean register(String id) {
		Grade grade= new Grade(id, "normal");
		boolean result=false;
		try {
			gradeRepository.save(grade);
			result = true;
		} catch (Exception e) {
			result = false;
		}
		
		return result;
	}

}
