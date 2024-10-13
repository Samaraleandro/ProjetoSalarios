package com.samara.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.samara.util.Conexao;

public class SalarioCalculo {
	
	public void calcularSalarios() {
		String selectSQL = "SELECT p.id AS pessoa_id, " + "p.nome AS nome_pessoa, " + "c.nome AS nome_cargo, "
				+ "COALESCE(SUM(CASE WHEN v.tipo = 'CREDITO' THEN v.valor END), 0) - "
				+ "COALESCE(SUM(CASE WHEN v.tipo = 'DEBITO' THEN v.valor END), 0) AS salario " + "FROM pessoa p "
				+ "JOIN cargo c ON p.cargo_id = c.id " + "LEFT JOIN vencimentos v ON true " 																						
				+ "GROUP BY p.id, p.nome, c.nome";

		String insertSQL = "INSERT INTO pessoa_salario_consolidado (pessoa_id, nome_pessoa, nome_cargo, salario) "
				+ "VALUES (?, ?, ?, ?)";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
				PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
				ResultSet  rs = selectStmt.executeQuery()) {


			String deleteSQL = "DELETE FROM pessoa_salario_consolidado";
			try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {
				deleteStmt.executeUpdate();
			}

			while (rs.next()) {
				insertStmt.setInt(1, rs.getInt("pessoa_id"));
				insertStmt.setString(2, rs.getString("nome_pessoa"));
				insertStmt.setString(3, rs.getString("nome_cargo"));
				insertStmt.setBigDecimal(4, rs.getBigDecimal("salario"));
				insertStmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
