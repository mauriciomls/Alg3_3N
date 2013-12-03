import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;


public class Principal {

	public static void main(String[] args) throws Exception {
		
		int origem;
		int destino;
		
		Scanner r = new Scanner(System.in);
        Grafo grafo = new Grafo();
        
		ReadFile.leArquivo(grafo);
		System.out.println("Grafo Direcionado");
		System.out.println("-----------------------------");
		System.out.println(grafo);
		
		origem = Integer.parseInt(JOptionPane.showInputDialog("Aresta Origem"));
        destino = Integer.parseInt(JOptionPane.showInputDialog("Aresta Destino"));
        
        
        Dijkstra d = new Dijkstra(grafo);
        Dijkstra.calcCaminho(grafo, origem, destino);
        
        
    }
     

}


