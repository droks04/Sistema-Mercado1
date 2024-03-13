package view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RelatoriosProdutos extends javax.swing.JFrame {

        public RelatoriosProdutos() {
        initComponents();
try {
   Class.forName("com.mysql.cj.jdbc.Driver");     
   Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_estoque", "root", "1234");
   //Aqui outros comandos de banco de dados
   PreparedStatement st = conectado.prepareStatement("SELECT * FROM produtos");
   ResultSet resultado = st.executeQuery();
   DefaultTableModel moldeTabela;
   moldeTabela = (DefaultTableModel) tlbProdutos.getModel();
   moldeTabela.setRowCount(0);
   while (resultado.next()) { 
       Object dep[] = {
          resultado.getInt("codigo"),
          resultado.getString("data"),
          resultado.getString("fornecedor"),
          resultado.getString("produto"),
          resultado.getInt("quantidade"),
          resultado.getString("valor")
          };
          moldeTabela.addRow(dep);
          cmbCodigo.addItem(resultado.getString("codigo"));
        }
    } catch (ClassNotFoundException x) {
   JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado " + x.getMessage());
    } catch (SQLException x) {
   JOptionPane.showMessageDialog(null,"Erro na conexão com o banco de dados " + x.getMessage());
      }
   }

       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tlbProdutos = new javax.swing.JTable();
        cmbCodigo = new javax.swing.JComboBox<>();
        lblCodigo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JToggleButton();

        setTitle("Relatório Produtos");
        getContentPane().setLayout(null);

        tlbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Fornecedor", "Produto", "Quantidade", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tlbProdutos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 55, 474, 188);

        cmbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbCodigo);
        cmbCodigo.setBounds(73, 14, 72, 22);

        lblCodigo.setText("Código");
        getContentPane().add(lblCodigo);
        lblCodigo.setBounds(24, 17, 43, 16);

        lblNome.setText("Produto");
        getContentPane().add(lblNome);
        lblNome.setBounds(157, 17, 43, 16);
        getContentPane().add(txtProduto);
        txtProduto.setBounds(212, 14, 167, 22);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar);
        btnPesquisar.setBounds(397, 14, 99, 23);

        setSize(new java.awt.Dimension(564, 308));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCodigoActionPerformed
       try {
   Class.forName("com.mysql.cj.jdbc.Driver");     
   Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_estoque", "root", "1234");
   //Aqui outros comandos de banco de dados
   PreparedStatement st = conectado.prepareStatement("SELECT * FROM produtos WHERE codigo = ?");
   st.setString(1, cmbCodigo.getSelectedItem().toString());
   ResultSet resultado = st.executeQuery();
   DefaultTableModel moldeTabela;
   moldeTabela = (DefaultTableModel) tlbProdutos.getModel();
   moldeTabela.setRowCount(0);
   while (resultado.next()) { 
       Object dep[] = {
          resultado.getInt("codigo"),
          resultado.getString("data"),
          resultado.getString("fornecedor"),
          resultado.getString("produto"),
          resultado.getInt("quantidade"),
          resultado.getString("valor")
          };
          moldeTabela.addRow(dep);
    }
    } catch (ClassNotFoundException x) {
   JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado " + x.getMessage());
    } catch (SQLException x) {
   JOptionPane.showMessageDialog(null,"Erro na conexão com o banco de dados " + x.getMessage());
      }
 
    }//GEN-LAST:event_cmbCodigoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
   Class.forName("com.mysql.cj.jdbc.Driver");     
   Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_estoque", "root", "1234");
   //Aqui outros comandos de banco de dados
   PreparedStatement st = conectado.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ?");
   st.setString(1, "%" + txtProduto.getText() + "%");
   ResultSet resultado = st.executeQuery();
   DefaultTableModel moldeTabela;
   moldeTabela = (DefaultTableModel) tlbProdutos.getModel();
   moldeTabela.setRowCount(0);
   while (resultado.next()) { 
       Object dep[] = {
          resultado.getInt("codigo"),
          resultado.getString("data"),
          resultado.getString("fornecedor"),
          resultado.getString("produto"),
          resultado.getInt("quantidade"),
          resultado.getString("valor")
          };
          moldeTabela.addRow(dep);
                  }
    } catch (ClassNotFoundException x) {
   JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado " + x.getMessage());
    } catch (SQLException x) {
   JOptionPane.showMessageDialog(null,"Erro na conexão com o banco de dados " + x.getMessage());
      }
    }//GEN-LAST:event_btnPesquisarActionPerformed

       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnPesquisar;
    private javax.swing.JComboBox<String> cmbCodigo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tlbProdutos;
    private javax.swing.JTextField txtProduto;
    // End of variables declaration//GEN-END:variables
}
