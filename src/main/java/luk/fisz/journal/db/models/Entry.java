package luk.fisz.journal.db.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "entries")
@Setter
@Getter
@NoArgsConstructor
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private Timestamp createdOn;
    @ManyToOne
    @JoinColumn(name = "journal_id", nullable = false)
    private Journal journal;

}
