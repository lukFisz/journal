package luk.fisz.journal.db.repos;

import luk.fisz.journal.db.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepo extends JpaRepository<Entry, Long> {

}
