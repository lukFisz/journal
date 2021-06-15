package luk.fisz.journal.controller;

import luk.fisz.journal.db.dto.JournalDTO;
import luk.fisz.journal.service.journal.JournalService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@PropertySource("classpath:route.properties")
public class JournalController {

    private final JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping("/${journal.by_id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id,
                                 Principal principal) {
        return new ResponseEntity<>(
                journalService.getByIdAndUsername(id, principal.getName()),
                HttpStatus.OK
        );
    }

    @GetMapping("${journal.all}")
    public ResponseEntity<?> get(Principal principal) {
        return new ResponseEntity<>(
                journalService.getAllByUsername(principal.getName()),
                HttpStatus.OK
        );
    }

    @PostMapping("${journal.create}")
    public ResponseEntity<?> create(@Valid @RequestBody JournalDTO journalDTO,
                                    Principal principal) {
        journalService.create(journalDTO, principal.getName());
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

}
