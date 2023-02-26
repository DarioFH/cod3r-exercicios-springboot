package br.com.softfh.exerciciossb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class PrimeiroController {

    @GetMapping(path = {"/ola", "/saudacao"})
    public String ola() {
        return "Hello Spring Boot";
    }

}
