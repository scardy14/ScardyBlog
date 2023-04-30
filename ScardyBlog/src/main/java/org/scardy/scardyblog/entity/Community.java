package org.scardy.scardyblog.entity;



import java.sql.Clob;
import java.sql.Date;
import java.time.LocalDateTime;

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
@Table(name="community")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "community_seq", sequenceName = "community_seq", allocationSize = 1)
public class Community {
	@Column(name="post_No")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "community_seq")
	@Id
	private int postNo;
	@Column
	private String category = "etc";
	@Column
	private String title;
	@Lob
	private Clob content;
	@Column
	private String id;
	@Column
	private Date post_date= Date.valueOf(LocalDateTime.now().toLocalDate());
	@Column
	private Date update_date= Date.valueOf(LocalDateTime.now().toLocalDate());
	@Column
	private String thumbnail;
	@Column
	private String status = "visible";
	
	public Community(String title, String id, Date post_date, String thumbnail) {
		super();
		this.title = title;
		this.id = id;
		this.post_date = post_date;
		this.thumbnail = thumbnail;
	}
	public Community(int postNo, String category, String title, String id, Date post_date, Date update_date,
			String thumbnail) {
		super();
		this.postNo = postNo;
		this.category = category;
		this.title = title;
		this.id = id;
		this.post_date = post_date;
		this.update_date = update_date;
		this.thumbnail = thumbnail;
	}
	
	
	
	
}
