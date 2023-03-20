package com.example.primesum.controller;

import com.example.primesum.service.PrimeSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class PrimeSumController {

    private final PrimeSumService primeSumService;

    // Using constructor injection rather than the bad field injection
    @Autowired
    public PrimeSumController(PrimeSumService primeSumService) {
        this.primeSumService = primeSumService;
    }

    @GetMapping(path = "/{max}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> sumPrimesToN(@PathVariable("max") Integer max) {
        Long sum = primeSumService.sumPrimesToN(max);
        return ResponseEntity.status(HttpStatus.OK).body(sum);
    }

}
