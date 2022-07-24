package org.esprit.ib.services.interfaces;

import org.esprit.ib.domain.Transaction;

import java.util.List;
import java.util.UUID;

public interface ITransactionService {
    public void save(Transaction transaction);
    public void delete(UUID uuid);
    public Transaction getTransactionByUUID(UUID uuid);
    public List<Transaction> getTransactions();
}
