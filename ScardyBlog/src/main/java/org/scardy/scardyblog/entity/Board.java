package org.scardy.scardyblog.entity;



import java.sql.Clob;
import java.sql.Date;

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
@SequenceGenerator(name = "board_seq", sequenceName = "board_seq", allocationSize = 1)
public class Board {
	@Column(name="post_No")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq")
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
	@Column
	private Date post_date;
	@Column
	private Date update_date;
	@Column
	private String thumbnail;
	public Board(String title, String id, Date post_date, String thumbnail) {
		super();
		this.title = title;
		this.id = id;
		this.post_date = post_date;
		this.thumbnail = thumbnail;
	}
	
	
}
