package com.tolgakmbl.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;


@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@Table(name="company_staffs")
@PrimaryKeyJoinColumn(name = "user_id")
public class CompanyStaff extends User{
	
	@NotBlank
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@Column(name = "last_name")
	private String lastName;
	
	@Builder(builderMethodName = "childBuilder")
	public CompanyStaff(final int id, final String email, final String password, final String firstName,
			final String lastName) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
