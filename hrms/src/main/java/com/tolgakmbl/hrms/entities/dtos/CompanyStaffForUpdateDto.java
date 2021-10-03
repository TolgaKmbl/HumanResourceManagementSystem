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
public class CompanyStaffForUpdateDto implements Dto {	
	@NotNull
	private int id;

	@NotBlank
	@Size(max = 50)
	private String firstName;

	@NotBlank
	@Size(max = 50)
	private String lastName;

	@NotBlank
	@Size(max = 100)
	private String password;
}
