package Model;
import java.util.Random;

public class Dado {
	
	private int resultados[];
	
	private static int getRandomD6 ()
	{
		Random num = new Random();
		return num.nextInt(6) + 1;
	}
	
	protected void setOrdemJogador (Jogador[] lstJogadores)
	{
		int dado1,dado2,max = 0,indice = 0,inicio=0,i=0;
		resultados = new int[lstJogadores.length];
		
		for ( i=0; i <  lstJogadores.length; i++)
		{
			dado1 = (Dado.getRandomD6());
			dado2 = (Dado.getRandomD6());
			System.out.println("Jogador "+lstJogadores[i].getnomeJogador()+" tirou no primeiro Dado:"+dado1+
					" e no segundo:"+dado2+" Resultado:"+(dado1+dado2));
			
			resultados[i] = dado1 + dado2;
			
			if(resultados[i] > max) {
				max = resultados[i];
				indice = i;
			}			
		} 
		
		System.out.println("O Jogador "+lstJogadores[indice].getnomeJogador() +" sera o distribuidor");
		lstJogadores[indice].setordemJogador(1);
		
				
		// Ordem dos jogadores a direita do distribuidor //
		for ( i = 1; i <  lstJogadores.length; i++) {
			if (indice+i <lstJogadores.length) {

				lstJogadores[indice+i].setordemJogador(i+1);
			}
			else { // lista chegou ao fim //
				lstJogadores[inicio].setordemJogador(i+1);
				inicio++;
			}
		}
		
		
		
		return;
	}
	

	// Obtém um valor aleatorio de 1 a 6 representando a joagada de um dado no tabuleiro //
	public int getResultadoDado() {
		
		
		Random num = new Random();
		int valor = num.nextInt(6) + 1;
		return valor;
		
		
	}

	

}