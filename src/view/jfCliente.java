/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Cliente;
import static livrariaDAO.TLivrariaOOJF.cadClientes;
import services.ClienteService;
import services.ServicosFactory;
import util.ValidaCNPJ;
import util.ValidaCPF;

/**
 *
 * @author jairb
 */
public class jfCliente extends javax.swing.JFrame {

    /**
     * Creates new form jfCliente
     */
    JButton btnClick = null;

    public jfCliente() throws SQLException {
        initComponents();
        addRowToTableBD();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCpfCnpj = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jrbCpf = new javax.swing.JRadioButton();
        jrbCnpj = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfNomeCliente = new javax.swing.JTextField();
        jtfCpfCnpj = new javax.swing.JTextField();
        jtfEndereco = new javax.swing.JTextField();
        jtfTelefone = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        jbDeletar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbConfirmar = new javax.swing.JButton();
        jbPesqCPF = new javax.swing.JButton();
        jbPesqCNPJ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Cliente");

        jLabel2.setText("Nome Cliente:");

        bgCpfCnpj.add(jrbCpf);
        jrbCpf.setText("CPF");
        jrbCpf.setToolTipText("");
        jrbCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCpfActionPerformed(evt);
            }
        });

        bgCpfCnpj.add(jrbCnpj);
        jrbCnpj.setText("CNPJ");
        jrbCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCnpjActionPerformed(evt);
            }
        });

        jLabel4.setText("Endereço:");

        jLabel5.setText("Telefone:");

        jtfNomeCliente.setToolTipText("");

        jtfCpfCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCpfCnpjKeyPressed(evt);
            }
        });

        jtfTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTelefoneKeyTyped(evt);
            }
        });

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idCliente", "Nome", "CPF", "CNPJ", "Telefone", "Endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtClientes.setToolTipText("");
        jScrollPane2.setViewportView(jtClientes);
        if (jtClientes.getColumnModel().getColumnCount() > 0) {
            jtClientes.getColumnModel().getColumn(0).setResizable(false);
            jtClientes.getColumnModel().getColumn(0).setPreferredWidth(5);
            jtClientes.getColumnModel().getColumn(2).setPreferredWidth(75);
            jtClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtClientes.getColumnModel().getColumn(5).setPreferredWidth(150);
        }
        jtClientes.getAccessibleContext().setAccessibleName("");

        jbDeletar.setText("Deletar");
        jbDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbConfirmar.setText("Confirmar");
        jbConfirmar.setEnabled(false);
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jbPesqCPF.setText("Pesquisar CPF");
        jbPesqCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesqCPFActionPerformed(evt);
            }
        });

        jbPesqCNPJ.setText("Pesquisar CNPJ");
        jbPesqCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesqCNPJActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbLimpar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jrbCpf)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jrbCnpj))
                                    .addComponent(jLabel2))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jbPesqCPF)
                                        .addGap(44, 44, 44)
                                        .addComponent(jbPesqCNPJ)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jtfNomeCliente)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jtfEndereco)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jbEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jbConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCancelar)))
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbCpf)
                    .addComponent(jrbCnpj)
                    .addComponent(jtfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesqCPF)
                    .addComponent(jbPesqCNPJ))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDeletar)
                    .addComponent(jbSalvar)
                    .addComponent(jbLimpar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditar)
                    .addComponent(jbConfirmar)
                    .addComponent(jbCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtfNomeCliente.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Boolean validaInputs() {
        String telefone = jtfTelefone.getText();
        if (jtfNomeCliente.getText().isEmpty() || (!jrbCpf.isSelected() && !jrbCnpj.isSelected())
                || jtfEndereco.getText().isEmpty() || jtfTelefone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", ".:Erro:.", JOptionPane.ERROR_MESSAGE);
            jtfNomeCliente.requestFocus();
            return false;
        }
        if (telefone.length() < 11) {
            JOptionPane.showMessageDialog(this, "Telefone informado esta incorreto", ".:Erro:.", JOptionPane.ERROR_MESSAGE);
            jtfTelefone.requestFocus();
            return false;
        }
        if (btnClick.getText() == "Salvar") {
            ClienteService clienteS = ServicosFactory.getClienteService();
            /*String cpf = jtfCPF.getText().substring(0, 3)
                    + jtfCPF.getText().substring(4, 7)
                    + jtfCPF.getText().substring(8, 11)
                    + jtfCPF.getText().substring(12, 14);
             */
            if (jrbCpf.isSelected()) {
                if (!ValidaCPF.isCPF(jtfCpfCnpj.getText())) {
                    JOptionPane.showMessageDialog(this,
                            "CPF informado esta incorreto!!!",
                            ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                    jtfCpfCnpj.requestFocus();
                    return false;
                } else try {
                    if (!clienteS.verCPF(jtfCpfCnpj.getText())) {
                        JOptionPane.showMessageDialog(this,
                                "CPF já cadastrado!!!",
                                ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                        jtfCpfCnpj.requestFocus();
                        return false;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (jrbCnpj.isSelected()) {
                if (!ValidaCNPJ.isCNPJ(jtfCpfCnpj.getText())) {
                    JOptionPane.showMessageDialog(this,
                            "CNPJ informado esta incorreto!!!",
                            ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                    jtfCpfCnpj.requestFocus();
                    return false;
                } else try {
                    if (!clienteS.verCNPJ(jtfCpfCnpj.getText())) {
                        JOptionPane.showMessageDialog(this,
                                "CNPJ já cadastrado!!!",
                                ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                        jtfCpfCnpj.requestFocus();
                        return false;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }

    public void jTableFilterClear() {
        DefaultTableModel model = (DefaultTableModel) jtClientes.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        jtClientes.setRowSorter(sorter);
        sorter.setRowFilter(null);
    }


    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        // TODO add your handling code here:
        jtfNomeCliente.setText("");
        jtfCpfCnpj.setText("");
        jtfEndereco.setText("");
        jtfTelefone.setText("");
        bgCpfCnpj.clearSelection();
        jtfNomeCliente.requestFocus();
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
        jfCliente.this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    public void addRowToTable() {
        DefaultTableModel model = (DefaultTableModel) jtClientes.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        Object rowData[] = new Object[6];//define vetor das colunas
        for (Cliente listCli : cadClientes.getClientes()) {
            rowData[0] = listCli.getIdCliente();
            rowData[1] = listCli.getNomeCliente();
            rowData[2] = listCli.getCpf();
            rowData[3] = listCli.getCnpj();
            rowData[4] = listCli.getTelefone();
            rowData[5] = listCli.getEndereco();
            model.addRow(rowData);
        }

    }

    public void addRowToTableBD() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) jtClientes.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        Object rowData[] = new Object[6];//define vetor das colunas
        ClienteService clienteS = ServicosFactory.getClienteService();
        for (Cliente listCli : clienteS.getClientes()) {
            rowData[0] = listCli.getIdCliente();
            rowData[1] = listCli.getNomeCliente();
            rowData[2] = listCli.getCpf();
            rowData[3] = listCli.getCnpj();
            rowData[4] = listCli.getTelefone();
            rowData[5] = listCli.getEndereco();
            model.addRow(rowData);
        }

    }

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        // TODO add your handling code here:
        btnClick = (JButton) evt.getSource();
        if (validaInputs()) {

            //Cadastro a partir das validações
            int id = cadClientes.gerarId();
            String nomeCliente = jtfNomeCliente.getText();
            String cnpj = jtfCpfCnpj.getText();
            //String CpfCnpj = jtfCpfCnpj.getText();
            String cpf = jtfCpfCnpj.getText();
            String endereco = jtfEndereco.getText();
            String telefone = jtfTelefone.getText();
            Cliente c = new Cliente(id, nomeCliente, cpf, cnpj, endereco, telefone);
            ClienteService clienteS = ServicosFactory.getClienteService();
            if (jrbCpf.isSelected()) {
                c.setCnpj(null);

                try {
                    clienteS.cadClienteCpf(c);
                } catch (SQLException ex) {
                    Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    addRowToTableBD();
                } catch (SQLException ex) {
                    Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                jbLimpar.doClick();
                JOptionPane.showMessageDialog(this, c.getNomeCliente() + " cadastrado com sucesso!");

            } else if (jrbCnpj.isSelected()) {
                c.setCpf(null);
                try {
                    clienteS.cadClienteCnpj(c);
                } catch (SQLException ex) {
                    Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    addRowToTableBD();
                } catch (SQLException ex) {
                    Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                jbLimpar.doClick();
                JOptionPane.showMessageDialog(this, c.getNomeCliente() + " cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Cadastro incompleto.");
            }
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jrbCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbCnpjActionPerformed

    private void jrbCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbCpfActionPerformed

    private void jbDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarActionPerformed
        // TODO add your handling code here:
        //jbEditar.setEnabled(false);
        int linha;
        String cpf;
        linha = jtClientes.getSelectedRow();
        cpf = (String) jtClientes.getValueAt(linha, 2);
        //Pessoa p = cadPessoas.getByDoc(cpf);
        ClienteService clienteS = ServicosFactory.getClienteService();
        Cliente c = new Cliente();
        try {
            c = clienteS.buscaClienteBD(cpf);
        } catch (SQLException ex) {
            Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        //int resposta = JOptionPane.showConfirmDialog(this, "deseja realmente deletar " + p.getNomePessoa() + "?", ".:Deletar:.", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        Object[] resp = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(this,
                "Deseja realmente deletar " + c.getNomeCliente() + "?",
                ".: Deletar :.", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, resp, resp[0]);
        if (resposta == 0) {
            //cadPessoas.deletar(p);
            try {
                //addRowToTable();
                clienteS.deletarClienteBD(c.getIdCliente());
                addRowToTableBD();
                JOptionPane.showMessageDialog(this, "Pessoa deletada com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Entedemos sua decisão", "", JOptionPane.INFORMATION_MESSAGE);
        }
        jbDeletar.setEnabled(true);

    }//GEN-LAST:event_jbDeletarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            //ajustando comportamento dos botões
            jbDeletar.setEnabled(false);
            jbSalvar.setEnabled(false);
            jbEditar.setEnabled(false);
            jbLimpar.setEnabled(false);
            jbConfirmar.setEnabled(true);
            jtfCpfCnpj.setEnabled(false);
            jbPesqCPF.setEnabled(false);
            jbPesqCNPJ.setEnabled(false);
            jrbCnpj.setEnabled(false);
            jrbCpf.setEnabled(false);
            //carregar os dados da pessoa selecionada nos JTextFields
            int linha;
            String cpf;
            String cnpj;
            linha = jtClientes.getSelectedRow();
            cpf = (String) jtClientes.getValueAt(linha, 2);

            //Pessoa p = cadPessoas.getByDoc(cpf);
            ClienteService clienteS = ServicosFactory.getClienteService();
            Cliente c = clienteS.buscaClienteBD(cpf);

            // if (jrbCpf.isSelected()) {
            if (c.getCpf() != null) {
                jtfNomeCliente.setText(c.getNomeCliente());
                jtfCpfCnpj.setText(c.getCpf());
                jtfEndereco.setText(c.getEndereco());
                jtfTelefone.setText(c.getTelefone());
                jrbCpf.setSelected(true);
                jrbCnpj.setSelected(false);
            } else {
                cnpj = (String) jtClientes.getValueAt(linha, 3);
                Cliente p = clienteS.buscaClienteCnpjBD(cnpj);
                jtfNomeCliente.setText(p.getNomeCliente());
                jtfCpfCnpj.setText(p.getCnpj());
                jtfEndereco.setText(p.getEndereco());
                jtfTelefone.setText(p.getTelefone());
                jrbCpf.setSelected(false);
                jrbCnpj.setSelected(true);
                ////
            }
            /*} else {
                jtfNomeCliente.setText(c.getNomeCliente());
                jtfCpfCnpj.setText(c.getCnpj());
                jtfEndereco.setText(c.getEndereco());
                jtfTelefone.setText(c.getTelefone());
                jrbCpf.setSelected(false);
                jrbCnpj.setSelected(true);
            }*/
        } catch (SQLException ex) {
            Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        // TODO add your handling code here:
        btnClick = (JButton) evt.getSource();
        if (validaInputs()) {
            try {

                ClienteService clienteS = ServicosFactory.getClienteService();
                //Pessoa p = cadPessoas.getByDoc(jtfCPF.getText())8;
                Cliente c = clienteS.buscaClienteBD(jtfCpfCnpj.getText());
                Cliente p = clienteS.buscaClienteCnpjBD(jtfCpfCnpj.getText());

                if (c.getCpf() != null) {
                    c.setNomeCliente(jtfNomeCliente.getText());
                    c.setCpf(jtfCpfCnpj.getText());
                    c.setCnpj(jtfCpfCnpj.getText());
                    c.setEndereco(jtfEndereco.getText());
                    c.setTelefone(jtfTelefone.getText());

                    c.setCnpj(null);
                    //atualiza pessoa no BD com dados na tela
                    clienteS.atualizarClienteBD(c);

                    addRowToTableBD();
                } else {
                    p.setNomeCliente(jtfNomeCliente.getText());
                    p.setCpf(jtfCpfCnpj.getText());
                    p.setEndereco(jtfEndereco.getText());
                    p.setTelefone(jtfTelefone.getText());
                    p.setCnpj(jtfCpfCnpj.getText());
                    p.setCpf(null);
                    clienteS.atualizarClienteCnpjBD(p);
                    addRowToTableBD();
                }

            } catch (SQLException ex) {
                Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            jbConfirmar.setEnabled(false);
            jbSalvar.setEnabled(true);
            jbLimpar.setEnabled(true);
            jtfCpfCnpj.setEnabled(true);
            jbLimpar.doClick();
            
            jbDeletar.setEnabled(true);
            jbEditar.setEnabled(true);


            jbPesqCPF.setEnabled(true);
            jbPesqCNPJ.setEnabled(true);
            jrbCnpj.setEnabled(true);
            jrbCpf.setEnabled(true);
            // jBLimpar.setText("Limpar");
            jTableFilterClear();
            String msg = "Dados atualizados com sucesso!";
            JOptionPane.showMessageDialog(this, msg, ".: Atualizar :.",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            //jbLimpar.doClick();
            //jtfCPF.setEnabled(true);
        }
    }//GEN-LAST:event_jbConfirmarActionPerformed

    private void jbPesqCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesqCPFActionPerformed
        // TODO add your handling code here:
        ClienteService clienteS = ServicosFactory.getClienteService();
      /*  String cpf = jtfCPF.getText().substring(0, 3)
                + jtfCPF.getText().substring(4, 7)
                + jtfCPF.getText().substring(8, 11)
                +jtfCPF.getText().substring(12, 14);*/
        
        if (!ValidaCPF.isCPF(jtfCpfCnpj.getText())) {
            JOptionPane.showMessageDialog(this,
                    "CPF informado esta incorreto!!!",
                    ".: Erro :.", JOptionPane.ERROR_MESSAGE);
            jtfCpfCnpj.requestFocus();
        } else try {
            if (!clienteS.verCPF(jtfCpfCnpj.getText())) {
                DefaultTableModel model = (DefaultTableModel) jtClientes.getModel();
                final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
                jtClientes.setRowSorter(sorter);
                String text = jtfCpfCnpj.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    try {
                        sorter.setRowFilter(RowFilter.regexFilter(text));
                    } catch (PatternSyntaxException pse) {
                        JOptionPane.showMessageDialog(this, "Registro não encontrado!");
                    }
                }
 
            }
        } catch (SQLException ex) {
            Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbPesqCPFActionPerformed

    private void jbPesqCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesqCNPJActionPerformed
        // TODO add your handling code here:
         ClienteService clienteS = ServicosFactory.getClienteService();
      /*  String cpf = jtfCPF.getText().substring(0, 3)
                + jtfCPF.getText().substring(4, 7)
                + jtfCPF.getText().substring(8, 11)
                +jtfCPF.getText().substring(12, 14);*/
        
        if (!ValidaCNPJ.isCNPJ(jtfCpfCnpj.getText())) {
            JOptionPane.showMessageDialog(this,
                    "CNPJ informado esta incorreto!!!",
                    ".: Erro :.", JOptionPane.ERROR_MESSAGE);
            jtfCpfCnpj.requestFocus();
        } else try {
            if (!clienteS.verCNPJ(jtfCpfCnpj.getText())) {
                DefaultTableModel model = (DefaultTableModel) jtClientes.getModel();
                final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
                jtClientes.setRowSorter(sorter);
                String text = jtfCpfCnpj.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    try {
                        sorter.setRowFilter(RowFilter.regexFilter(text));
                    } catch (PatternSyntaxException pse) {
                        JOptionPane.showMessageDialog(this, "Registro não encontrado!");
                    }
                }
 
            }
        } catch (SQLException ex) {
            Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbPesqCNPJActionPerformed

    private void jtfTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefoneKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfTelefoneKeyTyped

    private void jtfCpfCnpjKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCpfCnpjKeyPressed
        // TODO add your handling code here:
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfCpfCnpjKeyPressed

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
            java.util.logging.Logger.getLogger(jfCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jfCliente().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jfCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgCpfCnpj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbDeletar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbPesqCNPJ;
    private javax.swing.JButton jbPesqCPF;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JRadioButton jrbCnpj;
    private javax.swing.JRadioButton jrbCpf;
    private javax.swing.JTable jtClientes;
    private javax.swing.JTextField jtfCpfCnpj;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JTextField jtfNomeCliente;
    private javax.swing.JTextField jtfTelefone;
    // End of variables declaration//GEN-END:variables

}
