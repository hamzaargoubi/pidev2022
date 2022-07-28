package org.esprit.ib.controllers;

import org.esprit.ib.domain.dto.LoanDto;
import org.esprit.ib.services.interfaces.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("loans")
public class LoanController {
    @Autowired
    ILoanService loanService;

    @PostMapping("/save/{account_id}")
    public boolean save(@RequestBody LoanDto loanDto,@PathVariable("account_id") UUID accountId) {
        loanService.save(loanDto,accountId);
        return true;
    }

    @GetMapping
    public Collection<LoanDto> getAll() {
        return loanService.getAll();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") UUID uuid) {
        loanService.delete(uuid);
        return true;
    }
}
