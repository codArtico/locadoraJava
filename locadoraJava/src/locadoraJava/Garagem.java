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
		carros [0] = new Carro ("Chevrolet", "Onix", "2024", "Vermelho", 100, "gasolina", true);
		carros [1] = new Carro ("Volkswagen", "Polo Track", "2024", "Preto", 100, "gasolina", true);
		carros [2] = new Carro ("Citroen", "C3", "2024", "Branco", 100, "gasolina", true);
		carros [3] = new Carro ("Hyundai", "HB20", "2024", "Prata", 100, "gasolina", true);
		carros [4] = new Carro ("Renault", "Stepway", "2024", "Chumbo", 100, "gasolina", true);
		carros [5] = new Carro ("Fiat", "Argo", "2024", "Azul - Marinho", 100, "gasolina", true);
		carros [6] = new Carro ("Peugeot", "208", "2024", "Vermelho", 100, "gasolina", true);
		carros [7] = new Carro ("Fiat", "Cronos", "2024", "Prata", 100, "gasolina", true);
		carros [8] = new Carro ("Seres", "3", "2024", "Vermelho", 100, "eletrico", true);
		carros [9] = new Carro ("Fiat", "MOBI", "2024", "Vermelho", 100, "gasolina", true);
		
	}
	
	@Override
	public void alugarCarro(Cliente cliente, Scanner sc) {
		System.out.println("Pressione enter para continuar: ");
		sc.nextLine();
		System.out.println("Carros disponíveis para aluguel:");
	    mostrarCarros();

	    
	    System.out.println("Digite a marca do carro desejado:");
	    String marca = sc.nextLine();
	    System.out.println("Digite o modelo do carro desejado:");
	    String modelo = sc.nextLine();

	    
	    boolean carroEncontrado = false;
	    for (Carro carro : carros) {
	        if (carro.isDisponivel() && carro.getMarca().equalsIgnoreCase(marca) && carro.getModelo().equalsIgnoreCase(modelo)) {
	            carro.setDisponivel(false);
	            System.out.println("Carro alugado com sucesso para o cliente " + cliente.getNome());
	            carroEncontrado = true;
	            cliente.setCarroAlugado(carro);
	            cliente.setPossuiAluguel(true);
	        }
	    }

	    if (!carroEncontrado) {
	        System.out.println("Carro não disponível na garagem.");
	    }

	}
		
	@Override
	public void devolverCarro(Cliente cliente) {
		if (cliente.isPossuiAluguel()) {
		for (Carro carro : carros) {
			if (cliente.getCarroAlugado().equals(carro)) {
				carro.setDisponivel(true);
				cliente.setCarroAlugado(null);
				cliente.setPossuiAluguel(false);
			}
		}
		}
 }

	
	public void mostrarCarros() {
		int i = 0;
		
		while(i<carros.length) {
			if (carros[i].isDisponivel()) {
			carros[i].mostrarDados();
			}
			i++;
		}
	}
}
