/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.ProdutoController;
import Model.Produto;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Monteiro
 */
public class TelaVenda extends JFrame implements ActionListener{

JLabel lblId = new JLabel("Id:");
    JLabel lblNome = new JLabel("Nome:");
    JLabel lblFornecedor = new JLabel("Fornecedor:");
    JLabel lblEstadoCivil = new JLabel("Estado Civil:");
    JLabel lblMorada = new JLabel("Morada:");
    JLabel lblNrDserie = new JLabel("NrDserie:");
    JLabel lblAltura = new JLabel("Altura:");
    //JLabel lblPhoto = new JLabel("Photo:");
    JLabel lblNomeMae = new JLabel("Nome da Mae:");
    JLabel lblNomePai = new JLabel("Nome do Pai:");
    JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
    JLabel lblStatus = new JLabel("Estado:");
    JLabel lblDescricao = new JLabel("Descricao");
    JLabel lblDataMarcacao = new JLabel("Data de Marcacao:");
    

    JTextField jtfId = new JTextField();
    JTextField jtfNome = new JTextField();
     JTextField jtfDescricao = new JTextField();

    JTextField jtfFornecedor = new JTextField();
    JTextField jtfEstadoCivil = new JTextField();
    JTextField jtfMorada = new JTextField();
    JTextField jtfNrDserie = new JTextField();
     JFormattedTextField jtfDataMarcacao = new JFormattedTextField("DD / MM / AAAA");
    JTextField jtfAltura = new JTextField();

    JTextField jtfNomeMae = new JTextField();
    JTextField jtfNomePai = new JTextField();
     JFormattedTextField jtfDataNascimento = new JFormattedTextField("DD / MM / AAAA");
   
    JComboBox jcStatus = new JComboBox();
    JComboBox jcFornecedor = new JComboBox();
    JComboBox jcEstadCivil = new JComboBox();
    

    
     DefaultTableModel model = new DefaultTableModel();
    JTable tabela;
    
    
    JButton btnAdmin = new JButton("Usuario");
    JButton btnAtualizar = new JButton("Atualizar");
    JButton btnSubmeter = new JButton("Pesquisar");
    JButton btnPrimeiraTela = new JButton("Voltar");
    JButton btnApagar = new JButton("Apagar");
    Font font = new Font("serif", Font.ITALIC, 45);
    boolean[] canEdit = new boolean[]{
    false, false, false, false, false, false, false, false, false, false, false, false
    };
   

