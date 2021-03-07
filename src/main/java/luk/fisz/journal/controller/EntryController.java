package luk.fisz.journal.controller;

import luk.fisz.journal.service.entry.EntryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/journal/{journalID}/entry")
public class EntryController {

    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }



}
