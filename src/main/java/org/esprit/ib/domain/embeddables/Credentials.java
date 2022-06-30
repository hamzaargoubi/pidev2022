package org.esprit.ib.domain.embeddables;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Credentials {

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
}
