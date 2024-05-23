package locadoraJava;
import java.util.Scanner;

public class Garagem implements RegistrarAlugueis{
	private Carro[] carros;
	
	public Garagem(Carro[] carros) {
		super();
		this.carros = carros;
	}

	public Carro[] getCarros() {
		return carros;
	}

	public void setCarros(Carro[] carros) {
		this.carros = carros;
	}
	
	public void criarVetorCarros() {
		carros [0] = new Carro ("Chevrolet", "Onix", "2024", "Vermelho", "gasolina", true,210);
		carros [1] = new Carro ("Volkswagen", "Polo Track", "2024", "Preto", "gasolina", true,200);
		carros [2] = new Carro ("Citroen", "C3", "2024", "Branco", "gasolina", true,300);
		carros [3] = new Carro ("Hyundai", "HB20", "2024", "Prata", "gasolina", true,350);
		carros [4] = new Carro ("Renault", "Stepway", "2024", "Chumbo", "gasolina", true,50);
		carros [5] = new Carro ("Fiat", "Argo", "2024", "Azul - Marinho", "gasolina", true,100);
		carros [6] = new Carro ("Peugeot", "208", "2024", "Vermelho", "gasolina", true,150);
		carros [7] = new Carro ("Fiat", "Cronos", "2024", "Prata", "gasolina", true,200);
		carros [8] = new Carro ("Seres", "3", "2024", "Vermelho", "eletrico", true,450);
		carros [9] = new Carro ("Fiat", "MOBI", "2024", "Vermelho", "gasolina", true,100);
		
	}
	
	@Override
	public void alugarCarro(Cliente cliente, Scanner sc) {
		System.out.println("Carros disponíveis para aluguel:");
	    mostrarCarros();

	    
	    System.out.print("Digite a marca do carro desejado:");
	    String marca = sc.nextLine();
	    boolean marcaExiste = false;
	    
	    System.out.println("Carros disponiveis dessa marca: \n\n");
	    for (Carro i : carros) {
	    	if(i.isDisponivel() && i.getMarca().equalsIgnoreCase(marca)) {
	    		marcaExiste = true;
	    		i.mostrarDados();
	    	}
	    }
	    if (marcaExiste) {
	    System.out.print("Digite o modelo do carro desejado:");
	    String modelo = sc.nextLine();

	    
	    boolean carroEncontrado = false;
	    for (Carro carro : carros) {
	        if (carro.isDisponivel() && carro.getMarca().equalsIgnoreCase(marca) && carro.getModelo().equalsIgnoreCase(modelo) && !cliente.isPossuiAluguel()) {
	            carro.setDisponivel(false);
	            carroEncontrado = true;
	            cliente.setCarroAlugado(carro);
	            cliente.setPossuiAluguel(true);
	            carro.setDataIni(Carro.coletarData());
	            System.out.println("Carro alugado com sucesso para  " + cliente.getNome() + "\n");
	        }
	    }

	    if (!carroEncontrado) {
	        System.out.println("Modelo não disponível na garagem. \n");
	    }
	    
	    }
	    
	    else {
	    	System.out.println("Não temos carros disponiveis dessa marca! \n");
	    }

	}
		
	@Override
	public void devolverCarro(Cliente cliente) {
		if (cliente.isPossuiAluguel()) {
		for (Carro carro : carros) {
			if (cliente.getCarroAlugado().equals(carro)) {
				carro.setDisponivel(true);
				carro.setDataFim(Carro.coletarData());
				
			}
			
		}
		cliente.gerarFatura();
		cliente.setCarroAlugado(null);
		cliente.setPossuiAluguel(false);

		}
 }
	
	public void mostrarCarros() {
		System.out.println("");
		int i = 0;
		
		while(i<carros.length) {
			if (carros[i].isDisponivel()) {
			carros[i].mostrarDados();
			}
			i++;
		}
	}
}
