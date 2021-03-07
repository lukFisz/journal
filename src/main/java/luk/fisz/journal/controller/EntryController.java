package luk.fisz.journal.controller;

import luk.fisz.journal.dto.EntryDTO;
import luk.fisz.journal.service.entry.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/journal/{journalID}/entry")
public class EntryController {

    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllByJournal(@PathVariable long journalID,
                                             Principal principal) {
        return new ResponseEntity<>(
                entryService.getAllByJournalAndUsername(journalID, principal.getName()),
                HttpStatus.OK
        );
    }

    @GetMapping("/{entryID}")
    public ResponseEntity<?> get(@PathVariable long entryID,
                                 Principal principal) {
        return new ResponseEntity<>(
                entryService.getByIdAndUsername(entryID, principal.getName()),
                HttpStatus.OK
        );
    }

    //    TODO
    @PostMapping("")
    public ResponseEntity<?> create(@PathVariable long journalID,
                                    @RequestBody EntryDTO entryDTO) {
        entryService.create(entryDTO, journalID);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
