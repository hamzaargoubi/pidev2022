package org.esprit.ib.services.interfaces;

import org.esprit.ib.domain.Account;
import org.esprit.ib.domain.dto.AccountDto;

public interface IAccountService {
    Account save(AccountDto accountDto);
}
