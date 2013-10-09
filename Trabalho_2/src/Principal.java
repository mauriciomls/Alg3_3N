import java.net.*;
import java.util.*;

//Só foram implementados os algoritmos de reta e retangulo em escala de cinza.

public class Principal {

	public static void main(String[] args) throws Exception {
		
		Scanner ler = new Scanner(System.in);
		String entrada;
		Cor cor = new Cor(0);
		Imagem imagem = new Imagem(0,0);
		int sair = 0;
		String hostName = "";
		
		try {
		InetAddress addr = InetAddress.getLocalHost();
		hostName = addr.getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		do {
			try {
			System.out.println("Draw:\\" + hostName + ">");
			entrada = ler.next();
			
		if (entrada.equalsIgnoreCase("imagem")) {
			imagem = new Imagem(ler.nextInt(), ler.nextInt());
		}
		
		else if (entrada.equalsIgnoreCase("reta")) {
			int x0 = ler.nextInt();
			int y0 = ler.nextInt();
			int x1 = ler.nextInt();
			int y1 = ler.nextInt();
			Reta reta = new Reta();
			reta.setPonto(x0, y0, x1, y1);
			reta.draw(cor, imagem);
		}
		
		else if (entrada.equalsIgnoreCase("retangulo")) {
			int x0 = ler.nextInt();
			int y0 = ler.nextInt();
			int x1 = ler.nextInt();
			int y1 = ler.nextInt();
			
			Retangulo retangulo = new Retangulo();
			retangulo.setPonto(x0, y0, x1, y1);
			retangulo.draw(cor, imagem);
		}
		
		else if (entrada.equalsIgnoreCase("cor")) {
			try {
			int c = ler.nextInt();
			
			if (c >= 0 && c <= 255) {
				cor.setGrey(c);
			} else {
				System.out.print("Erro! O valor deve estar entre 0 e 255.\n");
			}
			} catch (Exception e) {
				System.out.print("Erro! O valor deve estar entre 0 e 255.\n");
			}
			
			cor = new Cor(cor.getGrey());
			
		}
		
		else if(entrada.equalsIgnoreCase("salvar")) {
			try {
			String nomeArq = ler.next();	
			imagem.saveToFile(nomeArq);
			} catch (Exception e) {
				System.out.print("Erro! Não existem dados para serem salvos.\n\n");
			}
		}
		
		else if (entrada.equalsIgnoreCase("exit")) {
			sair = 1;
			System.exit(0);
		}
		
		else {
			System.out.print("Comando Inválido!\n");
		}
		
		} catch (Exception e) {
			System.out.print("Erro!\n");
		}
		
		} while (sair == 0);

	}
}
