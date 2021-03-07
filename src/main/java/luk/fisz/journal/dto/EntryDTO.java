package luk.fisz.journal.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@Accessors(chain = true)
public class EntryDTO {

    private long id;
    private String title;
    private String content;
    private Timestamp createdOn;

}
