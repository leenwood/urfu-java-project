package alphaproject.urfuProject;

import alphaproject.urfuProject.Security.Account;
import alphaproject.urfuProject.Security.Role;
import alphaproject.urfuProject.Services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class UrfuProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrfuProjectApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/*
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			var acc=new Account();
			var role=new Role(1L,"ROLE_ADMIN");
			HashSet<Role> roles = new HashSet<>();
			roles.add(role);
			acc.setUsername("admin");
			acc.setPassword("admin");
			acc.setRoles(roles);
			userService.saveUser(acc);
		};
	}*/
}
