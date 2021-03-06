package luk.fisz.journal.services.journal;

import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.JournalRepo;
import luk.fisz.journal.db.repos.UserRepo;
import luk.fisz.journal.dto.JournalDTO;
import luk.fisz.journal.dto.UserDTO;
import luk.fisz.journal.services.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class JournalServiceImpl implements JournalService {

//    todo: refactor service impl to return only dto's

    private final UserService userService;
    private final UserRepo userRepo;
    private final JournalRepo journalRepo;
    private final ModelMapper modelMapper;

    public JournalServiceImpl(UserService userService, UserRepo userRepo, JournalRepo journalRepo, ModelMapper modelMapper) {
        this.userService = userService;
        this.userRepo = userRepo;
        this.journalRepo = journalRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public JournalDTO getOneById(long id) {
        return modelMapper.map(
                journalRepo.findById(id).orElseThrow(NoSuchElementException::new),
                JournalDTO.class
        );
    }

    @Override
    public List<JournalDTO> getAllOfSpecificUser(Principal principal) {
        UserDTO user = userService.getUserIfPresent(principal);
        return user.getJournals();
    }

    @Override
    public JournalDTO create(JournalDTO journalDTO, Principal principal) {
        UserDTO user = userService.getUserIfPresent(principal);
        Journal journalModel = new Journal();
        journalModel.setTitle(journalDTO.getTitle());
        journalModel.setCreatedOn(new Timestamp(new Date().getTime()));
        journalModel.setUser(modelMapper.map(user, User.class));
        return modelMapper.map(journalRepo.save(journalModel), JournalDTO.class);
    }

    @Override
    public JournalDTO update(JournalDTO journalDTO, Principal principal) {
        Journal journalModel = journalRepo
                .findById(journalDTO.getId())
                .orElseThrow(NoSuchElementException::new);

        if (this.confirmOwner(journalDTO.getId(), principal)) {
            journalModel.setTitle(journalDTO.getTitle());
            journalRepo.save(journalModel);
            return modelMapper.map(journalRepo.save(journalModel), JournalDTO.class);
        }
        return null;
    }

    @Override
    public boolean confirmOwner(long id, Principal principal) {
        User userModel = userRepo
                .findByUsername(principal.getName())
                .orElseThrow(NoSuchElementException::new);
        return journalRepo.existsByUser(userModel);
    }
}
