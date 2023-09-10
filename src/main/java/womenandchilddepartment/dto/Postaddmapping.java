package womenandchilddepartment.dto;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import womenandchilddepartment.model.Advertisement;
import womenandchilddepartment.model.Post;
import womenandchilddepartment.repo.AdvertisementRepo;
import womenandchilddepartment.repo.PostRepo;

@Component
public class Postaddmapping {
	@Autowired
	private AdvertisementRepo  advertisementRepo;
	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;
	
  public Object checkCityDto(PostDto postDtoCheck)
{

	int count=postDtoCheck.getAdvertisement().getAdvertisementNo();

	List<Advertisement> findAll = advertisementRepo.findAll();
	for(Advertisement ad:findAll)
	{
		int advertisementNo = ad.getAdvertisementNo();
		if(count==advertisementNo)
		{
			postDtoCheck.setAdvertisement(ad);
		break;
		}
	}
	return postDtoCheck;}}



