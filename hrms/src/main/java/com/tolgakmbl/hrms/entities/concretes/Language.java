package com.tolgakmbl.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "languages")
public class Language {
	
	@Column(name = "id")
	@Id
	@Size(min = 2, max = 2)
	@NotBlank
	private String id;

	@NotBlank
	@Column(name = "name")
	private String name;

}
