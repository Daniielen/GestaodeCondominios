package com.gestaodecondominios.Entities;


import java.time.LocalDate;

import com.gestaodecondominios.Entities.Enums.CondoFeesEnum;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_Condo_Fees")

public class CondoFeesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unit_id", nullable = false)
	private Unit unit;
	
	@Column(nullable = false)
	private float amount;
	
	@Column(nullable = false)
	private LocalDate dueDate;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CondoFeesEnum status;
	
	@Column(nullable = true)
	private LocalDate paymentDate;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
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

	public CondoFeesEnum getStatus() {
		return status;
	}

	public void setStatus(CondoFeesEnum status) {
		this.status = status;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
}
