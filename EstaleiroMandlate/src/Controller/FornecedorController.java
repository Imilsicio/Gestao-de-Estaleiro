/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexao;
import Model.Fornecedor;
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
public class FornecedorController {
      public void registar(Fornecedor fornecedor) {
        {
            Connection dataBase = new Conexao().conectarDB();
            String sql = "INSERT INTO fornecdor( nome) VALUES (?)";
            try (PreparedStatement stm = dataBase.prepareStatement(sql)) {
                stm.setString(1, fornecedor.getNome());
               
                
                
                
                stm.execute();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Fornecedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
}
     
     public ArrayList<Fornecedor> dados() {
        Connection dataBase = new Conexao().conectarDB();
        String sql = "SELECT * FROM Fornecedor";
        ArrayList<Fornecedor> dados = new ArrayList();
        try {
            ResultSet result;
            try (PreparedStatement stm = dataBase.prepareStatement(sql)) {
                result = stm.executeQuery();
                while (result.next()) {
                    Fornecedor fornecedor = new Fornecedor(
                            
                          
                            result.getInt("id"),
                            result.getString("nome")
                         
                    );
                    dados.add(fornecedor);
                }
            }
            result.close();
            return dados;
        } catch (SQLException e) {
            e.getMessage();
            return null;
        }

    }

    public void apagar(Fornecedor fornecedor) {
        Connection dataBase = new Conexao().conectarDB();
        String sql = "DELETE FROM fornecdor WHERE id = ?";
        try {
            try (PreparedStatement stm = dataBase.prepareStatement(sql)) {
                stm.setInt(1, fornecedor.getId());
                stm.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void atualizar(Fornecedor fornecedor) {
        Connection dataBase = new Conexao().conectarDB();
        if (!String.valueOf(fornecedor.getId()).isEmpty()) {
            String sql = "UPDATE fornecedor SET nrserie=?, nome=?,estado=?,descricao=? WHERE produto.id=?";
            try (PreparedStatement stm = dataBase.prepareStatement(sql)) {
               
                stm.setString(1, fornecedor.getNome());
               
                stm.setInt(2, fornecedor.getId());
                stm.executeUpdate();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Fornecedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
