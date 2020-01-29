package mr.send.money.sendmoney.web;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.service.imp.AccountServiceImp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountServiceImp accountServiceImp;
    
    Logger LOGGER =LoggerFactory.getLogger(AccountController.class);

    public AccountController(AccountServiceImp accountServiceImp) {
        this.accountServiceImp = accountServiceImp;
    }

    @GetMapping("/")
    public List<Account> accounts() {
        return accountServiceImp.findAll();
    }

    @GetMapping("/{numAccount}")
    public Account findAccount(@PathVariable("numAccount") String numAccount) {
    	LOGGER.info("Entree dans le methode findAccount avec le parametre numAccount:{}",numAccount);
        return accountServiceImp.findAccountByNumber(numAccount);
    }

    @PostMapping("/user_accounts")
    public List<Account> findUserAccount(@RequestBody @NotNull @Valid String userName) {
    	LOGGER.info("Entree dans le methode findUserAccount avec le parametre userName:{}",userName);
        return accountServiceImp.getUserAccounts(userName);
    }

    @PostMapping("/")
    public Account addAccount(@NotNull @Valid Account account) {
    	LOGGER.info("Entree dans le methode addAccount avec le parametre account:{}",account);
        return accountServiceImp.save(account);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable @NotNull Integer id) {
    	LOGGER.info("Entree dans le methode delete avec le parametre id:{}",id);
         accountServiceImp.delete(id);
         return "Deleted";
    }

}
