public class Aresta {

	private int pesoAresta;
	private Vertice arestaOrigem;
	protected Vertice arestaDestino;

	public int getPesoAresta() {
		return pesoAresta;
	}

	public void setPesoAresta(int peso) {
		this.pesoAresta = peso;
	}

	public Vertice getArestaOrigem() {
		return arestaOrigem;
	}

	public void setArestaOrigem(Vertice origem) {
		this.arestaOrigem = origem;
	}

	public Vertice getArestaDestino() {
		return arestaDestino;
	}

	public void setArestaDestino(Vertice destino) {
		this.arestaDestino = destino;
	}

}
