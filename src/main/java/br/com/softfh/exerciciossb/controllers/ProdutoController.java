package br.com.softfh.exerciciossb.controllers;

import br.com.softfh.exerciciossb.model.entities.Produto;
import br.com.softfh.exerciciossb.model.entities.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

//    @PostMapping
//    public @ResponseBody Produto novoProduto(
//            @RequestParam String nome,
//            @RequestParam double preco,
//            @RequestParam double desconto) {
//        Produto produto = new Produto(nome, preco, desconto);
//        produtoRepository.save(produto);
//        return produto;
//    }

    //@PostMapping
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto salvarProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping(path = "/pagina/{numPage}/{qtdPage}")
    public Iterable<Produto> getProdsPaginated(@PathVariable int numPage, @PathVariable int qtdPage) {
        if(qtdPage >= 5) qtdPage = 5;
        Pageable page = PageRequest.of(numPage,qtdPage);
        return produtoRepository.findAll(page);
    }
    @GetMapping
    public Iterable<Produto> getProds() {
       return produtoRepository.findAll();
    }

    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> getProdsByName(@PathVariable String parteNome) {
        //return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
        return produtoRepository.searchByName(parteNome);
    }
    @GetMapping(path = "/{id}")
    public Optional<Produto> GetProdById(@PathVariable int id) {
        return produtoRepository.findById(id);
    }

//    @PutMapping
//    public Produto updateProd(@Valid Produto produto){
//        produtoRepository.save(produto);
//        return produto;
//    }

    @DeleteMapping(path = "/{id}")
    public void delProd(@PathVariable int id) {
        produtoRepository.deleteById(id);
    }
}
