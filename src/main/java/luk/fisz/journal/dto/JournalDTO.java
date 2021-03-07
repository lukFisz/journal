package luk.fisz.journal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
public class JournalDTO {

    private long id;
    private Timestamp createdOn;
    private String title;
    private List<EntryDTO> entries;

}
