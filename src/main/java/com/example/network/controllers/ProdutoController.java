package com.example.network.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.network.models.Produto;
import com.example.network.repositorys.ProdutoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepo;
	
	@GetMapping("/produtos")
    public List<Produto> getAllTodos() {
        return produtoRepo.findAll();
    }
	
	@PostMapping("/produtos")
    public Produto createProduto(@Valid @RequestBody Produto produto) {
        return produtoRepo.save(produto);
    }
	
	@GetMapping(value="/produtos/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable(value = "id") Long id) {
        return produtoRepo.findById(id)
                .map(produto -> ResponseEntity.ok().body(produto))
                .orElse(ResponseEntity.notFound().build());
    }
	
	@PutMapping(value="/produtos/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable(value = "id") Long id, @Valid @RequestBody Produto produto) {
        return produtoRepo.findById(id)
                .map(produtoData -> {
                    produtoData.setNome(produto.getNome());
                    produtoData.setMarca(produto.getMarca());
                    produtoData.setPreco(produto.getPreco());
                    Produto update = produtoRepo.save(produtoData);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());
    }
	
	@DeleteMapping(value="/produtos/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable(value = "id") Long id) {
        return produtoRepo.findById(id)
                .map(todo -> {
                    produtoRepo.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
	
	
}
