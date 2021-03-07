package luk.fisz.journal.service.entry;

import luk.fisz.journal.db.models.Entry;
import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.db.repos.EntryRepo;
import luk.fisz.journal.service.journal.JournalFetcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@Transactional
public class EntryFactoryImpl implements EntryFactory {

    private final EntryRepo entryRepo;
    private final JournalFetcher journalFetcher;

    public EntryFactoryImpl(EntryRepo entryRepo, JournalFetcher journalFetcher) {
        this.entryRepo = entryRepo;
        this.journalFetcher = journalFetcher;
    }

    @Override
    public Entry create(String title, String content, long journalID) {
        Journal journal = journalFetcher.getById(journalID);
        Entry entry = new Entry()
                .setTitle(title)
                .setContent(content)
                .setCreatedOn(new Timestamp(System.currentTimeMillis()))
                .setJournal(journal);
        return entryRepo.saveAndFlush(entry);
    }

}
