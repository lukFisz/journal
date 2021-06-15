package luk.fisz.journal.db.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class UserDTO {

    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private List<JournalDTO> journals;

}
