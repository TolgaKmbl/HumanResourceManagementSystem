package com.tolgakmbl.hrms.business.adapters.mernisService;

import javax.validation.constraints.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonForValidateFromMernisService {
	
	@NotBlank
	String ad;
	
	@NotBlank
	String soyad;
	
	@Past
	int dogumYili;
	
	@NotNull
	private long TCKimlikNo;
}
