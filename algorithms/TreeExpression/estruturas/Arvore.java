package estruturas;

public class Arvore <T>{
	private NodeArvore<T> raiz;

	public String percorrerEmOrdem(NodeArvore<String> raiz, float[] valores, String variaveis){
		String retorno = "";		
		if(raiz!=null){

			if(raiz.getEsquerda()!=null){						// adiciona parenteses ao percorrer
				retorno+="( ";							
			}
			retorno += percorrerEmOrdem(raiz.getEsquerda(), valores, variaveis);


			if(Character.isLetter(raiz.getInfo().charAt(0))){				// verifica se e uma letra
				for(int i = 0; i<variaveis.length(); i++){					// se for, procura a letra correspondente na string
					if(raiz.getInfo().equals(String.valueOf(variaveis.charAt(i)))){
						raiz.setInfo(String.valueOf(valores[i]));			// substitui o a letra, pelo valor correspondente
						break;
					}
				}
			}

			retorno += raiz.getInfo() + " ";
			retorno += percorrerEmOrdem(raiz.getDireita(), valores, variaveis);

			if(raiz.getDireita()!=null){									
				retorno+=") ";									// adiciona parenteses ao voltar
			}
		}
		return retorno;
	}

	public float percorrerPosOrdem(NodeArvore<String> raiz, float numEsq, float numDir){

		if(raiz!=null){
			
			numEsq = percorrerPosOrdem(raiz.getEsquerda(), numEsq, numDir);
			
			if(raiz.getEsquerda()==null){									// percorre ate o ultimo no na esquerda
				numEsq = Float.valueOf(raiz.getInfo());	
			}
			
			numDir = percorrerPosOrdem(raiz.getDireita(), numEsq, numDir);
			
			if(raiz.getDireita()==null){									// percorre ate o ultimo no na direita
				numDir = Float.valueOf(raiz.getInfo());
			}
			
			switch(raiz.getInfo()){											// verifica a operacao
			case "+":
				numEsq = numEsq+numDir;
				break;
			case "-":
				numEsq = numEsq-numDir;
				break;
			case "*":
				numEsq = numEsq*numDir;
				break;
			case "/":
				numEsq = numEsq/numDir;
				break;
			default:														// caso nao seja uma operacao, nao faz nada
				break;			
			}				
		}		
		return numEsq;														
	}

	public Arvore(NodeArvore<T> raiz){
		this.raiz = raiz;
	}

	public NodeArvore<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodeArvore<T> raiz) {
		this.raiz = raiz;
	}

}
