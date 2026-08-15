package com.gestaodecondominios.Entities;

import jakarta.persistence.*;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import com.gestaodecondominios.Entities.Enums.TicketsStatusEnum;


@Entity
@Table(name = "tb_tickets")

public class TicketsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable = false, length = 150)
	private String title;
	
	@Column(nullable = false)
	private String description;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User author;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TicketsStatusEnum status;
	
	
	@CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
	private Instant createdAt;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public TicketsStatusEnum getStatus() {
		return status;
	}

	public void setStatus(TicketsStatusEnum status) {
		this.status = status;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
