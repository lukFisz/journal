package luk.fisz.journal.services;

import luk.fisz.journal.db.models.Entry;
import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.db.repos.EntryRepo;
import luk.fisz.journal.db.repos.JournalRepo;
import luk.fisz.journal.dto.EntryDTO;
import luk.fisz.journal.services.interfaces.EntryService;
import luk.fisz.journal.services.interfaces.JournalService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EntryServiceImpl implements EntryService {

    private final JournalService journalService;
    private final JournalRepo journalRepo;
    private final ModelMapper modelMapper;
    private final EntryRepo entryRepo;

    public EntryServiceImpl(JournalService journalService, JournalRepo journalRepo, ModelMapper modelMapper, EntryRepo entryRepo) {
        this.journalService = journalService;
        this.journalRepo = journalRepo;
        this.modelMapper = modelMapper;
        this.entryRepo = entryRepo;
    }

    @Override
    public EntryDTO getOneById(long id) {
        return modelMapper.map(
                entryRepo.findById(id).orElseThrow(NoSuchElementException::new),
                EntryDTO.class
        );
    }

    @Override
    public List<EntryDTO> getAllOfSpecificJournal(long journalID, Principal principal) {
        if (journalService.confirmOwner(journalID, principal))
            return journalService.getOneById(journalID).getEntries();
        return new ArrayList<>();
    }

    @Override
    public EntryDTO create(long journalID, EntryDTO entryDTO, Principal principal) {
        if (journalService.confirmOwner(journalID, principal)) {
            Journal journalModel = journalRepo.findById(journalID).orElseThrow(NoSuchElementException::new);
            Entry entryModel = new Entry();
            entryModel.setTitle(entryDTO.getTitle());
            entryModel.setContent(entryDTO.getContent());
            entryModel.setJournal(journalModel);
            entryModel.setCreatedOn(new Timestamp(new Date().getTime()));
            return modelMapper.map(
                    entryRepo.save(entryModel),
                    EntryDTO.class
            );
        }
        return null;
    }

    @Override
    public EntryDTO update(EntryDTO entryDTO) {
        Entry entryModel = entryRepo
                .findById(entryDTO.getId())
                .orElseThrow(NoSuchElementException::new);
        entryModel.setTitle(entryDTO.getTitle());
        entryModel.setContent(entryDTO.getContent());
        return modelMapper.map(
                entryRepo.save(entryModel),
                EntryDTO.class
        );
    }
}
