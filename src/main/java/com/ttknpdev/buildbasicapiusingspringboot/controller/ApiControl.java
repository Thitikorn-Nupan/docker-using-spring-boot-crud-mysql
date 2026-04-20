package com.ttknpdev.buildbasicapiusingspringboot.controller;

import com.ttknpdev.buildbasicapiusingspringboot.entity.Romance;
import com.ttknpdev.buildbasicapiusingspringboot.log.Log4J;
import com.ttknpdev.buildbasicapiusingspringboot.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/romance")
public class ApiControl {

    private final BooksService<Romance> romanceBooksService;
    private final Log4J log4J;

    @Autowired
    public ApiControl(BooksService<Romance> romanceBooksService) {
        this.romanceBooksService = romanceBooksService;
        log4J = new Log4J(ApiControl.class);
    }

    @GetMapping
    private ResponseEntity<?> testResponse() {
        return ResponseEntity.ok("hello, Docker");
    }

    @GetMapping(value = "/reads")
    private ResponseEntity<Iterable<Romance>> readsRomance() {
        log4J.logger.info("requested localhost:8080/ttknp/romance/reads");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(romanceBooksService.reads());
    }

    @GetMapping(value = "/read/{rid}")
    private ResponseEntity<Romance> readRomance(@PathVariable String rid) {
        log4J.logger.info("requested localhost:8080/ttknp/romance/read/{rid}");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(romanceBooksService.read(rid));
    }

    @PostMapping(value = "/create")
    private ResponseEntity<Romance> createRomance(@RequestBody Romance romance) {
        log4J.logger.info("requested localhost:8080/ttknp/romance/create");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(romanceBooksService.create(romance));
    }

    @PutMapping(value = "/update/{rid}")
    private ResponseEntity<Romance> createRomance(@RequestBody Romance romance , @PathVariable String rid) {
        log4J.logger.info("requested localhost:8080/ttknp/romance/update/{rid}");
        return ResponseEntity.status(HttpStatus.OK)
                .body(romanceBooksService.update(romance,rid));
    }

    @DeleteMapping(value = "/delete/{rid}")
    private ResponseEntity<Map<String,Romance>> deleteRomance(@PathVariable String rid) {
        log4J.logger.info("requested localhost:8080/ttknp/romance/delete/{rid}");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(romanceBooksService.delete(rid));
    }



}
