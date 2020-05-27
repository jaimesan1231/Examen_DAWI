package com.google.buscador.venta.service;

import java.util.List;

import com.google.buscador.venta.bean.ClienteBean;
import com.google.buscador.venta.bean.TipoBean;
import com.google.buscador.venta.daos.ClienteDAO;
import com.google.buscador.venta.daos.DAOFactory;

public class ClienteServiceImpl implements ClienteService{

	DAOFactory fabrica = DAOFactory.getFactorty(DAOFactory.MYSQL);
	ClienteDAO dao = fabrica.getCliente();
	
	@Override
	public int insertaCliente(ClienteBean obj) throws Exception {
		return dao.insertaCliente(obj);
	}

	@Override
	public List<TipoBean> listaTipo() throws Exception {
		return dao.listaTipo();
	}

	
}
