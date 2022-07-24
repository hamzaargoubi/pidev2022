package org.esprit.ib.domain.embeddables;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
}
