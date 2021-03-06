package luk.fisz.journal.services.journal;

import luk.fisz.journal.dto.JournalDTO;

import java.security.Principal;
import java.util.List;

public interface JournalService {

    JournalDTO getOneById(long id);

    List<JournalDTO> getAllOfSpecificUser(Principal principal);

    JournalDTO create(JournalDTO journalDTO, Principal principal);

    JournalDTO update(JournalDTO journalDTO, Principal principal);

    boolean confirmOwner(long id, Principal principal);

}
