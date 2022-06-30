package org.esprit.ib.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.esprit.ib.domain.embeddables.Credentials;
import org.esprit.ib.domain.types.ClientType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ClientType clientType;

    @Embedded
    private Credentials credentials;
    private String name;
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Account> accounts;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Post> posts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Comment> comments;
}
