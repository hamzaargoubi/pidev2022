package org.esprit.ib.controllers;

import org.esprit.ib.domain.Account;
import org.esprit.ib.domain.dto.AccountDto;
import org.esprit.ib.services.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    IAccountService accountService;

    @PostMapping("/save")
    public Account save(@RequestBody AccountDto accountDto){
        return accountService.save(accountDto);
    }
}
