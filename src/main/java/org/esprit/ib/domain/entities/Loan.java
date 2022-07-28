package org.esprit.ib.domain.entities;

import lombok.*;
import org.esprit.ib.domain.dto.LoanDto;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID uuid;

    private Date initialDate;
    private Date maturityDate;
    private int installments;
    private double totalAmount;
    private double paidAmount;

    @ManyToOne
    @JoinColumn(name = "beneficiary")
    private Account beneficiary;

    public LoanDto toDto() {
        return LoanDto.builder()
                .uuid(uuid)
                .beneficiary(beneficiary != null ? beneficiary.toDto() : null)
                .initialDate(initialDate)
                .maturityDate(maturityDate)
                .installments(installments)
                .totalAmount(totalAmount)
                .paidAmount(paidAmount)
                .build();
    }
}
