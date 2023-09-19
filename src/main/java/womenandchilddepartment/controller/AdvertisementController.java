package womenandchilddepartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import womenandchilddepartment.dto.AdvertisementDto;
import womenandchilddepartment.dto.ApiResponse;
import womenandchilddepartment.dto.PostDto;
import womenandchilddepartment.exception.AdvertisementAlreadyExistsException;
import womenandchilddepartment.exception.AdvertisementNotFoundException;
import womenandchilddepartment.exception.ResourceNotFoundException;
import womenandchilddepartment.model.Post;
import womenandchilddepartment.service.AdvertisementService;

import javax.validation.Valid;

@RestController
@RequestMapping("/advertisements")
public class AdvertisementController {

	@Autowired
	private AdvertisementService advertisementService;

	@PostMapping(value="/aaAdver")
	public ResponseEntity<String> createAdvertisementData(@RequestBody AdvertisementDto advertisementDto)
	{
		boolean created = advertisementService.createAdvertisementData(advertisementDto);
		if (created) {
			return new ResponseEntity<>("Advertisement created successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Advertisement with this advertisementNo already exists", HttpStatus.CONFLICT);
		}
	}
	@GetMapping(value="/allAdver")
	public List<AdvertisementDto> getAllAddv()
	{
		return advertisementService.getAllAddv();
	}

	@GetMapping(value="/allAdver/{adId}")
	public List<PostDto> getAdvById(@PathVariable Integer adId)
	{
		return advertisementService.getAdvById(adId);
	}

	@PostMapping(value="/addAdv")
	public Object createUniqueAdv(@RequestBody AdvertisementDto advertisementDto)
	{
		return advertisementService.createUniqueAdv(advertisementDto);
	}

	@DeleteMapping("/delete/{advertisementNo}")
	public ResponseEntity<String> deleteAdvertisementByAdvertisementNo(@PathVariable String advertisementNo) {
		boolean b = advertisementService.exists(advertisementNo);
		if(b==true) {
			return ResponseEntity.ok("Advertisement with advertisementNo " + advertisementNo + " deleted successfully.");

		}
		return null;	}

	@PutMapping("/updateCity")
	public ResponseEntity<String> updateAdvertisementNo(@RequestParam String oldAdvertisementNo, @RequestParam String newAdvertisementNo)
	{
		try {
			advertisementService.updateAdvertisementNo(oldAdvertisementNo, newAdvertisementNo);
			return ResponseEntity.ok("Advertisement updated successfully.");
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity ("Advertisement not found, Please check", HttpStatus.NOT_FOUND);
		} catch (AdvertisementAlreadyExistsException e) {
			return ResponseEntity.badRequest().body("New advertisementNo already exists.");
		}
	}
	}


