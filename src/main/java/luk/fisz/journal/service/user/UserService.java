package luk.fisz.journal.service.user;

import luk.fisz.journal.dto.UserDTO;

import java.security.Principal;

public interface UserService {

    UserDTO getByUsername(String username);

    UserDTO getUserIfPresent(Principal p);

}
