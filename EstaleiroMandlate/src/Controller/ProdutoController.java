/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexao;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monteiro
 */
public class ProdutoController {
    
     public void registar(Produto produto) {
        {
            Connection dataBase = new Conexao().conectarDB();
            String sql = "INSERT INTO produto( nrserie,nome, estado,descricao) VALUES (?,?,?,?)";
            try (PreparedStatement stm = dataBase.prepareStatement(sql)) {
                stm.setInt(1, produto.getNrSerie());
                stm.setString(2, produto.getNome());
                stm.setBoolean(3, produto.isEstado());
                stm.setString(4, produto.getDescricao());
                
                
                stm.execute();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
}
     
     public ArrayList<Produto> dados() {
        Connection dataBase = new Conexao().conectarDB();
        String sql = "SELECT * FROM produto";
        ArrayList<Produto> dados = new ArrayList();
        try {
            ResultSet result;
            try (PreparedStatement stm = dataBase.prepareStatement(sql)) {
                result = stm.executeQuery();
                while (result.next()) {
                    Produto produto = new Produto(
                            result.getInt("id"),
                            result.getInt("nrserie"),
                            result.getString("nome"),
                            result.getBoolean("estado"),
                            result.getString("Descricao")
                    );
                    dados.add(produto);
                }
            }
            result.close();
            return dados;
        } catch (SQLException e) {
            e.getMessage();
            return null;
        }

    }

    public void apagar(Produto produto) {
        Connection dataBase = new Conexao().conectarDB();
        String sql = "DELETE FROM produto WHERE id = ?";
        try {
            try (PreparedStatement stm = dataBase.prepareStatement(sql)) {
                stm.setInt(1, produto.getId());
                stm.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void atualizar(Produto produto) {
        Connection dataBase = new Conexao().conectarDB();
        if (!String.valueOf(produto.getId()).isEmpty()) {
            String sql = "UPDATE produto SET nrserie=?, nome=?,estado=?,descricao=? WHERE produto.id=?";
            try (PreparedStatement stm = dataBase.prepareStatement(sql)) {
                stm.setInt(1, produto.getNrSerie());
                stm.setString(2, produto.getNome());
                stm.setBoolean(3, produto.isEstado());
                stm.setString(4, produto.getDescricao());
                stm.setInt(5, produto.getId());
                stm.executeUpdate();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
