package womenandchilddepartment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@SpringBootApplication
public class WomenandchilddepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(WomenandchilddepartmentApplication.class, args);
	}
@Bean
public  ModelMapper modelMapper()
{
	return new ModelMapper();
}
//@Bean
//public BCryptPasswordEncoder bCryptPasswordEncoder() {
//	return new BCryptPasswordEncoder();
//}
}
