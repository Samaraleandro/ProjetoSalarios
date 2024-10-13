package com.samara.model;

public class CargoVencimento {
    private Integer id;
    private Cargo cargo;         
    private Vencimento vencimento; 

    public CargoVencimento() {}

    public CargoVencimento(Integer id, Cargo cargo, Vencimento vencimento) {
        this.id = id;
        this.cargo = cargo;
        this.vencimento = vencimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Vencimento getVencimento() {
        return vencimento;
    }

    public void setVencimento(Vencimento vencimento) {
        this.vencimento = vencimento;
    }

	@Override
	public String toString() {
		return "CargoVencimento [id=" + id + ", cargo=" + cargo + ", vencimento=" + vencimento + "]";
	}
}
