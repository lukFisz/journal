package luk.fisz.journal.services.user;

import luk.fisz.journal.dto.UserDTO;

import java.security.Principal;

public interface UserService {

    UserDTO getUserIfPresent(Principal p);

}
