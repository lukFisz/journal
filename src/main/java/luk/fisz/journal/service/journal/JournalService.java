package luk.fisz.journal.service.journal;

import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.dto.JournalDTO;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

public interface JournalService {

    Collection<Journal> getAllByUsername(String username);

    JournalDTO getOneById(long id);

    List<JournalDTO> getAllOfSpecificUser(Principal principal);

    JournalDTO create(JournalDTO journalDTO, Principal principal);

    JournalDTO update(JournalDTO journalDTO, Principal principal);

    boolean confirmOwner(long id, Principal principal);

}
