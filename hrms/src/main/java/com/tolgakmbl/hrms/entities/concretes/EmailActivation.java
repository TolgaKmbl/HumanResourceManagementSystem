package com.tolgakmbl.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="email_activations")
public class EmailActivation {	
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@JoinColumn(name = "user_id")
	@ManyToOne()
	private User user;
	
	@NotBlank
	@Size(max = 200)
	@Column(name = "activation_code")
	private String activationCode;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "is_activated", columnDefinition = "boolean default false")
	private boolean isActivated = false;
	
    @NotNull
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;
    
	@Column(name = "activation_date")
	private LocalDateTime activationDate;

	
}
