package org.scardy.scardyblog.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="authority")
@AllArgsConstructor
@NoArgsConstructor
public class Authority implements Serializable {
	private static final long serialVersionUID = -7679094053339103491L;
	@Column(name="id")
	@Id
	private String id;
	@Column
	private String grade;
}
