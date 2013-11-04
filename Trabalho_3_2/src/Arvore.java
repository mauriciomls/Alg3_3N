
public class Arvore {
		
	public Node raiz;
    
    public Arvore(){
        this.raiz = null;
    }
    
    public void put(String key,int valor){
        if(this.raiz == null){
            this.raiz = new Node(key,valor,true);
            this.raiz.pai = null;
        }else{
            putV(this.raiz, key, valor);
        }
    }
    
    private void putV(Node no,String chave,int val){
        if(val < no.valor){
           if(no.esq == null){
               no.esq = new Node(chave,val,false);
               no.esq.pai = no;
               case1(no);
           }else{
               putV(no.esq,chave,val);
           } 
        }else if(val > no.valor){
            if(no.dir == null){
               no.dir = new Node(chave,val,false);
               no.dir.pai = no;
               case1(no);
           }else{
        	   putV(no.dir,chave,val);
           }
        }
    }
    
    private Node getTio(Node no){
        
        if(no.pai != null && no.pai.pai == null){
            if(no.pai.esq == no){
                return no.dir;
            }else{
                return no.esq;
            }
        }else if(no.pai != null && no.pai.pai != null){
            if(no.pai.pai.esq == no.pai){
                return no.pai.pai.dir;
            }else{
                return no.pai.pai.esq;
                
            }
        }else{
            return null;
        }
        
    }
    
    private void case1(Node no){
        if(no.pai == null){
            no.cor = true;
        }else{
        	case2(no);
        }
    }
    
    private void case2(Node no){
        if(no.pai.cor == true){
        
        }else{
        	case3(no);
        }
    }
    private void case3(Node no){
        
        if(getTio(no).cor == false){
            no.pai.cor = true;
            getTio(no).cor = true;
            if(no.pai.pai != null){
                no.pai.pai.cor = false;
                case1(no.pai.pai);
            } 
        }else{
        	case4(no);
        }
    }
    
    private void case4(Node no){
        if(no == no.pai.dir && no.pai == no.pai.pai.esq){
            rotacionaEsq(no.pai);
            no = no.esq;
        }else if(no == no.pai.esq && no.pai == no.pai.pai.dir){
            rotacionaDir(no.pai);
            no = no.dir;
        }
        case5(no);
    }
    
    private void case5(Node no){
        no.pai.cor = true;
        getTio(no).cor = false;
        if(no == no.pai.esq && no.pai ==no.pai.pai.esq){
            rotacionaDir(no.pai.pai);
        }else{
            assert no == no.pai.dir && no.pai == no.pai.pai.dir;
            rotacionaEsq(no.pai.pai);
        }
    }
    
    
    private void rotacionaEsq(Node no){
        Node n = no.dir;
        substituiNodo(no, n);
        no.dir = n.esq;
        if(n.esq != null){
            n.esq.pai = no;
        }
        n.esq = no;
        no.pai = n;
    }
    private void rotacionaDir(Node no){
        Node n = no.esq;
        substituiNodo(no, n);
        no.esq = n.dir;
        if(n.dir != null){
            n.dir.pai = no;
        }
        n.dir = no;
        no.pai = n;
    }
    
    private void substituiNodo(Node velho,Node novo){
        if(velho.pai == null){
            this.raiz = novo;
        }else{
            if(velho == velho.pai.esq){
                velho.pai.esq = novo;
            }else{
                velho.pai.dir = novo;
            }
        }
        if(novo != null){
            novo.pai = velho.pai;
        }
    }
    
    public void busca(Node no,int chave){
        
        if(chave == this.raiz.valor){
            System.out.println("O valor procurado é a raiz.");
        }else{
            if(chave == no.valor){
                System.out.println("Encontrou o valor: "+no.chave+" ;para a chave: "+no.valor);
            }else{
                if(chave > no.valor){
                    busca(no.dir,chave);
                }else if(chave < no.valor){
                    busca(no.esq,chave);
                }
            }
        }
    }
    
     public void caminhaPrefixado(Node no) {
         if(no != null){
             System.out.print(no.valor+" ");
             caminhaPrefixado(no.esq);
             caminhaPrefixado(no.dir);
             
         }
     }
     public void caminhaPosfixado(Node no) {
         if(no != null){
             caminhaPosfixado(no.esq);
             caminhaPosfixado(no.dir);
             System.out.print(no.valor + " ");
         }
     }
     public void caminhaOrdenado(Node no) {
         if(no != null){
             caminhaOrdenado(no.esq);
             System.out.print(no.valor + " ");
             caminhaOrdenado(no.dir);
         }
     }
     
     public Node removeNo(Node no,int val){
         
         if(no != null){
             if(val > no.valor){
                 no.dir = removeNo(no.dir, val);
             }else if(val < no.valor){
                 no.esq = removeNo(no.esq, val);
             }else{
                 if(no.dir != null && no.esq != null){
                     no.valor = buscaMin(no.dir).valor;
                     no.dir = removeMin(no.dir);
                 }else{
                     no = (no.esq != null) ? no.esq : no.dir;
                 }
             }
             return no;
         }else{
             return null;
         }
     }
     
     public Node removeMin(Node no){
         if(no != null){
             if(no.esq != null){
                 no.esq = removeMin(no.esq);
                 return no;
             }else{
                 return no.dir;
             }
         }
         return null;
     }
     public Node buscaMin(Node no){
         if(no != null){
             while(no.esq != null){
                 no = no.esq;
             }
         }
         return no;
     }
     
     private Node rmCaso1(Node no){
         return no = null;
     }
     private Node rmCaso2(Node no){
         return no = null;
     }

}
