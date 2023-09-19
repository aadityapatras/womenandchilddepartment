package womenandchilddepartment.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import womenandchilddepartment.dto.*;
import womenandchilddepartment.model.User;
import womenandchilddepartment.security.JwtAuthResponse;
import womenandchilddepartment.security.JwtTokenHelper;
import womenandchilddepartment.service.FileService;
import womenandchilddepartment.service.UsersService;

@RestController
@RequestMapping("/user")

public class UserController {
@Autowired
private UsersService usersService;

@Autowired
private FileService fileService;

@Value("${project.image}")
private String path;

@Autowired
private JwtTokenHelper jwtTokenHelper;

@PostMapping(value="/users/create")
public ResponseEntity<String> createUserData(@Valid @RequestBody UserDto userDto) throws IOException
{
//	UsersDto usersDto= this.usersService.getUserById(userId);
//	String fileName=fileService.uploadImage(path, image);
//	
//	usersDto.setPicture(fileName);
//	UsersDto updateUser = usersService.updateUser(usersDto, userId);
//	return updateUser;
	String userData = usersService.createUserData(userDto);
	return new ResponseEntity<>(userData, HttpStatus.CREATED);
}
//@PostMapping("/login")
//public String login(@RequestBody Login login)
//{
//	String msg=this.usersService.login(login);
//	return msg;
//}
@PutMapping("/updateInfo/{userId}")
public ResponseEntity<UserDto> updateUser(@RequestBody UserDto usersDto, @PathVariable Integer userId)
{

	UserDto createdUserDto=this.usersService.updateUser(usersDto, userId);
	return new ResponseEntity<>(createdUserDto, HttpStatus.ACCEPTED);

}
@GetMapping("/getInfo/{userId}")
public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId)
{
	UserDto userById = usersService.getUserById(userId);
	ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	return ResponseEntity.of(Optional.of(userById));

}

@GetMapping("/getInfo/allUsers")
public 	ResponseEntity<List<UserDto>> getAllUser()
{
	List<UserDto> allUser = usersService.getAllUser();
	return new ResponseEntity<>(allUser,HttpStatus.ACCEPTED);
}

@DeleteMapping("/deleteUser/{userId}")
public ResponseEntity<ApiResponse> deleteUserId(@PathVariable Integer userId)
{
	usersService.deleteUserId(userId);
	return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully", true), HttpStatus.OK);
}


@PostMapping("/image/{userId}")
public ResponseEntity<UserDto> uploadPicture(@RequestParam("image") MultipartFile image, @RequestParam("pdf") MultipartFile pdf, @PathVariable Integer userId) throws Exception
{
	UserDto usersDto= this.usersService.getUserById(userId);
	String fileName=fileService.uploadImage(path, image);
	String uploadImage = fileService.uploadImage(path, pdf);
	usersDto.setPicture(fileName);
	usersDto.setFather_Name(uploadImage);
	UserDto updateUser = usersService.updateUser(usersDto, userId);
	return new ResponseEntity<>(updateUser, HttpStatus.CREATED);

}

//@GetMapping(value="/post/image/{imageName}", produces=MediaType.IMAGE_JPEG_VALUE)
//public void downloadImage(@PathVariable("imageName")String imageName, HttpServletResponse response) throws Exception
//{
//	InputStream resource=fileService.getResource(imageName, path);
//	response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//	StreamUtils.copy(resource, response.getOutputStream());
//}
@PutMapping("/updateInfor/{userConfId}")
	public ResponseEntity<Object> updateUserConfId(@RequestBody ApplicationSubmissionDto applicationSubmissionDto, @PathVariable String userConfId)
{
	Object o = usersService.updateUserConfId(applicationSubmissionDto, userConfId);
	return new ResponseEntity<>(o, HttpStatus.ACCEPTED);
}

	@PostMapping("/image/upload/{userConfId}")
	public ResponseEntity<ApplicationSubmissionDto> uploadAllPicture(@RequestParam("image") MultipartFile image,
													 @RequestParam("anyOther") MultipartFile anyOther,
													 @RequestParam("tenth") MultipartFile tenth,
														 @RequestParam("lastYearMark") MultipartFile lastYearMark,
													 @RequestParam("sign") MultipartFile sign,
													 @RequestParam("post") String post,
													 @RequestParam("areYouADepttCandidate") String areYouADepttCandidate,
													 @RequestParam("adressProof") MultipartFile adressProof,
													 @RequestParam("yearsOfExperience") String yearsOfExperience,
													 @RequestParam("organizationName") String organizationName,
													 @RequestParam("worknature") String worknature,
													 @RequestParam("experience") String experience,
													 @PathVariable String userConfId) throws Exception
	{
		ApplicationSubmissionDto applicationSubmissionDto= (ApplicationSubmissionDto) this.usersService.getUserConfId(userConfId);
		String fileName=fileService.uploadImage(path, image);
		String s4=fileService.uploadImage(path, sign);
		String s3=fileService.uploadImage(path, lastYearMark);
		String s2=fileService.uploadImage(path, tenth);
		String s = fileService.uploadImage(path, anyOther);
		String s1 = fileService.uploadImage(path, adressProof);
		applicationSubmissionDto.setAdressProof(s1);
		applicationSubmissionDto.setLastYearMarksheet(s3);
		applicationSubmissionDto.setAnyOtherDoc(s);
		applicationSubmissionDto.setSignature(s4);
		applicationSubmissionDto.setTenthExamMarkSheet_Certificate(s2);
		applicationSubmissionDto.setPicture(fileName);
		applicationSubmissionDto.setNatureOfWorksPerformed(worknature);
		applicationSubmissionDto.setPost(post);
		applicationSubmissionDto.setYearsOfExperience(yearsOfExperience);
		applicationSubmissionDto.setOrganizationName(organizationName);
		applicationSubmissionDto.setAreYouADepttCandidate(areYouADepttCandidate);
		applicationSubmissionDto.setWorkExperience(experience);
		//applicationSubmissionDto.setFather_Name(uploadImage);
		ApplicationSubmissionDto updateUser = (ApplicationSubmissionDto) usersService.updateUserConfId(applicationSubmissionDto, userConfId);

		return new ResponseEntity<>(updateUser, HttpStatus.CREATED);
	}
@GetMapping("/getUis/{userConfId}")
	public ResponseEntity<Object> getUserConfId(@PathVariable String userConfId)

{
	Object userConfId1 = usersService.getUserConfId(userConfId);
	ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	return ResponseEntity.of(Optional.of(userConfId1));
}

	@PostMapping("/login123")
	public ResponseEntity<String> login23(@RequestBody Login  login ) {
		String login1 = usersService.login(login);
		return new ResponseEntity<>(login1, HttpStatus.CREATED);
}

	@PostMapping("/update-password")
	public ResponseEntity<String> updatePassword(@RequestBody PasswordUpdateRequest passwordUpdateRequest) {
		String username = passwordUpdateRequest.getUserConfId();
		String oldPassword = passwordUpdateRequest.getOldPassword();
		String newPassword = passwordUpdateRequest.getNewPassword();

		boolean isUpdated = usersService.updatePassword(username, oldPassword, newPassword);

		if (isUpdated) {
			return ResponseEntity.ok("Password updated successfully!");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password update failed. Check your credentials.");
		}
	}


}