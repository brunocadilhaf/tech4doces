package br.com.tech4me.tech4doces.model;

public class Produtos {
    private TipoItem tipoItem;
    private String descricao;
    private double valor;
    
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
