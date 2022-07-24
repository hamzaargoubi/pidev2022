package org.esprit.ib.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.esprit.ib.domain.Client;
import org.esprit.ib.domain.embeddables.Credentials;
import org.esprit.ib.domain.types.ClientType;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private UUID uuid;
    @JsonProperty("client_type")
    private ClientType clientType;
    private String name;
    private String phone;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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
