package org.scardy.scardyblog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="account")
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
