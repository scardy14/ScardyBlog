package org.scardy.scardyblog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity // VO라는걸 알려주는거
@Table(name="account") //어느 테이블에서 정보를 연동시킬지
@AllArgsConstructor
@NoArgsConstructor
public class Account{
	@Column(name="id")
	@Id
	private String id;
	@Column
	private String password;
	@Column
	private String tel;
	@Column
	private String name;
	@Column
	private String nickname;
}
