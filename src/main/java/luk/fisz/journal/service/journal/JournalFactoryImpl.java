package luk.fisz.journal.service.journal;

import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.JournalRepo;
import luk.fisz.journal.dto.JournalDTO;
import luk.fisz.journal.service.user.UserFetcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@Transactional
public class JournalFactoryImpl implements JournalFactory {

    private final JournalRepo journalRepo;
    private final UserFetcher userFetcher;

    public JournalFactoryImpl(JournalRepo journalRepo, UserFetcher userFetcher) {
        this.journalRepo = journalRepo;
        this.userFetcher = userFetcher;
    }

    @Override
    public Journal create(String title, String ownerUsername) {
        User user = userFetcher.getByUsername(ownerUsername);
        Journal journal = new Journal()
                .setCreatedOn(new Timestamp(System.currentTimeMillis()))
                .setTitle(title)
                .setUser(user);
        return journalRepo.saveAndFlush(journal);
    }

}
