package alphaproject.urfuProject;


import alphaproject.urfuProject.entity.Account;
import alphaproject.urfuProject.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "Main controller Info")
public class MainController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/account/check/{accountId}")
    public String checkAccountById(@PathVariable long accountId) {
        var account = accountRepository.getReferenceById(accountId);
        if(account == null) {
            return "not found";
        }
        return "id: " + account.getId() + ". username: " + account.getUsername();
    }
}
