package womenandchilddepartment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordUpdateRequest {
    private String userConfId;
    private String oldPassword;
    private String newPassword;

    // Constructors, getters, and setters
}
