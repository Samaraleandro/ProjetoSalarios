package com.samara.model;

import java.math.BigDecimal;

public class PessoaSalario {
	private Pessoa pessoa;
	private Cargo cargo;
	private BigDecimal salario;

	public PessoaSalario() {
	}

	public PessoaSalario(Pessoa pessoa, Cargo cargo, BigDecimal salario) {
		this.pessoa = pessoa;
		this.cargo = cargo;
		this.salario = salario;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "PessoaSalario [pessoa=" + pessoa + ", cargo=" + cargo + ", salario=" + salario + "]";
	}
}
