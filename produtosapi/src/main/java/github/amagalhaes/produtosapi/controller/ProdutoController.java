package github.amagalhaes.produtosapi.controller;

import github.amagalhaes.produtosapi.model.Produto;
import github.amagalhaes.produtosapi.repository.ProdutoRepository;
import jakarta.persistence.PostRemove;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public  Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto Recebido: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("{id}")
    public Produto obterPorId(@PathVariable("id") String id){
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletar(@PathVariable String id) {
        produtoRepository.deleteById(id);
        return ResponseEntity.ok("Produto deletado com sucesso.");
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id,
                          @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
        return produtoRepository.findByNomeContaining(nome);
    }

}
