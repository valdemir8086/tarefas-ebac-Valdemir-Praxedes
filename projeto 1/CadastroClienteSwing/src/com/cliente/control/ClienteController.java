package com.cliente.control;

import com.cliente.dao.ClienteMapDAO;
import com.cliente.dao.IClienteDAO;
import com.cliente.dto.ClienteDTO;
import com.cliente.model.ClienteModel;
import com.cliente.view.ClienteView;

public class ClienteController implements ControllerInterface {

	
	private ClienteModel clienteModel;
	private ClienteView clienteView;
	
	public ClienteController() {
		super();
		clienteView = new ClienteView(this);
		this.clienteModel = new ClienteModel(clienteView);		
		
	    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	clienteView.setVisible(true);
            }
        });
	    
	    
	}

	@Override
	public void cadastrar(ClienteDTO cliente) {
		clienteModel.registrar(cliente);
	}

	@Override
	public void excluir(long cpf, int linhaSelecionada) {
		clienteModel.remover(cpf, linhaSelecionada);
		
	}

	@Override
	public void alterar(ClienteDTO cliente, int linhaSelecionada) {
		clienteModel.alterar(cliente, linhaSelecionada);
	}

	@Override
	public void consultar(long cpf, int linhaSelecionada) {
		clienteModel.selecionar(cpf, linhaSelecionada);
	}

}
