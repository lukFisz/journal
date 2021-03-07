package luk.fisz.journal.services.user;

import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.UserRepo;
import luk.fisz.journal.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserServiceImpl implements UserService {

    private final UserFetcher userFetcher;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserFetcher userFetcher, ModelMapper modelMapper) {
        this.userFetcher = userFetcher;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO getByUsername(String username) {
        User user = userFetcher.getByUsername(username);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO getUserIfPresent(Principal p) {
        return null;
    }
}
