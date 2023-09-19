package womenandchilddepartment.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static womenandchilddepartment.model.Role.USER;

@Entity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class User implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String userConfId;
	private String tenthRollNumber;
	
	
	private String yearOfPassingTenth;
	private String firstName;
	private String lastName;
	//@Column(unique=true)
	
	private String email;
	
	private String password;
	
	private String father_Name;
	
	
	private String educatinal_Qualification;

	private LocalDate dateOfBirth;
	
	private String category;
	private boolean hasLoggedOnce;
	private String address;
	
	private String gender;
	private String picture;

	private String mobileNo;
	private String technical_professionalQualification;
	
	 @Enumerated(EnumType.STRING)
	    private Role role=USER;

	@ManyToMany
	@JoinTable(
			name = "course_like",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "post_id"))
	Set<Post> post;


	private String areYouADepttCandidate;
	private String organizationName;
	private String yearsOfExperience;
	private String  natureOfWorksPerformed;

	private String signature;
	private String tenthExamMarkSheet_Certificate;
	private String adressProof;
	private String lastYearMarksheet;
	private String workExperience;
	private String anyOtherDoc;

//	public User(int uid, boolean hasLoggedOnce, String userConfId, String post, String tenthRollNumber, String yearOfPassingTenth, String name, String email, String password, String father_Name, String educatinal_Qualification, LocalDate  dateOfBirth, String category, String address, String gender, String picture, String mobileNo, String technical_professionalQualification, Role role, String areYouADepttCandidate, String organizationName, String yearsOfExperience, String natureOfWorksPerformed, String signature, String tenthExamMarkSheet_Certificate, String adressProof, String lastYearMarksheet, String workExperience, String anyOtherDoc) {
//		this.uid = uid;
//		this.userConfId = userConfId;
//		this.tenthRollNumber = tenthRollNumber;
//		this.yearOfPassingTenth = yearOfPassingTenth;
//		this.name = name;
//		this.hasLoggedOnce=hasLoggedOnce;
//		this.post=post;
//		this.email = email;
//		this.password = password;
//		this.father_Name = father_Name;
//		this.educatinal_Qualification = educatinal_Qualification;
//		this.dateOfBirth = dateOfBirth;
//		this.category = category;
//		this.address = address;
//		this.gender = gender;
//		this.picture = picture;
//		this.mobileNo = mobileNo;
//		this.technical_professionalQualification = technical_professionalQualification;
//		this.role = role;
//		this.areYouADepttCandidate = areYouADepttCandidate;
//		this.organizationName = organizationName;
//		this.yearsOfExperience = yearsOfExperience;
//		this.natureOfWorksPerformed = natureOfWorksPerformed;
//		this.signature = signature;
//		this.tenthExamMarkSheet_Certificate = tenthExamMarkSheet_Certificate;
//		this.adressProof = adressProof;
//		this.lastYearMarksheet = lastYearMarksheet;
//		this.workExperience = workExperience;
//		this.anyOtherDoc = anyOtherDoc;
//	}


	public User(int uid, String userConfId, String tenthRollNumber, String yearOfPassingTenth, String firstName, String lastName, String email, String password, String father_Name, String educatinal_Qualification, LocalDate dateOfBirth, String category, boolean hasLoggedOnce, String address, String gender, String picture, String mobileNo, String technical_professionalQualification, Role role, Set<Post> post, String areYouADepttCandidate, String organizationName, String yearsOfExperience, String natureOfWorksPerformed, String signature, String tenthExamMarkSheet_Certificate, String adressProof, String lastYearMarksheet, String workExperience, String anyOtherDoc) {
		this.uid = uid;
		this.userConfId = userConfId;
		this.tenthRollNumber = tenthRollNumber;
		this.yearOfPassingTenth = yearOfPassingTenth;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.father_Name = father_Name;
		this.educatinal_Qualification = educatinal_Qualification;
		this.dateOfBirth = dateOfBirth;
		this.category = category;
		this.hasLoggedOnce = hasLoggedOnce;
		this.address = address;
		this.gender = gender;
		this.picture = picture;
		this.mobileNo = mobileNo;
		this.technical_professionalQualification = technical_professionalQualification;
		this.role = role;
		this.post = post;
		this.areYouADepttCandidate = areYouADepttCandidate;
		this.organizationName = organizationName;
		this.yearsOfExperience = yearsOfExperience;
		this.natureOfWorksPerformed = natureOfWorksPerformed;
		this.signature = signature;
		this.tenthExamMarkSheet_Certificate = tenthExamMarkSheet_Certificate;
		this.adressProof = adressProof;
		this.lastYearMarksheet = lastYearMarksheet;
		this.workExperience = workExperience;
		this.anyOtherDoc = anyOtherDoc;
	}

	public void setFirtsName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirtsName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Set<Post> getPost() {
		return post;
	}

	public void setPost(Set<Post> post) {
		this.post = post;
	}

	public boolean isHasLoggedOnce() {
		return hasLoggedOnce;
	}

	public void setHasLoggedOnce(boolean hasLoggedOnce) {
		this.hasLoggedOnce = hasLoggedOnce;
	}

	public String getUserConfId() {
		return userConfId;
	}

	public void setUserConfId(String userConfId) {
		this.userConfId = userConfId;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getAreYouADepttCandidate() {
		return areYouADepttCandidate;
	}

	public void setAreYouADepttCandidate(String areYouADepttCandidate) {
		this.areYouADepttCandidate = areYouADepttCandidate;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getNatureOfWorksPerformed() {
		return natureOfWorksPerformed;
	}

	public void setNatureOfWorksPerformed(String natureOfWorksPerformed) {
		this.natureOfWorksPerformed = natureOfWorksPerformed;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTenthExamMarkSheet_Certificate() {
		return tenthExamMarkSheet_Certificate;
	}

	public void setTenthExamMarkSheet_Certificate(String tenthExamMarkSheet_Certificate) {
		this.tenthExamMarkSheet_Certificate = tenthExamMarkSheet_Certificate;
	}

	public String getAdressProof() {
		return adressProof;
	}

	public void setAdressProof(String adressProof) {
		this.adressProof = adressProof;
	}

	public String getLastYearMarksheet() {
		return lastYearMarksheet;
	}

	public void setLastYearMarksheet(String lastYearMarksheet) {
		this.lastYearMarksheet = lastYearMarksheet;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	public String getAnyOtherDoc() {
		return anyOtherDoc;
	}

	public void setAnyOtherDoc(String anyOtherDoc) {
		this.anyOtherDoc = anyOtherDoc;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTenthRollNumber() {
		return tenthRollNumber;
	}

	public void setTenthRollNumber(String tenthRollNumber) {
		this.tenthRollNumber = tenthRollNumber;
	}

	public String getYearOfPassingTenth() {
		return yearOfPassingTenth;
	}

	public void setYearOfPassingTenth(String yearOfPassingTenth) {
		this.yearOfPassingTenth = yearOfPassingTenth;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roleName = "ROLE_" + "USER";
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName);

		List<SimpleGrantedAuthority> simpleGrantedAuthorities = new java.util.ArrayList<>();
		simpleGrantedAuthorities.add(simpleGrantedAuthority);
		return simpleGrantedAuthorities;

//		return null;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userConfId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFather_Name() {
		return father_Name;
	}

	public void setFather_Name(String father_Name) {
		this.father_Name = father_Name;
	}

	public String getEducatinal_Qualification() {
		return educatinal_Qualification;
	}

	public void setEducatinal_Qualification(String educatinal_Qualification) {
		this.educatinal_Qualification = educatinal_Qualification;
	}

	public LocalDate  getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate  dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo)






	{
		this.mobileNo = mobileNo;
	}

	public String getTechnical_professionalQualification() {
		return technical_professionalQualification;
	}

	public void setTechnical_professionalQualification(String technical_professionalQualification) {
		this.technical_professionalQualification = technical_professionalQualification;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}




	 
}