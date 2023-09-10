package womenandchilddepartment.service;

import java.util.List;

import womenandchilddepartment.dto.AdvertisementDto;
import womenandchilddepartment.dto.PostDto;


public interface AdvertisementService {
	AdvertisementDto createAdvertisementData(AdvertisementDto advertisementDto);
	List<AdvertisementDto> getAllAddv();
	List<PostDto> getAdvById(Integer adId);
	Object createUniqueAdv(AdvertisementDto advertisementDto);
}
