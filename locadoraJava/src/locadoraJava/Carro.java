package locadoraJava;

public class Carro extends Aluguel{
	private String marca;
	private String modelo;
	private String ano;
	private String cor;
	private double quantCombustivel;
	private String tipoCombustivel;
	private boolean disponivel;
	
	public Carro(String marca, String modelo, String ano, String cor, double quantCombustivel, String tipoCombustivel, boolean disponivel, double diaria) {
		super (diaria);
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.setQuantCombustivel(quantCombustivel);
		this.tipoCombustivel = tipoCombustivel;
		this.setDisponivel(disponivel);
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
		System.out.println("Marca: " + marca + "\nModelo: " + modelo + "\nAno: " + ano + "\nCor: " + cor + "\nQuantidade de Combustivel: "
				+ quantCombustivel + "\nTipo de Combustivel: " + tipoCombustivel + "\nEstá disponivel para aluguel?: " + disponivel + "\n");
	}

	public double getQuantCombustivel() {
		return quantCombustivel;
	}

	public void setQuantCombustivel(double quantCombustivel) {
		this.quantCombustivel = quantCombustivel;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
}
