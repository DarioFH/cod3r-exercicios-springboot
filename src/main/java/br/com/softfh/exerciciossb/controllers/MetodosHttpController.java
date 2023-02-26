package br.com.softfh.exerciciossb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metodos")
public class MetodosHttpController {

    @GetMapping
    public String get(){
        return "Requisićão GET";
    }

    @PostMapping
    public String post(){
        return "Requisićão POST";
    }

    @PutMapping
    public String put(){
        return "Requisićão PUT";
    }

    @PatchMapping
    public String patch(){
        return "Requisićão PATCH";
    }

    @DeleteMapping
    public String delete(){
        return "Requisićão DELETE";
    }
}
