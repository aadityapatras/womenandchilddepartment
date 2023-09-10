package womenandchilddepartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import womenandchilddepartment.dto.PostDto;
import womenandchilddepartment.dto.Postaddmapping;
import womenandchilddepartment.dto.UserDto;
import womenandchilddepartment.model.Post;
import womenandchilddepartment.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService postService;

	@Autowired
		private Postaddmapping postaddmapping;
	
	@PostMapping("/addPost")
	public ResponseEntity<PostDto>  createCityData(@RequestBody PostDto cityDto)

	{
		postaddmapping.checkCityDto(cityDto);
		PostDto postData = postService.createPostData(cityDto);
		return new ResponseEntity<>(postData, HttpStatus.CREATED);
	}
	@GetMapping(value="/allpost")
	public ResponseEntity<List<PostDto>>  getAllPost()
	{
		List<PostDto> allPost = postService.getAllPost();
		return new ResponseEntity<>(allPost, HttpStatus.ACCEPTED);
			}

	@GetMapping("/adver/{adId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategoryId(@PathVariable Integer adId)
	{
		List<PostDto> posts=postService.getElement(adId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

	}

	@GetMapping("/advertisement/{advertisementId}")
	public ResponseEntity<List<Post>> getBooksByAuthorId(@PathVariable Integer advertisementId) {
		List<Post> byAdvertisementAdvertisementId = postService.findByAdvertisementAdvertisementId(advertisementId);
		return ResponseEntity.ok(byAdvertisementAdvertisementId);
	}

//	@GetMapping("/advertisement1/{advertisementNo}")
//	public ResponseEntity<List<Post>> getBooksByPublisherName(@PathVariable Integer advertisementNo) {
//		List<Post> books = postService.findAdvByAdvertisementNo(advertisementNo);
//		return ResponseEntity.ok(books);
//	}
}
