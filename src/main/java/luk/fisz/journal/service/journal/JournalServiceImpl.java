package luk.fisz.journal.service.journal;

import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.JournalRepo;
import luk.fisz.journal.db.repos.UserRepo;
import luk.fisz.journal.dto.JournalDTO;
import luk.fisz.journal.dto.UserDTO;
import luk.fisz.journal.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class JournalServiceImpl implements JournalService {

//    todo: refactor service impl to return only dto's

    private final JournalFetcher journalFetcher;
    private final UserService userService;
    private final UserRepo userRepo;
    private final JournalRepo journalRepo;
    private final ModelMapper modelMapper;

    public JournalServiceImpl(JournalFetcher journalFetcher,
                              UserService userService,
                              UserRepo userRepo,
                              JournalRepo journalRepo,
                              ModelMapper modelMapper) {
        this.journalFetcher = journalFetcher;
        this.userService = userService;
        this.userRepo = userRepo;
        this.journalRepo = journalRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public Collection<Journal> getAllByUsername(String username) {
        Collection<Journal> journals = journalFetcher.getAllByUser(username);
        return modelMapper.map(
                journals,
                new TypeToken<Collection<JournalDTO>>(){}.getType()
        );
    }

    @Override
    public JournalDTO getByIdAndUsername(long id, String username) {
        return modelMapper.map(
                journalFetcher.getByIdAndUsername(id, username),
                JournalDTO.class
        );
    }

}
