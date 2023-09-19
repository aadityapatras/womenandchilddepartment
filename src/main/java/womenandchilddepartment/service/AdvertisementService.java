package womenandchilddepartment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import womenandchilddepartment.dto.AdvertisementDto;
import womenandchilddepartment.dto.ApplicationSubmissionDto;
import womenandchilddepartment.dto.PostDto;
import womenandchilddepartment.model.Advertisement;


public interface AdvertisementService {
	boolean  createAdvertisementData(AdvertisementDto advertisementDto);
	List<AdvertisementDto> getAllAddv();
	List<PostDto> getAdvById(Integer adId);
	boolean exists(String advertisementNo);
//	List<PostDto> getAdvById(String adId);
AdvertisementDto updateCity(AdvertisementDto cityDto, String advertisementNo);
	Object createUniqueAdv(AdvertisementDto advertisementDto);
	void updateAdvertisementNo(String oldAdvertisementNo, String newAdvertisementNo);
	Object updateUserConfId(ApplicationSubmissionDto applicationSubmissionDto, String userConfId);

	ResponseEntity<String> deleteAdvertisementByAdvertisementNo(String advertisementNo);
}
