package womenandchilddepartment.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ApplicationSubmissionDto {

	@NotNull(message="areYouADepttCandidate should not be null!!")
	private String areYouADepttCandidate;
	@NotNull(message="organizationName should not be null!!")
	private String organizationName;
	@NotNull(message="Please Enter yearsOfExperience")
	private String yearsOfExperience;
	@NotNull(message="Please Enter natureOfWorksPerformed")
	private String  natureOfWorksPerformed;
	@NotNull(message="Please upload a picture")
	private String picture;
	@NotNull(message="Please verify your signature")
	private String signature;
	@Size( message="size must not be more than 50 words")
	@NotNull(message="Please upload your tenth Exam Mark Sheet_Certificate")
	private String tenthExamMarkSheet_Certificate;
	@NotNull(message="Please upload an adressProof")
	private String adressProof;
	@NotNull(message="Please upload your last Year Marksheet")
	private String lastYearMarksheet;
	@NotNull(message="work Experience should not be null!!")
	private String workExperience;
	@NotNull(message="Please upload an any other document if you have you do not have then please write no")
	private String anyOtherDoc;
	private String post;
	public ApplicationSubmissionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationSubmissionDto(int apsi, String areYouADepttCandidate, String organizationName,
			String yearsOfExperience, String natureOfWorksPerformed, String picture, String signature,
			String tenthExamMarkSheet_Certificate, String post, String adressProof, String lastYearMarksheet, String workExperience,
			String anyOtherDoc) {
		super();

		this.areYouADepttCandidate = areYouADepttCandidate;
		this.organizationName = organizationName;
		this.yearsOfExperience = yearsOfExperience;
		this.natureOfWorksPerformed = natureOfWorksPerformed;
		this.picture = picture;
		this.signature = signature;
		this.tenthExamMarkSheet_Certificate = tenthExamMarkSheet_Certificate;
		this.adressProof = adressProof;
		this.lastYearMarksheet = lastYearMarksheet;
		this.workExperience = workExperience;
		this.anyOtherDoc = anyOtherDoc;
		this.post=post;
	}


	public String getAreYouADepttCandidate() {
		return areYouADepttCandidate;
	}

	public void setAreYouADepttCandidate(String areYouADepttCandidate) {
		this.areYouADepttCandidate = areYouADepttCandidate;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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


	
}
