package womenandchilddepartment.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import womenandchilddepartment.dto.PostDto;
import womenandchilddepartment.model.Advertisement;
import womenandchilddepartment.model.Post;
import womenandchilddepartment.repo.AdvertisementRepo;
import womenandchilddepartment.repo.PostRepo;
import womenandchilddepartment.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private AdvertisementRepo advertisementRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PostDto createPostData(PostDto postDto) {
//		int advertisementNo1 = postDto.getAdvertisement().getAdvertisementNo();
//		System.out.println(advertisementNo1);
//		Post map = modelMapper.map(postDto, Post.class);
//		boolean existsByAdvertisementNo = advertisementRepo.existsByAdvertisementNo(advertisementNo1);
//		if(existsByAdvertisementNo==true) {
//			int id = advertisementRepo.findByAdvertisementNo(advertisementNo1).getId();
//                                                                                                                                                                                                                                                                                                          o(advertisementNo1).getAdvertisementNo().getId;
////			map.setAdvertisement(id);
//			System.out.print(id);
//			Post save = postRepo.save(map);
//			System.out.print("alratd exist");
//	}                                                                                                                                                                                                                                                  
//	else
//	{
//		System.out.print("not alratd exist");
//		map.setAdvertisement(postDto.getAdvertisement());
//		Post save = postRepo.save(map);
//		return modelMapper.map(save, PostDto.class);
//			}
//		
		Post city=modelMapper.map(postDto, Post.class);
		Post cityt=postRepo.save(city);
			
		return modelMapper.map(cityt, PostDto.class);
//		return null;

	}

	@Override
	public List<Post> findByAdvertisementAdvertisementId(Integer advertisementId)
	{
		return postRepo.findByAdvertisementAdvertisementId(advertisementId);
	}
	@Override
	public PostDto updatePost(PostDto postDto, Integer postCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto getPostByPostName(Integer postCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPost() {
		List<Post> userst = postRepo.findAll();
		List<PostDto> collect = userst.stream().map((post)->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return collect;
		
	}

	@Override
	public void deletePostByCode(Integer postCode) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public  List<PostDto> getElement(Integer advertisementNo)
	{
//		List<Advertisement> byAdv = advertisementRepo.findByAdv(advertisementNo);
////        List<Post> all = postRepo.findAll();
////        List<Post> allById = postRepo.findAllById(Set.of(advertisementNo));
////		List<PostDto> collect = all.stream().map((post) -> modelMapper.map(post, PostDto.class)).filter(advertisementNo==postRepo.findAllById(advertisementNo)).collect(Collectors.toList());
//
//		List<Post> posts=postRepo.findByAdvertisementId((Advertisement) byAdv);
//		List<PostDto> postDtoss=posts.stream().map((post)->modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
//		return   postDtoss;
		 return   null;
	}
//@Override
//	public List<Post> findAdvByAdvertisementNo(Integer advertisementNo) {
//		return postRepo.findByadvertisementNo(advertisementNo);
//	}
}
