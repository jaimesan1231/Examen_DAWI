package com.google.buscador.venta.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.google.buscador.venta.bean.ClienteBean;
import com.google.buscador.venta.bean.TipoBean;
import com.google.buscador.venta.service.ClienteServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

@ParentPackage("dawi")
public class ClienteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private List<TipoBean> lstTipo;
	@Getter @Setter
	private ClienteBean cliente;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	
	@Action(value = "/cargaTipo", results = { @Result(name = "salida", type = "json") })
	public String metodo01() {
		ClienteServiceImpl service = new ClienteServiceImpl();
		try {
			lstTipo = service.listaTipo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "salida";
	}

	@Action(value = "/registraCliente", results = {@Result(name = "salida", location = "/registraCliente.jsp", type = "redirect") })
	public String metodo02() {
		ClienteServiceImpl service = new ClienteServiceImpl();
		try {
			int s = service.insertaCliente(cliente);
			if (s > 0) {
				session.put("MENSAJE", "Registro exitoso");
			} else {
				session.put("MENSAJE", "Registro erróneo");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.put("MENSAJE", "Registro erróneo");
		}

		return "salida";
	}
}
