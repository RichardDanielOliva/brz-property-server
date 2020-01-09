package wirtz.project.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
//public class ServerAuthentificationApplication implements CommandLineRunner {
public class ServerAuthentificationApplication{
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ServerAuthentificationApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		String password = "12345";
//		
//		for (int i = 0; i < 2; i++) {
//			System.out.println(passwordEncoder.encode(password));
//		}
//		
//	}

}
