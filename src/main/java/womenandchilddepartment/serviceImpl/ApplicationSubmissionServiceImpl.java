package womenandchilddepartment.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import womenandchilddepartment.dto.ApplicationSubmissionDto;
import womenandchilddepartment.dto.UserDto;
import womenandchilddepartment.exception.ResourceNotFoundException;
import womenandchilddepartment.model.ApplicationSubmission;
import womenandchilddepartment.model.User;
import womenandchilddepartment.repo.ApplicationSubmissionRepo;
import womenandchilddepartment.service.ApplicationSubmissionService;
//@Service
public class ApplicationSubmissionServiceImpl
{
		///implements ApplicationSubmissionService{
	
//	@Autowired
//	private ApplicationSubmissionRepo applicationSubmissionRepo;
//
//	@Autowired
//	private ModelMapper modelMapper;
//
//	public String createUserData(ApplicationSubmissionDto applicationSubmissionDto)
//	{
//		ApplicationSubmission map = modelMapper.map(applicationSubmissionDto, ApplicationSubmission.class);
//		applicationSubmissionRepo.save(map);
//		modelMapper.map(map, ApplicationSubmissionDto.class);
//		return "your application to the post has been submitted successfully. Please print the form";
//
//	}
//
//	@Override
//	public ApplicationSubmissionDto getAppById(Integer asId) {
//		ApplicationSubmission applicationSubmission = applicationSubmissionRepo.findById(asId).orElseThrow(() -> new ResourceNotFoundException("ApplicationSubmission", "applicationSubmission", asId));
//		return modelMapper.map(applicationSubmission, ApplicationSubmissionDto.class);
//
//	}
//
//	@Override
//	public ApplicationSubmissionDto updateApplication(ApplicationSubmissionDto applicationSubmissionDto, Integer asId) {
//
////		ApplicationSubmission applicationSubmission = applicationSubmissionRepo.findById(asId).orElseThrow(() -> new ResourceNotFoundException("ApplicationSubmission", "applicationSubmission", asId));
////		applicationSubmission.setTenthExamMarkSheet_Certificate(applicationSubmissionDto.getTenthExamMarkSheet_Certificate());
////		applicationSubmission.setSignature(applicationSubmissionDto.getSignature());
////		applicationSubmission.setPicture(applicationSubmissionDto.getPicture());
////		applicationSubmission.setAnyOtherDoc(applicationSubmissionDto.getAnyOtherDoc());
////		applicationSubmission.setLastYearMarksheet(applicationSubmissionDto.getLastYearMarksheet());
////		ApplicationSubmission save = applicationSubmissionRepo.save(applicationSubmission);
////		ApplicationSubmissionDto map = modelMapper.map(save, ApplicationSubmissionDto.class);
////
//		ApplicationSubmission applicationSubmission=applicationSubmissionRepo.findById(asId).orElseThrow(()-> new ResourceNotFoundException("ApplicationSubmission", "applicationSubmission", asId));
//		applicationSubmission.setTenthExamMarkSheet_Certificate(applicationSubmissionDto.getTenthExamMarkSheet_Certificate());
//		applicationSubmission.setSignature(applicationSubmissionDto.getSignature());
////		applicationSubmission.setPicture(applicationSubmissionDto.getPicture());
//		applicationSubmission.setAnyOtherDoc(applicationSubmissionDto.getAnyOtherDoc());
//		applicationSubmission.setLastYearMarksheet(applicationSubmissionDto.getLastYearMarksheet());
//		applicationSubmission.setPicture(applicationSubmissionDto.getPicture());
//		ApplicationSubmission updatedUser=applicationSubmissionRepo.save(applicationSubmission);
//		ApplicationSubmissionDto map = modelMapper.map(updatedUser, ApplicationSubmissionDto.class);
//		return map;
//	}
//
//	@Override
//	public void deleteUserId(Integer asId) {
//
//	}
//
//	@Override
//	public List<ApplicationSubmissionDto> getAllUser() {
//		return null;
//	}

}
