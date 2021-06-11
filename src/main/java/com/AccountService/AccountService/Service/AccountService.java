package com.AccountService.AccountService.Service;

import com.AccountService.AccountService.Entity.Account;
import com.AccountService.AccountService.Repository.AccountRepository;
import com.AccountService.AccountService.valueObjects.Product;
import com.AccountService.AccountService.valueObjects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Account saveAccount(Account account) {
        System.out.println("account name ="+account.getAccountName());
        return accountRepository.save(account);
    }

    public Account findAccountById(Long accountId) {
        return accountRepository.findByAccountId(accountId);
    }

    public ResponseTemplateVO getAccountWithProducts(Long accountId) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        Account account = accountRepository.findByAccountId(accountId);
        Product product = restTemplate.getForObject("http://PRODUCT-SERVICE/products/"+account.getProductId(), Product.class);
        responseTemplateVO.setAccount(account);
        responseTemplateVO.setProduct(product);
        return responseTemplateVO;

    }
}
