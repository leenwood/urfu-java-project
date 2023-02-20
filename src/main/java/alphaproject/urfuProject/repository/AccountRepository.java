package alphaproject.urfuProject.repository;

import alphaproject.urfuProject.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}