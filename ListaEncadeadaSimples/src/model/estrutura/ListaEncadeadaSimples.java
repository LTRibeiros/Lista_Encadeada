package model.estrutura;
import java.lang.IllegalArgumentException;

public class ListaEncadeadaSimples <T> {
	private No<T> inicio = null; //declara que o inicio da lista é vazia
	
	//lista de comandos
	
    //append  adiciona o elemento no final;
	//get	  retorna um no dado index;
	//index   retorna um indice de um elemento;
	//insert  insere um elemento em uma determinada posição;
	//last    retorna o ultimo elemento;
	//remove  remove um elemento dedo o index;
	//total   retorna o total de elementos;
	
	public void append(T elemento) {
		No<T> buffer /*No é o objeto e buffer é uma variavel*/ = new No<>(elemento); //cria No e buffer e adiciona o parametro de elemento dentro do objeto
		
		if (this.inicio == null ) {
			this.inicio = buffer; //se não existirem elementos na lista, o elemento passado vira o inicio
		} else {
			this.last().setProximo(buffer); //se tiver elementos na lista, ele pega o ultimo No em last() e seta o valor do buffer como o proximo nó
		}
	
}
	

	
	public No<T> get(int index) throws IllegalArgumentException { 
			
		/*
		 * por questão de falta de profundidade na lista encadeada, tem dois erros possiveis, a ausencia de elementos e o indice não existir.
		 * com dois pontos de parada, chegamos no index solicitado ou não temos mais elementos em getProximo
		*/
		
		int i = 0;
		if (this.inicio == null) 
			throw new IllegalArgumentException("Nao existem itens na lista");
		
		  No<T> buffer = this.inicio;
		  
		for (i = 0; i < index ; i ++) {
				if(buffer.getProximo() == null)  // nao temos mais elementos em get proximo
				break;
				buffer = buffer.getProximo(); // chegamos no index solicitado
				}
		
			
			if (i < index) 
				throw new IllegalArgumentException("Indice informado não existe");
				return buffer;		
			}
	
	public int index(T elemento) throws IllegalArgumentException {
		if (this.inicio == null)
			throw new IllegalArgumentException("Nao existe item na lista.");
		
		int index = 0;
		if (this.inicio.getValor() == elemento) //esse só checa se o primeiro valor da lista é igual o elemento? (faz sentido, pq o do só começa comparando com o proximo, por causa do getProximo()
			return index;
		
		No<T> buffer = this.inicio;
		do { //faça até o if ocorrer
				if(buffer.getValor() == elemento) {
				return index;
			}
				buffer = buffer.getProximo();
				index ++;
		    }
		
		while(buffer != null);
				throw new IllegalArgumentException("Item não encontrado.");
			}
	
	public void insert(int index, T elemento) throws IllegalArgumentException { //insert baseado na posição que queremos
		if (index == 0) {
			
				No<T> buffer_novo = new No<>(elemento);
						if (this.inicio != null) 
						{
							No<T> buffer_inicio = this.inicio;
							buffer_novo.setProximo(buffer_inicio); //se a lista tiver elemento no index 0, ele realoca o inicio
							this.inicio = buffer_novo;
						} 
							else
						{						
							this.inicio = buffer_novo; //se tiver vazia, ele define o primeiro nó
				        }
		}
			 else { //se não for no começo da lista, ele chama a função passando o No anterior como parametro PQPPPPPPP
				this.insert( this.get(--index), elemento); //se for no meio, ele aponta o index anterior para o proximo
			}
		}
	
	
	public void insert (No<T> item, T elemento) throws IllegalArgumentException { //insert baseado no elemento anterior
		No<T> buffer_novo = new No<>(elemento);
		No<T> buffer_proximo = item.getProximo();
		item.setProximo(buffer_novo);
		buffer_novo.setProximo(buffer_proximo);
	}

	public No<T> last () throws IllegalArgumentException {
		if (this.inicio == null) 
			throw new IllegalArgumentException("Nao existem itens na lista");
		    No<T> buffer = this.inicio;
		    while(buffer.getProximo()!= null)
		    	buffer = buffer.getProximo();
		    return buffer;
	}
	
	public void remove(int index) {
		if (index == 0) {
			this.inicio.setValor(null);
			if(this.inicio.getProximo() == null ) {
				this.inicio = null;
			} else {
				No<T> buffer = this.inicio.getProximo();
				this.inicio.setProximo(null);
				this.inicio = buffer;
			}
			return;
		}
		No<T> buffer_anterior = this.get(index - 1);
		No<T> item = buffer_anterior.getProximo();
		No<T> buffer_proximo = item.getProximo();
		buffer_anterior.setProximo(buffer_proximo);
		item.setProximo(null);
		item.setValor(null);
	
	}
	
	public int total() {
		if (this.inicio == null)
			return 0;
		No<T> buffer = this.inicio;
		int total_elementos = 0;
		
		do {
			total_elementos++;
			buffer = buffer.getProximo();			
		} while (buffer != null); // do while
		return total_elementos;
	}
	
	
	public String toString() {
		if (this.inicio == null) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		No<T> buffer  = this.inicio;
		builder.append(buffer.getValor());
		while (buffer.getProximo() != null) {
			builder.append(",");
			buffer = buffer.getProximo();
			builder.append(buffer.getValor());
		}
		builder.append("]");
		return builder.toString();
	}
}


		
		
	


