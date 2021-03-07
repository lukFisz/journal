package luk.fisz.journal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.List;

import static luk.fisz.journal.property.validation.JournalMessage.*;

@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
public class JournalDTO {

    private long id;
    private Timestamp createdOn;
    @NotBlank(message = titleNotBlank)
    private String title;
    private List<EntryDTO> entries;

}
