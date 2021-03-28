package luk.fisz.journal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static luk.fisz.journal.common.validation.UserRegistrationProperties.*;

@Setter
@Getter
@NoArgsConstructor
public class UserRegistrationDTO {

    private String firstname;
    private String lastname;

    @NotBlank(message = "{user_registration.email.not_blank}")
    @Pattern(regexp = EMAIL_PATTERN_REGEX,
            message = "{user_registration.email.pattern}")
    private String email;

    @NotBlank(message = "{user_registration.username.not_blank}")
    @Size(min = USERNAME_SIZE_MIN,
            max = USERNAME_SIZE_MAX,
            message = "{user_registration.username.size}")
    private String username;

    @NotBlank(message = "{user_registration.password.not_blank}")
    @Size(min = PASSWORD_SIZE_MIN,
            max = PASSWORD_SIZE_MAX,
            message = "{user_registration.password.size}")
    private String password;

}
