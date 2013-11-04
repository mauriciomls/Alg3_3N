
public class Node {
	
	public String chave;
    public int valor;
    public Node esq, dir,pai;
    public int n;
    boolean cor;//preto = true
    
    
    public Node(String chave,int valor,boolean cor){
        this.chave                  =   chave;
        this.valor                  =   valor; 
        this.cor                    =   cor; 
    }

}
