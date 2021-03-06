package com.tolgakmbl.hrms.entities.concretes;


import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="job_seekers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class JobSeeker extends User{

	@NotBlank
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@Column(name = "last_name")
	private String lastName;

	@NotBlank
	@Column(name = "national_id")
	private String nationalId;

	@NotNull
	@Past
	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Builder(builderMethodName = "childBuilder")
	public JobSeeker(final int id, @NotBlank @Email @Size(max = 100) final String email,
			@NotBlank @Size(max = 100) final String password, @NotBlank @Size(max = 50) final String firstName,
			@NotBlank @Size(max = 50) final String lastName,
			@NotBlank @Size(min = 11, max = 11) final String nationalId, @NotNull @Past final LocalDate birthDate) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalId = nationalId;
		this.birthDate = birthDate;
	}

}
