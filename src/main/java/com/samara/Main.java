package com.samara;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.samara.dao.PessoaDAO;
import com.samara.model.Pessoa;
import com.samara.util.Conexao;

public class Main {

	public static void main(String[] args) {
		try (Connection connection = Conexao.getConnection()) {
            PessoaDAO pessoaDAO = new PessoaDAO(connection);

            List<Pessoa> pessoas = pessoaDAO.listarPessoas();
            for (Pessoa pessoa : pessoas) {
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("Cidade: " + pessoa.getCidade());
                System.out.println("Cidade: " + pessoa.getCep());
            }
	} catch (SQLException e) {
        e.printStackTrace();
    }
	}

}
