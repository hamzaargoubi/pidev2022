package org.esprit.ib.controllers;

import org.esprit.ib.domain.entities.Transaction;
import org.esprit.ib.services.interfaces.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping("")
    public void saveTransaction(@RequestBody Transaction transaction) {
        transactionService.save(transaction);
    }

    @DeleteMapping("/{uuid}")
    public void deleteTransaction(@PathVariable("uuid") UUID uuid) {
        transactionService.delete(uuid);
    }

    @GetMapping("/{uuid}")
    public Transaction getTransaction(@PathVariable("uuid") UUID uuid) {
        return transactionService.getTransactionByUUID( uuid);
    }

    @GetMapping("")
    public List<Transaction> getTransactions(){
        return transactionService.getTransactions();
    }


}
