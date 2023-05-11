package alphaproject.urfuProject;

import alphaproject.urfuProject.Services.VideoCardService;
import alphaproject.urfuProject.bot.TelegramBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class UrfuProjectApplication {

	public static void main(String[] args) throws TelegramApiException {
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
