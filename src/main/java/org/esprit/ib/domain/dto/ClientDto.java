package org.esprit.ib.domain.dto;

import lombok.*;
import org.esprit.ib.domain.Client;
import org.esprit.ib.domain.embeddables.Credentials;
import org.esprit.ib.domain.types.ClientType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private ClientType clientType;
    private String name;
    private String phone;
    private String email;
    private String password;

    public Client toEntity() {
        return Client.builder()
                .clientType(clientType)
                .name(name)
                .phone(phone)
                .credentials(
                        Credentials.builder()
                                .email(email)
                                .password(password)
                                .build()
                )
                .build();
    }
}
