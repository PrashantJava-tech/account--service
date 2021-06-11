package com.AccountService.AccountService.Controller;

import com.AccountService.AccountService.Entity.Account;
import com.AccountService.AccountService.Service.AccountService;
import com.AccountService.AccountService.valueObjects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/")
    public Account saveAccount(@RequestBody Account account) {
        System.out.println("account name before save="+account.getAccountName());
        Account account1 = accountService.saveAccount(account);
        System.out.println("account name after save  ="+account1.getAccountName());
        return account1;
    }

    @GetMapping("/{accountId}")
    public ResponseTemplateVO getAccountWithProducts(@PathVariable Long accountId) {
        return  accountService.getAccountWithProducts(accountId);
    }
}
