package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.domain.Account;
import ssm.service.AccountService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("accountController")
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String  findAll(Model model){
        System.out.println("控制器 执行了！");
        List<Account> accounts=accountService.findAll();
        model.addAttribute("list",accounts);
        return "success";
    }

    @RequestMapping("/insert")
    public void insertAccount(Account account, HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
        System.out.println(account);
        accountService.insertAccount(account);
        httpServletResponse.sendRedirect(request.getContextPath()+"/account/findAll");
    }
}
