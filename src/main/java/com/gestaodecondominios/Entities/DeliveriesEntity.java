package com.gestaodecondominios.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_deliveries")

public class DeliveriesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable = false, length = 255)
	private String description;
	
	@Column(nullable = true, length = 100)
	private String trackingCode;
	
	@ManyToOne
	@JoinColumn(name = "unit_id")
	private Long unitId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Long receivedById;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime receivedAt;
	
	@Column(nullable = false, length = 20)
	private String status;
	
	@ManyToOne
	@JoinColumn(nullable = true, name = "user_id")
	private Long deliveredById;
	
	@Column(nullable = true, length = 100)
	private String recipientName;
	
	@Column(nullable = true, updatable = false)
	private LocalDateTime deliveredAt;
	
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public Long getReceivedById() {
		return receivedById;
	}

	public void setReceivedById(Long receivedById) {
		this.receivedById = receivedById;
	}

	public LocalDateTime getReceivedAt() {
		return receivedAt;
	}

	public void setReceivedAt(LocalDateTime receivedAt) {
		this.receivedAt = receivedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getDeliveredById() {
		return deliveredById;
	}

	public void setDeliveredById(Long deliveredById) {
		this.deliveredById = deliveredById;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public LocalDateTime getDeliveredAt() {
		return deliveredAt;
	}

	public void setDeliveredAt(LocalDateTime deliveredAt) {
		this.deliveredAt = deliveredAt;
	}
	
	
}
