package com.samara.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.samara.model.Cargo;
import com.samara.model.CargoVencimento;
import com.samara.model.Vencimento;

public class CargoVencimentoDAO {
    private Connection connection;

    public CargoVencimentoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<CargoVencimento> listarTodos() throws SQLException {
        String sql = "SELECT * FROM cargo_vencimentos";
        List<CargoVencimento> cargoVencimentos = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CargoVencimento cargoVencimento = new CargoVencimento();
                cargoVencimento.setId(rs.getInt("id"));

                Cargo cargo = new Cargo();
                cargo.setId(rs.getInt("cargo_id"));
                cargoVencimento.setCargo(cargo);

                Vencimento vencimento = new Vencimento();
                vencimento.setId(rs.getInt("vencimento_id"));
                cargoVencimento.setVencimento(vencimento);

                cargoVencimentos.add(cargoVencimento);
            }
        }

        return cargoVencimentos;
    }
    
    public CargoVencimento buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM cargo_vencimentos WHERE id = ?";
        CargoVencimento cargoVencimento = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cargoVencimento = new CargoVencimento();
                cargoVencimento.setId(rs.getInt("id"));

                Cargo cargo = new Cargo();
                cargo.setId(rs.getInt("cargo_id"));
                cargoVencimento.setCargo(cargo);

                Vencimento vencimento = new Vencimento();
                vencimento.setId(rs.getInt("vencimento_id"));
                cargoVencimento.setVencimento(vencimento);
            }
        }

        return cargoVencimento;
    }
}
