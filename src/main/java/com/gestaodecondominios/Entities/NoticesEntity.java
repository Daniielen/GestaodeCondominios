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
	private String description;
	
	@Column(nullable = false, length = 500)
	private String content;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Instant created_at;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Long user_id;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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


	public Long getUser_id() {
		return user_id;
	}


	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	
}