package luk.fisz.journal.service.journal;

import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.dto.JournalDTO;

public interface JournalFactory {
    Journal create(String title, String ownerUsername);
}
