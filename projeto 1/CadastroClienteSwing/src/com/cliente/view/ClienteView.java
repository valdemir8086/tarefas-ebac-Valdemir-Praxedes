package com.cliente.view;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.jgoodies.forms.layout.FormLayout;
import com.cliente.control.ClienteController;
import com.cliente.control.ControllerInterface;
import com.cliente.dao.ClienteMapDAO;
import com.cliente.dao.IClienteDAO;
import com.cliente.dto.ClienteDTO;
import com.cliente.model.ClienteModel;
import com.cliente.observer.ClienteObserver;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class ClienteView extends JFrame implements ClienteObserver {
	
	private ClienteController controller;
	
    private DefaultTableModel modelo = new DefaultTableModel();
    private IClienteDAO clienteDAO = new ClienteMapDAO();
	
    //botões
    private JButton btnExcluir;
    private JButton btnSalvar;
    private JButton btnAlterar;
    
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItemSair;
    private JMenu menuItemSair;
    private JScrollPane jScrollPane1;
    
    //label
    private JLabel lblCPF;
    private JLabel lblNome;
    private JLabel lblTelefone;
    private JLabel lblEndereco;
    private JLabel lblNumero;
    private JLabel lblCidade;
    private JLabel lblEstado;
    
    //campos
    private JTextField txtCPF;
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEndereco;
    private JTextField txtNumero;
    private JTextField txtCidade;
    private JTextField txtEstado;
    
    private JTable tabelaClientes;
    private int linhaSelecionada; 

    
	public ClienteView(ClienteController controller) {
		super("Cliente consulta");
		this.controller = controller;
        initComponents();
        initCustomComponents();
	}
	
	 private void initComponents() {

	        lblNome = new JLabel();
	        txtNome = new JTextField();
	        btnSalvar = new JButton();
	        lblCPF = new JLabel();
	        txtCPF = new JTextField();
	        jScrollPane1 = new JScrollPane();
	        tabelaClientes = new JTable();
	        btnExcluir = new JButton();
	        jMenuBar1 = new JMenuBar();
	        menuItemSair = new JMenu();
	        jMenuItemSair = new JMenuItem();
	        lblTelefone = new JLabel();
	        txtTelefone = new JTextField();
	        lblEndereco = new JLabel();
	        txtEndereco = new JTextField();
	        lblNumero = new JLabel();
	        txtNumero = new JTextField();
	        lblCidade = new JLabel();
	        txtCidade = new JTextField();
	        lblEstado = new JLabel();
	        txtEstado = new JTextField();
	        btnAlterar = new JButton();
	        
	        

	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	        lblNome.setText("Nome:");

	        btnSalvar.setText("Salvar");
	        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnSalvarActionPerformed(evt);
	            }
	        });

	        btnAlterar.setText("Alterar");
	        btnAlterar.setEnabled(false);
	        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnAlterarActionPerformed(evt);
	            }
	        });
	        
	        lblCPF.setText("CPF:");
	        
	        lblTelefone.setText("Telefone:");
	        lblEndereco.setText("Endereço:");
	        lblNumero.setText("Numero:");
	        lblCidade.setText("Cidade:");
	        lblEstado.setText("Estado:");
	        tabelaClientes.setColumnSelectionAllowed(false);
	        tabelaClientes.setModel(new DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null}
	            },
	            new String [] {
	                "Title 1", "Title 2", "Title 3", "Title 4"
	            }
	        )) ;
	        tabelaClientes.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent evt) {
	                tabelaClientesMouseClicked(evt);
	            }
	        });
	        jScrollPane1.setViewportView(tabelaClientes);
	        btnExcluir.setEnabled(false);
	        btnExcluir.setText("Excluir");
	        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnExcluirActionPerformed(evt);
	            }
	        });

	        menuItemSair.setText("Opções");
	        menuItemSair.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                menuItemSairActionPerformed(evt);
	            }
	        });

	        jMenuItemSair.setText("Sair");
	        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItemSairActionPerformed(evt);
	            }
	        });
	        menuItemSair.add(jMenuItemSair);

	        jMenuBar1.add(menuItemSair);

	        setJMenuBar(jMenuBar1);

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(45, 45, 45)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(btnSalvar)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(btnAlterar)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(btnExcluir))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(lblNome)
	                        .addGap(18, 18, 18)
	                        .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
	                        .addGap(32, 32, 32)
	                        .addComponent(lblCPF)
	                        .addGap(18, 18, 18)
	                        .addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                    		 .addComponent(lblTelefone)
	                    		 .addGap(18, 18, 18)
	                    		 .addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
		                        .addComponent(lblEndereco)
		                        .addGap(18, 18, 18)
		                        .addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
		                        .addGap(32, 32, 32)
		                        .addComponent(lblNumero)
		                        .addGap(18, 18, 18)
		                        .addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
		                        .addComponent(lblCidade)
		                        .addGap(18, 18, 18)
		                        .addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
		                        .addGap(32, 32, 32)
		                        .addComponent(lblEstado)
		                        .addGap(18, 18, 18)
		                        .addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
	                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(133, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	            	.addGap(20, 20, 20)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(lblNome)
	                    .addComponent(txtNome,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lblCPF)
	                    .addComponent(txtCPF,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(20, 20, 20)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                		.addComponent(lblTelefone)
	                		.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(20, 20, 20)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                    .addComponent(lblEndereco)
		                    .addComponent(txtEndereco,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                    .addComponent(lblNumero)
		                    .addComponent(txtNumero,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(20, 20, 20)
		            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                    .addComponent(lblCidade)
		                    .addComponent(txtCidade,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                    .addComponent(lblEstado)
		                    .addComponent(txtEstado,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		            .addGap(39, 39, 39)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(btnSalvar)
	                    .addComponent(btnAlterar)
	                    .addComponent(btnExcluir))
	                .addGap(38, 38, 38)
	                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(93, Short.MAX_VALUE))
	        );

	        pack();
	    }

	    private void menuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSairActionPerformed
	        // TODO add your handling code here:
	    }

	    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
	        int result = JOptionPane.showConfirmDialog(this,"Deseja sair da aplicação?", "Sair",
	                        JOptionPane.YES_NO_OPTION,
	                        JOptionPane.QUESTION_MESSAGE);
	        if(result == JOptionPane.YES_OPTION){
	            System.exit(0);
	        }
	    }//GEN-LAST:event_jMenuItemSairActionPerformed

	    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
	        String nome = txtNome.getText();
	        String cpf = txtCPF.getText();
	        String endereco = txtEndereco.getText();
	        String estado = txtEstado.getText();
	        String cidade = txtCidade.getText();
	        String numero = txtNumero.getText();
	        String telefone = txtTelefone.getText();
	        
	        if (!isCamposValidos(nome, cpf, endereco, estado,cidade,numero, telefone )) {
	            JOptionPane.showMessageDialog(null, "Existem campos a serem preenchidos", "ATENÇÃO",JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }
	        
	        ClienteDTO cliente = new ClienteDTO(nome,cpf, telefone, endereco, numero, cidade, estado);
	        controller.cadastrar(cliente);
	        
	    }
	    
	    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
	        String nome = txtNome.getText();
	        String cpf = txtCPF.getText();
	        String endereco = txtEndereco.getText();
	        String estado = txtEstado.getText();
	        String cidade = txtCidade.getText();
	        String numero = txtNumero.getText();
	        String telefone = txtTelefone.getText();
	        
	        if (!isCamposValidos(nome, cpf, endereco, estado,cidade,numero, telefone )) {
	            JOptionPane.showMessageDialog(null, "Existem campos a serem preenchidos", "ATENÇÃO",JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }
	        
	        ClienteDTO cliente = new ClienteDTO(nome,cpf, telefone, endereco, numero, cidade, estado);
	        controller.alterar(cliente, linhaSelecionada);
	        
	    }

	    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
	        int linhaSelecionada = tabelaClientes.getSelectedRow();
	        Long cpf = (Long) tabelaClientes.getValueAt(linhaSelecionada, 1);
	        
	        controller.consultar(cpf, linhaSelecionada);

	    }

	    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
	       int linhaSelecionada = tabelaClientes.getSelectedRow();
	       
	       if (linhaSelecionada >= 0) {
	            int result = JOptionPane.showConfirmDialog(this,"Deseja realmente excluir este cliente?", "CUIDADO",
	                        JOptionPane.YES_NO_OPTION,
	                        JOptionPane.QUESTION_MESSAGE);
	        
	            if(result == JOptionPane.YES_OPTION){

	                Long cpf = (Long) tabelaClientes.getValueAt(linhaSelecionada, 1);
	                this.controller.excluir(cpf, linhaSelecionada);
	                
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Nenhum cliente selecionado.", "ERRO",JOptionPane.INFORMATION_MESSAGE);
	        }
	       
	       
	    }//GEN-LAST:event_btnExcluirActionPerformed

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
	            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	       
	        
	     
	        
	        ControllerInterface controller = new ClienteController();
	        
	    
	    }


	    private boolean isCamposValidos(String ...campos) {
	        for (String campo : campos) {
	            if (campos == null || "".equals(campo)) {
	                return false;
	            }
	        }
	        return true;
	    }

	    private void initCustomComponents() {
	        modelo.addColumn("Nome");
	        modelo.addColumn("CPF");
	        modelo.addColumn("Telefone");
	        modelo.addColumn("Endereço");
	        modelo.addColumn("Numero");
	        modelo.addColumn("Cidade");
	        modelo.addColumn("Estado");
	       
	        tabelaClientes.setModel(modelo);
	        
	  
	    }
	    
	     private void limparCampos() {
	        txtNome.setText("");
	        txtCPF.setText("");
	        txtEndereco.setText("");
	        txtEstado.setText("");
	        txtCidade.setText("");
	        txtNumero.setText("");
	        txtTelefone.setText("");
	 	 	txtCPF.setEnabled(true);
	   	 	btnSalvar.setEnabled(true);
	   	 	btnAlterar.setEnabled(false);
	   	 	tabelaClientes.setRowSelectionAllowed(true);
	   	 	
	   	 	if(modelo.getRowCount() == 0) btnExcluir.setEnabled(false);
	   	 	else btnExcluir.setEnabled(true);
	        
	        
	    }

		@Override
		public void updateRegistrar(ClienteDTO cliente, boolean isCadastrado)  {
		    
	        if (isCadastrado) {
	            modelo.addRow(new Object[]{cliente.getNome(), cliente.getCpf(), cliente.getTel(), cliente.getEnd(), cliente.getNumero(), cliente.getCidade(), cliente.getEstado()});
	            limparCampos();
	        } else {
	            JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado", "ATENÇÃO",JOptionPane.INFORMATION_MESSAGE);
	        }
			
		}

		@Override
		public void updateRemover(ClienteDTO dto, int linhaSelecionada, boolean isRemovido) {
			modelo.removeRow(linhaSelecionada);

            JOptionPane.showMessageDialog(null, "Cliente "+ dto.getNome() +" excluído com sucesso", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
			
		}

		@Override
		public void updateSelecionar(ClienteDTO cliente, int linhaSelecionada) {
		     txtNome.setText(cliente.getNome());
			 txtCPF.setText(cliente.getCpf().toString());
			 txtCidade.setText(cliente.getCidade());
			 txtEndereco.setText(cliente.getEnd());
			 txtEstado.setText(cliente.getEstado());
			 txtNumero.setText(cliente.getNumero().toString());
			 txtTelefone.setText(cliente.getTel().toString());
			 this.linhaSelecionada = linhaSelecionada;
			 
			 txtCPF.setEnabled(false);
			 btnSalvar.setEnabled(false);
			 btnAlterar.setEnabled(true);
			 tabelaClientes.setRowSelectionAllowed(false);
			
			
		}

		@Override
		public void updateAlterado(ClienteDTO cliente, int linhaSelecionada) {
			modelo.setValueAt(cliente.getNome(), linhaSelecionada, 0);
			modelo.setValueAt(cliente.getCpf(), linhaSelecionada, 1);
			modelo.setValueAt(cliente.getTel(), linhaSelecionada, 2);
			modelo.setValueAt(cliente.getEnd(), linhaSelecionada, 3);
			modelo.setValueAt(cliente.getNumero(), linhaSelecionada, 4);
			modelo.setValueAt(cliente.getCidade(), linhaSelecionada, 5);
			modelo.setValueAt(cliente.getEstado(), linhaSelecionada, 6);
			
	       limparCampos();
			
		}

}
