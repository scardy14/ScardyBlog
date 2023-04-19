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
@Table(name="category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize = 1)
public class Category {
	@Id
	@Column(name="seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
	int seq;
	
	@Column
	String category;

	public Category(String category) {
		super();
		this.category = category;
	}
	
	

}
