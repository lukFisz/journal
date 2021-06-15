package luk.fisz.journal.service.journal;

import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.db.dto.JournalDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class JournalServiceImpl implements JournalService {

//    todo: refactor service impl to return only dto's

    private final JournalFetcher journalFetcher;
    private final JournalFactory journalFactory;
    private final ModelMapper modelMapper;

    public JournalServiceImpl(JournalFetcher journalFetcher,
                              JournalFactory journalFactory, ModelMapper modelMapper) {
        this.journalFetcher = journalFetcher;
        this.journalFactory = journalFactory;
        this.modelMapper = modelMapper;
    }

    @Override
    public Collection<JournalDTO> getAllByUsername(String username) {
        Collection<Journal> journals = journalFetcher.getAllByUsername(username);
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

    @Override
    public void create(JournalDTO source, String ownerUsername) {
        journalFactory.create(source.getTitle(), ownerUsername);
    }

}
