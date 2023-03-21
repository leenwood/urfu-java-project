package alphaproject.urfuProject.Services;

import alphaproject.urfuProject.Repositories.RoleRepository;
import alphaproject.urfuProject.Repositories.UserRepository;
import alphaproject.urfuProject.Security.Account;
import alphaproject.urfuProject.Security.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public Account findUserById(Long userId) {
        Optional<Account> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new Account());
    }

    public List<Account> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(Account user) {
        Account userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<Account> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM Account u WHERE u.id > :paramId", Account.class)
                .setParameter("paramId", idMin).getResultList();
    }
}