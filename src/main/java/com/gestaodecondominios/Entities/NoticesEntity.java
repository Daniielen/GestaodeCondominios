package com.gestaodecondominios.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.Instant;

@Entity
@Table(name = "tb_notices")
public class NoticesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false, length = 500)
	private String content;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Instant created_at;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Long author_id;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Instant getCreated_at() {
		return created_at;
	}


	public void setCreated_at(Instant created_at) {
		this.created_at = created_at;
	}


	public Long getAuthor_id() {
		return author_id;
	}


	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}

	
	
	
}