package womenandchilddepartment.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="post")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pI;
	private String postName;
	private String qualification;
	private int experienceRequired;
	private int ageCriteria;
	private Date openDate;
	private Date closeDate;
	private String postCode;

	//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Advertisement advertisement;
//	@ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name= "advertisementId")
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="advertisementId", nullable = false )
	private Advertisement advertisement;

	@ManyToMany(mappedBy = "post")
	Set<User> user;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}


//	public Post(int postCode, String postName, String qualification, int experienceRequired, String ageCriteria,
//			Date openDate, Date closeDate, Advertisement advertisement) {
//		super();
//		this.postCode = postCode;
//		this.postName = postName;
//		this.qualification = qualification;
//		this.experienceRequired = experienceRequired;
//		this.ageCriteria = ageCriteria;
//		this.openDate = openDate;
//		this.closeDate = closeDate;
//		this.advertisement = advertisement;
//	}


	public Post(int pI, String postName, String qualification, int experienceRequired, int ageCriteria, Date openDate, Date closeDate, String postCode, Advertisement advertisement, Set<User> user) {
		super();
		this.pI = pI;
		this.postName = postName;
		this.qualification = qualification;
		this.experienceRequired = experienceRequired;
		this.ageCriteria = ageCriteria;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.postCode = postCode;
		this.advertisement = advertisement;
		this.user = user;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public void setpI(int pI) {
		this.pI = pI;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public int getpI() {
		return pI;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getPostName() {
		return postName;
	}


	public void setPostName(String postName) {
		this.postName = postName;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public int getExperienceRequired() {
		return experienceRequired;
	}


	public void setExperienceRequired(int experienceRequired) {
		this.experienceRequired = experienceRequired;
	}


	public int getAgeCriteria() {
		return ageCriteria;
	}


	public void setAgeCriteria(int ageCriteria) {
		this.ageCriteria = ageCriteria;
	}


	public Date getOpenDate() {
		return openDate;
	}


	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}


	public Date getCloseDate() {
		return closeDate;
	}


	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}


	public Advertisement getAdvertisement() {
		return advertisement;
	}


	public void setAdvertisement(Advertisement id) {
		this.advertisement = id;
	}


}

	
