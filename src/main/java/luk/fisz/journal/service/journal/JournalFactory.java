package luk.fisz.journal.service.journal;

import luk.fisz.journal.db.models.Journal;

public interface JournalFactory {
    Journal create(String title, String ownerUsername);
}
