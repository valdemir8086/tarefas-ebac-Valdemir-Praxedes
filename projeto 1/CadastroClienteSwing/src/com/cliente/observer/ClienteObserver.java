package com.cliente.observer;

import com.cliente.dto.ClienteDTO;

public interface ClienteObserver {
	
	public void updateRegistrar(ClienteDTO dto, boolean isSucesso);
	
	public void updateRemover(ClienteDTO dto,int linhaSelecionada, boolean isSucesso);
	
	public void updateSelecionar(ClienteDTO dto, int linhaSelecionada);
	
	public void updateAlterado(ClienteDTO dto, int linhaSelecionada);
}
