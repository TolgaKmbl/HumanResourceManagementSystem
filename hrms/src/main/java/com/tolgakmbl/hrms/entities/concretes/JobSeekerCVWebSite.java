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
@Table(name = "job_seeker_cv_web_sites")
public class JobSeekerCVWebSite {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @JoinColumn(name = "job_seeker_cv_id")
    @ManyToOne
    private JobSeekerCV jobSeekerCV;

    @NotNull
    @JoinColumn(name = "web_site_id")
    @ManyToOne
    private WebSite webSite;

    @NotBlank
    @Column(name = "address")
    private String address;
    
}
