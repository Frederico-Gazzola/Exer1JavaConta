package Exercicio1;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Processo {
	
	private static Lista<Conta> con = new Lista<Conta>();
	
	public static String screen() {
		String aux = "Escolha uma opção:\n";
		aux += "1. Abrir conta\n";
		aux += "2. Realizar saque\n";
		aux += "3. Realizar depósito\n";
		aux += "4. Relatório de contas\n";
		aux += "5. Encerrar conta\n";
		aux += "6. Encerrar aplicativo\n";
		return aux;
		
	}
	
	
	public static void cadastrar() {

		String nome, cpf;
		Double saldo;
		
		nome = showInputDialog("Insira o seu nome: ");
		cpf = showInputDialog("Insira o seu CPF: ");
		saldo = Double.parseDouble(showInputDialog("Insira o saldo inicial (Pode ser 0):"));
		
		Conta conta = new Conta(cpf);
		
		if (con.pesquisar(conta) == null){
			conta.setNome(nome);
			conta.setSaldo(saldo);
			con.inserir(conta);
			showMessageDialog(null, "Está conta agora está cadastrada.");
		}else {
			
			showMessageDialog(null, "Houve um erro devido a este CPF já existir em outra conta.");
		}

	}
	
public static void relatorio() {
		
		No<Conta> x = con.inicio;
		String relat = "";

		while(x != null){
			relat = relat + x.dado.imprimirRelatorio() ;
			x = x.dir;
		
		} 
		showMessageDialog(null, relat);

	}


public static void excluir() {
	
	String cpf;
	boolean check;

	cpf = showInputDialog("Cpf");
	Conta conta = new Conta(cpf);
	
	check = con.remover(conta);

	if(check) {
		showMessageDialog(null, "A conta foi removida.");

	} else {

		showMessageDialog(null, "A Conta inserida não existe.");
	}
	 
}

	public static void saque() {
		
		double saldo;
		String cpf;
		

		cpf = showInputDialog("Informe o CPF:");
		Conta conta = new Conta(cpf);
		
		No<Conta> quantia = con.pesquisar(conta);
		
		if (quantia == null){
			showMessageDialog(null, "A Conta inserida não existe.");
		}else {
			saldo = Double.parseDouble(showInputDialog("Inserir a quantia do saque:"));
			if (saldo <= quantia.dado.getSaldo()){
				quantia.dado.sacarValor(saldo);
				showMessageDialog(null, "Saque executado.");
				
			} else {
				showMessageDialog(null, "Este saque é invalido.");
			}
		}

	}

	public static void deposito() {
		
		String cpf;
		double saldo;

		cpf = showInputDialog("Informe o Cpf");
		Conta conta = new Conta(cpf);
		
		No<Conta> quantia  = con.pesquisar(conta);
		
		if (quantia == null){
			showMessageDialog(null, "A Conta inserida não existe");
			
		}else {
			saldo = Double.parseDouble(showInputDialog("Inserir a quantia do depósito:"));
			if (saldo > 0){
				quantia.dado.depositarValor(saldo);
				showMessageDialog(null, "Depósito executado.");
				
			} else {
				showMessageDialog(null, "Este depósito é inválido");
			}
		}

	}


	

	
	

}
