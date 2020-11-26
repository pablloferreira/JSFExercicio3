package br.edu.faculdadedelta.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.faculdadedelta.dao.ControleDAOPabllo;
import br.edu.faculdadedelta.modelo.ControlePabllo;


@ManagedBean
@SessionScoped
public class ControleControllerPabllo {

	private ControlePabllo cont = new ControlePabllo();
	private ControleDAOPabllo dao = new ControleDAOPabllo();
	
	private Date dateInicio;
	private Date dateFinal;

	public ControlePabllo getCont() {
		return cont;
	}

	public void setCont(ControlePabllo cont) {
		this.cont = cont;
	}

	public ControleDAOPabllo getDao() {
		return dao;
	}

	public void setDao(ControleDAOPabllo dao) {
		this.dao = dao;
	}
	
	public Date getDateInicio() {
		return dateInicio;
	}

	public void setDateInicio(Date dateInicio) {
		this.dateInicio = dateInicio;
	}

	public Date getDateFinal() {
		return dateFinal;
	}

	public void setDateFinal(Date dateFinal) {
		this.dateFinal = dateFinal;
	}

	private static final String PAGINA_CADASTRO = "cadastroProcedimento.xhtml"; 
	private static final String PAGINA_LISTA = "listaProcedimento.xhtml";
	
	
	public ControlePabllo getControlePabllo() {
		return cont;
	}
	
	public void setControlePabllo(ControlePabllo cont) {
		this.cont = cont;
	}
	
	
	public void limparCampos() {
		cont = new ControlePabllo();
	}
	
	private void exibirMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public String salvar() {
		try {
			if (cont.getDateInicio().after(new Date())) {
				if (cont.getId()==null) {
					dao.incluir(cont);
					exibirMensagem("Inclusão realizada com Sucesso!");
					limparCampos();
				} else {
					dao.alterar(cont);
					exibirMensagem("Alteração realizada com Sucesso!");
				}
			} else {
				exibirMensagem("A Data ser maior que a tada atual e o limite é 01/01/2020!");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			exibirMensagem("Erro ao realizar a operação. Tente novamente mais tarde. " + e.getMessage());
			e.printStackTrace();
		}
		return PAGINA_CADASTRO;
	}
	
	public String editar() {
		return PAGINA_CADASTRO;
	}
	
	public String excluir() {
		try {
			dao.excluir(cont);
			exibirMensagem("Exclusão realizada com sucesso!");
			limparCampos();
		} catch (ClassNotFoundException | SQLException e) {
			exibirMensagem("Erro ao realizar a operação. Tente novamente mais tarde. " + e.getMessage());
			e.printStackTrace();
		}
		return PAGINA_LISTA;
	}
	
	public List<ControlePabllo> getLista() {
        List<ControlePabllo> listaRetorno = new ArrayList<ControlePabllo>();
        try {
            listaRetorno = ControleDAOPabllo.listar();
        } catch (ClassNotFoundException | SQLException e) {
            exibirMensagem("Erro ao realizar a operação. "
                    + "Tente novamente mais tarde. " + e.getMessage());
            e.printStackTrace();
        }
        return listaRetorno;
    }
	
}