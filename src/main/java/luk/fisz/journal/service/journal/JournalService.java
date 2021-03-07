package luk.fisz.journal.service.journal;

import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.dto.JournalDTO;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

public interface JournalService {

    Collection<Journal> getAllByUsername(String username);

    JournalDTO getByIdAndUsername(long id, String username);

    void create(JournalDTO source, String ownerUsername);
}
