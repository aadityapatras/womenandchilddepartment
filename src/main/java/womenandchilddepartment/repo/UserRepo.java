package womenandchilddepartment.repo;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;

import womenandchilddepartment.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	User findOneByIgnoreCaseNameAndPassword(@NotNull(message = "username should not be null!!") String username,
			@NotNull(message = "password should not be null!!") String password);
	Optional<User> findByEmail(String email);
	//Optional<Users> findByEmail(String email);
	User findByName(String username);
	User findByUserConfId(String userConfId);
//	User findByuserConfId(String userConfId);
	boolean existsByEmail(String email);
}
