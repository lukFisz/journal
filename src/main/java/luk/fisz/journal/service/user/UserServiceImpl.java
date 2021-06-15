package luk.fisz.journal.service.user;

import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.dto.UserDTO;
import luk.fisz.journal.db.dto.UserRegistrationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserFetcher userFetcher;
    private final UserFactory userFactory;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserFetcher userFetcher, UserFactory userFactory, ModelMapper modelMapper) {
        this.userFetcher = userFetcher;
        this.userFactory = userFactory;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO getByUsername(String username) {
        User user = userFetcher.getByUsername(username);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void create(UserRegistrationDTO registrationDTO) {
        userFactory.create(
                registrationDTO.getUsername(),
                registrationDTO.getPassword(),
                registrationDTO.getEmail(),
                registrationDTO.getFirstname(),
                registrationDTO.getLastname()
        );
    }

}
