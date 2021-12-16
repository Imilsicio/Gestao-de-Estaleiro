/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexao;
import Model.Usuario;
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
public class UsuarioController {
          public void registar(Usuario usuario) {
        {
            Connection dataBase = new Conexao().conectarDB();
            String sql = "INSERT INTO usuario( senha,nome, sexo) VALUES (?,?,?)";
            try (PreparedStatement stm = dataBase.prepareStatement(sql)) {
                stm.setString(1, usuario.getNome());
                stm.setString(2, usuario.getSenha());
                stm.setString(3, usuario.getSexo());
                
                
                stm.execute();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
}
     
     public ArrayList<Usuario> dados() {
        Connection dataBase = new Conexao().conectarDB();
        String sql = "SELECT * FROM Usuario";
        ArrayList<Usuario> dados = new ArrayList();
        try {
            ResultSet result;
            try (PreparedStatement stm = dataBase.prepareStatement(sql)) {
                result = stm.executeQuery();
                while (result.next()) {
                    Usuario usuario = new Usuario(
                            
                            result.getString("nome"),
                            result.getInt("id"),
                            result.getString("senha"),
                            result.getString("sexo")
                    );
                    dados.add(usuario);
                }
            }
            result.close();
            return dados;
        } catch (SQLException e) {
            e.getMessage();
            return null;
        }

    }

    public void apagar(Usuario usuario) {
        Connection dataBase = new Conexao().conectarDB();
        String sql = "DELETE FROM fornecdor WHERE id = ?";
        try {
            try (PreparedStatement stm = dataBase.prepareStatement(sql)) {
                stm.setInt(1, usuario.getId());
                stm.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void atualizar(Usuario usuario) {
        Connection dataBase = new Conexao().conectarDB();
        if (!String.valueOf(usuario.getId()).isEmpty()) {
            String sql = "UPDATE usuario SET  nome=?,senha=? WHERE usuario.id=?";
            try (PreparedStatement stm = dataBase.prepareStatement(sql)) {
                stm.setString(1, usuario.getNome());
                stm.setString(2, usuario.getSenha());
                //stm.setString(3, usuario.getSexo());
                stm.setInt(3, usuario.getId());
                stm.executeUpdate();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
