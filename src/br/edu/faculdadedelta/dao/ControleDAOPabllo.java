package br.edu.faculdadedelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadedelta.modelo.ControlePabllo;
import br.edu.faculdadedelta.util.ConexaoPabllo;

public class ControleDAOPabllo {
	
	public void incluir(ControlePabllo controle) throws ClassNotFoundException, SQLException {
		Connection conn = ConexaoPabllo.conectarNoBanco();
		String sql = "INSERT INTO public.procedimentos("
				+ "paciente_desc, procedimento_desc, valor_procedimento, data_inicio_procedimento, "
				+ "data_fim_procedimento, quantidade_exame_procedimento) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, controle.getPaciente().trim());
		ps.setString(2, controle.getDescricao().trim());
		ps.setDouble(3, controle.getValorProced());
		ps.setDate(4, new java.sql.Date(controle.getDateInicio().getTime()));
		ps.setDate(5, new java.sql.Date(controle.getDateFinal().getTime()));
	    ps.setInt(6, controle.getQtExames());
	   
	    ps.executeUpdate();
	    
	    ConexaoPabllo.fecharConexao(ps, conn, null);
	}
	
	public void alterar(ControlePabllo controle) throws ClassNotFoundException, SQLException {
		Connection conn = ConexaoPabllo.conectarNoBanco();
		String sql = "UPDATE public.procedimentos\n" + 
				"	SET paciente_desc=?, procedimento_desc=?, valor_procedimento=?, "
			+   " data_inicio_procedimento=?, data_fim_procedimento=?, quantidade_exame_procedimento=?\n" 
			+	"	WHERE id_procedimento=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, controle.getPaciente().trim());
		ps.setString(2, controle.getDescricao().trim());
		ps.setDouble(3, controle.getValorProced());
		ps.setDate(4, new java.sql.Date(controle.getDateInicio().getTime()));
		ps.setDate(5, new java.sql.Date(controle.getDateFinal().getTime()));
	    ps.setInt(6, controle.getQtExames());
	    ps.setLong(7, controle.getId());
	    
	    ps.executeUpdate();
	    
	    ConexaoPabllo.fecharConexao(ps, conn, null);
	}
	
	public void excluir(ControlePabllo controle) throws ClassNotFoundException, SQLException {
		Connection conn = ConexaoPabllo.conectarNoBanco();
		String sql = "DELETE FROM procedimentos WHERE id_procedimento = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setLong(1, controle.getId());
	    
	    ps.executeUpdate();
	    
	    ConexaoPabllo.fecharConexao(ps, conn, null);
	}
	
	public static List<ControlePabllo> listar() throws ClassNotFoundException, SQLException {
		Connection conn = ConexaoPabllo.conectarNoBanco();
		String sql = "SELECT id_procedimento, paciente_desc, procedimento_desc, valor_procedimento, "
				+ " data_inicio_procedimento, data_fim_procedimento, quantidade_exame_procedimento\n"  
				+ "	FROM public.procedimentos";
		PreparedStatement ps = conn.prepareStatement(sql);
		List<ControlePabllo> listaRetorno = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ControlePabllo controle = new ControlePabllo();
			controle.setId(rs.getLong("id_procedimento"));
			controle.setPaciente(rs.getString("paciente_desc").trim());
			controle.setDescricao(rs.getString("procedimento_desc").trim());
			controle.setValorProced(rs.getDouble("valor_procedimento"));
			controle.setDateInicio(rs.getDate("data_inicio_procedimento"));
			controle.setDateFinal(rs.getDate("data_fim_procedimento"));
			controle.setQtExames(rs.getInt("quantidade_exame_procedimento"));
			
			listaRetorno.add(controle);
		}
		ConexaoPabllo.fecharConexao(ps, conn, rs);
		return listaRetorno;
	}
	
}