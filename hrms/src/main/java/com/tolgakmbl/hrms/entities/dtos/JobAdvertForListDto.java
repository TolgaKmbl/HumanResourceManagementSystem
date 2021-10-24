package com.tolgakmbl.hrms.entities.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.*;

import com.tolgakmbl.hrms.core.entities.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobAdvertForListDto implements Dto {
	@NotNull
	int id;

	@NotBlank
	@Size(max = 100)
	private String companyName;

	private String companyImageUrl;

	@NotBlank
	private String cityName;

	@NotBlank
	@Size(max = 50)
	private String title;

	@Positive
	private int numberOfOpenPositions;

	@NotBlank
	private String workingTimeName;
	
	@Past
	private LocalDateTime createdAt;

	@Future
	private LocalDateTime applicationDeadline;

	@PositiveOrZero
	private int minSalary;

	@PositiveOrZero
	private int maxSalary;
}
