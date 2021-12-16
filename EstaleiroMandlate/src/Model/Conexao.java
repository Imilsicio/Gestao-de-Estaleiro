/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monteiro
 */
public class Conexao {
     public Connection conectarDB() {
        Connection conexao = null;
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/estaleiromandlate";
            String usuario = "root";
            String senha = "";
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao;
        } catch (ClassNotFoundException | SQLException ex) {
            
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
