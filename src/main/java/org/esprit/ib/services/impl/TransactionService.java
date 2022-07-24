package org.esprit.ib.services.impl;

import org.esprit.ib.domain.entities.Transaction;
import org.esprit.ib.repositories.TransactionRepository;
import org.esprit.ib.services.interfaces.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void delete(UUID uuid) {
        transactionRepository.deleteById(uuid);
    }

    @Override
    public Transaction getTransactionByUUID(UUID uuid) {
        return transactionRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }
}
