package com.google.buscador.venta.bean;

import lombok.Data;

@Data

public class ClienteBean {
	private int idCliente;
	private String nomCliente,apeCliente,dniCliente,fecNac;
	private TipoBean tipo;
	
	
}
