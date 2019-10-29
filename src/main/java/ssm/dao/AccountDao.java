package ssm.dao;

import ssm.domain.Account;

import java.util.List;

public interface AccountDao {

    public List<Account> findAll();

    public int insertAccount(Account account);
}
