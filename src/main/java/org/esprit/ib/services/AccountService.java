package org.esprit.ib.services;

import org.esprit.ib.domain.Account;
import org.esprit.ib.domain.dto.AccountDto;
import org.esprit.ib.repositories.AccountRepository;
import org.esprit.ib.services.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(AccountDto accountDto) {
        return accountRepository.save(accountDto.toEntity());
    }

    @Override
    public Collection<AccountDto> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(Account::toDto)
                .collect(Collectors.toList());
    }
}
