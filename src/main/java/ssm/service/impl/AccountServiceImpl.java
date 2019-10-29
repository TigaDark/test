package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.AccountDao;
import ssm.domain.Account;
import ssm.service.AccountService;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl  implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("service查询所有!");
        return accountDao.findAll();
    }

    @Override
    public void insertAccount(Account account) {
        accountDao.insertAccount(account);
    }
}
