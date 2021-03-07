package luk.fisz.journal.db.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "journals")
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Timestamp createdOn;
    private String title;
    @OneToMany(mappedBy = "journal", targetEntity = Entry.class)
    private List<Entry> entries;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
