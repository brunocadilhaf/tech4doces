package br.com.tech4me.tech4doces.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Produtos {
    @Id
    private String id;
    private TipoItem tipoItem;
    private String descricao;
    private double valor;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public TipoItem getTipoItem() {
        return tipoItem;
    }
    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
}
