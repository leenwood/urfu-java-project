package alphaproject.urfuProject.Repositories;

import alphaproject.urfuProject.Security.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}