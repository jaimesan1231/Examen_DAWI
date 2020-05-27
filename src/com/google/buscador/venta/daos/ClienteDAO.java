package com.google.buscador.venta.daos;

import java.util.List;

import com.google.buscador.venta.bean.ClienteBean;
import com.google.buscador.venta.bean.TipoBean;

public interface ClienteDAO {
	public int insertaCliente(ClienteBean obj) throws Exception;
	public List<TipoBean> listaTipo() throws Exception;
}
