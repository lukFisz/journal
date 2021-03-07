package luk.fisz.journal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static luk.fisz.journal.property.validation.UserRegistrationMessage.*;

@Setter
@Getter
@NoArgsConstructor
public class UserRegistrationDTO {

    private String firstname;
    private String lastname;

    @NotBlank(message = emailNotBlankMsg)
    @Pattern(regexp = emailPatternRegex,
            message = emailPatternMsg)
    private String email;

    @NotBlank(message = usernameNotBlankMsg)
    @Size(min = usernameSizeMin,
            max = usernameSizeMax,
            message = usernameSizeMsg)
    private String username;

    @NotBlank(message = passwordNotBlankMsg)
    @Size(min = passwordSizeMin,
            max = passwordSizeMax,
            message = passwordSizeMsg)
    private String password;

}
