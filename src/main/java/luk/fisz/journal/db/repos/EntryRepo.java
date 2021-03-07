package luk.fisz.journal.db.repos;

import luk.fisz.journal.db.models.Entry;
import luk.fisz.journal.db.models.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface EntryRepo extends JpaRepository<Entry, Long> {
    List<Entry> findAllByJournal(Journal journal);
    Optional<Entry> findByIdAndJournal(long id, Journal journal);
}
