import java.util.*;

public class Vertice {

	ArrayList<Aresta> listaAdjacencias = new ArrayList<Aresta>();
	String n;

	public Vertice(String n) {
		this.n = n;

	}

	public void adicionaLista(Aresta aresta) {
		listaAdjacencias.add(aresta);
	}

	public String getN() {
		return n;
	}

}
