package com.cliente.dao;

import java.util.Map;
import java.util.TreeMap;

import com.cliente.dto.ClienteDTO;

public class ClienteMapDAO  implements IClienteDAO {
    private Map<Long, ClienteDTO> map;
    
    public ClienteMapDAO() {
        map = new TreeMap<>();
    }

    @Override
    public Boolean cadastrar(ClienteDTO cliente) {
        if (map.containsKey(cliente.getCpf())) {
            return false;
        }
        
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
    	ClienteDTO clienteCadastrado = map.get(cpf);
        map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
    }

    @Override
    public void alterar(ClienteDTO cliente) {
    	ClienteDTO clienteCadastrado = map.get(cliente.getCpf());
        clienteCadastrado.setNome(cliente.getNome());
        clienteCadastrado.setTel(cliente.getTel());
        clienteCadastrado.setNumero(cliente.getNumero());
        clienteCadastrado.setEnd(cliente.getEnd());
        clienteCadastrado.setCidade(cliente.getCidade());
        clienteCadastrado.setEstado(cliente.getEstado());
    }

    @Override
    public ClienteDTO consultar(Long cpf) {
        return this.map.get(cpf);
    }
}
