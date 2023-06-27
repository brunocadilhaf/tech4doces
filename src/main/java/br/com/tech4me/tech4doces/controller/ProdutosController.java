package br.com.tech4me.tech4doces.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4doces.model.Produtos;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    List<Produtos> produtos = new ArrayList<>();

    @GetMapping
    public List<Produtos> obterProdutos() {
        return produtos;
    }

    @GetMapping("/{descricao}")
    public Produtos consultarPorNome(@PathVariable String descricao) {
        Produtos produto = produtos.stream()
            .filter(p -> p.getDescricao().equalsIgnoreCase(descricao))
            .findFirst().orElse(null);
        
        return produto;
    }

    @PostMapping
    public ResponseEntity<String> cadastroProduto(@RequestBody Produtos produto) {
        produtos.add(produto);
        String mensagem = String.format("Categoria: %s - Produto: %s cadastrado com sucesso!", 
            produto.getTipoItem(), produto.getDescricao());

        return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
    }

    @DeleteMapping("/{descricao}")
    public String removerProduto(@PathVariable String descricao) {
        Boolean removeu = produtos.removeIf(p -> p.getDescricao().equalsIgnoreCase(descricao));

        if (removeu) {
            return "Produto deletado com sucesso!";
        } else {
            return "Produto não localizado!";
        }
        
    }

    @PutMapping("/{descricao}")
    public Produtos atualizarProduto(@PathVariable String descricao, @RequestBody Produtos novoProduto) {
        // Localizar
        Produtos antigoProduto = produtos.stream()
            .filter(p -> p.getDescricao().equalsIgnoreCase(descricao))
            .findFirst().orElse(null);

        // Atualizar
        if (antigoProduto != null) {
            antigoProduto.setTipoItem(novoProduto.getTipoItem());
            antigoProduto.setDescricao(novoProduto.getDescricao());
            antigoProduto.setValor(novoProduto.getValor());
        }
        // devolver o produto
        return antigoProduto;
    }
}
