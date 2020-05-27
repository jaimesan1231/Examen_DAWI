package com.google.buscador.venta.service;

import java.util.List;

import com.google.buscador.venta.bean.ClienteBean;
import com.google.buscador.venta.bean.TipoBean;

public interface ClienteService {

	public int insertaCliente(ClienteBean obj) throws Exception;
	
	public List<TipoBean> listaTipo() throws Exception;
	
	
}
