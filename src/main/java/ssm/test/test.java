package ssm.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.dao.AccountDao;
import ssm.domain.Account;
import ssm.service.AccountService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    private InputStream config;
    private SqlSessionFactory ssf;
    private SqlSession ss;
    private AccountDao accountDao;

    @Test
    public void testspring(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.findAll();
    }

    @Test
    public void testmybatis() throws IOException {

        //读取配置文件
        config = Resources.getResourceAsStream("Mybatis-Confing.xml");
        //创建SqlSessionFactory工厂
        ssf = new SqlSessionFactoryBuilder().build(config);
        //使用工厂生成SqlSession对象
        ss = ssf.openSession();
        //使用SqlSession创建Mapper接口代理对象
        accountDao = ss.getMapper(AccountDao.class);
        List<Account> accounts=accountDao.findAll();
        for(Account a:accounts)
            System.out.println(a);
        Account a = new Account();
        a.setMoney(123);
        a.setName("123");
//       注意增删改 必须提交事务
        accountDao.insertAccount(a);
        ss.commit();
        config.close();
        ss.close();
    }
}
