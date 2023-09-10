package womenandchilddepartment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import womenandchilddepartment.dto.PostDto;
import womenandchilddepartment.model.Post;


public interface PostService {
	PostDto createPostData(PostDto postDto);
	PostDto updatePost(PostDto postDto, Integer postCode);
	PostDto getPostByPostName(Integer postCode);
	List<PostDto> getAllPost();
	void deletePostByCode(Integer postCode);
	public  List<PostDto> getElement(Integer adId);
	List<Post> findByAdvertisementAdvertisementId(Integer advertisementId);
//	List<Post> findAdvByAdvertisementNo(Integer advertisementNo);
}
