package com.tolgakmbl.hrms.entities.dtos;

import javax.validation.constraints.*;

import com.tolgakmbl.hrms.core.entities.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class EmployerForUpdateDto implements Dto {
	@NotNull
	private int employerId;

	@NotBlank
	@Size(max = 100)
	private String companyName;

	@NotBlank
	@Size(max = 100)
	private String website;

	@NotBlank
	@Size(max = 15)
	private String phone;

	@NotBlank
	@Size(max = 100)
	private String password;
}
