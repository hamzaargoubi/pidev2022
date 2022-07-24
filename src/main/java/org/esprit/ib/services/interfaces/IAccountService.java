package org.esprit.ib.services.interfaces;

import org.esprit.ib.domain.Account;
import org.esprit.ib.domain.dto.AccountDto;

import java.util.Collection;
import java.util.UUID;

public interface IAccountService {
    Account save(AccountDto accountDto);

    Collection<AccountDto> getAll();

    boolean delete(UUID uuid);
}
