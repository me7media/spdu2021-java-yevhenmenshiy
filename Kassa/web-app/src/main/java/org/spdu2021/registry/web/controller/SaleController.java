package org.spdu2021.registry.web.controller;

import org.spdu2021.registry.logger.Logger;
import org.spdu2021.registry.logger.LoggerFactory;
import org.spdu2021.registry.web.entity.Event;
import org.spdu2021.registry.web.entity.Sale;
import org.spdu2021.registry.web.service.EventService;
import org.spdu2021.registry.web.service.SaleService;
import org.spdu2021.registry.web.service.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/sales")
public class SaleController {
    private static final Logger logger = LoggerFactory.getLogger(SaleController.class);

    @Autowired
    private SaleService saleService;

    @Autowired
    private ValidationErrorService validationService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(saleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(saleService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Sale sale, BindingResult result) {
        ResponseEntity errors = validationService.validate(result);
        if (errors != null) return errors;
        Sale saleSaved = saleService.createOrUpdate(sale);
        return new ResponseEntity<Sale>(sale, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Sale sale, BindingResult result) {
        ResponseEntity errors = validationService.validate(result);
        if (errors != null) return errors;
        sale.setId(id);
        Sale saleSaved = saleService.createOrUpdate(sale);
        return new ResponseEntity<Sale>(saleSaved, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        saleService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
