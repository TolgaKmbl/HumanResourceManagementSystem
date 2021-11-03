package com.tolgakmbl.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="employers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User{
	
	@Column(name="company_name")
	@NotBlank
	private String companyName;
	
	@Column(name = "company_image_url")
	private String companyImageUrl;
	
	@Column(name="website")
	@NotBlank
	private String website;
	
	@Column(name="phone_number")
	@NotBlank
	private String phone;	
	
	@Builder(builderMethodName = "childBuilder")
	public Employer(final int id, @NotBlank @Email @Size(max = 100) final String email,
			@NotBlank @Size(max = 100) final String password, @NotBlank @Size(max = 100) final String companyName,
			@NotBlank @Size(max = 100) final String website,
			@NotBlank @Size(max = 15) final String phone) {
		super(id, email, password);
		this.companyName = companyName;
		this.website = website;
		this.phone = phone;
	}
}
