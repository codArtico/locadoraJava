package locadoraJava;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public abstract class Aluguel {
	protected Data dataIni;
	protected Data dataFim;
	protected double diaria;
	
	Aluguel(double diaria){
		this.diaria = diaria;
	}
	
	
	public Data getDataIni() {
		return dataIni;
	}

	public void setDataIni(Data dataIni) {
		this.dataIni = dataIni;
	}

	public Data getDataFim() {
		return dataFim;
	}

	public void setDataFim(Data dataFim) {
		this.dataFim = dataFim;
	}

	public double getDiaria() {
		return diaria;
	}

	public void setDiaria(double diaria) {
		this.diaria = diaria;
	}


	private static Scanner sc = new Scanner(System.in);
	
	public static Data coletarData() {
		System.out.print("Digite a data no formato dd/mm/aaaa: ");
		String dataInput = sc.nextLine();
		
		String[] partesData = dataInput.split("/");

        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);
        int ano = Integer.parseInt(partesData[2]);
        
        Data data = new Data(dia,mes,ano);
        return data;
	}
	
	public long calcularDias () {
		long diferencaEmDias = ChronoUnit.DAYS.between(dataIni.getData(), dataFim.getData());
		return diferencaEmDias;
	}
	
	public double calcularAluguel() {
		double valorAluguel = calcularDias() * diaria;
		return valorAluguel;
	}
		
}
