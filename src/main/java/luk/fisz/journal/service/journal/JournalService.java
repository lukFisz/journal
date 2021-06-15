package luk.fisz.journal.service.journal;

import luk.fisz.journal.db.dto.JournalDTO;

import java.util.Collection;

public interface JournalService {

    Collection<JournalDTO> getAllByUsername(String username);

    JournalDTO getByIdAndUsername(long id, String username);

    void create(JournalDTO source, String ownerUsername);
}
