package womenandchilddepartment.serviceImpl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import womenandchilddepartment.dto.AdvertisementDto;
import womenandchilddepartment.dto.PostDto;
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
	public AdvertisementDto createAdvertisementData(AdvertisementDto advertisementDto) {
		Advertisement map = modelMapper.map(advertisementDto, Advertisement.class);
		int advertisementNo = advertisementDto.getAdvertisementNo();
//		List<Advertisement> findAll = advertisementRepo.findAll();
//		for(Advertisement ad:findAll)
//		{
//			int advertisementNo1 = ad.getAdvertisementNo();
//			if(advertisementNo==advertisementNo)
//			{
//				advertisementDto.setAdvertisementNo(ad);
//				break;
//			}
//		}
	//	return advertisementDto;}

		Advertisement save = advertisementRepo.save(map);
		return modelMapper.map(save, AdvertisementDto.class);
		//		int i = Calendar.getInstance().get(Calendar.YEAR);
//		long count = advertisementRepo.count()+1;
//		String u=count+"_"+i;
//		map.setAsfsid(u);
	}
	@Override
	public List<AdvertisementDto> getAllAddv() {
			List<Advertisement> userst = advertisementRepo.findAll();
			List<AdvertisementDto> collect = userst.stream().map((advertisement)->modelMapper.map(advertisement, AdvertisementDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<PostDto> getAdvById(Integer adId) {
		int advertisementNo = advertisementRepo.findByAdvertisementNo(adId).getAdvertisementNo();
		List<Post> all = postRepo.findAll();
//		all.stream().
//		List<Post> allById = postRepo.findAllById(Set.of(advertisementNo));
//		List<PostDto> collect = all.stream().map((post) -> modelMapper.map(post, PostDto.class)).filter(advertisementNo==postRepo.findAllById(adId)).collect(Collectors.toList());
		return   null;
	}

	@Override
	public Object createUniqueAdv(AdvertisementDto advertisementDto) {
	int ad=	advertisementDto.getAdvertisementNo();
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





//	}

}
