package luk.fisz.journal.services.interfaces;

import luk.fisz.journal.dto.UserDTO;

import java.security.Principal;

public interface UserService {

    UserDTO getUserIfPresent(Principal p);

}
