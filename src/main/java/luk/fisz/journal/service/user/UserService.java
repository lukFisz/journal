package luk.fisz.journal.service.user;

import luk.fisz.journal.db.dto.UserDTO;
import luk.fisz.journal.db.dto.UserRegistrationDTO;

public interface UserService {

    UserDTO getByUsername(String username);

    void create(UserRegistrationDTO registrationDTO);
}
