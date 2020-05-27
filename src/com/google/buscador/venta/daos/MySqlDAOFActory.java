package com.google.buscador.venta.daos;


public class MySqlDAOFActory extends DAOFactory {

	@Override
	public ClienteDAO getCliente() {
		return new MySqlClienteDAO();
	}
	
}
