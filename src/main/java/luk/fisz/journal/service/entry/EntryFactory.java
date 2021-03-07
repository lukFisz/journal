package luk.fisz.journal.service.entry;

import luk.fisz.journal.db.models.Entry;

public interface EntryFactory {
    Entry create(Entry entry, long journalID, String ownerUsername);
}
