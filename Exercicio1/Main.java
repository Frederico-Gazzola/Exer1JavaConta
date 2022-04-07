package Exercicio1;

import javax.swing.JOptionPane;

public class Main {
	

	public static void main(String[] args) {
		int escolha;
		
		do {
			escolha = Integer.parseInt(JOptionPane.showInputDialog(Processo.screen()));
			if (escolha < 1 || escolha > 6) {
				JOptionPane.showMessageDialog(null, "Opção inválida");
			} else {
				switch (escolha) {
				case 1:
					Processo.cadastrar();
					break;
				case 2:
					Processo.saque();;
					break;
				case 3:
					Processo.deposito();;
					break;
				case 4:
					Processo.relatorio();;
					break;
				case 5:
					Processo.excluir();
				}
			}
			
		} while (escolha != 6);
		

	}
	
		
		

	}
