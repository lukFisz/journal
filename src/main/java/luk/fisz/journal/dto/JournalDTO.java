package luk.fisz.journal.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import luk.fisz.journal.property.validation.JournalMessage;

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
    @NotBlank(message = JournalMessage.titleNotBlank)
    private String title;
    private List<EntryDTO> entries;

}
