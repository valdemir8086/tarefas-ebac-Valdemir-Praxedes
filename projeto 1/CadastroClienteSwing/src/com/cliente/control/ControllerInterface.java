package com.cliente.control;

import com.cliente.dto.ClienteDTO;
import com.cliente.model.ClienteModel;

public interface ControllerInterface {
	
	
    public void cadastrar(ClienteDTO cliente);
    
    public void excluir(long cpf, int linhaSelecionada);
    
    public void alterar(ClienteDTO cliente, int linhaSelecionada);
    
    public void consultar(long cpf, int linhaSelecionada);
}
