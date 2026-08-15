package com.gestaodecondominios.Entities;

import jakarta.persistence.*;
import com.gestaodecondominios.Entities.Enums.*;
import java.time.LocalDate;

public class ReservationsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate start_date;
	
	@Column(nullable = false)
	private LocalDate end_time;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatusReservationEnum status;
	
	@ManyToOne
	@JoinColumn(name = "common_area_id", nullable = false)
	private CommonArea common_area;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalDate end_time) {
		this.end_time = end_time;
	}

	public StatusReservationEnum getStatus() {
		return status;
	}

	public void setStatus(StatusReservationEnum status) {
		this.status = status;
	}

	public CommonArea getCommon_area() {
		return common_area;
	}

	public void setCommon_area(CommonArea common_area) {
		this.common_area = common_area;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
