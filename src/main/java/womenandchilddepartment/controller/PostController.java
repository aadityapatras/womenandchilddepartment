package womenandchilddepartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import womenandchilddepartment.dto.ApiResponse;
import womenandchilddepartment.dto.PostDto;
import womenandchilddepartment.dto.Postaddmapping;
import womenandchilddepartment.dto.UserDto;
import womenandchilddepartment.exception.ResourceNotFoundException;
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
	public Object  createCityData(@RequestBody PostDto cityDto)

	{
		if(cityDto.getAdvertisement().getAdvertisementNo()==null){
			return "Please select and Advertisement";
		}
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

//	@GetMapping("/adver/{adId}/posts")
//	public ResponseEntity<List<PostDto>> getPostByCategoryId(@PathVariable Integer adId)
//	{
//		List<PostDto> posts=postService.getElement(adId);
//		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
//
//	}

	@GetMapping("/advertisement/{advertisementId}")
	public ResponseEntity<List<Post>> getBooksByAuthorId(@PathVariable Integer advertisementId) {
		List<Post> byAdvertisementAdvertisementId = postService.findByAdvertisementAdvertisementId(advertisementId);
		return ResponseEntity.ok(byAdvertisementAdvertisementId);
	}

	@GetMapping("/advertisement1/{advertisementNo}")
	public ResponseEntity<ApiResponse> getBooksByPublisherName(@PathVariable String advertisementNo) {
		List<Post> books = postService.getElement(advertisementNo);
		if(advertisementNo!=null)
		{


			return new ResponseEntity<ApiResponse>(new ApiResponse("found successfully", true), HttpStatus.OK);
		} else if (books==null) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("not found", false), HttpStatus.NOT_FOUND);
		} else {
			return null;
		}
	}

	@PutMapping("/updateBrandInfo/{postCode}")
	public ResponseEntity<String> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postCode)
	{
		try {
			postService.updatePost(postDto, postCode);
			return ResponseEntity.ok("Post updated successfully.");
		} catch (ResourceNotFoundException e) {
//			return ResponseEntity.notFound().build();
			return new ResponseEntity<>("Post Code Not Found", HttpStatus.NOT_FOUND);
		}


//		return postService.updatePost(postDto, postCode);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> deletePostByPostCode(@RequestParam Integer pI) {
		try {
			postService.deletePostByPI(pI);
			return ResponseEntity.ok("Post deleted successfully.");
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}
		catch (RuntimeException e){
			return new ResponseEntity<>("Plaese select an advertisement No.", HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/byAdvertisementNo")
	public ResponseEntity<Object> getPostsByAdvertisementNo(@RequestParam String advertisementNo) {
		try {
			List<Post> postsByAdvertisementNo = postService.getPostsByAdvertisementNo(advertisementNo);
			return  ResponseEntity.ok(postsByAdvertisementNo);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}
		catch (RuntimeException e){
			return new ResponseEntity<>("Plaese select an advertisement No.", HttpStatus.BAD_REQUEST);
	}}
	@DeleteMapping("/delete1")
	public ResponseEntity<String> deletePostByPostCode1(@RequestParam String postCode) {
		try {
			postService.deletePostByPostCode1(postCode);
			return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
		} catch (RuntimeException e) {
			// Handle not found exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}