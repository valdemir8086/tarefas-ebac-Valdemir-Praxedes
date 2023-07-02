package com.cliente.model;

import com.cliente.dao.ClienteMapDAO;
import com.cliente.dao.IClienteDAO;
import com.cliente.dto.ClienteDTO;
import com.cliente.observer.ClienteObserver;

public class ClienteModel {
	    
    private ClienteObserver clienteObserver;
	private IClienteDAO dao;

    public ClienteModel(ClienteObserver clienteObserver) {
    	this.clienteObserver = clienteObserver;
    	dao = new ClienteMapDAO();
    }
    
    public void registrar(ClienteDTO dto) {
    	
    	Boolean isSucesso = dao.cadastrar(dto);
    	clienteObserver.updateRegistrar(dto, isSucesso);
    }
    
    
    public void remover(long cpf, int linhaSelecionada) {
    	
    	ClienteDTO cliente = dao.consultar(cpf);
    	dao.excluir(cpf);
    	clienteObserver.updateRemover(cliente, linhaSelecionada, true);
    }
    
    public void selecionar(long cpf, int linhaSelecionada) {
    	ClienteDTO cliente = dao.consultar(cpf);
    	clienteObserver.updateSelecionar(cliente, linhaSelecionada);
    }
    
    public void alterar(ClienteDTO dto, int linhaSelecionada) {
    	dao.alterar(dto);
    	clienteObserver.updateAlterado(dto, linhaSelecionada);
    }

}
