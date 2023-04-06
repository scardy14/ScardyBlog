package org.scardy.scardyblog.entity;



import java.sql.Clob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="board")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "seq_generator", sequenceName = "board_seq", allocationSize = 1)
public class Board {
	@Column(name="post_No")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@Id
	private int postNo;
	@Column
	private String category;
	@Column
	private String title;
	@Lob
	private Clob content;
	@Column
	private String id;
}