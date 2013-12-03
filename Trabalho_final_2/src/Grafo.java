import java.util.*;

public class Grafo {
	
	ArrayList<Vertice> vertice = new ArrayList<Vertice>();
	ArrayList<Aresta> aresta = new ArrayList<Aresta>();
	
	//adiciona arestas ao grafo
	public Aresta addAresta(int pesoAresta, Vertice arestaOrigem, Vertice arestaDestino) {
		Aresta aresta = new Aresta();
		
		aresta.setArestaOrigem(arestaOrigem);
		aresta.setArestaDestino(arestaDestino);
		aresta.setPesoAresta(pesoAresta);
		
		arestaOrigem.adicionaLista(aresta);
		this.aresta.add(aresta);
		
		return aresta;
	}
	
	//adiciona vertices ao grafo
	public Vertice addVertice(String nome) {
		Vertice vertice = null;

		int vNull = verticeNull(nome);

		if (vNull == -1) {
			vertice = new Vertice(nome);
			this.vertice.add(vertice);
		} else {
			vertice = this.vertice.get(vNull);
		}
		
		return vertice;
	}

	public int verticeNull(String nome) {
		int vNull = -1;

		for (int i = 0; i < vertice.size(); i++) {
			
			if (vertice.get(i).n.equals(nome)) {
				vNull = i;
				break;
			} else {
				vNull = -1;
			}
		}

		return vNull;
	}
	
	//monta a String com as arestas e vertices
	public String toString() {
		String read = "";
		for (Vertice u : vertice) {
			read += u.n + "  =>   ";
			for (Aresta e : u.listaAdjacencias) {
				Vertice v = e.getArestaDestino();
				read += v.n + "    ";
			}
			read += "\n";
		}
		return read;
	}

	public ArrayList<Vertice> getVertice() {
		return vertice;
	}

	public ArrayList<Aresta> getAresta() {
		return aresta;
	}

}
