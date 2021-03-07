package luk.fisz.journal.service.user;

import luk.fisz.journal.dto.UserDTO;
import luk.fisz.journal.dto.UserRegistrationDTO;

import java.security.Principal;

public interface UserService {

    UserDTO getByUsername(String username);

    void create(UserRegistrationDTO registrationDTO);
}
