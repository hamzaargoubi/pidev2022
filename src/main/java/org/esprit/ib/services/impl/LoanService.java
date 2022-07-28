package org.esprit.ib.services.impl;

import org.esprit.ib.domain.dto.LoanDto;
import org.esprit.ib.domain.entities.Account;
import org.esprit.ib.domain.entities.Loan;
import org.esprit.ib.repositories.AccountRepository;
import org.esprit.ib.repositories.ClientRepository;
import org.esprit.ib.repositories.LoanRepository;
import org.esprit.ib.services.interfaces.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LoanService implements ILoanService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private LoanRepository loanRepository;

    @Override
    public void save(LoanDto loanDto, UUID accountUuid) {
        Account account = accountRepository.findById(accountUuid).orElse(null);
        if (account == null){
            return;
        }
        Loan loan = loanDto.toEntity();
        loan.setBeneficiary(account);

        loanRepository.save(loan);

    }

    @Override
    public Collection<LoanDto> getAll() {
        return loanRepository.findAll()
                .stream()
                .map(Loan::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID uuid) {
        loanRepository.deleteById(uuid);
    }
}
