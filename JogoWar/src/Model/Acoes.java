package Model;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Controller.ControlaJogo;
import View.ControlaView;


// Padrão Singleton //
public class Acoes implements  ObservadoIF{
		
	private static Continente[] Continentes;
	private static Territorio[] listaTerritorios;
	private Exercito[] Exercitos;
	private static Objetivo[] Objetivos;
	private Cartas C;
	private static Jogador[] listaJogadores;
	boolean respInicializaJogo;
	private static Acoes ctrl = null;
	private int DadoAtk[] = new int[3];
	private int DadoDef[] = new int[3];
	private String[] nomes;
	private String[] cores;
	private int qtdJogadores;
	
	
	 private List<ObservadorIF> lst = new ArrayList<ObservadorIF>();
	

	private Acoes() {
	}
	
	public void add(ObservadorIF o) {
		lst.add(o);
	}
	private void atualiza() {
		Iterator<ObservadorIF> li =lst.iterator();		
		
		while(li.hasNext()) {
			ObservadorIF a = li.next();
			a.not(this);
		}

	}
	@Override
	public void remove(ObservadorIF o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	/////////////////////////////////////
	////// Incluídos no Observer  ///////
	/////////////////////////////////////
	
	public String[] getNomesJogadores() {
		String [] nomes = new String[listaJogadores.length];
		for (int i =0 ; i < listaJogadores.length;i++) {
			nomes[i] = listaJogadores[i].getnomeJogador();
		}
		
		return nomes;
	}
	
	public String[] getCoresJogadores() {
		String[] cores = new String[listaJogadores.length];
		
		for(int i=0; i < listaJogadores.length;i++) {
			cores[i] = listaJogadores[i].getColor();
		}
		return cores;
	}
	
	public int getNumExercitos(String nomeTerritorio) {
		
		for(int i=0;i<listaTerritorios.length;i++) {
			if(listaTerritorios[i].getNomeTerritorio().equals(nomeTerritorio) == true) {
				return listaTerritorios[i].getnumExercitos();
			}
		}
		
		return -1;
	}
	
	public String getCorDonoTerritorio(String nomeTerritorio) {
		for(int i=0;i<listaTerritorios.length;i++) {
			if(listaTerritorios[i].getNomeTerritorio().equals(nomeTerritorio) == true) {
				
				return listaTerritorios[i].getCorExercito();
			}
		}
		
		return "Sem dono";
	}
	
	public Color[] getCorTodosTerritorios() {
		
		Color [] c =  new Color[listaTerritorios.length];
		
		for(int i=0;i<listaTerritorios.length;i++) {
			c[i]=getColorJava(listaTerritorios[i].getCorExercito());
		}
		
		return c;		
	}
		
	public Color getCorTerritorioJava(String nomeTerritorio) {
		
		Color c = null;
		
		for(int i=0;i<listaTerritorios.length;i++) {
			if(listaTerritorios[i].getNomeTerritorio().equals(nomeTerritorio) == true) {
				c = getColorJava(listaTerritorios[i].getCorExercito());
				return c; 
			}
		}
		return c;		
		
	}	
	
	public String[] getListaTerritoriosString(int posJogAlvo) {
		
		Territorio[] T = listaJogadores[posJogAlvo].getListaTerritorios();
		String []S = new String[listaJogadores[posJogAlvo].getnumTerritoriosJog()];
		for(int i=0;i< S.length;i++) {
			if (T[i] != null) {
				S[i] = T[i].getNomeTerritorio();
			}
		}
		
		return S;
		
	}
	
	public void adicionaExercitoTerritorio(int qtd, String territorioAlvo) {

		for(int i=0;i<listaTerritorios.length;i++) {
			if(listaTerritorios[i].getNomeTerritorio().equals(territorioAlvo)==true) {
				listaTerritorios[i].setNumExercitos(listaTerritorios[i].getnumExercitos()+qtd);
				break;
			}
		}
		
	}
	
	public boolean DeslocaExercitos(String territorioDoador, String territorioRecebedor, int qtdExRetirar) {
		
		// Verifica se o deslocamento pode ser feito //
		if (verificaDeslocamento(territorioDoador,territorioRecebedor)==false) {
			System.out.println("Não passou por VerificaDeslocamento!");
			return false;
		}
		
		for(int i=0;i<listaTerritorios.length;i++) {
			// Retira os Exércitos do Doador //
			if(listaTerritorios[i].getNomeTerritorio().contentEquals(territorioDoador)==true) {
				listaTerritorios[i].setNumExercitos(listaTerritorios[i].getnumExercitos()-qtdExRetirar);
			}
			// Coloca os Exércitos no Recebedor //
			if(listaTerritorios[i].getNomeTerritorio().contentEquals(territorioRecebedor)==true) {
				listaTerritorios[i].setNumExercitos(listaTerritorios[i].getnumExercitos()+qtdExRetirar);
			}
		}
		
		return true;
		
	}
	
	public String distribuiCartaBonus(int jogAlvo ) {
		String Carta[] = Cartas.getCartas().getCartaBonus();
		if( Carta[0] == null || Carta[1] == null) {
			System.out.println("Erro ao retirar carta bonus");
			return null;
		}
		listaJogadores[jogAlvo].setUmaCarta(Carta[0], Carta[1]);
		
		return Carta[0];		
		
	}
	
	 
	// Troca de Cartas por Exercitos //
	public int realizaTrocaCartas(int jogAlvo) {
		
		int qtdQuadrado = 0;
		int qtdTriangulo = 0;
		int qtdCirculo = 0;
		int qtdCoringa = 0;
		int exBonus = 0;
		int numTrocas = Cartas.getCartas().getNumTrocas();		
		
		String NomesCartas[] = listaJogadores[jogAlvo].getCartas();
		String Figuras[] = listaJogadores[jogAlvo].getFiguras();
		
		
		Territorio T[] = listaJogadores[jogAlvo].getListaTerritorios();
		
		for(int i=0; i < T.length;i++) {
			if (T[i]!=null) {
				for(int j=0;j<NomesCartas.length;j++) {
					if (NomesCartas[j] !=null) {
						if (T[i]!=null)
						if(T[i].getNomeTerritorio().equals(NomesCartas[j]) == true) {
							System.out.println("O Jogador Possui a carta e o territorio "+NomesCartas[j]);
							exBonus = exBonus + 2;
						}
					}
				}
			}
		}
		
		switch(numTrocas) {
		case 1: exBonus = exBonus + 4;
		case 2: exBonus = exBonus + 6;
		case 3: exBonus = exBonus + 8;
		case 4: exBonus = exBonus + 10;
		case 5: exBonus = exBonus + 12;
		case 6: exBonus = exBonus + 15;
		case 7: exBonus = exBonus + 12;
		case 8: exBonus = exBonus + 15;
		}
		
		if (numTrocas>8) {
			exBonus = exBonus + 25 + ((numTrocas-8)*10);
		}
		
		
		
		for (int i=0; i <Figuras.length;i++) {
			if (Figuras[i] != null) {
				if(Figuras[i].contentEquals("Quadrado")==true) {
					qtdQuadrado++;
				}
				if(Figuras[i].contentEquals("Triangulo")==true) {
					qtdTriangulo++;
				}
				if(Figuras[i].contentEquals("Circulo")==true) {
					qtdCirculo++;
				}
				if(Figuras[i].contentEquals("Coringa")==true) {
					qtdCoringa++; 
				}
			}
		}
		
		
		// 3 figuras diferentes sem Coringa//
		if (qtdQuadrado > 0 && qtdTriangulo > 0 && qtdCirculo >0) {		
			
			System.out.println("O Jogador possui 3 cartas com figuras diferentes!");
			
			for(int i = 0 ; i < 5; i++) {
				if(Figuras[i].contentEquals("Quadrado")==true) {
					listaJogadores[jogAlvo].retiraCartaBonus(NomesCartas[i]);
					break;
				}
			}
			for(int i = 0 ; i < 5; i++) {
				if(Figuras[i].contentEquals("Triangulo")==true) {
					listaJogadores[jogAlvo].retiraCartaBonus(NomesCartas[i]);
					break;
				}
			}
			for(int i = 0 ; i < 5; i++) {
				if(Figuras[i].contentEquals("Circulo")==true) {
					listaJogadores[jogAlvo].retiraCartaBonus(NomesCartas[i]);
					break;
				}
			}
			
			return exBonus;			
		}
		
		// 3 cartas com quadrado //
		if(qtdQuadrado > 2  ) {

			System.out.println("O jogador possui 3 cartas com quadrado");
			int cont = 0;
			
			for (int i=0;i<5;i++) {
				if (cont ==3) {
					break;
				}
				else if(Figuras[i].contentEquals("Quadrado")==true) {
					listaJogadores[jogAlvo].retiraCartaBonus(NomesCartas[i]);
					cont++;
				}
			}
			return exBonus;	
		}
		
		// 3 cartas com triangulo //
		if(qtdTriangulo > 2  ) {
			System.out.println("O jogador possui 3 cartas com triangulo");

			int cont = 0;
			
			for (int i=0;i<5;i++) {
				if (cont ==3) {
					break;
				}
				else if(Figuras[i].contentEquals("Triangulo")==true) {
					listaJogadores[jogAlvo].retiraCartaBonus(NomesCartas[i]);
					cont++;
				}
			}
			return exBonus;	
		}
		
		// 3 cartas com Circulo //
		if(qtdTriangulo > 2  ) {
			System.out.println("O jogador possui 3 cartas com circulo");

			int cont = 0;
			
			for (int i=0;i<5;i++) {
				if (cont ==3) {
					break;
				}
				else if(Figuras[i].contentEquals("Circulo")==true) {
					listaJogadores[jogAlvo].retiraCartaBonus(NomesCartas[i]);
					cont++;
				}
			}
			return exBonus;	
			
		}
		
		// 2 Quadrados e um coringa //
		if (qtdQuadrado == 2 && qtdCoringa == 1) {
			System.out.println("O jogador possui 2 cartas com quadrado e um coringa");

			int cont =0;
			
			for (int i=0;i<5;i++) {
				if (cont == 2) {
					break;
				}
				else if(Figuras[i].contentEquals("Quadrado")==true) {
					listaJogadores[jogAlvo].retiraCartaBonus(NomesCartas[i]);
					cont++;
				}
			}
			
			for (int i=0;i<5;i++) {
				if (Figuras[i].contentEquals("Coringa")==true) {
					listaJogadores[jogAlvo].retiraCartaBonus(NomesCartas[i]);
					break;
				}
			}
			
			return exBonus;			
			
		}
		
		// 2 triangulos e 1 Coringa //
		if (qtdTriangulo == 2 && qtdCoringa == 1) {
			System.out.println("O jogador possui 2 cartas com triangulo e um coringa");

			int cont =0;
			
			for (int i=0;i<5;i++) {
				if (cont == 2) {
					break;
				}
				else if(Figuras[i].contentEquals("Triangulo")==true) {
					listaJogadores[jogAlvo].retiraCartaBonus(NomesCartas[i]);
					cont++;
				}
			}
			
			for (int i=0;i<5;i++) {
				if (Figuras[i].contentEquals("Coringa")==true) {
					listaJogadores[jogAlvo].retiraCartaBonus(NomesCartas[i]);
					break;
				}
			}
			
			return exBonus;
			
		}
		
		// 2 Circulos e 1 Coringa //
		if (qtdTriangulo == 2 && qtdCoringa == 1) {
			System.out.println("O jogador possui 2 cartas com circulo e um coringa");

			int cont =0;
			
			for (int i=0;i<5;i++) {
				if (cont == 2) {
					break;
				}
				else if(Figuras[i].contentEquals("Circulo")==true) {
					listaJogadores[jogAlvo].retiraCartaBonus(NomesCartas[i]);
					cont++;
				}
			}
			
			for (int i=0;i<5;i++) {
				if (Figuras[i].contentEquals("Coringa")==true) {
					listaJogadores[jogAlvo].retiraCartaBonus(NomesCartas[i]);
					break;
				}
			}
			
			return exBonus;
			
		}
		
		
		
		
		return 0;
		
		
		
		
		
	} 
	
	public int getQtdCartasBonusJogador(int jogAlvo) {
		return listaJogadores[jogAlvo].getQtdCartasBonus();
	}
	
	
	////////////////////////////////////
	////////////////////////////////////
	
	
	// Métodos para o Controller //
	
	
	
	public static Acoes getAcoes() {
		if( ctrl == null) {
			ctrl = new Acoes();
		}
		
		return ctrl;
	} 	
	
	// Verifica se o jogo pode ser iniciado, se sim inicia //
	public boolean inicializaJogo() {

		
		if(nomes[0]==null) {
			System.out.println("Erro ao receber os nomes dos Jogadores pela View!");
			return false;
		}
		if(cores[0]==null) {
			System.out.println("Erro ao receber as cores dos Jogadores pela View!");
			return false;
		}
		
		listaTerritorios = InicializaComponentes.getInicializaComponentes().inicializaTerritorios(listaTerritorios);	
		if(listaTerritorios[0].getNomeTerritorio() == null) {
			System.out.println("Erro ao inicializar os territórios!");
			return false; 
		}
		
		Continentes = InicializaComponentes.getInicializaComponentes().defineContinentes(listaTerritorios);
		if(Continentes[0].getNomeContinente() == null) {
			System.out.println("Erro ao inicializar os Continentes!");
			return false; 
		}
		
		listaJogadores = InicializaComponentes.getInicializaComponentes().defineJogadores(nomes, cores);
		if(listaJogadores[0].getnomeJogador() == null) {
			System.out.println("Erro ao inicializar os Jogadores!");
			return false;
		}
		
		Exercitos = InicializaComponentes.getInicializaComponentes().defineExercitos(listaJogadores);
		if(Exercitos[0].getCorExercito() == null) {
			System.out.println("Erro ao inicializar os Donos dos Exércitos!");
			return false;
		}
		
		listaJogadores = InicializaComponentes.getInicializaComponentes().defineDonoTerritorios(listaJogadores, listaTerritorios, Exercitos, C);
		if (listaJogadores[0].getListaTerritorios()[0].getNomeTerritorio() == null) {
			System.out.println("Erro ao inicializar os Donos dos territórios!");
			return false;
		}
		
		Objetivos = InicializaComponentes.getInicializaComponentes().defineDonoObjetivos(listaJogadores, Objetivos, C);
		for (int i=0;i<listaJogadores.length;i++) {
			if(listaJogadores[i].getObjetivo()==null) {
				System.out.println("Erro ao inicializar os Donos dos objetivos! Jogador sem objetivo!!");
				return false;
			}
		}
		
		Cartas.getCartas().inicializaCartasBonus();
		
			
		return true;		 
	}


	
	public int recebeExercitos(String jogadorAlvo) {
		
		int posJog = 0;
		int qtdExReceber = 0;
		int qtdmatchs = 0; // quantidade de territorios que o jogador possui no continente
		Territorio[] lstTerritorioCont;
		
		for (int i=0;i<listaJogadores.length;i++) {
			if(listaJogadores[i].getnomeJogador().contentEquals(jogadorAlvo)==true) {
				posJog=i;
				break;
			}
		}
		
		qtdExReceber = listaJogadores[posJog].getnumTerritoriosJog()/2;
		
		Territorio []lstTerritoriosJogador = listaJogadores[posJog].getListaTerritorios();
		
		// Verifica a posse de continentes //
		
		for(int i=0;i<Continentes.length;i++) {
			lstTerritorioCont = new Territorio[Continentes[i].getNumTerritorios()];
			lstTerritorioCont = Continentes[i].getTerritoriosContinente();
			for (int j=0; j < lstTerritorioCont.length;j++) {
				for(int k=0; k <listaJogadores[posJog].getnumTerritoriosJog();k++) {
					if(lstTerritoriosJogador[k] != null) {
						if(lstTerritorioCont[j].getNomeTerritorio().contentEquals(lstTerritoriosJogador[k].getNomeTerritorio())==true) {
							qtdmatchs = qtdmatchs + 1;
						}
					}
				}
			}
			// Verifica se possui todos os territórios do continente //
			if(lstTerritorioCont.length == qtdmatchs) {
				switch(Continentes[i].getNomeContinente()) {
					case "America do Norte": qtdExReceber = qtdExReceber+5;break;
					case "America do Sul": qtdExReceber = qtdExReceber+2;break;
					case "Africa": qtdExReceber = qtdExReceber+3;break;
					case "Europa": qtdExReceber = qtdExReceber+5;break;
					case "Asia": qtdExReceber = qtdExReceber+7;break;
					case "Oceania": qtdExReceber = qtdExReceber+2;break;
				}
			}
			qtdmatchs = 0;
		}
		
		// Encontra o Exército do Jogador e incrementa//
		for(int i=0;i<Exercitos.length;i++) {
			if(Exercitos[i].getCorExercito().equals(listaJogadores[posJog].getColor())==true) {
				Exercitos[i].setQTDExercito(Exercitos[i].getQTDExercito()+qtdExReceber);
				break;
			}			
		}
		
		// Adiciona exércitos para o jogador //
		listaJogadores[posJog].setNumExercitos(listaJogadores[posJog].getNumExercitos()+qtdExReceber);
		
		return qtdExReceber;
	}		
		
	// O resultado dos dados devem estar setados //
	// Realiza o ataque e caso seja bem sucedido, desloca as tropas //
	public boolean realizaAtaque(String TerritorioAtk, String TerritorioDef, String corJogadorAtk ) {
		
		int posTerritorioDef=0;
		int posTerritorioAtk=0;
		int posJogAtk = 0;
		int posJogDef = 0;
		
		if (validaAtaque(TerritorioAtk,TerritorioDef,corJogadorAtk) == false) {
			System.out.println("O ataque não foi validado");
			return false;
		}
		
		int[] resultado = comparaDados(DadoAtk,DadoDef);
		
		int ExercitosARetirarAtk =  resultado[1];
		int ExercitosARetirarDef =  resultado[2];
		
		
		
		// Encontra a posicao dos territórios //
		for(int i=0;i<listaTerritorios.length;i++) {
			if(listaTerritorios[i].getNomeTerritorio().contentEquals(TerritorioDef) == true) {
				posTerritorioDef = i;
			}
			if(listaTerritorios[i].getNomeTerritorio().contentEquals(TerritorioAtk) == true) {
				posTerritorioAtk = i;
			}			
		}
		// Retira os Exércitos mortos em batalha dos territórios //
		listaTerritorios[posTerritorioAtk].setNumExercitos(listaTerritorios[posTerritorioAtk].getnumExercitos()-ExercitosARetirarAtk);
		listaTerritorios[posTerritorioDef].setNumExercitos(listaTerritorios[posTerritorioDef].getnumExercitos()-ExercitosARetirarDef);

		

		
		// Ataque conquistou o território //
		if ( resultado[0] == 1) {
			ControlaJogo.getControlaJogo().setConquistouTerritorio(1);
			
			
			
			
			for(int i=0;i<listaJogadores.length;i++) {
				// Jogador atacante //
				if(listaJogadores[i].getColor().contentEquals(corJogadorAtk)==true){
					posJogAtk = i;
				}
				// Jogador defensor //
				if (listaTerritorios[posTerritorioDef].getdonoTerritorio().contentEquals(listaJogadores[i].getnomeJogador())==true) {
					posJogDef= i;
				}
			}
			
			// Troca o dono do Território //
			listaTerritorios[posTerritorioDef].setdonoTerritorio(listaJogadores[posJogAtk].getnomeJogador());
			// Muda a cor do Exército no território Defensor //
			listaTerritorios[posTerritorioDef].setCorExercito(corJogadorAtk);
			// Move a maior quantidade possível de exércitos para o território //
			listaTerritorios[posTerritorioDef].setNumExercitos((listaTerritorios[posTerritorioAtk].getnumExercitos()-1));
			listaTerritorios[posTerritorioAtk].setNumExercitos(1);
			
			System.out.println("ATAQUE GANHOU");
			
			// Jogador atacante //
			// Adiciona 1 Território ao total do jogador //
			listaJogadores[posJogAtk].setnumTerritoriosJog(listaJogadores[posJogAtk].getnumTerritoriosJog()+1);
			System.out.println("TERRITORIOS DO JOG DPS DO ATK: "+listaJogadores[posJogAtk].getnumTerritoriosJog());
			// Retira os exércitos mortos em batalha da posse do jogador //
			listaJogadores[posJogAtk].setNumExercitos(listaJogadores[posJogAtk].getNumExercitos()-ExercitosARetirarAtk);
			// Coloca o território ganho na lista de Territórios do Jogador //
			listaJogadores[posJogAtk].setUmTerritorio(listaTerritorios[posTerritorioDef]);
					
				
			// Jogador defensor //
			// Retira 1 Território ao total do jogador //
			listaJogadores[posJogDef].setnumTerritoriosJog(listaJogadores[posJogDef].getnumTerritoriosJog()-1);
			// Retira os exércitos mortos em batalha da posse do jogador //
			listaJogadores[posJogDef].setNumExercitos(listaJogadores[posJogDef].getNumExercitos()-ExercitosARetirarDef);
			// Retira o território da lista de Territórios do Jogador //
			listaJogadores[posJogDef].retiraTerritorio(listaTerritorios[posTerritorioDef]);
				
			if(verificaAtingiuObjetivo(listaJogadores[posJogAtk].getnomeJogador())==true) {
				ControlaJogo.getControlaJogo().setGanhou(1);
			}

		}
		else {
			System.out.println("DEFESA GANHOU");
		}
		
		// Diminui o número de Exércitos dos Jogadores se necessário //
		for(int i=0;i<Exercitos.length;i++) {
			if(listaJogadores[posJogAtk].getColor().contentEquals(Exercitos[i].getCorExercito())==true) {
				Exercitos[i].setQTDExercito(Exercitos[i].getQTDExercito()-ExercitosARetirarAtk);
			}
			if(listaJogadores[posJogDef].getColor().contentEquals(Exercitos[i].getCorExercito())==true) {
				Exercitos[i].setQTDExercito(Exercitos[i].getQTDExercito()-ExercitosARetirarDef);
			}			
		}
		// Atualiza os Observadores //
		atualiza();
		return true;
		
	}
	
	
	public boolean verificaAtingiuObjetivo(String Jogador) {
		
		System.out.println("Verificando objetivos do jogador: "+Jogador);
		
		Objetivo O = new Objetivo();
		int posJog = 0;
		
		for(int i=0;i<listaJogadores.length;i++) {
			if(listaJogadores[i].getnomeJogador().contentEquals(Jogador)==true) {
				O = listaJogadores[i].getObjetivo();
				posJog = i;
				break;
			}
		}
		
		System.out.println("Destruir o exército: "+O.getExercitos());
		if(O.getContinentes()!=null) {
			String []tempC = O.getContinentes(); 
			System.out.println("Continentes: "+tempC[0]+" e "+tempC[1]);
		}
		System.out.println("Conquistar um total de "+O.getTerritorios()+" territorios");
		
		
		
		// Verifica se o jogador possui a quantidade necessária de territórios //
		if(listaJogadores[posJog].getnumTerritoriosJog() < O.getTerritorios()) {
			System.out.println("O Jogador ainda não conquistou a quantidade de territórios necessárias, Total: "+listaJogadores[posJog].getnumTerritoriosJog());
			return false;
		}
		
		//  Verifica se o Exército alvo foi destruído //
		for (int i=0;i<Exercitos.length;i++) {
			if(Exercitos[i].getCorExercito().contentEquals(O.getExercitos())==true) {
				
				if (Exercitos[i].getQTDExercito() > 0) {
					return false;
				}
			}
			
		}
		
		
		Territorio T[] = listaJogadores[posJog].getListaTerritorios();
		
		// Implementar a conquista de Continentes //
		
		
		int contador = 0;

		String Cont [] = O.getContinentes();
		
		Territorio AS[] = null;
		Territorio AN[] = null;
		Territorio EU[] = null;
		Territorio ASA[] = null;
		Territorio OC[] = null;
		Territorio AF[] = null;
		
		for (int i=0; i<Continentes.length;i++) {
			switch(Continentes[i].getNomeContinente()) {
			case "America do Sul": 
				AS = new Territorio[Continentes[i].getNumTerritorios()];
				AS = Continentes[i].getTerritoriosContinente();
			case "America do Norte":
				AN = new Territorio[Continentes[i].getNumTerritorios()];
				AN = Continentes[i].getTerritoriosContinente();
			case "Europa":
				EU = new Territorio[Continentes[i].getNumTerritorios()];
				EU = Continentes[i].getTerritoriosContinente();
			case "Asia": 
				ASA = new Territorio[Continentes[i].getNumTerritorios()];
				ASA = Continentes[i].getTerritoriosContinente();
			case "Oceania": 
				OC = new Territorio[Continentes[i].getNumTerritorios()];
				OC = Continentes[i].getTerritoriosContinente();
			case "Africa": 
				AF = new Territorio[Continentes[i].getNumTerritorios()];
				AF = Continentes[i].getTerritoriosContinente();
			}
		}
		if(Cont!=null) {
			 for (int i=0;i<Cont.length;i++) {
				 System.out.println("Verificando se o jogador possui o continente: "+Cont[i]);
				 if(Cont[i].contentEquals("America do Sul")==true) {
					 for(int j=0;j<AS.length;j++) {
						 for(int k=0;k<T.length;k++) {
							 if (T[k]!=null) {
								 if(AS[j].getNomeTerritorio().contentEquals(T[k].getNomeTerritorio())==true) {
									 contador++;
								 }
							 }
						 }
					 }
					 
					 if (contador != 4) {
						 System.out.println("O Jogador nao possui todos os territorios da America do Sul");
						 return false;
					 }
					 contador = 0;
				 }
					 
				 if(Cont[i].contentEquals("America do Norte")==true){
					 for(int j=0;j<AN.length;j++) {
						 for(int k=0;k<T.length;k++) {
							 if (T[k]!=null) {
								 if(AN[j].getNomeTerritorio().contentEquals(T[k].getNomeTerritorio())==true) {
									 contador++;
								 }
							 }
						 }
					 }
					 
					 if (contador != 9) {
						 System.out.println("O Jogador nao possui todos os territorios da America do Norte");
						 return false;
					 }
					 contador = 0;
				 }
				 if(Cont[i].contentEquals("Europa")==true) {
					 for(int j=0;j<EU.length;j++) {
						 for(int k=0;k<T.length;k++) {
							 if (T[k]!=null) {
								 if(EU[j].getNomeTerritorio().contentEquals(T[k].getNomeTerritorio())==true) {
									 contador++;
								 }
							 }
						 }
					 }
					 
					 if (contador != 8) {
						 System.out.println("O Jogador nao possui todos os territorios da Europa");
						 return false;
					 }
					 contador = 0;
				 } 
				 if(Cont[i].contentEquals("Asia")==true){
					 for(int j=0;j<ASA.length;j++) {
						 for(int k=0;k<T.length;k++) {
							 if (T[k]!=null) {
								 if(ASA[j].getNomeTerritorio().contentEquals(T[k].getNomeTerritorio())==true) {
									 contador++;
								 }
							 }
						 }
					 }
					 
					 if (contador != 20) {
						 System.out.println("O Jogador nao possui todos os territorios da Asia");
						 return false;
					 }
					 contador = 0;
				 }
				 if(Cont[i].contentEquals("Oceania")==true) {
					 for(int j=0;j<OC.length;j++) {
						 for(int k=0;k<T.length;k++) {
							 if (T[k]!=null) {
								 if(OC[j].getNomeTerritorio().contentEquals(T[k].getNomeTerritorio())==true) {
									 contador++;
								 }
							 }
						 }
					 }
					 
					 if (contador != 4) {
						 System.out.println("O Jogador nao possui todos os territorios da Oceania");
						 return false;
					 }
					 contador = 0;
				 }
				 if(Cont[i].contentEquals("Africa")==true) {
					 for(int j=0;j<AF.length;j++) {
						 for(int k=0;k<T.length;k++) {
							 if(T[k]!=null) {
								 if(AF[j].getNomeTerritorio().contentEquals(T[k].getNomeTerritorio())==true) {
									 contador++;
								 }
							 }
						 }
					 }
					 
					 if (contador != 6) {
						 System.out.println("O Jogador nao possui todos os territorios da Africa");
						 return false;
					 }
					 contador = 0;
				 }
			 }
		}
			
		
		
		return true;
	}
	
	
	// int [0] = vencedor (1,2)
	// int [1] = quantidade de ex perdido pelo atk
	// int [2] = quantidade de ex perdido pelo def
	public int[] comparaDados(int[] DadoAtk,int[] DadoDef) {
		
		
		int qtdDadoAtk = 0;
		int qtdDadoDef = 0;
		// resultado [0] = vencedor (1,2)
		// resultado [1] = quantidade de ex perdido pelo atk
		// resultado [2] = quantidade de ex perdido pelo def
		int [] resultado = new int[3];
		
		for(int i=0;i<3;i++) {
			if (DadoAtk[i] != 0) {
				qtdDadoAtk = qtdDadoAtk + 1;
			}
			if (DadoDef[i] != 0) {
				qtdDadoDef = qtdDadoDef + 1;
			}
		}
		
		// 1 ATK Vs 1 DEF //
		if (qtdDadoAtk==1 && qtdDadoDef ==1) {
			if (DadoAtk[0] > DadoDef[0]) {
				resultado[0] = 1;
				resultado[1] = 0;
				resultado[2] = 1;
				return resultado;
			}
			else {
				resultado[0] = 2;
				resultado[1] = 1;
				resultado[2] = 0;
				return resultado;
			}
		}
		// 1 Atk VS 2 DEF //
		if (qtdDadoAtk==1 && qtdDadoDef ==2) {
			if (DadoAtk[0] > DadoDef[0]) {
				// Venceu os dois dados da defesa //
				if (DadoAtk[0] > DadoDef[1]) {
					resultado[0] = 1;
					resultado[1] = 0;
					resultado[2] = 2;
					return resultado;
				}
				// Ganhou 1 mas perdeu 1, defesa vence mas perde um exército //
				else {
					resultado[0] = 2;
					resultado[1] = 1;
					resultado[2] = 1;
					return resultado;
				}
				
			}
			// Perdeu no primeiro dado //
			else {
				resultado[0] = 2;
				resultado[1] = 1;
				resultado[2] = 0;
				return resultado;
			}
		}
		
		
		
		// 1 Atk VS 3 DEF //
		if (qtdDadoAtk==1 && qtdDadoDef ==3) {
			if (DadoAtk[0] > DadoDef[0]) {
				// Venceu os dois dados da defesa //
				if (DadoAtk[0] > DadoDef[1]) {
					// Venceu os 3 dados da defesa //
					if (DadoAtk[0] > DadoDef[2]) {
						resultado[0] = 1;
						resultado[1] = 0;
						resultado[2] = 3;
						return resultado;
					}
					// Venceu os 2 dados da defesa mas perdeu 1 //
					else {
						resultado[0] = 2;
						resultado[1] = 1;
						resultado[2] = 2;
						return resultado;
					}
				}
				// Ganhou 1 mas perdeu 1, defesa vence mas perde um exército //
				else {
					resultado[0] = 2;
					resultado[1] = 1;
					resultado[2] = 1;
					return resultado;
				}
				
			}
			// Perdeu no primeiro dado //
			else {
				resultado[0] = 2;
				resultado[1] = 1;
				resultado[2] = 0;
				return resultado;
			}
		}
		
		// 2 Atk VS 1 DEF //
		if (qtdDadoAtk==2 && qtdDadoDef ==1) {
			if (DadoAtk[0] > DadoDef[0]) {
				resultado[0] = 1;
				resultado[1] = 0;
				resultado[2] = 1;
				return resultado;
			}
			else {
				if (DadoAtk[1]>DadoDef[0]) {
					resultado[0] = 1;
					resultado[1] = 1;
					resultado[2] = 1;
					return resultado;
				}
				// Perdeu nos dois dados //
				else {
					resultado[0] = 2;
					resultado[1] = 2;
					resultado[2] = 0;
					return resultado;
				}
				
			}
		}
				
		// 2 Atk VS 2 DEF //
		if (qtdDadoAtk==2 && qtdDadoDef ==2) {
			if (DadoAtk[0] > DadoDef[0]) {
				// ATK Ganhou os dois //
				if(DadoAtk[1] > DadoDef[1]) {
					resultado[0] = 1;
					resultado[1] = 0;
					resultado[2] = 2;
					return resultado;
				}
				// ATK Ganhou 1 e perdeu 1 //
				else {
					resultado[0] = 2;
					resultado[1] = 1;
					resultado[2] = 1;
					return resultado;
				}
				
			}
			// Perdeu no primeiro Dado //
			else {
					resultado[0] = 2;
					resultado[1] = 1;
					resultado[2] = 0;
					return resultado;
			}	
		}
		
		
		// 2 Atk VS 3 DEF //
		if (qtdDadoAtk==2 && qtdDadoDef ==3) {
			if (DadoAtk[0] > DadoDef[0]) {
				// ATK Ganhou os 2 //
				if(DadoAtk[1] > DadoDef[1]) {
					if (DadoAtk[1] > DadoDef[2]) {
						resultado[0] = 1;
						resultado[1] = 0;
						resultado[2] = 3;
						return resultado;
					}
					// ATK ganhou 2 dados e perdeu 1 //
					else {
						resultado[0] = 1;
						resultado[1] = 1;
						resultado[2] = 3;
						return resultado;
					}
					
				}
				// ATK ganhou 1 e DEF perdeu 1 //
				else {
						resultado[0] = 2;
						resultado[1] = 1;
						resultado[2] = 1;
						return resultado;
				}
					
			}
		}
			
				
		// 3 Atk VS 1 DEF //
		if (qtdDadoAtk==3 && qtdDadoDef ==1) {
			if (DadoAtk[0] > DadoDef[0]) {
				resultado[0] = 1;
				resultado[1] = 0;
				resultado[2] = 1;
				return resultado;
			}
			
			else {
				if (DadoAtk[1] > DadoDef[0]) {
					resultado[0] = 1;
					resultado[1] = 1;
					resultado[2] = 1;
					return resultado;
				}
				else {
					// ATK perdeu os 2 ataques //
					if (DadoAtk[2] > DadoDef[0]) {
						resultado[0] = 1;
						resultado[1] = 2;
						resultado[2] = 1;
						return resultado;
					}
					// ATK perdeu os 3 ataques //
					else {
						resultado[0] = 2;
						resultado[1] = 3;
						resultado[2] = 0;
						return resultado;
						
					}
				}
			}
		}
		
		// 3 Atk VS 2 DEF //
		if (qtdDadoAtk==3 && qtdDadoDef ==2) {
			if (DadoAtk[0] > DadoDef[0]) {
				if (DadoAtk[1] > DadoDef[1]) {
					resultado[0] = 1;
					resultado[1] = 0;
					resultado[2] = 2;
					return resultado;
				}
				else {
					if (DadoAtk[2] > DadoDef[1]) {
						resultado[0] = 1;
						resultado[1] = 1;
						resultado[2] = 1;
						return resultado;
					}
					else {
						resultado[0] = 2;
						resultado[1] = 2;
						resultado[2] = 1;
						return resultado;
					}
				}
			}
			
			else {
				if (DadoAtk[1] > DadoDef[0]) {
					if (DadoAtk[2] > DadoDef[1]) {
						resultado[0] = 1;
						resultado[1] = 1;
						resultado[2] = 2;
						return resultado;
					}
					else {
						resultado[0] = 2;
						resultado[1] = 2;
						resultado[2] = 1;
						return resultado;
					}
				}
				else {
					// ATK perdeu os 2 ataques //
					if (DadoAtk[2] > DadoDef[0]) {
						resultado[0] = 2;
						resultado[1] = 2;
						resultado[2] = 1;
						return resultado;
					}
					// ATK perdeu os 3 ataques //
					else {
						resultado[0] = 2;
						resultado[1] = 3;
						resultado[2] = 0;
						return resultado;
						
					}
				}
			}
		}
		
		
		// 3 Atk VS 3 DEF //
		if (qtdDadoAtk==3 && qtdDadoDef ==3) {
			if (DadoAtk[0] > DadoDef[0]) {
				if (DadoAtk[1] > DadoDef[1]) {
					if (DadoAtk[2] > DadoDef[2]) {
						resultado[0] = 1;
						resultado[1] = 0;
						resultado[2] = 3;
						return resultado;
					}
					else {
						resultado[0] = 1;
						resultado[1] = 1;
						resultado[2] = 3;
						return resultado;
					}
				}
				else {
					if (DadoAtk[2] > DadoDef[2]) {
						resultado[0] = 1;
						resultado[1] = 1;
						resultado[2] = 3;
						return resultado;
					}
					else {
						resultado[0] = 2;
						resultado[1] = 2;
						resultado[2] = 1;
						return resultado;
					}
				}
			}
			
			
			else {
				if (DadoAtk[1] > DadoDef[1]) {
					if (DadoAtk[2] > DadoDef[2]) {
						resultado[0] = 1;
						resultado[1] = 1;
						resultado[2] = 3;
						return resultado;
					}
					else {
						if (DadoAtk[2] > DadoDef[0]) {
							resultado[0] = 2;
							resultado[1] = 2;
							resultado[2] = 1;
							return resultado;
						}
					}
				}
				else {
					// ATK perdeu os 2 ataques //
					if (DadoAtk[2] > DadoDef[2]) {
						resultado[0] = 2;
						resultado[1] = 2;
						resultado[2] = 1;
						return resultado;
					}
					// ATK perdeu os 3 ataques //
					else {
						resultado[0] = 2;
						resultado[1] = 3;
						resultado[2] = 0;
						return resultado;
						
					}
				}
			}
		}
		
		return resultado;
		
		
	}
	
		
	public boolean validaAtaque(String TerritorioAtk, String TerritorioDef, String corJogador) {
		
		
		int numT = 0;
		String []Fronteiras;
		
		
		for (int i=0; i <listaTerritorios.length;i++) {
			if(listaTerritorios[i].getNomeTerritorio().contentEquals(TerritorioAtk)==true) {
				numT = i;
				if (listaTerritorios[i].getnumExercitos()<2) {
					System.out.println("Sem exércitos suficientes para realizar o ataque!");
					return false;
				}
				if(listaTerritorios[i].getCorExercito().contentEquals(corJogador)==false) {
					System.out.println("O território atacante não pertence ao jogador!");
					return false;
				}
			}
			if(listaTerritorios[i].getNomeTerritorio().contentEquals(TerritorioDef)==true) {
				if (listaTerritorios[i].getCorExercito().contentEquals(corJogador)==true) {
					System.out.println("O jogador não pode atacar o próprio território!");
					return false;
				}
			}
		}
		
	
		Fronteiras = new String[listaTerritorios[numT].getFronteiras().length];
		Fronteiras = listaTerritorios[numT].getFronteiras();
		
		for (int i=0; i<Fronteiras.length;i++) {
			if(Fronteiras[i]!= null) {
				if(Fronteiras[i].contentEquals(TerritorioDef)==true) {
					return true;
				}
			}
		}
		
		
		System.out.println("Os Territórios não fazem fronteira");
		
		
		return false;
		
	}
		
	public void setDadoAtk(int[] atk) {
		DadoAtk[0] = atk[0];
		DadoAtk[1] = atk[1];
		DadoAtk[2] = atk[2];
	}
	
	public void setDadoDef(int[] def) {
		DadoDef[0] = def[0];
		DadoDef[1] = def[1];
		DadoDef[2] = def[2];
	}
	
	// atk = 1 // Def = 2
	public int getResultadoDado() {
		
		Dado d = new Dado();
		int valor = d.getResultadoDado();			
		
		
		return valor;
		
	}
	
	public String getJogadorAlvo(int posJogador) {
		 return listaJogadores[posJogador].getnomeJogador();
		}
	
	public Territorio[] getListaTerritorios() {
		return listaTerritorios;
	}
	
	private Color getColorJava(String col) {
		Color color = null;
	    switch (col.toLowerCase()) {
	    case "preto":
	        color = Color.BLACK;
	        break;
	        
	    case "azul":
	        color = Color.BLUE;
	        break;
	        
	    case "verde":
	        color = Color.GREEN;
	        break;
	        
	    case "branco":
	        color = Color.WHITE;
	        break;
	        
	    case "amarelo":
	        color = Color.YELLOW;
	        break;
	    case "vermelho":
	        color = Color.RED;
	        break;	    
	        }
	    return color;
	   }
	

	
	public int getQtdExercitosJogador(int posJogAlvo) {
		int qtd = listaJogadores[posJogAlvo].getNumExercitos();
		
		return qtd;
	}
	
	public Exercito[] getListaExercitos() {
		return Exercitos;
	}
	
	public Continente[] getListaContinentes() {
		return Continentes;
	}
	
	public String[][] getObjetivosJogador(String nomeJogador) {
		String o[] = new String[2];
		String c[] = new String[2];
		
		String resposta[][]= new String[2][2];
		
		
		
		for (int i=0; i < Objetivos.length;i++) {
			 // Encontra o Objetivo do jogador //
			if( Objetivos[i].getDonoObjetivo()!= null) {
				if(Objetivos[i].getDonoObjetivo().equals(nomeJogador) == true) {
					if(Objetivos[i].getExercitos()==null) {
						o[0] = "nenhum";
					}
					else {
						o[0]= Objetivos[i].getExercitos();
					}
					
					o[1]= Integer.toString((Objetivos[i].getTerritorios()));
					if(Objetivos[i].getContinentes()!=null) {
						c = Objetivos[i].getContinentes();
											
					}
					resposta[0][0] = o[0];
					resposta[0][1] = o[1];
					resposta[1][0] = c[0];
					resposta[1][1] = c[1];
					return resposta;
				}
				
				
			}
		}
		
		return null;
	}

	private boolean verificaDeslocamento(String nomeTerritorio1,String nomeTerritorio2) {
		
		
		String dono1 = null;
		String dono2 = null;
		String Front[];
		int pos1 = 0;
		
		
		for(int i=0;i<listaTerritorios.length;i++) {
			if(listaTerritorios[i].getNomeTerritorio().contentEquals(nomeTerritorio1)==true) {				
				dono1 = listaTerritorios[i].getdonoTerritorio();
				System.out.println("O Território "+nomeTerritorio1+" pertence ao jogador "+dono1);
				pos1 = i;
			}
			if(listaTerritorios[i].getNomeTerritorio().contentEquals(nomeTerritorio2)==true) {
				dono2 = listaTerritorios[i].getdonoTerritorio();
				System.out.println("O Território "+nomeTerritorio2+" pertence ao jogador "+dono2);
			}
		}
		
		
		
		if(dono1.contentEquals(dono2)==false) {
			System.out.println("Territórios com donos diferentes!");
			return false;
		}
		
		Front = new String[listaTerritorios[pos1].getFronteiras().length];
		Front = listaTerritorios[pos1].getFronteiras();
		for(int i=0; i < Front.length;i++) {
			if(Front[i] !=null) {
				if(Front[i].contentEquals(nomeTerritorio2)==true) {
					System.out.println("O Território "+nomeTerritorio1+" Faz fronteira com o Território "+nomeTerritorio2);
					return true;
				}
			}
		}
		System.out.println("Os Territórios não fazem fronteira");
		
		return false;
		
		
	}

	
	public int[] getOrdemJogadores() {
		int []vetor = new int[listaJogadores.length];
		for(int i=0;i<listaJogadores.length;i++) {
			vetor[i]=listaJogadores[i].getOrdemJogador();
		}
		return vetor;
	}


	public void setNomes(String nm) {
		for (int i=0;i<nomes.length;i++) {
			if(nomes[i]==null) {
				nomes[i]=nm;
				break;
			}
		}

	}
	
	public void setCores(String cr) {

		for( int i=0; i < cores.length; i++) {
			if(cores[i]==null) {
				cores[i]=cr;
				break;
			}
		}
	}
	
	public void setQtdJogadores(int n) {
		qtdJogadores = n;
		nomes = new String[qtdJogadores];
		cores = new String[qtdJogadores];
	}

	public void AtualizaOb() {
		atualiza();
	}
	
	public void eliminaJogador(String jogador) {
		int indice = -1;
		int j=0;
		Jogador[] listaTemp = listaJogadores;
		
		for(int i=0;i<listaJogadores.length;i++) {
			if(listaJogadores[i].getnomeJogador().contentEquals(jogador)==true) {
				indice = i;
				break;
			}
		}
		// Verifica se é o último // 
		if(indice == (listaJogadores.length-1)) {
			listaJogadores = new Jogador[listaJogadores.length-1];
			
			for (int i=0;i<listaJogadores.length;i++) {
				listaJogadores[i] = listaTemp[i];
			}
		}
		
		
		else {
			listaJogadores = new Jogador[listaJogadores.length-1];
			
			for (int i=0;i<listaJogadores.length;i++) {
				if(i == indice) {
					j++;
					listaJogadores[i] = listaTemp[j];
					
				}
				else {
					listaJogadores[i] = listaTemp[j];
					j++;
				}				
			}			
		}
	}
	
	public  void loadData(File f) {
		File file;
		Scanner sc;
		
		for(int i=0;i<Objetivos.length;i++) {
			Objetivos[i].setDonoObjetivo(null);
		}
		for(int i=0;i<listaJogadores.length;i++) {
			listaJogadores[i].setObjetivo(null);
		}
		
		try {
			file = f;
			sc = new Scanner (file);

			int numJogador  = Integer.parseInt(sc.nextLine().replaceAll("\\s",""));
			int atualJog = Integer.parseInt(sc.nextLine().replaceAll("\\s",""));//jogador da vez
			ControlaJogo.getControlaJogo().setDaVez(atualJog); //carrega o jog da vez

			for(int i = 0; i < numJogador; i++)
			{
				String nomeJogador = sc.nextLine().replaceAll("\\s","");
				String corJogador = sc.nextLine().replaceAll("\\s","");
				int numExercitos = Integer.parseInt(sc.nextLine().replaceAll("\\s",""));
				int numTerritorios = Integer.parseInt(sc.nextLine().replaceAll("\\s",""));
				int ordemJogador = Integer.parseInt(sc.nextLine().replaceAll("\\s",""));
				int ObjJogador = Integer.parseInt(sc.nextLine().replaceAll("\\s",""));
				Territorio[] lstTerritoriosJogador = new Territorio[numTerritorios];

				listaJogadores[i].setCor(corJogador); //Edita a cor do jogador.
				listaJogadores[i].setnomeJogador(nomeJogador); //Edita o nome do Jogador.
				listaJogadores[i].setNumExercitos(numExercitos); //Edita o numero de exercitos.
				listaJogadores[i].setnumTerritoriosJog(numTerritorios); //Edita o numero de territorios.
				listaJogadores[i].setordemJogador(ordemJogador); //Edita a ordem do jogador.
				listaJogadores[i].setObjetivo(Objetivos[ObjJogador]); //Edita o objetivo do jogador.
				Objetivos[ObjJogador].setDonoObjetivo(listaJogadores[i].getnomeJogador());
				
				for(int j = 0; j < numTerritorios; j++)
				{
					
					String nomeTerritorio = sc.nextLine().replaceAll("\\s+$","");
					int numExercitosTerritorio = Integer.parseInt(sc.nextLine().replaceAll("\\s",""));
					for (int k =0; k < listaTerritorios.length; k++)
					{
						if (listaTerritorios[k].getNomeTerritorio().contentEquals(nomeTerritorio))
						{
							listaTerritorios[k].setdonoTerritorio(nomeJogador);
							listaTerritorios[k].setNumExercitos(numExercitosTerritorio);
							listaTerritorios[k].setCorExercito(corJogador);
					
							lstTerritoriosJogador[j] = listaTerritorios[k];
						}
					}
					
				}

				listaJogadores[i].setlstTerritorios(lstTerritoriosJogador);
			}
			
			AtualizaOb();
			ControlaView.getInicializaView().atualizaInfosLoad();
			
		}
		catch (FileNotFoundException e) {
            e.printStackTrace();
		}
	}
	
	public void saveGame (File f) throws IOException {
		try (FileWriter fw = new FileWriter (f + ".txt")){
			 fw.write(String.valueOf(listaJogadores.length) + " \r\n"); // Qtd jogadores
			 fw.write(ControlaJogo.getControlaJogo().getJogDaVez() + " \r\n");//jogador da vez, falta salvar.
			 for (int i = 0; i < listaJogadores.length; i++) {
				 fw.write(listaJogadores[i].getnomeJogador() + " \r\n"); // Nome
				 fw.write(listaJogadores[i].getColor() + " \r\n"); //Cor
				 fw.write(String.valueOf(listaJogadores[i].getNumExercitos()) + " \r\n");//numExer
				 fw.write(String.valueOf(listaJogadores[i].getnumTerritoriosJog()) + " \r\n");//numTer
				 fw.write(String.valueOf(listaJogadores[i].getOrdemJogador()) + " \r\n");//ordem
				 
				 for (int k = 0; k < Objetivos.length; k++)
				 {
					 if(listaJogadores[i].getObjetivo() == Objetivos[k])
						 fw.write(String.valueOf(k) + " \r\n"); // indice Obj
				 }
				 
				 
				 
				 for(int j = 0; j < listaJogadores[i].getListaTerritorios().length; j++)
				 {
					 Territorio [] T = listaJogadores[i].getListaTerritorios();
					 if(T[j]!=null) {
						 fw.write(T[j].getNomeTerritorio() + " \r\n");//nomeTer
						 fw.write(String.valueOf(T[j].getnumExercitos()) + " \r\n");//qtdExer
						 }
				 }
			 }
		 }
		catch (FileNotFoundException e) {
	        e.printStackTrace();
			}
		return;}
	
}


