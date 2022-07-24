package org.esprit.ib.domain;

import lombok.*;
import org.esprit.ib.domain.dto.AccountDto;
import org.esprit.ib.domain.types.AccountType;
import org.esprit.ib.utils.CodeGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

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
    @Column(name = "type", nullable = false)
    private AccountType accountType;

    private final String serialCode = CodeGenerator.generate();

    private double balance;

    @ManyToOne
    @JoinColumn(name = "owner")
    private Client client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            joinColumns = @JoinColumn(name = "transaction", referencedColumnName = "id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "source", referencedColumnName = "source"),
                    @JoinColumn(name = "recipient", referencedColumnName = "recipient")
            }
    )
    private List<Transaction> transactions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiary")
    private List<Loan> loans;


    public AccountDto toDto() {
        return AccountDto
                .builder()
                .uuid(uuid)
                .accountType(accountType)
                .balance(balance)
                .clientDto(client != null ? client.toDto() : null)
                .build();
    }
}
