package womenandchilddepartment.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import womenandchilddepartment.dto.ApplicationSubmissionDto;
import womenandchilddepartment.dto.Login;
import womenandchilddepartment.dto.UserDto;
import womenandchilddepartment.model.User;


public interface UsersService {
	String createUserData(UserDto userDto);
//   	String login(Login login);
	UserDto updateUser(UserDto usersDto, Integer userId);
	Object updateUserConfId(ApplicationSubmissionDto applicationSubmissionDto, String userConfId);
	UserDto getUserById(Integer userId);
	Object getUserConfId(String userConfId);
	List<UserDto> getAllUser();
	void deleteUserId(Integer userId);
	User findByUserConfId(String userConfId);
	String login(Login login);
	public boolean authenticateUser(String userConfId, String password, LocalDate dateOfBirth);
//	Object updatePassword(UserDto userDto, String userConfId);
	boolean updatePassword(String userConfId, String oldPassword, String newPassword);
	User findByUsername(String userConfId);

	//String authenticateUser(String userConfId);
}
