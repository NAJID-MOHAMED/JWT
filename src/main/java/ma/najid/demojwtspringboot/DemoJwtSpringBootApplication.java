package ma.najid.demojwtspringboot;

import ma.najid.demojwtspringboot.entities.AppRole;
import ma.najid.demojwtspringboot.entities.AppUser;
import ma.najid.demojwtspringboot.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoJwtSpringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoJwtSpringBootApplication.class, args);
	}
    @Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner start(AccountService accountService) {
		return args -> {
			accountService.addRole(new AppRole(null,"USER"));
			accountService.addRole(new AppRole(null,"ADMIN"));
			accountService.addRole(new AppRole(null,"CUSTOMMER_MANAGER"));
			accountService.addRole(new AppRole(null,"PRODUCT_MANAGER"));
			accountService.addRole(new AppRole(null,"BILLS_MANAGER"));


			accountService.addUser((new AppUser(null,"user1","1234",new ArrayList<>())));
			accountService.addUser((new AppUser(null,"admin","1234",new ArrayList<>())));
			accountService.addUser((new AppUser(null,"user2","1234",new ArrayList<>())));
			accountService.addUser((new AppUser(null,"user3","1234",new ArrayList<>())));
			accountService.addUser((new AppUser(null,"user4","1234",new ArrayList<>())));

			accountService.addRoleToUser("user1","USER");
			accountService.addRoleToUser("admin","ADMIN");
			accountService.addRoleToUser("admin","USER");
			accountService.addRoleToUser("user2","USER");
			accountService.addRoleToUser("user2","CUSTOMMER_MANAGER");
			accountService.addRoleToUser("user3","USER");
			accountService.addRoleToUser("user3","CUSTOMMER_MANAGER");
			accountService.addRoleToUser("user4","USER");
			accountService.addRoleToUser("user4","BILLS_MANAGER");
		};
	}

}
