package womenandchilddepartment.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import womenandchilddepartment.dto.AdvertisementDto;
import womenandchilddepartment.dto.ApplicationSubmissionDto;
import womenandchilddepartment.dto.PostDto;
import womenandchilddepartment.exception.AdvertisementAlreadyExistsException;
import womenandchilddepartment.exception.AdvertisementNotFoundException;
import womenandchilddepartment.exception.ResourceNotFoundException;
import womenandchilddepartment.model.Advertisement;
import womenandchilddepartment.model.Post;
import womenandchilddepartment.repo.AdvertisementRepo;
import womenandchilddepartment.repo.PostRepo;
import womenandchilddepartment.service.AdvertisementService;

@Service
public class AdvertisementServiceImpl implements AdvertisementService{

	@Autowired
	private AdvertisementRepo advertisementRepo;

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;
	@Override
	public boolean  createAdvertisementData(AdvertisementDto advertisementDto) {
		Advertisement map = modelMapper.map(advertisementDto, Advertisement.class);
//		String advertisementNo = advertisementDto.getAdvertisementNo();
//		Advertisement save = advertisementRepo.save(map);
//		return modelMapper.map(save, AdvertisementDto.class);

		if (advertisementRepo.existsByAdvertisementNo(advertisementDto.getAdvertisementNo())) {
			return false;
			// Advertisement with this advertisementNo already exists
		}

		// Create a new advertisement
		String advertisementNo = advertisementDto.getAdvertisementNo();

		Advertisement save = advertisementRepo.save(map);
//		return modelMapper.map(save, AdvertisementDto.class);
		return true; // Advertisement created successfully

	}
	@Override
	public List<AdvertisementDto> getAllAddv() {
		List<Advertisement> userst = advertisementRepo.findAll();
		List<AdvertisementDto> collect = userst.stream().map((advertisement)->modelMapper.map(advertisement, AdvertisementDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<PostDto> getAdvById(Integer adId) {
		Advertisement advertisementNo = advertisementRepo.findById(adId).orElseThrow(()-> new ResourceNotFoundException("Advertisement", "advertisement", adId));
		List<Post> all = postRepo.findAll();
//		all.stream().
//		List<Post> allById = postRepo.findAllById(Set.of(advertisementNo));
//		List<PostDto> collect = all.stream().map((post) -> modelMapper.map(post, PostDto.class)).filter(advertisementNo==postRepo.findAllById(adId)).collect(Collectors.toList());
		return   null;
	}

	@Override
	public Object createUniqueAdv(AdvertisementDto advertisementDto) {
		String ad=	advertisementDto.getAdvertisementNo();
		Advertisement map = modelMapper.map(advertisementDto, Advertisement.class);
		boolean b = advertisementRepo.existsByAdvertisementNo(ad);
		if(b==true)
		{
			return "This Advertisement already exist in our database";
		}else {
			map.setAdvertisementNo(advertisementDto.getAdvertisementNo());
			Advertisement save1 = advertisementRepo.save(map);
			save1.setAdvertisementNo(advertisementDto.getAdvertisementNo());
			AdvertisementDto map3 = modelMapper.map(save1, AdvertisementDto.class);
			modelMapper.map(advertisementDto, Advertisement.class);
			Advertisement ad22=	advertisementRepo.save(map);

			return ad22;
		}
	}

	@Override
	public Object updateUserConfId(ApplicationSubmissionDto applicationSubmissionDto, String userConfId) {
		return null;
	}

//		int advertisementNo = map.getAdvertisementNo();
//		List<Advertisement> findAll = advertisementRepo.findAll();
//		for(Advertisement ad1:findAll)
//		{
//			int advertisementNo1 = ad1.getAdvertisementNo();
//			if(!findAll.contains(ad))
//			{
//				map.setAdvertisementNo(ad);
////				advertisementDto.setAdvertisementNo(advertisementNo1);
//				break;
//			}
//		}
//			return advertisementDto;
//		return null;
//		Advertisement save = advertisementRepo.save(map);
//		return modelMapper.map(save, AdvertisementDto.class);

	@Override
	public boolean exists(String advertisementNo)
	{
		boolean b = advertisementRepo.existsByAdvertisementNo(advertisementNo);
		return b;
	}

	@Override
	public AdvertisementDto updateCity(AdvertisementDto cityDto, String advertisementNo) {
		return null;
	}

	@Override
public ResponseEntity<String> deleteAdvertisementByAdvertisementNo(String advertisementNo) {
//	Optional<Advertisement> existingValue = advertisementRepo.findByAdvertisementNo(advertisementNo);

		return ResponseEntity.ok("Value '" + advertisementNo + "' deleted successfully.");
	}
//	else {
//		// If the value doesn't exist, return a not found response
//		return ResponseEntity.notFound().build();
//	}
//@Override
//public AdvertisementDto updateCity(AdvertisementDto cityDto, String advertisementNo) {
//	Advertisement city=advertisementRepo.findOneByIgnoreCaseAdvertisementNo(advertisementNo);
//	city.setAdvertisementNo(cityDto.getAdvertisementNo());
////		city.setCountry(cityDto.getCountry());
//	Advertisement updatedCity=advertisementRepo.save(city);
//	AdvertisementDto updatedCity1=modelMapper.map(city, AdvertisementDto.class);
//	return updatedCity1;
//}
@Transactional
public void updateAdvertisementNo(String oldAdvertisementNo, String newAdvertisementNo) throws ResourceNotFoundException, AdvertisementAlreadyExistsException {
	Advertisement advertisement = advertisementRepo.findByAdvertisementNo(oldAdvertisementNo);
	boolean b = advertisementRepo.existsByAdvertisementNo(oldAdvertisementNo);
	if (b==false) {
		throw new ResourceNotFoundException("Advertisement", "advertisement", oldAdvertisementNo);
	}

	Advertisement existingAdvertisement = advertisementRepo.findByAdvertisementNo(newAdvertisementNo);
	if (existingAdvertisement != null) {
		throw new AdvertisementAlreadyExistsException("New advertisementNo already exists.");
	}

	advertisement.setAdvertisementNo(newAdvertisementNo);
	advertisementRepo.save(advertisement);
}
}

//	}


