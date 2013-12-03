import java.util.*;

import javax.swing.JOptionPane;

public class Dijkstra {

	private Map<Vertice, Vertice> pre;
	private Map<Vertice, Integer> dist;
	private final ArrayList<Aresta> aresta;
	private Set<Vertice> nodoM;
	private Set<Vertice> nodoN;

	public Dijkstra(Grafo g) {
		new ArrayList<Vertice>(g.getVertice());
		this.aresta = new ArrayList<Aresta>(g.getAresta());
	}

	public void calcMap(Vertice map) {

		nodoM = new HashSet<Vertice>();
		nodoN = new HashSet<Vertice>();
		dist = new HashMap<Vertice, Integer>();
		pre = new HashMap<Vertice, Vertice>();
		dist.put(map, 0);
		nodoN.add(map);

		while (nodoN.size() > 0) {
			Vertice nodo = getMenor(nodoN);
			nodoM.add(nodo);
			nodoN.remove(nodo);
			getMenorDistancia(nodo);
		}
	}

	private List<Vertice> getFilho(Vertice node) {
		List<Vertice> filhos = new ArrayList<Vertice>();

		for (Aresta aresta : this.aresta) {
			if (aresta.getArestaOrigem().equals(node) && !isMarcado(aresta.getArestaDestino())) {
				filhos.add(aresta.getArestaDestino());
			}
		}
		return filhos;
	}
	
	//m�todo que calcula o menor caminho de um vertice a todos os outros do grafo
	private void getMenorDistancia(Vertice nodo) {
		List<Vertice> nodosAdjacentes = getFilho(nodo);
		for (Vertice alvo : nodosAdjacentes) {
			if (menorDistancia(alvo) > menorDistancia(nodo)
					+ getDistancia(nodo, alvo)) {
				dist.put(alvo, menorDistancia(nodo) + getDistancia(nodo, alvo));
				pre.put(alvo, nodo);
				nodoN.add(alvo);
			}
		}
	}

	private int menorDistancia(Vertice destino) {
		Integer dist = this.dist.get(destino);
		if (dist == null) {
			return Integer.MAX_VALUE;
		} else {
			return dist;
		}
	}

	private Vertice getMenor(Set<Vertice> vertices) {
		Vertice min = null;
		
		for (Vertice vertice : vertices) {
			if (min == null) {
				min = vertice;
			} else {
				if (menorDistancia(vertice) < menorDistancia(min)) {
					min = vertice;
				}
			}
		}
		return min;
	}

	private int getDistancia(Vertice node, Vertice alvo) {
		for (Aresta aresta : this.aresta) {
			if (aresta.getArestaOrigem().equals(node)
					&& aresta.getArestaDestino().equals(alvo)) {
				return aresta.getPesoAresta();
			}
		}
		throw new RuntimeException("Ocorreu um erro inesperado!");
	}

	private boolean isMarcado(Vertice vertice) {
		return nodoM.contains(vertice);
	}

	public static void calcCaminho(Grafo g, int origem, int destino) throws Exception {
		try{
		List<Vertice> nodes = g.getVertice();
		Dijkstra d = new Dijkstra(g);

		d.calcMap(nodes.get(origem));
		d.statusVertice(nodes.get(destino));
		} catch (Exception e) {
			System.out.println("Aresta inexistente!");
		}
	}
	
	//monta a String do resultado final
	public void statusVertice(Vertice alvo) {
		LinkedList<Vertice> path = new LinkedList<Vertice>();
		Vertice c = alvo;
		path.add(c);
		
		while (pre.get(c) != null) {
			c = pre.get(c);
			path.add(c);

		}

		Collections.reverse(path);
		
		try {
		String saida = "";
		int d = 0;
		for (Vertice vertice : path) {
			saida += vertice.getN() + " => ";
			d = dist.get(vertice);
		}
		System.out.println("-----------------------------");
		System.out.println("Menor caminho: " + saida);
		System.out.println("\nMenor Distancia: " + d);
		} catch (Exception e) {
			System.out.println("Caminho inexistente!");
		}
	}

}
