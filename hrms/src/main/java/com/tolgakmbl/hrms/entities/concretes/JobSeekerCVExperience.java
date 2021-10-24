package com.tolgakmbl.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "job_seeker_cv_experiences")
public class JobSeekerCVExperience {
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@JoinColumn(name = "job_seeker_cv_id")
	@ManyToOne
	private JobSeekerCV jobSeekerCV;
	
	@NotNull
	@JoinColumn(name = "job_position_id")
	@ManyToOne
	private JobPosition jobPosition;
	
	@NotBlank
	@Column(name = "workplace_name")
	private String workplaceName;
	
    @NotNull
    @PastOrPresent
    @Column(name = "start_date")
    private LocalDate startDate;

    @PastOrPresent
    @Column(name = "quit_date")
    private LocalDate quitDate;

}
