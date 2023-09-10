package womenandchilddepartment.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;


public class AdvertisementDto {
	private int advertisementId;
//	private  String asfsid;

	@UniqueElements(message="username should not be null!!")
	@Column(unique = true)
	private int advertisementNo;

	public AdvertisementDto(int advertisementId, int advertisementNo) {
		this.advertisementId = advertisementId;
//		this.asfsid = asfsid;
		this.advertisementNo = advertisementNo;
	}

	public AdvertisementDto() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public String getAsfsid() {
//		return asfsid;
//	}
//
//	public void setAsfsid(String asfsid) {
//		this.asfsid = asfsid;
//	}

	public int getAdvertisementNo() {
		return advertisementNo;
	}

	public int getAdvertisementId() {
		return advertisementId;
	}

	public void setAdvertisementId(int advertisementId) {
		this.advertisementId = advertisementId;
	}

	public void setAdvertisementNo(int advertisementNo) {
		this.advertisementNo = advertisementNo;
	}
	
//	private List<PostDto> postDto;


}
