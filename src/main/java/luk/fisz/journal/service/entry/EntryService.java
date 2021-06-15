package luk.fisz.journal.service.entry;

import luk.fisz.journal.db.dto.EntryDTO;

import java.util.Collection;

public interface EntryService {

    EntryDTO getByIdAndUsername(long entryID, String username);

    Collection<EntryDTO> getAllByJournalAndUsername(long journalID, String username);

    void create(EntryDTO source, long journalID, String ownerUsername);
}
