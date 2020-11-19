package luk.fisz.journal.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import luk.fisz.journal.db.models.Journal;

import java.util.List;

@Data
@Accessors(chain = true)
public class UserDTO {

    private long id;
    private String username;
    private List<JournalDTO> journals;
    private String role;

}
