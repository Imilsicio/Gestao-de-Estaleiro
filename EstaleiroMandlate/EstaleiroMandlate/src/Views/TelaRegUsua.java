/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Monteiro
 */
public class TelaRegUsua extends JFrame implements ActionListener, Serializable  {
    JLabel lblId = new JLabel("Id:");
    JLabel lblNome = new JLabel("Nome:");
    JLabel lblSenha = new JLabel("Senha:");
    

    JTextField jtfId = new JTextField();
    JTextField jtfNome = new JTextField();

    JPasswordField jpfSenha = new JPasswordField();
    
    DefaultTableModel model = new DefaultTableModel();
    JTable tabela;
    
   
    JButton btnAtualizar = new JButton("Atualizar");
    JButton btnSubmeter = new JButton("Registar");
    JButton btnPesquisar = new JButton("Pesquisar");
    JButton btnApagar = new JButton("Apagar");
    JButton btnVoltar = new JButton("Voltar");
    Font font = new Font("serif", Font.ITALIC, 45);
    boolean[] canEdit = new boolean[]{
    false, false, false, false, false, false, false, false, false, false, false, false
    };

    public TelaRegUsua() {
        setTitle("Admin");
        setSize(400, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void criarGUI() {
        setLayout(null);

        lblId.setBounds(20, 480, 120, 25);
        jtfId.setBounds(140, 480, 120, 25);

        lblNome.setBounds(20, 80, 120, 25);
        jtfNome.setBounds(140, 80, 160, 25);

        lblSenha.setBounds(20, 130, 120, 25);
        jpfSenha.setBounds(140, 130, 160, 25);

       
        btnSubmeter.setBounds(140, 180, 160, 25);
        btnAtualizar.setBounds(140, 550, 160, 25);
        btnPesquisar.setBounds(140, 520, 160, 25);
       btnApagar.setBounds(140, 580, 160, 25);
        btnVoltar.setBounds(140,620,160,25);

        lblNome.setToolTipText("Nome");
        lblSenha.setToolTipText("Senha");
        btnSubmeter.setToolTipText("Registar");
                model.addColumn("Id");
        model.addColumn("Nome");

       
        tabela = new JTable(model){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        
        JScrollPane scrollpane = new JScrollPane(tabela);
        scrollpane.setBounds(20, 250, 340, 210);
       
        
        add(scrollpane);
        add(lblId);
        add(jtfId);
        add(lblNome);
        add(jtfNome);
        add(lblSenha);
         add(jpfSenha);
         
         add(btnVoltar);
        add(btnPesquisar);
        add(btnSubmeter);
        add(btnAtualizar);
        add(btnApagar);
        
     
        
        
        btnApagar.addActionListener(this);
        btnPesquisar.addActionListener(this);
        btnAtualizar.addActionListener(this);
        btnSubmeter.addActionListener(this);
        jtfNome.addActionListener(this);
        jpfSenha.addActionListener(this);
        btnVoltar.addActionListener(this);
        
         dadosTabela();
        setVisible(true);
    }
    


    public static void main(String[] args) {
        
        new TelaRegUsua().criarGUI();
    }

     public void dadosTabela() {
        DefaultTableModel model_ = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0);
        Usuario usuarios = new Usuario();
        ArrayList<Usuario> dados = new UsuarioController().dados();

        if (dados.isEmpty() == false) {
            for (int i = 0; i < dados.size(); i++) {

                model_.addRow(new String[]{
                    dados.get(i).getId() + "",
                    dados.get(i).getNome() + "",
                   
                });
            }
        }
    }
      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }
    @Override
    public void actionPerformed(ActionEvent u) {

if (u.getSource() == btnSubmeter) {
            if (jtfNome.getText().isEmpty() == true || String.valueOf(jpfSenha.getPassword()).isEmpty() == true ){
                JOptionPane.showMessageDialog(null, "Preencha os campos!");
            } else {
                Usuario novoUsuario = new Usuario(jtfNome.getText(),String.valueOf(jpfSenha.getPassword()));
              
                UsuarioController pc = new UsuarioController();
               pc.registar(novoUsuario);
                                JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");

              
            }
        }
        if (u.getSource() == btnPesquisar) {
            if (jtfId.getText().isEmpty()== true) {
                JOptionPane.showMessageDialog(null,"Preencha o campo ID!");
            }else{
                UsuarioController uo = new UsuarioController();
                Usuario usuariop = new Usuario(); 
                int id = (Integer.parseInt(jtfId.getText()));
                  for(Usuario usuario : uo.dados()){
                      if( id == usuario.getId()){
                          usuariop = usuario;
                          break;
                      }        
                  }
                  jtfNome.setText(usuariop.getNome());
                  
                  
                  
                }
            }
        if (u.getSource() == btnAtualizar) {
            if (jtfId.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Preencha os campos!");
            } else {
                
                    int id =(Integer.parseInt(jtfId.getText()));
                Usuario atuUsuario = new Usuario(jtfNome.getText(),String.valueOf(jpfSenha.getPassword()));
                UsuarioController po = new UsuarioController();
                
                po.atualizar(atuUsuario);
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

            }
        }
        if (u.getSource() == btnApagar) {
            if (jtfId.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Escolha um Id!");
            } else {
                
                    int id =(Integer.parseInt(jtfId.getText()));
                Usuario atuUsuario = new Usuario(jtfNome.getText(),String.valueOf(jpfSenha.getPassword()));
               UsuarioController po = new UsuarioController();
                
                po.apagar(atuUsuario);
                JOptionPane.showMessageDialog(null, "Eliminado com sucesso!");

            }
        }
        if(u.getSource()== btnVoltar){
            this.dispose();
            new TelaAdmin().criarGUI();
        }
        }

    
    
}
