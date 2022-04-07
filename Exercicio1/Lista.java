package Exercicio1;
public class Lista<T> {
	No<T> inicio;
	No<T> fim;
	int total;
	
	// método para inserir um elemento na lista
	public void inserir(T dado) {
		No<T> aux = new No<T>(dado);
		if(total == 0) {
			inicio = aux;
		} else {
			aux.esq = fim;
			fim.dir = aux;
		}
		fim = aux;
		total++;
	}

	// método para pesquisar um elemento e retornar o endereço de memória
	public No<T> pesquisar(T dado) {
		No<T> aux = inicio;
		boolean achou = false;
		while(aux != null && achou == false) {
			if(aux.dado.equals(dado)) {
				achou = true;
				break;
			}
			aux = aux.dir;
		}
		return aux;
	}
	
	// método para remover um elemento da lista
	public boolean remover(T dado) {
		No<T> aux = pesquisar(dado);
		if(aux != null) {
			if (total == 1) { // caso tenha um único elemento
				inicio = null;
				fim = null;
			} else if (aux.equals(inicio)) {
				aux.dir.esq = null;
				inicio = aux.dir;
				aux.dir = null;
			} else if (aux.equals(fim)) {
				aux.esq.dir = null;
				fim = aux.esq;
				aux.esq = null;
			} else {
				aux.esq.dir = aux.dir;
				aux.dir.esq = aux.esq;
				aux.dir = null;
				aux.esq = null;
			}
			total--;
			return true;
		} else {
			return false;
		}
	}
}