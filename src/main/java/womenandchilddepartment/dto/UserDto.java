package womenandchilddepartment.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import womenandchilddepartment.model.Role;

import static womenandchilddepartment.dto.RoleDto.USER;

public class UserDto {

	
	private int uid;
	@NotEmpty
	@Pattern(message = "Roll number must be a digit", regexp="^[0-9]*$")
	private String tenthRollNumber;
	
	@NotEmpty
	@Pattern(message = "Year must be a digit", regexp="^[0-9]*$")
	private String yearOfPassingTenth;
	
	@NotNull(message="username should not be null!!")
	@Size(min=3, max=30, message="username must not be more than 50 words")
	private String firstName;
	@NotNull(message="username should not be null!!")
	@Size(min=3, max=30, message="username must not be more than 50 words")
	private String lastName;
	//@Column(unique=true)
	@NotNull(message="email should not be null!!")
	@Email(message="Please insert a valid emailId")
	private String email;
	
	@NotNull(message="password should not be null!!")
	@Size(min=8, message="password must not be less than 8 letters")
	private String password;
	@NotNull(message="father_Name should not be null!!")
	@Size(min=3, max=30, message="father_Name must not be more than 50 words")
	private String father_Name;
	private boolean hasLoggedOnce;
	@NotNull(message="educatinal_Qualification should not be null!!")
	private String educatinal_Qualification;
	@NotNull(message="dateOfBirth should not be null!!")
	private LocalDate  dateOfBirth;
	
	@NotNull(message="category should not be null!!")
	private String category;

	@NotNull(message="address should not be null!!")
	@Size(min=10,max=50, message="address must not be less than 10 words and more than 50 words")
	private String address;
	
	@NotNull(message="gender should not be null!!")
	@Size(min=2,max=10, message="gender must not be less than 2 words")
	private String gender;
	
	private String picture;
	
	@NotNull(message="mobileNo should not be null!!")
	@Size(min=10, max=10, message="mobileNo must not be more than 10 words")
	@Pattern(regexp = "[7-9][0-9]{9}", message = "Mobile number is invalid!!")
	private String mobileNo;
	
	private String technical_professionalQualification;
	
	
	    private RoleDto role=USER;

	public boolean isHasLoggedOnce() {
		return hasLoggedOnce;
	}

	public void setHasLoggedOnce(boolean hasLoggedOnce) {
		this.hasLoggedOnce = hasLoggedOnce;
	}

	public UserDto() {
			super();
			// TODO Auto-generated constructor stub
		}


		public UserDto(int uid,
				@NotEmpty @Pattern(message = "Roll number must be a digit", regexp = "^[0-9]*$") String tenthRollNumber,
				@NotEmpty @Pattern(message = "Year must be a digit", regexp = "^[0-9]*$") String yearOfPassingTenth,
				@NotNull(message = "username should not be null!!") @Size(min = 3, max = 30, message = "username must not be more than 50 words") String firstName,
					   @NotNull(message = "username should not be null!!") @Size(min = 3, max = 30, message = "username must not be more than 50 words") String lastName,
					   @NotNull(message = "email should not be null!!") @Email(message = "Please insert a valid emailId") String email,
				@NotNull(message = "password should not be null!!") @Size(min = 8, message = "password must not be less than 8 letters") String password,
				@NotNull(message = "father_Name should not be null!!") @Size(min = 3, max = 30, message = "father_Name must not be more than 50 words") String father_Name,
				@NotNull(message = "educatinal_Qualification should not be null!!") String educatinal_Qualification,
				@NotNull(message = "dateOfBirth should not be null!!") LocalDate  dateOfBirth,
				@NotNull(message = "category should not be null!!") String category,
				@NotNull(message = "address should not be null!!") @Size(min = 10, max = 50, message = "address must not be less than 10 words and more than 50 words") String address,
				@NotNull(message = "gender should not be null!!") @Size(min = 2, max = 10, message = "gender must not be less than 2 words") String gender,
				String picture,
				@NotNull(message = "mobileNo should not be null!!") @Size(min = 10, max = 10, message = "mobileNo must not be more than 10 words") @Pattern(regexp = "[7-9][0-9]{9}", message = "Mobile number is invalid!!") String mobileNo,
				String technical_professionalQualification, RoleDto role) {
			super();
			this.uid = uid;
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
			this.address = address;
			this.gender = gender;
			this.picture = picture;
			this.mobileNo = mobileNo;
			this.technical_professionalQualification = technical_professionalQualification;
			this.role = role;
		}


	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

//
//		public String getName() {
//			return name;
//		}
//
//
//		public void setName(String name) {
//			this.name = name;
//		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
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


		public void setDateOfBirth(LocalDate dateOfBirth) {
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


		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}


		public String getTechnical_professionalQualification() {
			return technical_professionalQualification;
		}


		public void setTechnical_professionalQualification(String technical_professionalQualification) {
			this.technical_professionalQualification = technical_professionalQualification;
		}


		public RoleDto getRole() {
			return role;
		}


		public void setRole(RoleDto role) {
			this.role = role;
		}


}
