package locadoraJava;

import java.util.Scanner;

public class Cliente implements Login {
	protected String nome;
	protected String cpf;
	protected String endereco;
	protected String telefone;
	protected boolean possuiAluguel;
	protected Carro carroAlugado;
	protected String email;
	protected String senha;
	protected boolean logado = false;
	
	
	public Cliente(String nome, String cpf, String endereco, String telefone, String email, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.possuiAluguel = false;
		this.email = email;
		this.senha = senha;
	}
	
	public static Scanner sc = new Scanner (System.in);
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Carro getCarroAlugado() {
		return carroAlugado;
	}

	public void setCarroAlugado(Carro carroAlugado) {
		this.carroAlugado = carroAlugado;
	}

	public boolean isPossuiAluguel() {
		return possuiAluguel;
	}

	public void setPossuiAluguel(boolean possuiAluguel) {
		this.possuiAluguel = possuiAluguel;
	}

	public void mostrarDados() {
		String possuiCarro = "";
		
		if (possuiAluguel) {
			possuiCarro = "Sim!";
		}
		else {
			possuiCarro = "Não!";
		}
		
		System.out.println("Nome: " + this.nome + "\nCpf: " + cpf + "\nEndereco: " + endereco + "\nTelefone: " + telefone + "\nPossui Carro Alugado?: "
				+ possuiCarro + "\n");
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	
	public static Cliente logar(Cliente[] vetorClientes, int contClientes) {
		sc.nextLine();
		System.out.println("Digite seu email: ");
		String email = sc.nextLine();
		boolean encontrado = false;
		for (int i = 0; i<contClientes; i++) {
			if (email.equals(vetorClientes[i].getEmail())) {
				encontrado = true;
				System.out.println("Digite sua senha");
				String senha = sc.nextLine();
				if (senha.equals(vetorClientes[i].getSenha())) {
					vetorClientes[i].setLogado(true);
					return vetorClientes[i];
				}
				else {
					System.out.println("Senha incorreta.");
				}
			}
		}
		if(!encontrado) {
			System.out.println("Email não encontrado");
		}
		return null;
	}
	
	public void alterarSenha () {
		sc.nextLine();
		System.out.print("Digite a senha antiga: ");
		String senha = sc.nextLine();
		if (this.senha.equals(senha)) {
			System.out.println("Digite a nova senha: ");
			String nova = sc.nextLine();
			if(nova!=senha) {
				setSenha(nova);
			}
			else {
				System.out.println("Sua nova senha não pode ser igual a antiga!");
			}
		}
		else {
			System.out.println("Senha incorreta.");
		}
	}

	@Override
	public boolean deslogar() {
		this.logado = false;
		return false;
	}
	}
