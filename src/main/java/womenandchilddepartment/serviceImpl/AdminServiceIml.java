package womenandchilddepartment.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import womenandchilddepartment.dto.AdminDto;
import womenandchilddepartment.dto.UserDto;
import womenandchilddepartment.exception.ResourceNotFoundException;
import womenandchilddepartment.model.Admin;
import womenandchilddepartment.model.User;
import womenandchilddepartment.repo.AdminRepo;
import womenandchilddepartment.repo.UserRepo;
import womenandchilddepartment.service.AdminService;

@Service
public class AdminServiceIml implements AdminService {

    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String createAdminData(AdminDto adminDto) {
        String email = adminDto.getEmail();
        Admin map = modelMapper.map(adminDto, Admin.class);
        boolean b1 = adminRepo.existsByEmail(email);
        if (b1 == true) {
            return "User Already exist pease Login";
        } else {
            String encode = passwordEncoder.encode(adminDto.getPassword());
            adminDto.setPassword(encode);

//            String userId1= adminDto.getName()+adminDto.getTenthRollNumber();

            Admin user = modelMapper.map(adminDto, Admin.class);

//            user.setUserConfId(userId1);
            Admin savedUser = adminRepo.save(user);
            AdminDto map1 = modelMapper.map(savedUser, AdminDto.class);
//		String userId= user.getName()+user.getTenthRollNumber();
            return "Successfully Signed Up"+ map1;
        }
    }

    @Override
    public Admin findByAdminEmail(String email) {

        Admin admin = adminRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Admin", "admin", email));


        return admin;
    }
}
