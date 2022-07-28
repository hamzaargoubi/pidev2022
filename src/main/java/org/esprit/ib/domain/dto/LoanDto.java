package org.esprit.ib.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.esprit.ib.domain.entities.Loan;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
    private UUID uuid;

    private Date initialDate;
    private Date maturityDate;
    private int installments;
    private double totalAmount;
    private double paidAmount;

    @JsonProperty("account")
    private AccountDto beneficiary;

    public Loan toEntity() {
        return Loan.builder()
                .initialDate(initialDate)
                .maturityDate(maturityDate)
                .installments(installments)
                .totalAmount(totalAmount)
                .paidAmount(paidAmount)
                .build();
    }
}
