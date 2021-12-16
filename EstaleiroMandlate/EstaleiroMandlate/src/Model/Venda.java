/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Monteiro
 */
public class Venda {
     private int id;
    private int NrSerie;
    private String nome;
    private boolean estado;
    private String descricao;
    private String forncedor;
    private int quantidade;
    private int codProduto;
    private String Vendedor;

    public Venda() {
    }

    public Venda(int id, int NrSerie, String nome, boolean estado, String descricao, String forncedor, int quantidade, int codProduto, String Vendedor) {
        this.id = id;
        this.NrSerie = NrSerie;
        this.nome = nome;
        this.estado = estado;
        this.descricao = descricao;
        this.forncedor = forncedor;
        this.quantidade = quantidade;
        this.codProduto = codProduto;
        this.Vendedor = Vendedor;
    }

    public Venda(int NrSerie, String nome, boolean estado, String descricao, String forncedor, int quantidade, int codProduto, String Vendedor) {
        this.NrSerie = NrSerie;
        this.nome = nome;
        this.estado = estado;
        this.descricao = descricao;
        this.forncedor = forncedor;
        this.quantidade = quantidade;
        this.codProduto = codProduto;
        this.Vendedor = Vendedor;
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

    public String getForncedor() {
        return forncedor;
    }

    public void setForncedor(String forncedor) {
        this.forncedor = forncedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

   

    
    
    
}
