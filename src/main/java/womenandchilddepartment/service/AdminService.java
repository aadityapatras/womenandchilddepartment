package womenandchilddepartment.service;

import womenandchilddepartment.dto.AdminDto;
import womenandchilddepartment.dto.UserDto;
import womenandchilddepartment.model.Admin;
import womenandchilddepartment.model.User;

public interface AdminService {

    String createAdminData(AdminDto adminDto);

    Admin findByAdminEmail(String email);
    //   	String login(Login login);
  //  UserDto updateUser(UserDto usersDto, Integer userId);
}
