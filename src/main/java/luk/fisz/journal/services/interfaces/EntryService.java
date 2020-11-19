package luk.fisz.journal.services.interfaces;

import luk.fisz.journal.dto.EntryDTO;

import java.security.Principal;
import java.util.List;

public interface EntryService {

    EntryDTO getOneById(long id);

    List<EntryDTO> getAllOfSpecificJournal(long journalID, Principal principal);

    EntryDTO create(long journalID, EntryDTO entryDTO, Principal principal);

    EntryDTO update(EntryDTO entryDTO);

}
