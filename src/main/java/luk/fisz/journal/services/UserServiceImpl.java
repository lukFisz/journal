package luk.fisz.journal.services;

import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.UserRepo;
import luk.fisz.journal.dto.UserDTO;
import luk.fisz.journal.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO getUserIfPresent(Principal p) {
        User _user = userRepo
                .findByUsername(p.getName())
                .orElseThrow(NoSuchElementException::new);
        modelMapper.map(_user, UserDTO.class);
        return modelMapper.map(_user, UserDTO.class);
    }

}
