package com.samara.controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.samara.model.Cargo;
import com.samara.model.Pessoa;
import com.samara.model.PessoaSalario;
import com.samara.service.SalarioCalculo;
import com.samara.util.Conexao;

public class SalarioConsolidadoBean implements Serializable {
	private List<PessoaSalario> listaPessoasSalarios;
	
    public void calcularSalarios() {
        SalarioCalculo salarioCalculo = new SalarioCalculo();
        salarioCalculo.calcularSalarios();
        carregarSalarios();
    }

    public void carregarSalarios() {
    	listaPessoasSalarios = new ArrayList<>();
        String query = "SELECT pessoa_id, nome_pessoa, nome_cargo, salario FROM pessoa_salario_consolidado";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
            	Pessoa pessoa = new Pessoa();
            	Cargo cargo = new Cargo();
                PessoaSalario pessoaSalario = new PessoaSalario();
                pessoa.setId(rs.getInt("pessoa_id"));
                pessoa.setNome(rs.getString("nome_pessoa"));
                
                cargo.setNome(rs.getString("nome_cargo"));
                
                pessoaSalario.setSalario(rs.getBigDecimal("salario"));
                listaPessoasSalarios.add(pessoaSalario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<PessoaSalario> getListaSalarios() {
        return listaPessoasSalarios;
    }
}
