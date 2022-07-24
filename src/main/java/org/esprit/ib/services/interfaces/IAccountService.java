package org.esprit.ib.services.interfaces;

import org.esprit.ib.domain.dto.AccountDto;

import java.util.Collection;
import java.util.UUID;

public interface IAccountService {
    void save(AccountDto accountDto);

    Collection<AccountDto> getAll();

    void delete(UUID uuid);
}
