package com.tolgakmbl.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "job_seeker_cvs")
public class JobSeekerCV {
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@JoinColumn(name = "job_seeker_id")
	@OneToOne
	private JobSeeker jobSeeker;
	
	@Column(name = "cover_letter")
	private String coverLetter;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVImage> images;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVWebSite> webSites;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVEducation> educations;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVExperience> experiences;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVSkill> skills;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVLanguage> languages;


}
