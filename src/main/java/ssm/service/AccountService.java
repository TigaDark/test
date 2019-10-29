package ssm.service;

import ssm.domain.Account;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();

    public void insertAccount(Account account);
}
