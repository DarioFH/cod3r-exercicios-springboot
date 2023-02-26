package br.com.softfh.exerciciossb.controllers;

import br.com.softfh.exerciciossb.model.entities.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @GetMapping(path = "/qualquer")
    public Cliente obterCliente() {
        return new Cliente(28, "Pedro", "123.456.789-00");
    }

    @GetMapping("/{id}")
    public Cliente obterClienteporId1(@PathVariable int id) {
        return new Cliente(id, "Maria", "987.654.432-00");
    }

    @GetMapping()
    public Cliente obterClienteporId2(@RequestParam(name = "id", defaultValue = "1") int id) {
        return new Cliente(id, "João", "111.222.333-44");
    }
}
