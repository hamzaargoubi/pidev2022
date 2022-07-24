package org.esprit.ib.services;

import org.esprit.ib.domain.Account;
import org.esprit.ib.domain.Client;
import org.esprit.ib.domain.dto.AccountDto;
import org.esprit.ib.repositories.AccountRepository;
import org.esprit.ib.repositories.ClientRepository;
import org.esprit.ib.services.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void save(AccountDto accountDto) {
        Client client = clientRepository.findByEmail(accountDto.getEmail());
        if (client == null) {
            return;
        }
        Account account = accountDto.toEntity();
        account.setClient(client);
        accountRepository.save(account);
    }

    @Override
    public Collection<AccountDto> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(Account::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID uuid) {
        accountRepository.deleteById(uuid);
    }
}
