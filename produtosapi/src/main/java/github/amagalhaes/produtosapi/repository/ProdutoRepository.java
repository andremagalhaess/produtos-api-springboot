package github.amagalhaes.produtosapi.repository;

import github.amagalhaes.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByNomeContaining(String nome);
}
