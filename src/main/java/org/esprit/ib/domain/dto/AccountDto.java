package org.esprit.ib.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.esprit.ib.domain.entities.Account;
import org.esprit.ib.domain.types.AccountType;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private UUID uuid;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;
    @JsonProperty("account_type")

    private AccountType accountType;
    private double balance;

    @JsonProperty("client")
    private ClientDto clientDto;

    public Account toEntity() {
        return Account.builder()
                .accountType(accountType)
                .build();
    }

}
