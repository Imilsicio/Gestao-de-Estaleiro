/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Monteiro
 */
public class Produto {
    private int id;
    private int NrSerie;
    private String nome;
    private boolean estado;
    private String descricao;

    public Produto(int id, int NrSerie, String nome, boolean estado, String descricao) {
        this.id = id;
        this.NrSerie = NrSerie;
        this.nome = nome;
        this.estado = estado;
        this.descricao = descricao;
    }

    public Produto(int NrSerie, String nome, boolean estado, String descricao) {
        this.NrSerie = NrSerie;
        this.nome = nome;
        this.estado = estado;
        this.descricao = descricao;
    }

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNrSerie() {
        return NrSerie;
    }

    public void setNrSerie(int NrSerie) {
        this.NrSerie = NrSerie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
            
    
}
