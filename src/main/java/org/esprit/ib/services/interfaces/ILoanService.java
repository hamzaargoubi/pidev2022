package org.esprit.ib.services.interfaces;


import org.esprit.ib.domain.dto.LoanDto;

import java.util.Collection;
import java.util.UUID;

public interface ILoanService {

    void save(LoanDto loanDto,UUID accountUuid);

    Collection<LoanDto> getAll();

    void delete(UUID uuid);
}
