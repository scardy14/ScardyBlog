package org.scardy.scardyblog;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.scardy.scardyblog.entity.Grade;
import org.scardy.scardyblog.repository.AccountRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

@SpringBootTest
class ScardyBlogApplicationTests {
	@Test
	void contextLoads() {
	}
	
	@Test
	void testJPA() {
		//accountRepository.findById("scardy");
	}

}
