package com.tolgakmbl.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "cities")
public class City {
	
	@Column(name = "id")
	@Id
	private short id;

	@NotBlank
	@Column(name = "name")
	private String name;

}