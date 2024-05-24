package locadoraJava;
import java.time.LocalDate;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	private LocalDate data;
	
	public Data (int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.data = LocalDate.of(ano, mes, dia);
	}
	
	public int getDia() {
		return dia;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
}
