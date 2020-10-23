package calculadora;

import java.util.Scanner;
import java.util.StringTokenizer;

import estruturas.Arvore;
import estruturas.NodeArvore;
import estruturas.Pilha;

public class Calculadora {
	private String variaveis = "";
	private float[] valores;
	private String[] tokens;
	private Scanner input;

	public float calcularExpressao(String expressao){			// metodo principal
		
		float resultado = 0;
		
		if(!verificaFormato(expressao)){			// caso haja algum erro na expressao, nao executa o metodo
			System.out.println("Formato incorreto, tente novamente!");
		}
		else{											
			Arvore<String> arvore = construirArvore();				// constroi a arvore
			recebeValores();										// recebe o valor das variaveis
			imprimirExpressao(arvore);								// imprime a expressao e substitui as variaveis pelos valores
			resultado = calcular(arvore);							// calcula a expressao
			System.out.println("Resultado: " + resultado);
		}

		return resultado;
	}

	private boolean verificaFormato(String expressao){
		int variaveis = 0;								// para uma expressao esta
		int parenteses = 0;								// correta, o numero de variaveis e igual ao numero
		int operacoes = 0;								// de operacoes + 1.
														// o numero de parentes e igual ao dobro do numero de operacoes

		StringTokenizer exp = new StringTokenizer(expressao);

		this.tokens = new String[exp.countTokens()];		// cria-se um array de strings, com os caracteres separados
															// por um espaco, a partir do stringTokenizer
		for(int i = 0; i<tokens.length; i++){		
			tokens[i] = exp.nextToken();	
		}
															// o seguinte laco, verifica se um caractere esta em uma posicao incorreta
		for(int i = 0; i<tokens.length; i++){				
			if(i == tokens.length - 1){						// quando for o ultimo caractere
				if(!tokens[i].equals(")")){					// se nao for um ")" , esta incorreto.
					return false;							
				}else{		
					parenteses++;							// aumenta a quantidade
				}
			}
			else{											// se depois de "(", tiver uma operacao ou um ")"
				if(tokens[i].equals("(")){
					if("+-/*".indexOf(tokens[i+1])!=-1 || tokens[i+1].equals(")")){
						return false;						// esta incorreto
					}
					else{
						parenteses++;						// aumenta a quantidade
					}
				}

				if(Character.isLetter(tokens[i].charAt(0)) || Character.isDigit(tokens[i].charAt(0))){
					if(Character.isLetter(tokens[i+1].charAt(0)) || Character.isDigit(tokens[i+1].charAt(0)) ||
							tokens[i+1].equals("(")){		// se depois da variavel ou do numero, tiver uma outra variavel ou numero, ou um "("
						return false;						// esta incorreto
					}
					else{
						variaveis++;						// aumenta a quantidade
					}
				}

				if("+-/*".indexOf(tokens[i]) !=-1){			// se depois da operacao, tiver uma outra operacao, ou um ")"
					if("+-/*".indexOf(tokens[i+1]) !=-1 || tokens[i+1].equals(")")){	
						return false;						// esta incorreto
					}
					else{
						operacoes++;						// aumenta a quantidade
					}
				}

				if(tokens[i].equals(")")){					// se depois de um ")", tiver um "(", ou uma letra ou numero.
					if(tokens[i+1].equals("(") || Character.isLetter(tokens[i+1].charAt(0)) || 
							Character.isDigit(tokens[i+1].charAt(0))){
						return false;						//esta incorreto
					}
					else{
						parenteses++;						// aumenta a quantidade
					}
				}
			}
		}
																			// caso esteja tudo certo, em relacao a ordem dos caracteres..
		if((2*operacoes)==parenteses && variaveis==operacoes+1){			// verifica se a quantidade está OK
			return true;
		}

		return false;

	}

	private Arvore<String> construirArvore(){					//Se a expressao passou pela verificacao, constroi a arvore

		Pilha <NodeArvore <String> > valor = new Pilha <NodeArvore <String> >();		
		Pilha <NodeArvore <String> > operador = new Pilha<NodeArvore <String> >();

		for(int i = 0; i<tokens.length; i++){
			if(tokens[i].equals(")")){							// quando tiver um ")", significa que acabou uma operacao
				NodeArvore <String> raiz = operador.pop();		// retira da pilha de operadores a operacao
				if(raiz!=null){
					raiz.setDireita(valor.pop());				// a esquerda e direita sao numeros ou valores retirados da pilha de valor
					raiz.setEsquerda(valor.pop());
					valor.push(raiz);							// o conjunto é readicionado na pilha de valor
				}
				if(i == tokens.length-1){
					Arvore<String> arvoreExpressoes = new Arvore<String>(raiz);		// quando chegar na quantidade de caracteres
					return arvoreExpressoes;										// retorna a arvore
				}
			}
			else{
				if(!tokens[i].equals("(")){											// tudo o que for diferente de "(" sera adicionado

					NodeArvore <String> no = new NodeArvore<String>(tokens[i]);

					if("+-/*".indexOf(tokens[i]) !=-1){								// se for uma operacao, adiciona na pilha de operador
						operador.push(no);
					}
					else{
						if(Character.isLetter(tokens[i].charAt(0))){				// se for uma letra ou numero, adiciona na pilha de valor
							variaveis+=tokens[i].charAt(0);							// esta string recebe as variaveis, e sera utilizada nos proximos metodos
						}	
						valor.push(no);

					}
				}
			}
		}
		return null;
	}

	private String removerDuplicatas(String variaveis){								// este metodo apenas remove caracteres repetidos
		String retorno = "";														// para quando for receber os valores.
													
		if(variaveis.length()!=0){
			String letras = "abcdefghijklmnopqrstuvwxyz";
			for(int i = 0; i<variaveis.length(); i++){
				if(letras.indexOf(variaveis.charAt(i))!=-1){
					retorno+=variaveis.charAt(i);
					letras = letras.replace(variaveis.charAt(i), ' ');
				}
			}
		}
		return retorno;
	}


	private void recebeValores(){							// recebe os valores informados pelo usuario
		variaveis = removerDuplicatas(variaveis);			// faz com que o usuario informe apenas uma vez

		valores = new float[variaveis.length()];
		input = new Scanner(System.in);
		
		for(int i = 0; i<valores.length; i++){
			System.out.println("Digite um valor para a variavel: " + variaveis.charAt(i));

			while(input.hasNext()){
				if(input.hasNextFloat()){
					valores[i] = input.nextFloat();
					break;
				}
				else{
					input.next();
				}
			}
		}
	}


	private void imprimirExpressao(Arvore<String> arvore) {
		String expressao = "Expressao inserida: ";
		expressao += arvore.percorrerEmOrdem(arvore.getRaiz(), valores, variaveis);
		System.out.println(expressao);

	}


	private float calcular(Arvore<String> arvore) {
		return arvore.percorrerPosOrdem(arvore.getRaiz(), 0, 0);
	}
}
