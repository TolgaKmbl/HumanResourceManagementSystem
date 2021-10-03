package com.tolgakmbl.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "mernis_activations")
public class MernisActivation {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @JoinColumn(name = "user_id")
    @OneToOne()
    private User user;

    @NotNull
    @PastOrPresent
    @Column(name = "approval_date")
    private LocalDateTime approvalDate;

    @NotNull
    @Column(name = "is_approved", columnDefinition = "boolean default false")
    private boolean isApproved = false;

    @Builder
    public MernisActivation(final int id, @NotNull final User user, @NotNull final boolean isApproved,
                            @NotNull @PastOrPresent final LocalDateTime approvalDate) {
        this.id = id;
        this.user = user;
        this.isApproved = isApproved;
        this.approvalDate = approvalDate;
    }
    
}
