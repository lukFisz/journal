package luk.fisz.journal.controller;

import luk.fisz.journal.dto.JournalDTO;
import luk.fisz.journal.service.journal.JournalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if (id != null) {
            return new ResponseEntity<>(
                    journalService.getByIdAndUsername(id, principal.getName()),
                    HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                    journalService.getAllByUsername(principal.getName()),
                    HttpStatus.OK
            );
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> get(@RequestBody JournalDTO journalDTO,
                                 Principal principal) {
        journalService.create(journalDTO, principal.getName());
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

}
