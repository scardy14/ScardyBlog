package org.scardy.scardyblog.configure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.scardy.scardyblog.entity.Account;
import org.scardy.scardyblog.entity.Grade;
import org.scardy.scardyblog.repository.AccountRepository;
import org.scardy.scardyblog.repository.GradeRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class MemberAuthenticationProvider implements AuthenticationProvider{	
	private final AccountRepository accountRepository;
	private final GradeRepository gradeRepository;
	//private final BCryptPasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {		
		//1.파라미터로 전달받은 Authentication 객체에 대해 지정한 id , password 방식의 인증처리를 지원하지 않으면 null을 리턴한다.
		//  supports 메서드는 아래에 오버라이딩 되어있음 
		if(!supports(authentication.getClass())){
			return null;
		}
		//2.사용자 정보 DB로부터 조회
		String id = authentication.getName();//사용자가 로그인시 입력한 ID 반환
		String password=(String) authentication.getCredentials();//사용자가 입력한 패스워드 반환
		
		Optional<Account> accountOptional = accountRepository.findById(id);
		Account account = accountOptional.get();
		if(account == null){
			System.out.println("회원아이디가 없습니다.");
			throw new UsernameNotFoundException("회원 아이디가 존재하지 않습니다");
			
		}
		
		/*
        if (passwordEncoder.matches(password, account.getPassword())) {//! 비밀번호가 일치하지 않으면  
            System.out.println("비번불일치");    
        	throw new BadCredentialsException("비밀번호가 일치하지 않습니다");
                
        }
        */
		if (!password.equals(account.getPassword())) {//! 비밀번호가 일치하지 않으면  
        	throw new BadCredentialsException("비밀번호가 일치하지 않습니다");
                
        }
		
		//4.사용자 권한 조회
        Optional<Grade> gradeOptional = gradeRepository.findById(id);
        Grade grade = gradeOptional.get();
        
        
        
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(grade.getGrade()));
		Authentication auth = new UsernamePasswordAuthenticationToken(id, password, authorities);
		return auth;		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}	
}
