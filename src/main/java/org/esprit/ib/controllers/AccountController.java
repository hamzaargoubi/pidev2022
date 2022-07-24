package org.esprit.ib.controllers;

import org.esprit.ib.domain.dto.AccountDto;
import org.esprit.ib.services.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    IAccountService accountService;

    @PostMapping("/save")
    public boolean save(@RequestBody AccountDto accountDto) {
        accountService.save(accountDto);
        return true;
    }

    @GetMapping
    public Collection<AccountDto> getAll() {
        return accountService.getAll();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") UUID uuid) {
        accountService.delete(uuid);
        return true;
    }
}
