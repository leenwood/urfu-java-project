package alphaproject.urfuProject.Repositories;

import alphaproject.urfuProject.Security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
