package locadoraJava;

import java.util.Scanner;

public interface RegistrarAlugueis {
	public void devolverCarro(Cliente cliente);
	public void alugarCarro(Cliente cliente, Scanner sc);
}
