/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.UsuarioController;
import Controller.UsuarioController;
import Model.Usuario;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author Monteiro
 */
public class Login extends JFrame implements ActionListener, Serializable {

    JLabel lblUsuario = new JLabel("USUÁRIO:");
    JLabel lblSenha = new JLabel("SENHA:");

    JTextField jtfUsuario = new JTextField();
    JPasswordField jpfSenha = new JPasswordField();

    JButton btnEntrar = new JButton("ENTRAR");
    Font font = new Font("serif", Font.ITALIC, 45);

    public Login() {
        setTitle("Login");
        setSize(500, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void criarGUI() {
        setLayout(null);

        lblUsuario.setBounds(200, 50, 120, 25);
        lblSenha.setBounds(200, 110, 120, 25);
        jtfUsuario.setBounds(150, 80, 160, 25);
        jpfSenha.setBounds(150, 140, 160, 25);
        btnEntrar.setBounds(190, 190, 80, 25);

        lblUsuario.setToolTipText("Nome do Usuário");
        lblSenha.setToolTipText("Senha");
        btnEntrar.setToolTipText("Entrar");

        add(lblUsuario);
        add(jtfUsuario);
        add(lblSenha);
        add(jpfSenha);
        add(btnEntrar);

        btnEntrar.addActionListener(this);
        jtfUsuario.addActionListener(this);
        jpfSenha.addActionListener(this);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login().criarGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEntrar) {
            if (jtfUsuario.getText().isEmpty() == true || String.valueOf(jpfSenha.getPassword()).isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Preecha os campos!");
            } else {
                Usuario novoUsuario = new Usuario(jtfUsuario.getText(), String.valueOf(jpfSenha.getPassword()));

                UsuarioController uc = new UsuarioController();
                

                ArrayList<Usuario> usuarios = uc.dados();
                if (usuarios.isEmpty() == true) {
                    //tela registo usuario
                } else {
                    boolean login = false;
                    for (Usuario usuario : usuarios) {
                        String senha = "";
                        for (int i = 0; i < jpfSenha.getPassword().length; i++) {
                            senha += jpfSenha.getPassword()[i];
                        }
                        
                        if (usuario.getNome().equals(jtfUsuario.getText()) && usuario.getSenha().equals(senha)) {
                            login = true;
                            break;
                        }
                    }

                    if (login == true) {
                       this.dispose();
                        new TelaAdmin().criarGUI();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario e senha incorrectos!");
                    }
                }
            }
        }
    }

}

    

