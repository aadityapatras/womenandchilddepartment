package womenandchilddepartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import womenandchilddepartment.dto.AdvertisementDto;
import womenandchilddepartment.dto.PostDto;
import womenandchilddepartment.model.Post;
import womenandchilddepartment.service.AdvertisementService;

@RestController
@RequestMapping("/advertisements")
public class AdvertisementController {
	
	@Autowired
	private AdvertisementService advertisementService;
	
	@PostMapping(value="/aaAdver")
	public AdvertisementDto createAdvertisementData(@RequestBody AdvertisementDto advertisementDto)
	{
		return advertisementService.createAdvertisementData(advertisementDto);
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
}
