package com.tolgakmbl.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="job_adverts")
public class JobAdvert {


	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@JoinColumn(name = "employer_id")
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Employer employer;

	@NotNull
	@JoinColumn(name = "job_position_id")
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private JobPosition jobPosition;

	@NotNull
	@JoinColumn(name = "city_id")
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private City city;

	@JoinColumn(name = "working_type_id")
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private WorkingType workingType;

	@JoinColumn(name = "working_time_id")
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private WorkingTime workingTime;

	@NotBlank
	@Column(name = "description")
	private String description;

	@PositiveOrZero
	@Column(name = "min_salary")
	private int minSalary;

	@PositiveOrZero
	@Column(name = "max_salary")
	private int maxSalary;
	
	@PastOrPresent
	@Column(name = "created_at", columnDefinition = "Date default " + "CURRENT_TIMESTAMP")
	private final LocalDateTime createdAt = LocalDateTime.now();

	@Positive
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;

	@Future
	@Column(name = "application_deadline")
	private LocalDateTime applicationDeadline;

	@Column(name = "is_active", columnDefinition = "boolean default false")
	private boolean isActive = false;

	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;

}
