package womenandchilddepartment.serviceImpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import womenandchilddepartment.dto.AdvertisementDto;
import womenandchilddepartment.dto.ApplicationSubmissionDto;
import womenandchilddepartment.dto.Login;
import womenandchilddepartment.dto.UserDto;
import womenandchilddepartment.exception.ResourceNotFoundException;
import womenandchilddepartment.model.Advertisement;
import womenandchilddepartment.model.User;
import womenandchilddepartment.repo.UserRepo;
import womenandchilddepartment.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UserRepo usersRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String createUserData(UserDto userDto) {
		String email = userDto.getEmail();
		User map=modelMapper.map(userDto, User.class);
		boolean b1 = usersRepo.existsByEmail(email);
		if(b1==true){return "User Already exist pease Login";
	}
	else{
		String encode = passwordEncoder.encode(userDto.getPassword());
		userDto.setPassword(encode);

		String userId1= userDto.getName()+userDto.getTenthRollNumber();

		User user=modelMapper.map(userDto, User.class);

		user.setUserConfId(userId1);
		User savedUser=usersRepo.save(user);
		 modelMapper.map(savedUser, UserDto.class);
//		String userId= user.getName()+user.getTenthRollNumber();
		 return "Login Id is:" +userId1;
  	}

}

	@Override
	public UserDto updateUser(UserDto usersDto, Integer userId) {
		User users=usersRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "user", userId));
//				users.setEmail(usersDto.getEmailId())
users.setEmail(usersDto.getEmail());
users.setPassword(usersDto.getPassword());
users.setName(usersDto.getName());
users.setPicture(usersDto.getPicture());
users.setFather_Name(usersDto.getFather_Name());
		User updatedUser=usersRepo.save(users);
		UserDto usertech=modelMapper.map(updatedUser, UserDto.class);
		return usertech;
		}

	@Override
	public Object updateUserConfId(ApplicationSubmissionDto applicationSubmissionDto, String userConfId) {
		try {
			User byuserConfId = usersRepo.findByUserConfId(userConfId);
			byuserConfId.setAnyOtherDoc(applicationSubmissionDto.getAnyOtherDoc());
			byuserConfId.setLastYearMarksheet(applicationSubmissionDto.getLastYearMarksheet());
			byuserConfId.setAreYouADepttCandidate(applicationSubmissionDto.getAreYouADepttCandidate());
			byuserConfId.setTenthExamMarkSheet_Certificate(applicationSubmissionDto.getTenthExamMarkSheet_Certificate());
			byuserConfId.setPicture(applicationSubmissionDto.getPicture());
			byuserConfId.setNatureOfWorksPerformed(applicationSubmissionDto.getNatureOfWorksPerformed());
			byuserConfId.setWorkExperience(applicationSubmissionDto.getWorkExperience());
//			byuserConfId.setPost(applicationSubmissionDto.getPost());
//			byuserConfId.setPost(applicationSubmissionDto.getPost());
			byuserConfId.setOrganizationName(applicationSubmissionDto.getOrganizationName());
			byuserConfId.setYearsOfExperience(applicationSubmissionDto.getYearsOfExperience());
			byuserConfId.setSignature(applicationSubmissionDto.getSignature());
			byuserConfId.setAdressProof(applicationSubmissionDto.getAdressProof());
			byuserConfId.setWorkExperience(applicationSubmissionDto.getWorkExperience());
			User save = usersRepo.save(byuserConfId);
			ApplicationSubmissionDto map = modelMapper.map(save, ApplicationSubmissionDto.class);
			return map;
		}
		catch (NullPointerException e)
		{
			return "Invalid UserId";

		}

	}
@Override
public Object getUserConfId(String userConfId)
{
	try
	{
		User byuserConfId = usersRepo.findByUserConfId(userConfId);
		return modelMapper.map(byuserConfId, ApplicationSubmissionDto.class);
	}
	catch (IllegalArgumentException e)
	{
		return "Invalid userId";
	}
}
	@Override
	public UserDto getUserById(Integer userId) {
			 
				User users=usersRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "user", userId));
				return modelMapper.map(users, UserDto.class);
	}
	
	@Override
	public List<UserDto> getAllUser() {
		List<User> userst = usersRepo.findAll();
		List<UserDto> collect = userst.stream().map((user)->modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deleteUserId(Integer userId) {
		User users = usersRepo.findById(userId).orElseThrow(()->(new ResourceNotFoundException("User", "user", userId)));
		usersRepo.delete(users);
		
	}
	public User findByUserConfId(String userConfId) {
		return usersRepo.findByUserConfId(userConfId);
	}

	public boolean authenticateUser(String userConfId, String password, LocalDate dateOfBirth) {
		User user = findByUserConfId(userConfId);
		//String s=passwordEncoder.encode(user.getPassword());

		if (user != null && user.getPassword().equals(password) && user.getDateOfBirth().isEqual(dateOfBirth)) {
			boolean hasLoggedOnce = user.isHasLoggedOnce();
			if (!hasLoggedOnce) {
				// Update hasLoggedOnce flag to true
				user.setHasLoggedOnce(true);
				usersRepo.save(user);
			}
			return true;
		}

		return false;
	}

	@Override
	public String login(Login login) {
		System.out.println("Received Login object: " + login);
		User user = this.usersRepo.findOneByIgnoreCaseNameAndPassword(login.getUserConfId(), login.getPassword());
		System.out.println("Retrieved User: " + user);
		System.out.println(login.getPassword());
		if (user == null) {
			return "Not Logged in";
		} else {
			return "Logged in";
		}
	}


//	@Override
//	public Object updatePassword(UserDto userDto, String userConfId) {
//		try {
//			User byuserConfId = usersRepo.findByUserConfId(userConfId);
//			byuserConfId.setPassword(userDto.getPassword());
//			User save = usersRepo.save(byuserConfId);
//			UserDto map = modelMapper.map(save, UserDto.class);
//			return map;
//		}
//		catch (NullPointerException e)
//		{
//			return "Invalid UserId";
//
//		}

//}
@Override
	public User findByUsername(String userConfId) {
		return usersRepo.findByUserConfId(userConfId);
	}
	public boolean updatePassword(String userConfId, String oldPassword, String newPassword) {
		User user = findByUsername(userConfId);

		if (user != null && user.getPassword().equals(oldPassword)) {
			// Update the user's password with the new password (you should hash it)
			user.setPassword(newPassword);
			usersRepo.save(user);
			return true;
		}

		return false;
	}}
