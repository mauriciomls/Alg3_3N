import java.io.*;

public class ReadFile {

	public static void leArquivo(Grafo grafo) throws IOException {
		Vertice vertice1;
		Vertice vertice2;

		FileInputStream fst = new FileInputStream("Grafo.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(fst));

		String line;

		while ((line = reader.readLine()) != null) {
			String v[];
			v = line.split(" ");

			vertice1 = grafo.addVertice(v[0]);
			vertice2 = grafo.addVertice(v[1]);
			int peso = Integer.parseInt(v[2]);

			Aresta aresta = grafo.addAresta(peso, vertice1, vertice2);
		}
		reader.close();
	}

}
