package luk.fisz.journal.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import luk.fisz.journal.db.models.Entry;
import luk.fisz.journal.db.models.User;

import java.sql.Timestamp;
import java.util.List;

@Data
@Accessors(chain = true)
public class JournalDTO {

    private long id;
    private Timestamp createdOn;
    private String title;
    private List<EntryDTO> entries;

}
