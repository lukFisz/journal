package luk.fisz.journal.controller;

import luk.fisz.journal.db.dto.EntryDTO;
import luk.fisz.journal.service.entry.EntryService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@PropertySource("classpath:route.properties")
public class EntryController {

    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("${entry.all}")
    public ResponseEntity<?> getAllByJournal(@PathVariable long journalID,
                                             Principal principal) {
        return new ResponseEntity<>(
                entryService.getAllByJournalAndUsername(journalID, principal.getName()),
                HttpStatus.OK
        );
    }

    @GetMapping("/${entry.by_id}")
    public ResponseEntity<?> get(@PathVariable long entryID,
                                 Principal principal) {
        return new ResponseEntity<>(
                entryService.getByIdAndUsername(entryID, principal.getName()),
                HttpStatus.OK
        );
    }

    @PostMapping("${entry.create}")
    public ResponseEntity<?> create(@PathVariable long journalID,
                                    @RequestBody EntryDTO entryDTO,
                                    Principal principal) {
        entryService.create(entryDTO, journalID, principal.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
