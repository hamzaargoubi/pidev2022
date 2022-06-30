package org.esprit.ib.domain.dto;

import lombok.*;
import org.esprit.ib.domain.Account;
import org.esprit.ib.domain.types.AccountType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private AccountType accountType;
    private double balance;
    private ClientDto clientDto;

    public Account toEntity() {
        return Account.builder()
                .accountType(accountType)
                .build();
    }

}
