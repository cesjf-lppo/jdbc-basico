package br.cesjf;

import java.util.Date;
import java.util.Locale;

public class Produto {

    private String nome;
    private Integer quantidade;
    private Float preco;
    private Date atualizado;

    public Produto() {
    }

    public Produto(String nome, Integer quantidade, Float preco, Date atualizado) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.atualizado = atualizado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Date getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(Date atualizado) {
        this.atualizado = atualizado;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s\t%d\t%6.2f", nome, quantidade, preco);
    }

    
}
