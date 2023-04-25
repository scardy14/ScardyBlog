package org.scardy.scardyblog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="memo_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "memo_category_seq", sequenceName = "memo_category_seq", allocationSize = 1)
public class MemoCategory {
	@Id
	@Column(name="seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memo_category_seq")
	int seq;
	
	@Column
	String category;

	public MemoCategory(String category) {
		super();
		this.category = category;
	}
	
	

}
