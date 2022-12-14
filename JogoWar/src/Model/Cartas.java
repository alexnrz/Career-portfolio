package Model;
import java.util.Random;

class Cartas {

	
	private int numCartas = 52;
	private String NomesCartas[] = new String[52];
	private String Simbolos[] = new String[52];
	private String CartasRetiradas[] = new String[52];
	private int numTrocas = 0;
	
	private static Cartas ctrl = null;
	private Cartas() {}
	
	public static Cartas getCartas() {
		if(ctrl==null) {
			ctrl = new Cartas();
		}
		
		return ctrl;
	}
	

	
	/* Retorna um objetivo, verifica se há objetivos disponíveis, verifica se o jogador existe //
	// e verifica se o jogador alvo já possui um objetivo */
	public Objetivo retiraCartaObjetivo(Objetivo[] Objetivos, Jogador[] Jogadores, String nomeJogador) {
		
		int numObjetivo, posJogador=0,i=0;
		int totalObjetivos = Objetivos.length;
		int flag = 0;
		Random gerador = new Random(); 
		
		System.out.println("Jogador que vai receber o objetivo: "+nomeJogador);

		
		Objetivo ObjetivoJogador = new Objetivo(); 

		numObjetivo = gerador.nextInt(totalObjetivos);
		System.out.println("Sorteou o objetivo: "+numObjetivo);
		
		while(i < Objetivos.length || flag != 0) {
			if(Objetivos[numObjetivo].getDonoObjetivo()==null) {
				if(Objetivos[numObjetivo].getExercitos().contentEquals("nenhum")==false) {
					String corTemp =  Objetivos[numObjetivo].getExercitos();
					corTemp = corTemp.toLowerCase();
					for (int j=0;j<Jogadores.length;j++) {
						String corjogTemp = Jogadores[j].getColor();
						corjogTemp = corjogTemp.toLowerCase();
						
						System.out.println("Cor do jogador: "+corjogTemp+" Cor objetivo: "+corTemp);
						// Existe um jogador com a cor do objetivo //
						if(corTemp.contentEquals(corjogTemp)==true) {
							System.out.println("Existe um jogador com a cor "+corTemp+" que pertence ao objetivo");
							if(Jogadores[j].getnomeJogador().contentEquals(nomeJogador)==false) {
								System.out.println("Um jogador inimigo é o dono da cor");
								flag=1;
								break;
							}
							
						}						
					}
					
					
				}
				else {
					break;
				}
				
			}
			if(flag == 0) {
				i++;
				numObjetivo = gerador.nextInt(totalObjetivos);
				System.out.println("Sorteou um novo objetivo: "+numObjetivo);
			}
			else {
				break;
			}			
		}
		
		// Verifica se o jogador alvo está mesmo no jogo //
		while(Jogadores[posJogador].getnomeJogador().equals(nomeJogador) == false) {
			posJogador++;
			if (posJogador > 6) {
				System.out.println("Jogador não encontrado para definir um objetivo");
				return null;
			}
		}
		// Verifica se o jogador alvo já possui um Objetivo //
		if ( Jogadores[posJogador].getObjetivo() != null) {
			System.out.println("O jogador ja possui um objetivo!");
			return null;
		}
		
		Objetivos[numObjetivo].setDonoObjetivo(Jogadores[posJogador].getnomeJogador());
		
		ObjetivoJogador = Objetivos[numObjetivo];
		
		return ObjetivoJogador;		
	}
	
	
	/* Retorna um território, verifica se o jogador alvo existe, verifica se há territórios
	 * disponíveis */
	public Territorio retiraCartaTerritorio(Territorio[] listaTerritorios,Jogador[] Jogadores, String nomeJogador) {
		int totalTerritorios=listaTerritorios.length;
		int numTerritorio,posJogador=0,i=0;
		Random gerador = new Random();
		Territorio cartaTerritorio;
		
		numTerritorio = gerador.nextInt(totalTerritorios);
		while(listaTerritorios[numTerritorio].getdonoTerritorio() != null) {

			numTerritorio = gerador.nextInt(totalTerritorios);
			i++;
			if ( i > totalTerritorios) {
				break;
			}
		}
		
		while(Jogadores[posJogador].getnomeJogador() != nomeJogador) {
			posJogador++;
			if (posJogador > 6) {
				System.out.println("Jogador não encontrado para receber um Território");
				return null;
			}
		}
		listaTerritorios[numTerritorio].setCorExercito(Jogadores[posJogador].getColor());
		listaTerritorios[numTerritorio].setNumExercitos(listaTerritorios[numTerritorio].getnumExercitos()+1);
		listaTerritorios[numTerritorio].setdonoTerritorio(nomeJogador);
	
		
		cartaTerritorio = listaTerritorios[numTerritorio];		
		
		return cartaTerritorio;	
	}
	

