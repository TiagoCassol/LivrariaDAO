/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static livrariaDAO.TLivrariaOOJF.cadEditoras;
import static livrariaDAO.TLivrariaOOJF.cadVendas;
import model.Livro;
import model.Venda;
import services.ClienteService;
import services.LivroService;
import services.ServicosFactory;
import services.VendaService;
import util.ValidaCPF;

/**
 *
 * @author casso
 */
public class jfVenda extends javax.swing.JFrame {

    /**
     * Creates new form jfVenda
     */
    public jfVenda() throws SQLException {
        initComponents();
        addRowToTableBD();
    }

    public void addRowToTableBD() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) jtVenda.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        Object rowData[] = new Object[8];//define vetor das colunas
        VendaService vendaS = ServicosFactory.getVendaService();
        for (Venda v : vendaS.getVendas()) {
            rowData[0] = v.getIdCliente();
            rowData[1] = v.getIdLivro();
            rowData[2] = v.getQtd();
            rowData[3] = v.getSubTotal();
            rowData[4] = v.getDataVenda();

            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfLivro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jlEstoque = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlPreco = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfQuant = new javax.swing.JTextField();
        jlSubTotal = new javax.swing.JLabel();
        jbComprar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtVenda = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jtfCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jlCliente = new javax.swing.JLabel();
        jlLivro = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CPF do cliente:");

        jtfLivro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfLivroFocusLost(evt);
            }
        });
        jtfLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfLivroActionPerformed(evt);
            }
        });

        jLabel2.setText("Estoque:");

        jlEstoque.setText("0");

        jLabel4.setText("Preço:            R$");

        jlPreco.setText("0");

        jLabel6.setText("Preço final:   R$");

        jLabel7.setText("Quantidade:");

        jtfQuant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfQuantFocusLost(evt);
            }
        });

        jlSubTotal.setText("0");

        jbComprar.setText("Comprar");
        jbComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComprarActionPerformed(evt);
            }
        });

        jtVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id Cliente", "id LIvro", "QuantCompra", "SubTotal", "dataVenda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtVenda);

        jLabel9.setText("ISBN do livro");

        jtfCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfClienteFocusLost(evt);
            }
        });
        jtfCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfClienteActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Comprar Livro");

        jButton4.setText("Escolher esse livro");

        jlCliente.setText("Cliente...");
        jlCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jlClienteFocusLost(evt);
            }
        });

        jlLivro.setText("Livro...");
        jlLivro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jlLivroFocusLost(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbComprar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(jtfLivro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlLivro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)))
                                .addGap(4, 4, 4)
                                .addComponent(jlEstoque)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jlCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlLivro))
                    .addComponent(jLabel9))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jlPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEstoque)
                    .addComponent(jLabel7)
                    .addComponent(jtfQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jlSubTotal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbComprar)
                    .addComponent(jbCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfLivroActionPerformed

    private void jtfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfClienteActionPerformed

    private void jlClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jlClienteFocusLost
        // TODO add your handling code here:
        jlCliente.setText(jlCliente.getText().toUpperCase());
    }//GEN-LAST:event_jlClienteFocusLost

    private void jlLivroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jlLivroFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jlLivroFocusLost

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
        jfVenda.this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComprarActionPerformed
        // TODO add your handling code here:
        Venda ven = new Venda();
        if (jtfCliente.getText().isEmpty() && jtfLivro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencher cliente e livro!");
        } else {
            try {
                VendaService vendaS = ServicosFactory.getVendaService();
                ClienteService clienteS = ServicosFactory.getClienteService();
                LivroService livroS = ServicosFactory.getLivroService();
                int id = cadVendas.gerarId();
                int idCliente;
                int idLivro;

                //idEditora = editoraS.getIdEditora(jcbEditora.getSelectedItem().toString());
                idCliente = clienteS.getIdCliente((jlCliente.getText()));
                idLivro = livroS.getIdLivro((jlLivro.getText()));
                int quantCompra = (Integer.parseInt(jtfQuant.getText()));
               // int estoque = (Integer.parseInt(jlEstoque.getText()));
                float subTotal = (Float.parseFloat(jlSubTotal.getText())); 
                LocalDateTime dataVenda= LocalDateTime.now();
                Venda v = new Venda(id, idCliente, idLivro, quantCompra, subTotal, dataVenda);
                vendaS.cadVenda(v);
                this.addRowToTableBD();
                //jbCancelar.doClick();
            } catch (SQLException ex) {
                Logger.getLogger(jfLivro.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "venda cadastrada com sucesso!");
        }

    }//GEN-LAST:event_jbComprarActionPerformed

    private void jtfClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfClienteFocusLost
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            ClienteService clienteS = ServicosFactory.getClienteService();
            if (!ValidaCPF.isCPF(jtfCliente.getText())) {
                JOptionPane.showMessageDialog(this,
                        "CPF informado esta incorreto!!!",
                        ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                jtfCliente.requestFocus();
            } else if (!clienteS.verCPF(jtfCliente.getText())) {
                int id = clienteS.getIdCliente(jtfCliente.getText());
                jlCliente.setText(clienteS.getNomeCliente(id));
            }else{
                jlCliente.setText("Pessoa não cadastrada");
            }
        } catch (SQLException ex) {
            Logger.getLogger(jfVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_jtfClienteFocusLost

    private void jtfLivroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfLivroFocusLost
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            LivroService livroS = ServicosFactory.getLivroService();
             if (!livroS.verIsbn(jtfLivro.getText())) {
                int id = livroS.getIdLivro(jtfLivro.getText());
                jlLivro.setText(livroS.getNomeLivro(id));
                jlPreco.setText(Float.toString(livroS.getPrecoLivro(id)));
                jlEstoque.setText(Float.toString(livroS.getEstoqueLivro(id)));
           
            }else{
                jlLivro.setText("Livro não cadastrado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(jfVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_jtfLivroFocusLost

    private void jtfQuantFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfQuantFocusLost
        // TODO add your handling code here:
       // float subTotal = (Float.parseFloat(jlSubTotal.getText())); 
        //float jlPreco = (Float.parseFloat(jlPreco.getText()));
        float calculo = (Float.parseFloat(jlPreco.getText())) * (Float.parseFloat(jtfQuant.getText()));
        jlSubTotal.setText(Float.toString(calculo));
    }//GEN-LAST:event_jtfQuantFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jfVenda().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jfVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbComprar;
    private javax.swing.JLabel jlCliente;
    private javax.swing.JLabel jlEstoque;
    private javax.swing.JLabel jlLivro;
    private javax.swing.JLabel jlPreco;
    private javax.swing.JLabel jlSubTotal;
    private javax.swing.JTable jtVenda;
    private javax.swing.JTextField jtfCliente;
    private javax.swing.JTextField jtfLivro;
    private javax.swing.JTextField jtfQuant;
    // End of variables declaration//GEN-END:variables
}
