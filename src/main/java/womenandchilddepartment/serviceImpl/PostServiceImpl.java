package womenandchilddepartment.serviceImpl;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import womenandchilddepartment.dto.AdvertisementDto;
import womenandchilddepartment.dto.PostDto;
import womenandchilddepartment.exception.ResourceNotFoundException;
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
		List<Post> all = postRepo.findAll();
		System.out.println(all);
		long count2 = all.stream().count()+1;

		Calendar calendar = Calendar.getInstance();

		// Get the current year
		int currentYear = calendar.get(Calendar.YEAR);
//		int i = city.getpI();

		city.setPostCode(String.valueOf(count2+"/"+currentYear));
//		i++;
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
	public PostDto updatePost(PostDto postDto, Integer pI) {
		// TODO Auto-generated method stub
		Post post = postRepo.findById(pI).orElseThrow(() -> new ResourceNotFoundException("Post", "post", pI));
		if (postDto.getPostName() != null)
			post.setPostName(postDto.getPostName());
		if (postDto.getAdvertisement() != null)
		post.setAdvertisement(postDto.getAdvertisement());
		if (postDto.getAgeCriteria() != 0)
		post.setAgeCriteria(postDto.getAgeCriteria());
		if (postDto.getCloseDate() != null)
		post.setCloseDate(postDto.getCloseDate());
		if (postDto.getOpenDate() != null)
		post.setOpenDate(postDto.getOpenDate());
		if (postDto.getExperienceRequired() != 0)
		post.setExperienceRequired(postDto.getExperienceRequired());
		Post updatedbrand=postRepo.save(post);
		PostDto brandtech=modelMapper.map(updatedbrand, PostDto.class);
		return brandtech;

	}

	@Override
	public PostDto getPostByPostName(Integer pI) {
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
	public void deletePostByCode(Integer pI) {
		// TODO Auto-generated method stub

	}
	@Override
	public  List<Post> getElement(String advertisementNo)
	{
//		public List<Product> findAll(String email)
//		{
		try{
//			Optional<User> us1= Optional.ofNullable(userRepository.findByEmail(email));
			Optional<Optional<Advertisement>> us1= Optional.ofNullable(Optional.ofNullable(advertisementRepo.findByAdvertisementNo(advertisementNo)));
			if (us1.isPresent()) {
				Optional<Advertisement> advertisement = us1.get();
				//List<Post> objects =
//				return new ArrayList<>(advertisement.getAdvertisementNo());
				return null;
			}

			else {
				return Collections.emptyList();
			}
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}
	@Override
	@Transactional
	public void deletePostByPI(Integer pI) throws ResourceNotFoundException, NullPointerException {
		Post post = postRepo.findById(pI).orElseThrow(()->new ResourceNotFoundException("Post", "post", pI));
		if (post == null) {
			throw  new RuntimeException("Advertisement not found with advertisementNo: " + pI);
		} else if(postRepo.existsById(pI)==false)
		{
			throw new ResourceNotFoundException("Post", "post", pI);
		}
		postRepo.delete(post);
	}
@Override
	public List<Post> getPostsByAdvertisementNo(String advertisementNo) throws  NullPointerException, ResourceNotFoundException {
//	public List<Post> getPostsByAdvertisementNo(String advertisementNo) throws ChangeSetPersister.NotFoundException {
		// Check if the advertisement exists, and throw NotFoundException if not found
	Advertisement advertisement = advertisementRepo.findByAdvertisementNo(advertisementNo);
	if (advertisement == null) {
		// Handle not found exception
		throw new RuntimeException("Advertisement not found with advertisementNo: " + advertisementNo);
	}
	return new ArrayList<>(advertisement.getProduct());
}
@Override
@Transactional
	public void deletePostByPostCode1(String postCode) {
		Optional<Post> post = Optional.ofNullable(postRepo.findByPostCode(postCode));
		if (post.isPresent()) {
			postRepo.delete(post.get());
		} else {
			throw new RuntimeException("Post not found with postCode: " + postCode);
		}
	}
}
//@Override
//	public List<Post> findAdvByAdvertisementNo(Integer advertisementNo) {
//		return postRepo.findByadvertisementNo(advertisementNo);
//	}