	public void inicializaCartasBonus() {
		
		
		

		
		
		NomesCartas[0] = "Africa do Sul";
		NomesCartas[1] = "Angola";
		NomesCartas[2] = "Argelia";
		NomesCartas[3] = "Egito";
		NomesCartas[4] = "Nigeria";
		NomesCartas[5] = "Somalia";
		
		NomesCartas[6] = "Alasca";
		NomesCartas[7] = "Calgary";
		NomesCartas[8] = "California";
		NomesCartas[9] = "Groelancia";
		NomesCartas[10] = "Mexico";
		NomesCartas[11] = "Nova York";
		NomesCartas[12] = "Quebec";
		NomesCartas[13] = "Texas";
		NomesCartas[14] = "Vancouver";
		
		NomesCartas[15] = "Arabia Saudita";
		NomesCartas[16] = "Bangladesh";
		NomesCartas[17] = "Cazaquistao";
		NomesCartas[18] = "China";
		NomesCartas[19] = "Coreia do Norte";
		NomesCartas[20] = "Coreia do Sul";
		NomesCartas[21] = "Estonia";
		NomesCartas[22] = "India";
		NomesCartas[23] = "Ira";
		NomesCartas[24] = "Iraque";
		NomesCartas[25] = "Japao";
		NomesCartas[26] = "Jordania";
		NomesCartas[27] = "Letonia";
		NomesCartas[28] = "Mongolia";
		NomesCartas[29] = "Paquistao";
		NomesCartas[30] = "Russia";
		NomesCartas[31] = "Siberia";
		NomesCartas[32] = "Siria";
		NomesCartas[33] = "Tailandia";
		NomesCartas[34] = "Turquia";
		
		NomesCartas[35] = "Argentina";
		NomesCartas[36] = "Brasil";
		NomesCartas[37] = "Peru";
		NomesCartas[38] = "Venezuela";
		
		NomesCartas[39] = "Espanha";
		NomesCartas[40] = "Franca";
		NomesCartas[41] = "Italia";
		NomesCartas[42] = "Polonia";
		NomesCartas[43] = "Reino Unido";
		NomesCartas[44] = "Romenia";
		NomesCartas[45] = "Suecia";
		NomesCartas[46] = "Ucrania";
		
		NomesCartas[47] = "Autralia";
		NomesCartas[48] = "Indonesia";
		NomesCartas[49] = "Nova Zelandia";
		NomesCartas[50] = "Perth";
		
		NomesCartas[51] = "Coringa";
		
		
		///////////////////////////////
		//////////////////////////////
		
		
		Simbolos[0] = "Triangulo";
		Simbolos[1] = "Quadrado";
		Simbolos[2] = "Circulo";
		Simbolos[3] = "Egito";
		Simbolos[4] = "Circulo";
		Simbolos[5] = "Quadrado";
		
		Simbolos[6] = "Triangulo";
		Simbolos[7] = "Circulo";
		Simbolos[8] = "Quadrado";
		Simbolos[9] = "Circulo";
		Simbolos[10] = "Quadrado";
		Simbolos[11] = "Quadrado";
		Simbolos[12] = "Circulo";
		Simbolos[13] = "Triangulo";
		Simbolos[14] = "Triangulo";
		
		Simbolos[15] = "Circulo";
		Simbolos[16] = "Circulo";
		Simbolos[17] = "Circulo";
		Simbolos[18] = "Quadrado";
		Simbolos[19] = "Quadrado";
		Simbolos[20] = "Triangulo";
		Simbolos[21] = "Circulo";
		Simbolos[22] = "Triangulo";
		Simbolos[23] = "Quadrado";
		Simbolos[24] = "Triangulo";
		Simbolos[25] = "Circulo";
		Simbolos[26] = "Quadrado";
		Simbolos[27] = "Quadrado";
		Simbolos[28] = "Triangulo";
		Simbolos[29] = "Circulo";
		Simbolos[30] = "Triangulo";
		Simbolos[31] = "Quadrado";
		Simbolos[32] = "Quadrado";
		Simbolos[33] = "Triangulo";
		Simbolos[34] = "Triangulo";
		
		Simbolos[35] = "Quadrado";
		Simbolos[36] = "Circulo";
		Simbolos[37] = "Triangulo";
		Simbolos[38] = "Circulo";
		
		Simbolos[39] = "Circulo";
		Simbolos[40] = "Triangulo";
		Simbolos[41] = "Quadrado";
		Simbolos[42] = "Triangulo";
		Simbolos[43] = "Circulo";
		Simbolos[44] = "Triangulo";
		Simbolos[45] = "Quadrado";
		Simbolos[46] = "Circulo";
		
		Simbolos[47] = "Triangulo";
		Simbolos[48] = "Triangulo";
		Simbolos[49] = "Quadrado";
		Simbolos[50] = "Circulo";
		
		Simbolos[51] = "Coringa";
		
		
	}
	
	
	public int getNumCartas () {
		return numCartas;
	}	
		

		
	public String[] getCartaBonus() {
		String []t = new String[2];
		Random gerador = new Random();
		int indiceCarta = 0;
		
		
		if (numCartas == 0) {
			System.out.print("Todas as Cartas foram Retiradas, embaralhando novamente...");
			for (int i=0; i < CartasRetiradas.length;i++) {
				CartasRetiradas[i] = null;
			}
		}
		
		
		
		indiceCarta = gerador.nextInt(51);
		while(CartasRetiradas[indiceCarta] != null) {
			indiceCarta = gerador.nextInt(51);
		}
			// Carta ainda não foi retirada //

		System.out.println("Jogador recebeu a carta "+NomesCartas[indiceCarta]+" com o simbolo "+Simbolos[indiceCarta]);
		t[0] = NomesCartas[indiceCarta];
		t[1] = Simbolos[indiceCarta];
		CartasRetiradas[indiceCarta] = NomesCartas[indiceCarta];
		numTrocas++;
		numCartas--;
		return t;
	
		
	}
	
	public int getNumTrocas() {
		return numTrocas;
	}
	
}
