package luk.fisz.journal.controllers;

import luk.fisz.journal.dto.EntryDTO;
import luk.fisz.journal.services.interfaces.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/entry")
public class EntryController {

//    TODO: pomyslec jakie jeszcze metody dodac; edit

    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping("/get/all/{id}")
    List<EntryDTO> getAll(@PathVariable long id,
                          Principal principal) {
        return entryService.getAllOfSpecificJournal(id, principal);
    }

    @PostMapping("/{id}/create")
    ResponseEntity<Object> create(@PathVariable long id,
                                  @RequestBody EntryDTO entryDTO,
                                  Principal principal) {
        if (entryService.create(id, entryDTO, principal) != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/edit")
    ResponseEntity<Object> edit(@RequestBody EntryDTO entryDTO) {
        entryService.update(entryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
