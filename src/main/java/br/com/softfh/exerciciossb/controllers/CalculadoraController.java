package br.com.softfh.exerciciossb.controllers;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path ="/calculadora")
public class CalculadoraController {

    @GetMapping()
    public String helloCalc(){
        return "hello";
    }

    @GetMapping(path= "/somar/{a}/{b}")
    public Integer soma(@PathVariable int a, @PathVariable int b){
        return a + b;
    }

    @GetMapping("/subtrair")
    public Integer subtrair(@RequestParam(name="a", required = true) int a, @RequestParam(name="b", required = true) int b){
        return a - b;
    }
}
