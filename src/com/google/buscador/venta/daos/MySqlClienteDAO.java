package com.google.buscador.venta.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.buscador.util.ConectaDB;
import com.google.buscador.venta.bean.ClienteBean;
import com.google.buscador.venta.bean.TipoBean;


public class MySqlClienteDAO implements ClienteDAO{

	private static final Log log = LogFactory.getLog(MySqlClienteDAO.class);
	
	
	@Override
	public int insertaCliente(ClienteBean obj) throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		int insertados = -1;
		try {
			String sql = "insert into tb_cliente values(null,?,?,?,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNomCliente());
			pstm.setString(2, obj.getApeCliente());
			pstm.setString(3, obj.getDniCliente());
			pstm.setString(4, obj.getFecNac());
			pstm.setInt(5, obj.getTipo().getIdTipo());
			log.info(pstm);
			insertados = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return insertados;
	}

	@Override
	public List<TipoBean> listaTipo() throws Exception {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<TipoBean> lista = new ArrayList<TipoBean>();
		try {
			String sql = "select * from tb_tipo";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			TipoBean bean = null;
			while(rs.next()){	
				bean = new TipoBean();
				bean.setIdTipo(rs.getInt(1));
				bean.setNomTipo(rs.getString(2));
				lista.add(bean);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}

	
	
}
