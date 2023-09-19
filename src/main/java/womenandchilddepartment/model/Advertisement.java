package womenandchilddepartment.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="advertisement")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Advertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
	private int advertisementId;
	private String advertisementNo;

	@JsonIgnore
	@OneToMany(mappedBy="advertisement")
	private Set<Post> product=new HashSet<Post>();

	public Advertisement(int advertisementId, String advertisementNo) {
		this.advertisementId = advertisementId;
		this.advertisementNo = advertisementNo;
	}

	public Advertisement(String advertisementNo) {
	}

	;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<Post> post;

//	public Advertisement() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public int getId() {
//		return id;
//	}
//
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public Advertisement(int id, int advertisementNo) {
//		this.id = id;
//
//		this.advertisementNo = advertisementNo;
//	}
//
//	public int getAdvertisementNo() {
//		return advertisementNo;
//	}
//
//	public void setAdvertisementNo(int advertisementNo) {
//		this.advertisementNo = advertisementNo;
//	}

//	public String getAsfsid() {
//		return asfsid;
//	}
//
//	public void setAsfsid(String asfsid) {
//		this.asfsid = asfsid;
//	}


	public int getAdvertisementId() {
		return advertisementId;
	}

	public String getAdvertisementNo() {
		return advertisementNo;
	}

	public Set<Post> getProduct() {
		return product;
	}

	public void setAdvertisementId(int advertisementId) {
		this.advertisementId = advertisementId;
	}

	public void setAdvertisementNo(String advertisementNo) {
		this.advertisementNo = advertisementNo;
	}

	public void setProduct(Set<Post> product) {
		this.product = product;
	}
}
