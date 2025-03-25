package model.estrutura;

public class No <T> {
	
	private T valor; //valor é variavel e T é objeto
	private No<T> proximo; //No é objeto e proximo é variavel
	
	public No(T valor) {
		this.proximo = null;
		this.valor = valor;
	}
	
	public No(T valor, No<T> proximo) {
		this.proximo = proximo;
		this.valor = valor;
	}
	
	public T getValor () {
		return valor;
	}
	
	public void setValor(T valor) {
		this.valor = valor;
	}
	
	public No<T> getProximo () {
		return proximo;
	}
	
	public void setProximo (No<T> proximo) {
		this.proximo = proximo;
	}
	
	
	public String toString() {
		return valor.toString(); 
	}

}
