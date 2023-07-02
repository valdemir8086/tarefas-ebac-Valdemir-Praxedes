package com.cliente.dao;

import com.cliente.dto.ClienteDTO;
import com.cliente.model.ClienteModel;

public interface IClienteDAO {
	
    public Boolean cadastrar(ClienteDTO cliente);
    
    public void excluir(Long cpf);
    
    public void alterar(ClienteDTO cliente);
    
    public ClienteDTO consultar(Long cpf);
}
