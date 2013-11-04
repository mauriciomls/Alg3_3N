import java.io.*;
import java.net.*;
import java.util.*;


public class Principal {
	
	static Arvore tree;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		tree = new Arvore();
        
        Scanner ler = new Scanner(System.in);
        int entrada;
        int key;
        String valor; 
        
        
        do {
        	System.out.println("Comandos:\\" + getHostName() + ">");
        	entrada = ler.nextInt();
            
            switch(entrada){
            case 1: //inserir nodo
                
                System.out.println("Inserção - Informe a chave:");
                key = ler.nextInt();
                
                System.out.println("Inserção - Informe o valor:");
                valor = ler.next();
                
                adicionarNO(valor, key);
                break;
                
            case 2: // remover nodo
                System.out.println("Exclusão - Informe a chave:");
                key = ler.nextInt();
                removeNo(key);
                break;
                
            case 3: // pesquisa valor
                System.out.println("Consulta - Informe a chave:");
                key = ler.nextInt();
                consultar(key);
                break;
            
            default:
                System.out.println("Valor Inválido!");
                break;
            }
        } while(entrada != 0);
        
        
    }
    
    public static void adicionarNO(String valor,int chave){
        tree.put(valor, chave);
        System.out.println("Chave " + chave + " inserida");
    }
    
    public static void removeNo(int chave){
        tree.removeNo(tree.raiz, chave);
        System.out.println("Chave " + chave + " removida");
    }
    
    public static void consultar(int chave){
        tree.busca(tree.raiz, chave);
    }
    
    
    
    public static String getHostName() {
    	String hName = "";
    	try {
    		InetAddress addr = InetAddress.getLocalHost();
    		hName = addr.getHostName();
    		} catch (UnknownHostException e) {
    			e.printStackTrace();
    		}
    	return hName;
    }
    
}


