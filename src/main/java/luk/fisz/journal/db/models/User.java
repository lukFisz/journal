package luk.fisz.journal.db.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    @Column(nullable = false)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;
    private String role = "USER";
    private boolean active = true;
    @OneToMany(mappedBy = "user", targetEntity = Journal.class)
    private List<Journal> journals;
}
