import java.io.*;

public class Imagem {
	
	private int[][] imagem;
	
	public Imagem(int altura, int largura) {
		this.imagem = new int[altura][largura];
	}
	
	public void setPixel(Ponto p, Cor cor) {
		imagem[p.x][p.y] = cor.getGrey();
		
	}
	
	
	public void saveToFile(String fileName) throws IOException {
		
		BufferedWriter out = new BufferedWriter(new FileWriter(fileName + ".pnm"));
	
		out.write(String.format("P2\n%d %d\n255\n", imagem[0].length, imagem[0].length));
		
		for (int[] linha : imagem) {
			for(int v: linha) {
				out.write(String.format("%d ", v));
			}
		}
		
		out.close();
	}
	
	

		

}
