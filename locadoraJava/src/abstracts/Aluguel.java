package abstracts;
import java.util.Scanner;

import util.Data;

import java.time.temporal.ChronoUnit;

public abstract class Aluguel {
	protected Data dataIni;
	protected Data dataDev;
	protected Data dataFim;
	protected double diaria;
	
	public Aluguel(double diaria){
		this.diaria = diaria;
	}
	
	
	public Data getDataDev() {
		return dataDev;
	}


	public void setDataDev(Data dataDev) {
		this.dataDev = dataDev;
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
		long diferencaEmDias = Math.abs(ChronoUnit.DAYS.between(dataIni.getData(), dataFim.getData()));
		return diferencaEmDias;
	}
	
	public long calcularDiasAtraso () {
		long diferencaEmDias = Math.abs(ChronoUnit.DAYS.between(dataFim.getData(), dataDev.getData()));
		return diferencaEmDias;
	}
	
	public double calcularTaxaAtraso() {
		long diasAtraso = calcularDiasAtraso();
		double taxaAtraso = 0;
		
		if (diasAtraso>0) {
			taxaAtraso = (diasAtraso*(diaria*3));
		}
		
		return taxaAtraso;
	}
	
	public double calcularAluguel() {
		
		double valorAluguel = (diaria + (calcularDias() * diaria)+calcularTaxaAtraso());
		return valorAluguel;
	}

}
