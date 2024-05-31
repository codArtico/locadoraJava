package interfaces;

import java.util.Scanner;

import entities.Cliente;

public interface RegistrarAlugueis {
	public void devolverCarro(Cliente cliente);
	public void alugarCarro(Cliente cliente, Scanner sc);
}
