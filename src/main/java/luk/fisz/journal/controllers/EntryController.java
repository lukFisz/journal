package luk.fisz.journal.controllers;

import luk.fisz.journal.dto.EntryDTO;
import luk.fisz.journal.services.entry.EntryService;
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



}
