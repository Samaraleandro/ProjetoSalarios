package com.samara.controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.samara.dao.PessoaDAO;
import com.samara.model.Pessoa;
import com.samara.util.Conexao;

public class SalarioConsolidadoBean implements Serializable {
	private List<Pessoa> listaPessoas;

	public void init() {
		try (Connection connection = Conexao.getConnection()) {
			PessoaDAO pessoaDAO = new PessoaDAO(connection);
			this.listaPessoas = pessoaDAO.listarPessoas();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
}
