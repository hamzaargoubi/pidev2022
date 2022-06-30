package org.esprit.ib.services.interfaces;

import org.esprit.ib.domain.Account;
import org.esprit.ib.domain.dto.AccountDto;

import java.util.Collection;

public interface IAccountService {
    Account save(AccountDto accountDto);

    Collection<AccountDto> getAll();
}
