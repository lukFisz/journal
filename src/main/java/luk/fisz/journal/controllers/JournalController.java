package luk.fisz.journal.controllers;

import luk.fisz.journal.services.journal.JournalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/journal")
public class JournalController {

    private final JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable(required = false) Long id,
                                 Principal principal) {
        if (id == null) {
//            TODO
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    journalService.getAllByUsername(principal.getName()),
                    HttpStatus.OK
            );
        }
    }

}
