package Exercicio1;

public class Conta {
	
	String nome;
	String cpf;
	double saldo;
	
	public Conta(String cpf) {
		this.cpf = cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	
	public void depositarValor(double quantia){
		this.saldo = saldo + quantia;
	}
	
	public void sacarValor(double quantia){
		this.saldo = saldo - quantia;
	}
	
	public String imprimirRelatorio() {
		return 
				"[Nome do Correntista: " + this.nome + 
				" CPF:  " + this.cpf +
				" Saldo Atual: " + this.saldo + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		Conta cont = (Conta) obj;
		return this.cpf.equals(cont.cpf);
	}
	
	@Override
	public String toString() {
		String aux = "";
		aux += "CPF: " + cpf + "\n";
		aux += "Nome: " + nome + "\n";
		aux += "Saldo" + saldo + "\n";
		return aux;
 	}

}
