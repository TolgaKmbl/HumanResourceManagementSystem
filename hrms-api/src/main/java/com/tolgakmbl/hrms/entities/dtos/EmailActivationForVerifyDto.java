package com.tolgakmbl.hrms.entities.dtos;

import javax.validation.constraints.*;

import com.tolgakmbl.hrms.core.entities.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailActivationForVerifyDto implements Dto {
	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String activationCode;
}
