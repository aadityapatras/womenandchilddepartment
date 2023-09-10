package womenandchilddepartment.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Login {



//	@NotNull(message="username should not be null!!")

	private String userConfId;
	
//	@NotNull(message="password should not be null!!")

	private String password;

//	@NotNull(message="dateOfBirth should not be null!!")
	private LocalDate  dateOfBirth;


}
