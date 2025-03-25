package view;
import controller.ListaEncadeadaSimplesController;
import java.lang.IllegalArgumentException;

public class ListaEncadeadaSimples {
  public static void main(String[] args) {
	 
	 ListaEncadeadaSimplesController obj = new ListaEncadeadaSimplesController();
	 try {
		System.out.println(obj.teste());
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
	
}
}
