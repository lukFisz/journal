package luk.fisz.journal.controllers;

import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.dto.JournalDTO;
import luk.fisz.journal.services.interfaces.JournalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {

    private final JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping("/get/all")
    List<JournalDTO> getAll(Principal principal) {
        return journalService.getAllOfSpecificUser(principal);
    }

    @PostMapping("/create")
    ResponseEntity<Object> create(@RequestBody JournalDTO journal,
                                  Principal principal) {
        journalService.create(journal, principal);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/edit")
    ResponseEntity<Object> edit(@RequestBody JournalDTO journal,
                                Principal principal) {
        if (journalService.update(journal, principal) != null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
