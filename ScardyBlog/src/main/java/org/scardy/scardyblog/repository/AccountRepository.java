package org.scardy.scardyblog.repository;


import org.scardy.scardyblog.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String>{
	public boolean existsByTel(String tel);
}
