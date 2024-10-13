package com.samara;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.samara.dao.CargoDAO;
import com.samara.dao.CargoVencimentoDAO;
import com.samara.dao.PessoaDAO;
import com.samara.dao.VencimentoDAO;
import com.samara.model.Cargo;
import com.samara.model.CargoVencimento;
import com.samara.model.Pessoa;
import com.samara.model.Vencimento;
import com.samara.util.Conexao;

public class Main {

	public static void main(String[] args) {
		try (Connection connection = Conexao.getConnection()) {
            PessoaDAO pessoaDAO = new PessoaDAO(connection);
            CargoDAO cargoDAO = new CargoDAO(connection);
            VencimentoDAO vencimentoDAO = new VencimentoDAO(connection);
            CargoVencimentoDAO cargoVencimentoDAO = new CargoVencimentoDAO(connection);

            List<Pessoa> pessoas = pessoaDAO.listarPessoas();
            List<Cargo> cargos = cargoDAO.listarTodos();
            List<Vencimento> vencimentos = vencimentoDAO.listarTodos();
            List<CargoVencimento> cargoVencimentos = cargoVencimentoDAO.listarTodos();
            
            System.out.println(pessoas);
            System.out.println(cargos);
            System.out.println(vencimentos);
            System.out.println(cargoVencimentos);
	} catch (SQLException e) {
        e.printStackTrace();
    }
	}

}
