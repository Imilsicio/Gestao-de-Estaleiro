/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexao;
import Model.Produto;
import Model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monteiro
 */
public class VendaController {
    
    public void VendaPro(Venda venda) {
        {
            Connection dataBase = new Conexao().conectarDB();
            String sql = "INSERT INTO venda( nrserie,nome, estado,descricao,fornecedor,vendedor) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement stm = dataBase.prepareStatement(sql)) {
                stm.setInt(1, venda.getNrSerie());
                stm.setString(2, venda.getNome());
                stm.setBoolean(3, venda.isEstado());
                stm.setString(4, venda.getDescricao());
                stm.setString(5, venda.getForncedor());
                stm.setInt(6, venda.getQuantidade());
                stm.setInt(8, venda.getCodProduto());
                stm.setString(9, venda.getVendedor());
                
                
                stm.execute();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }
    public void apagar(Venda venda) {
        Connection dataBase = new Conexao().conectarDB();
        String sql = "DELETE FROM produto WHERE id = ?";
        try {
            try (PreparedStatement stm = dataBase.prepareStatement(sql)) {
                stm.setInt(1, venda.getId());
                stm.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    
}
    
}
