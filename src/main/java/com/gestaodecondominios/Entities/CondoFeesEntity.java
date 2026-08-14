package com.gestaodecondominios.Entities;


import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_CondoFees")

public class CondoFeesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name = "unit_id")
	private Long unitId;
	
	@Column(nullable = false)
	private float amount;
	
	@Column(nullable = false)
	private LocalDate dueDate;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private LocalDate paymentDate;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
}
