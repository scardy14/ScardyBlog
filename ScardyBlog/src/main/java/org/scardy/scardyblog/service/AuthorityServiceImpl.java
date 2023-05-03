package org.scardy.scardyblog.service;

import org.scardy.scardyblog.entity.Authority;
import org.scardy.scardyblog.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService{
	private final AuthorityRepository authorityRepository;
	@Override
	public boolean register(String id) {
		Authority grade= new Authority(id, "NORMAL");
		boolean result=false;
		try {
			authorityRepository.save(grade);
			result = true;
		} catch (Exception e) {
			result = false;
		}
		
		return result;
	}

}
