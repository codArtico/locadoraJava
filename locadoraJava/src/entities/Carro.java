package entities;

import abstracts.Aluguel;

public class Carro extends Aluguel{
	private String marca;
	private String modelo;
	private String ano;
	private String cor;
	private String tipoCombustivel;
	private boolean disponivel;
	
	public Carro(String marca, String modelo, String ano, String cor, String tipoCombustivel, boolean disponivel, double diaria) {
		super (diaria);
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.tipoCombustivel = tipoCombustivel;
		this.disponivel = disponivel;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public void mostrarDados() {
		System.out.println("Marca: " + marca + "\nModelo: " + modelo + "\nAno: " + ano + "\nCor: " + cor + "\nTipo de Combustivel: " + tipoCombustivel + "\nValor da Diária: " + diaria + "\n");
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
}
