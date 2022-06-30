package org.esprit.ib.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.esprit.ib.domain.types.AccountType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AccountType accountType;

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

}
