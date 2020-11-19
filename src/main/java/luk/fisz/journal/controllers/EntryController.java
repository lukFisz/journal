package luk.fisz.journal.controllers;

import luk.fisz.journal.dto.EntryDTO;
import luk.fisz.journal.services.interfaces.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/journal/{journalID}/entry")
public class EntryController {

    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("/all")
    List<EntryDTO> getAll(@PathVariable long journalID,
                          Principal principal) {
        return entryService.getAllOfSpecificJournal(journalID, principal);
    }

    @PostMapping("/create")
    ResponseEntity<Object> create(@PathVariable long journalID,
                                  @RequestBody EntryDTO entryDTO,
                                  Principal principal) {
        if (entryService.create(journalID, entryDTO, principal) != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/edit")
    ResponseEntity<Object> edit(@RequestBody EntryDTO entryDTO) {
        entryService.update(entryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
