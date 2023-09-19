package womenandchilddepartment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import womenandchilddepartment.dto.PostDto;
import womenandchilddepartment.model.Post;


public interface PostService {
	PostDto createPostData(PostDto postDto);
	PostDto updatePost(PostDto postDto, Integer pI);
	PostDto getPostByPostName(Integer pI);
	List<PostDto> getAllPost();
	void deletePostByCode(Integer pI);
	public  List<Post> getElement(String advertisementNo);
	List<Post> findByAdvertisementAdvertisementId(Integer advertisementId);
	List<Post> getPostsByAdvertisementNo(String advertisementNo) throws NullPointerException;
	void deletePostByPI(Integer pI);

	public void deletePostByPostCode1(String postCode);
//	List<Post> findAdvByAdvertisementNo(Integer advertisementNo);
}
