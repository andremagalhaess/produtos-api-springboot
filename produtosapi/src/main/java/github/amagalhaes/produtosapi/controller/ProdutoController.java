package github.amagalhaes.produtosapi.controller;

import github.amagalhaes.produtosapi.model.Produto;
import github.amagalhaes.produtosapi.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody Produto produto) {
        System.out.println("Produto Recebido: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);

        return ResponseEntity.ok("Produto salvo com sucesso: " + produto);
    }

    @GetMapping("{id}")
    public ResponseEntity<String> obterPorId(@PathVariable("id") String id) {
        var produto = produtoRepository.findById(id);

        if (produto.isPresent()) {
            return ResponseEntity.ok("Produto encontrado: " + produto.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletar(@PathVariable String id) {
        produtoRepository.deleteById(id);

        return ResponseEntity.ok("Produto deletado com sucesso. ID: " + id);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> atualizar(@PathVariable("id") String id,
                                            @RequestBody Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);

        return ResponseEntity.ok("Produto atualizado com sucesso: " + produto);
    }

    @GetMapping
    public ResponseEntity<String> buscar(@RequestParam("nome") String nome) {
        List<Produto> produtos = produtoRepository.findByNomeContaining(nome);

        return ResponseEntity.ok(
                "Produtos encontrados: " + produtos
        );
    }
}