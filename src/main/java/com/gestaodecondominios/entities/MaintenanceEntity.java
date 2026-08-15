package com.gestaodecondominios.Entities;

import jakarta.persistence.*;
import com.gestaodecondominios.Entities.Enums.*;
import java.time.LocalDate;

@Entity
@Table(name="tb_maintenance_task")
public class MaintenanceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 150)
	private String title;
	
	@Column(nullable = false, length = 250)
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatusMaintenanceEnum status;
	
	@Column(nullable = false)
	private LocalDate completed_date;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatusMaintenanceEnum getStatus() {
		return status;
	}

	public void setStatus(StatusMaintenanceEnum status) {
		this.status = status;
	}

	public LocalDate getCompleted_date() {
		return completed_date;
	}

	public void setCompleted_date(LocalDate completed_date) {
		this.completed_date = completed_date;
	}
	
	
	
}