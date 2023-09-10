package womenandchilddepartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import womenandchilddepartment.dto.ApplicationSubmissionDto;
import womenandchilddepartment.service.ApplicationSubmissionService;
import womenandchilddepartment.service.FileService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
//@RestController
//@RequestMapping("/app")

public class ApplicationSubmissionController {
//    @Autowired
//    private ApplicationSubmissionService applicationSubmissionService;
//
//    @Autowired
//    private FileService fileService;
//
//    @Value("${project.image}")
//    private String path;
//
//    @PostMapping(value = "/admiss/create")
//    public String createUserData(@Valid @RequestBody ApplicationSubmissionDto applicationSubmissionDto) throws IOException {
////	UsersDto usersDto= this.usersService.getUserById(userId);
////	String fileName=fileService.uploadImage(path, image);
////
////	usersDto.setPicture(fileName);
////	UsersDto updateUser = usersService.updateUser(usersDto, userId);
////	return updateUser;
//        return applicationSubmissionService.createUserData(applicationSubmissionDto);
//    }
//
//    //@PostMapping("/login")
////public String login(@RequestBody Login login)
////{
////	String msg=this.usersService.login(login);
////	return msg;
////}
//    @PutMapping("/updateInfo/{asId}")
//    public ApplicationSubmissionDto updateApp(@RequestBody ApplicationSubmissionDto applicationSubmissionDto, @PathVariable Integer asId) {
//        return applicationSubmissionService.updateApplication(applicationSubmissionDto, asId);
//    }
//
//    @GetMapping("/getInfo/{userId}")
//    public ApplicationSubmissionDto getUserById(@PathVariable Integer asId) {
//        return applicationSubmissionService.getAppById(asId);
//    }
//
//    @GetMapping("/getInfo/allUsers")
//    public List<ApplicationSubmissionDto> getAllUser() {
//        return applicationSubmissionService.getAllUser();
//    }
//
//    @DeleteMapping("/deleteUser/{asId}")
//    void deleteUserId(@PathVariable Integer asId) {
//        applicationSubmissionService.deleteUserId(asId);
//    }
//
//
//    @PostMapping("/image/{asId}")
//    public ApplicationSubmissionDto uploadPicture(@RequestParam("image") MultipartFile image, @RequestParam("otherDoc") MultipartFile otherDoc, @RequestParam("signature") MultipartFile signature, @RequestParam("tenthMarkesheet") MultipartFile tenthMarkesheet, @RequestParam("lastYearMarksheet") MultipartFile lastYearMarksheet, @PathVariable Integer asId) throws Exception {
//        ApplicationSubmissionDto applicationSubmissionDto1 = this.applicationSubmissionService.getAppById(asId);
//        String fileName = fileService.uploadImage(path, image);
//        String uploadImage = fileService.uploadImage(path, otherDoc);
//        String s1 = fileService.uploadImage(path, signature);
//        String s3=fileService.uploadImage(path, lastYearMarksheet);
//        String s = fileService.uploadImage(path, tenthMarkesheet);
//        applicationSubmissionDto1.setPicture(fileName);
//        applicationSubmissionDto1.setTenthExamMarkSheet_Certificate(s);
//        applicationSubmissionDto1.setSignature(s1);
//        applicationSubmissionDto1.setAnyOtherDoc(uploadImage);
//        applicationSubmissionDto1.setLastYearMarksheet(s3);
//        //usersDto.setFather_Name(uploadImage);
//        ApplicationSubmissionDto updateUser = applicationSubmissionService.updateApplication(applicationSubmissionDto1, asId);
//        return updateUser;
//    }
//
//    @GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
//    public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws Exception {
//        InputStream resource = fileService.getResource(imageName, path);
//        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//        StreamUtils.copy(resource, response.getOutputStream());
//    }
}