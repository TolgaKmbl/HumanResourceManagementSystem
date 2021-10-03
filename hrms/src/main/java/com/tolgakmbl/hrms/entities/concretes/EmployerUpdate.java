package com.tolgakmbl.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Table(name="employer_updates")
public class EmployerUpdate {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Employer employer;

	@NotBlank
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "company_image_url")
	private String companyImageUrl;

	@NotBlank
	@Size(max = 100)
	@Column(name = "website")
	private String website;

	@NotBlank
	@Size(max = 15)
	@Column(name = "phone_number")
	private String phone;
	
	@NotNull
	@Column(name = "updated_at")
	private final LocalDateTime updatedAt = LocalDateTime.now();

	@NotNull
	@Column(name = "is_approved", columnDefinition = "boolean default false")
	private boolean isApproved = false;

	@NotNull
	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;
	
}
