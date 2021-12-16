/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.ProdutoController;
import Controller.UsuarioController;
import Model.Produto;
import Model.Usuario;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class TelaRegProduto extends JFrame implements ActionListener, Serializable  {
    JLabel lblId = new JLabel("Id:");
    JLabel lblNome = new JLabel("Nome:");
    JLabel lblSenha = new JLabel("Senha:");
    JLabel lblNrSerie = new JLabel("Numero de Serie:");
    JLabel lblDescricao = new JLabel("Descricao:");
    JLabel lblFornecedor = new JLabel("Forncedor:");
    
    JComboBox jcFornecedor = new JComboBox();
    

    JTextField jtfId = new JTextField();
    JTextField jtfNome = new JTextField();
    JTextField jtfNrSerie = new JTextField();
    JTextField jtfDescricao = new JTextField();
    JTextField jtfFornecedor = new JTextField();
    
    

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

    public TelaRegProduto() {
        setTitle("Regista Produto");
         setSize(1080, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void criarGUI() {
        setLayout(null);

        lblId.setBounds(920, 210, 120, 25);
        jtfId.setBounds(870, 250, 120, 25);

        lblNome.setBounds(80, 40, 120, 25);
        jtfNome.setBounds(20, 80, 160, 25);
        
        lblNrSerie.setBounds(250, 40, 120, 25);
        jtfNrSerie.setBounds(220, 80, 160, 25);
        
        lblDescricao.setBounds(460, 40, 120, 25);
        jtfDescricao.setBounds(420, 80, 160, 120);
        
      //  lblFornecedor.setBounds(90, 80, 120, 25);
       // jtfFornecedor.setBounds(140, 80, 160, 25);

        //lblSenha.setBounds(20, 130, 120, 25);
        //jpfSenha.setBounds(140, 130, 160, 25);
 jcFornecedor.setBounds(320, 250, 160, 25);
       
       // jcFornecedor.setSelectedIndex(0);
       
        btnSubmeter.setBounds(610, 80, 160, 25);
        btnAtualizar.setBounds(850, 350, 160, 25);
        btnPesquisar.setBounds(850, 290, 160, 25);
       btnApagar.setBounds(850, 390, 160, 25);
        btnVoltar.setBounds(850,430,160,25);

        lblNome.setToolTipText("Nome");
        lblSenha.setToolTipText("Senha");
        btnSubmeter.setToolTipText("Registar");
         model.addColumn("Id");
         model.addColumn("Numero de Serie");
        model.addColumn("Nome");
        model.addColumn("Descricao");
   

       
        tabela = new JTable(model){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        
        JScrollPane scrollpane = new JScrollPane(tabela);
        scrollpane.setBounds(20, 250, 800, 210);
       
        
        add(scrollpane);
        add(lblId);
        add(jtfId);
        add(lblNome);
        add(jtfNome);
        add(lblSenha);
         add(jpfSenha);
         add(jtfNrSerie);
         add(lblNrSerie);
         add(lblDescricao);
         add(jtfDescricao);
         add(lblFornecedor);
         //add(jtfFornecedor);
         add(jcFornecedor);
         
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
        
        new TelaRegProduto().criarGUI();
    }

     public void dadosTabela() {
        DefaultTableModel model_ = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0);
        Produto produto = new Produto();
        ArrayList<Produto> dados = new ProdutoController().dados();

        if (dados.isEmpty() == false) {
            for (int i = 0; i < dados.size(); i++) {

                model_.addRow(new String[]{
                    dados.get(i).getId() + "",
                    dados.get(i).getNrSerie()+"",
                    dados.get(i).getNome() + "",
                    dados.get(i).getDescricao()
                    
                   
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
            if (jtfNome.getText().isEmpty() == true || jtfDescricao.getText().isEmpty() == true || jtfNrSerie.getText().isEmpty()==true ){
                JOptionPane.showMessageDialog(null, "Preencha os campos!");
            } else {
                Produto novoPro = new Produto(Integer.parseInt(jtfNrSerie.getText()), jtfNome.getText(), true, jtfDescricao.getText(), jtfFornecedor.getText());
              
                ProdutoController pc = new ProdutoController();
               pc.registar(novoPro);
                                JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");

              
            }
        }
        if (u.getSource() == btnPesquisar) {
            if (jtfId.getText().isEmpty()== true) {
                JOptionPane.showMessageDialog(null,"Preencha o campo ID!");
            }else{
                ProdutoController uo = new ProdutoController();
                Produto pro = new Produto(); 
                int id = (Integer.parseInt(jtfId.getText()));
                  for(Produto produto : uo.dados()){
                      if( id == produto.getId()){
                          pro = produto;
                          break;
                      }        
                  }
                  jtfNome.setText(pro.getNome());
                  jtfNrSerie.setText(String.valueOf(pro.getNrSerie()));
                  jtfDescricao.setText(pro.getDescricao());
                  
                  
                  
                }
            }
        if (u.getSource() == btnAtualizar) {
            if (jtfId.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Preencha os campos!");
            } else {
                
                    int id =(Integer.parseInt(jtfId.getText()));
               Produto novoPro = new Produto(Integer.parseInt(jtfNrSerie.getText()), jtfNome.getText(), true, jtfDescricao.getText(), jtfFornecedor.getText());
              
                ProdutoController pc = new ProdutoController();
               pc.atualizar(novoPro);
                                JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
               

            }
        }
         if (u.getSource() == btnApagar) {
            if (jtfId.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Preencha os campos!");
            } else {
                
                    int id =(Integer.parseInt(jtfId.getText()));
                Produto apagaPro = new Produto(id);
                ProdutoController po = new ProdutoController();
                
                po.apagar(apagaPro);
                JOptionPane.showMessageDialog(null, "Eliminado com sucesso!");

            }
            
        }
        if(u.getSource()== btnVoltar){
            this.dispose();
            new TelaAdmin().criarGUI();
        }
        }

    
    
}

    

