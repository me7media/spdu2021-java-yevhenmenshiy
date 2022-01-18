package org.spdu2021.registry.web.controller;

import org.spdu2021.registry.web.entity.Event;
import org.spdu2021.registry.web.service.EventService;
import org.spdu2021.registry.web.service.ValidationErrorService;
import org.springframework.http.ResponseEntity;
import org.spdu2021.registry.logger.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/events")
public class EventController {
    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    @Autowired
    private ValidationErrorService validationService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(eventService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(eventService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Event event, BindingResult result) {
        ResponseEntity errors = validationService.validate(result);
        if (errors != null) return errors;
        Event eventSaved = eventService.createOrUpdate(event);
        return new ResponseEntity<Event>(eventSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Event event, BindingResult result) {
        ResponseEntity errors = validationService.validate(result);
        if (errors != null) return errors;
        event.setId(id);
        Event eventSaved = eventService.createOrUpdate(event);
        return new ResponseEntity<Event>(eventSaved, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        eventService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
