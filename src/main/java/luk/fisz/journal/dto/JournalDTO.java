package luk.fisz.journal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
public class JournalDTO {

    private long id;
    private Timestamp createdOn;
    @NotBlank(message = "{journal.title.not_blank}")
    private String title;
    private List<EntryDTO> entries;

}