    public TelaVenda() {
        setTitle("Admin");
        setSize(1080, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    }

    public void criarGUI() {
        setLayout(null);

        lblDescricao.setBounds(600,250,120,25);
        jtfDescricao.setBounds(600,280,170,100);
        lblId.setBounds(80, 350, 120, 25);
        jtfId.setBounds(105, 350, 160, 25);

        lblNome.setBounds(40, 250, 120, 25);
        jtfNome.setBounds(105, 250, 160, 25);
 
        lblFornecedor.setBounds(280, 250, 120, 25);
       // jtfFornecedor.setBounds(320, 250, 160, 25);
 
        lblEstadoCivil.setBounds(530, 250, 120, 25);
        jtfEstadoCivil.setBounds(600, 250, 160, 25);

        lblMorada.setBounds(800, 250, 120, 25);
        jtfMorada.setBounds(860, 250, 160, 25);

        lblNrDserie.setBounds(20, 300, 120, 25);
        jtfNrDserie.setBounds(105, 300, 160, 25);

        lblAltura.setBounds(280, 300, 120, 25);
        jtfAltura.setBounds(320, 300, 160, 25);
        //lblPhoto.setBounds(20, 290, 290, 25);
        //jtfPhoto.setBounds(140, 290, 160, 25);
        lblNomeMae.setBounds(515, 300, 120, 25);
        jtfNomeMae.setBounds(600, 300, 160, 25);

        lblNomePai.setBounds(770, 300, 120, 25);
        jtfNomePai.setBounds(860, 300, 160, 25);
        
        
        
        lblStatus.setBounds(300,350,160,25);
        jcStatus.setBounds(360, 350, 160, 25);
        jcStatus.addItem("Activo");
        jcStatus.addItem("Desactivo");
        jcStatus.setEditable(false);
        jcStatus.setSelectedIndex(0);
        
        jcFornecedor.setBounds(360, 250, 160, 25);
        jcFornecedor.addItem("CIM");
        jcFornecedor.addItem("SOMOFER");
        jcFornecedor.setEditable(false);
        jcFornecedor.setSelectedIndex(0);
        
        jcEstadCivil.setBounds(600, 250, 160, 25);
        jcEstadCivil.addItem("Solteiro/a");
        jcEstadCivil.addItem("Casado/a");
        jcEstadCivil.addItem("Divorciado/a");
        jcEstadCivil.addItem("Viuvo/a");
        jcEstadCivil.setEditable(false);
        jcEstadCivil.setSelectedIndex(0);

         lblDataNascimento.setBounds(480, 350, 120, 25);
        jtfDataNascimento.setBounds(600, 350, 160, 25);
        //lblStatus.setBounds(20, 490, 120, 25);
        //jtfStatus.setBounds(140, 490, 160, 25);
        lblDataMarcacao.setBounds(20, 400, 120, 25);
        jtfDataMarcacao.setBounds(130, 400, 160, 25);
        btnSubmeter.setBounds(105, 500, 160, 25);
        btnAtualizar.setBounds(300, 500, 160, 25);
        btnPrimeiraTela.setBounds(860,500,160,25);
        btnApagar.setBounds(500,500,160,25);
        btnAdmin.setBounds(680,500,160,25);
   
        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Numero de Serie");
        model.addColumn("Estado");
        model.addColumn("Descricao");
        model.addColumn("Fornecedor");
        
       
        tabela = new JTable(model){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        
        
        lblNome.setToolTipText("Nome");
        lblFornecedor.setToolTipText("Fornecedor");
        btnSubmeter.setToolTipText("Submeter");
        JScrollPane scrollpane = new JScrollPane(tabela);
        scrollpane.setBounds(20, 10, 1040, 210);

        add(btnAdmin);
        add(lblId);
        add(jtfId);
        add(lblNome);
        add(jtfNome);
        add(lblFornecedor);
        add(jcFornecedor);
        add(lblDescricao);
        add(jtfDescricao);
       // add(lblEstadoCivil);
      //  add(jcEstadCivil);
     //   add(lblMorada);
     //   add(jtfMorada);
        add(lblNrDserie);
        add(jtfNrDserie);
       // add(lblAltura);
       // add(jtfAltura);
        //add(lblPhoto);
        //add(jtfPhoto);
       // add(lblNomeMae);
        //add(jtfNomeMae);
        //add(lblNomePai);
        //add(jtfNomePai);
        //add(lblDataNascimento);
        //add(jtfDataNascimento);
        add(lblStatus);
        //add(jtfStatus);
        //add(lblDataMarcacao);
        //add(jtfDataMarcacao);
        add(btnSubmeter);
        add(btnAtualizar);
        add(btnPrimeiraTela);
        add(btnApagar);
        add(scrollpane);
        add(jcStatus);
        
        

        btnAtualizar.addActionListener(this);
        btnSubmeter.addActionListener(this);
        jtfNome.addActionListener(this);
        jtfFornecedor.addActionListener(this);
        btnPrimeiraTela.addActionListener(this);
        btnApagar.addActionListener(this);
        btnAdmin.addActionListener(this);
        
        dadosTabela();
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaVenda().criarGUI(); 
    }
    
    public void dadosTabela() {
        DefaultTableModel model_ = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0);
        Produto produtos = new Produto();
        ArrayList<Produto> dados = new ProdutoController().dados();

        if (dados.isEmpty() == false) {
            for (int i = 0; i < dados.size(); i++) {

                model_.addRow(new String[]{
                    dados.get(i).getId() + "",
                    dados.get(i).getNome() + "",
                    dados.get(i).getNrSerie()+"",
                    dados.get(i).isEstado()+"",
                    dados.get(i).getDescricao(),
                    dados.get(i).getForncedor()
                   /* dados.get(i).getMorada(),
                    dados.get(i).getNrDserie(),
                    dados.get(i).getDataNascimento(),
                    dados.get(i).getNomeMae(),
                    dados.get(i).getNomePai(),
                    dados.get(i).getDataMarcacao(),
                    dados.get(i).getStatus()*/
                });
            }
        }
    }
      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }

    @Override
    public void actionPerformed(ActionEvent u) {

        if (u.getSource() == btnAtualizar) {
            if (jtfId.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Preencha os campos!");
            } else {
                
                    int id =(Integer.parseInt(jtfId.getText()));
                Produto atuProduto = new Produto(Integer.parseInt(jtfNrDserie.getText()), jtfNome.getText(), true, jtfDescricao.getText(), String.valueOf(jcFornecedor.getSelectedItem()));
                ProdutoController po = new ProdutoController();
                
                po.atualizar(atuProduto);
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

            }
        }
        if (u.getSource() == btnSubmeter) {
            if (jtfId.getText().isEmpty()== true) {
                JOptionPane.showMessageDialog(null,"Preencha o campo ID!");
            }else{
                ProdutoController po = new ProdutoController();
                Produto prosub = new Produto(); 
                int id = (Integer.parseInt(jtfId.getText()));
                  for(Produto produto : po.dados()){
                      if( id == produto.getId()){
                          prosub = produto;
                          break;
                      }        
                  }
                 jtfNome.setText(prosub.getNome());
                 jcFornecedor.setSelectedItem(prosub.getForncedor());
                 jtfNrDserie.setText(String.valueOf(prosub.getNrSerie()));
                 jtfDescricao.setText(prosub.getDescricao());
                  /*  jcEstadCivil.setSelectedItem(pessoap.getEstadoCivil());
                  jtfMorada.setText(pessoap.getMorada());
                  jtfNrDserie.setText(pessoap.getNrDserie());
                  jtfNomeMae.setText(pessoap.getNomeMae());
                  jtfNomePai.setText(pessoap.getNomePai());
                  jtfDataMarcacao.setText(pessoap.getDataMarcacao());
                  jcStatus.setSelectedItem(pessoap.getStatus());
                  jtfDataNascimento.setText(pessoap.getDataNascimento());
                  jtfAltura.setText(String.valueOf(pessoap.getAltura())); */
                  
                }
            }
        if(u.getSource() == btnPrimeiraTela){
            this.dispose();
           // new PrimeiraTela().criarGUI();
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
 if(u.getSource()== btnAdmin){
     this.dispose();
     new TelaRegUsua().criarGUI();
 }
 
 
    }
}
