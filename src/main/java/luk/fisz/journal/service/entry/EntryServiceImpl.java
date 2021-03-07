package luk.fisz.journal.service.entry;

import luk.fisz.journal.dto.EntryDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EntryServiceImpl implements EntryService {

    private final EntryFetcher entryFetcher;
    private final EntryFactory entryFactory;
    private final ModelMapper modelMapper;

    public EntryServiceImpl(EntryFetcher entryFetcher, EntryFactory entryFactory, ModelMapper modelMapper) {
        this.entryFetcher = entryFetcher;
        this.entryFactory = entryFactory;
        this.modelMapper = modelMapper;
    }

    @Override
    public EntryDTO getByIdAndUsername(long entryID, String username) {
        return modelMapper.map(
                entryFetcher.getByIdAndUsername(entryID, username),
                EntryDTO.class
        );
    }

    @Override
    public Collection<EntryDTO> getAllByJournalAndUsername(long journalID, String username) {
        return modelMapper.map(
                entryFetcher.getAllByJournalAndUsername(journalID, username),
                new TypeToken<Collection<EntryDTO>>(){}.getType()
        );
    }

    @Override
    public void create(EntryDTO source, long journalID) {
        entryFactory.create(
                source.getTitle(),
                source.getContent(),
                journalID
        );
    }

}
