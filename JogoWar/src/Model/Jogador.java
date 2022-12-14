package Model;

class Jogador {

	private String Color;
	private String nomeJogador;
	private int numExercitos = 0;
	private int numTerritoriosJog = 0;
	private int ordemJogador;
	private Objetivo Ob;
	private Territorio Territorios[] = new Territorio[55];
	private String[] Cartas = new String[40];
	private String[] Figuras = new String[40];
	
	/* Funções referentes à cor do jogador */
	public String getColor() {
		return Color;
	}	
	public void setCor(String sColor) {
		Color = sColor;
	}	
	
	/* Funções referentes ao nome do jogador */
	public String getnomeJogador() {
		return nomeJogador;
	}	
	public void setnomeJogador(String nomeJ) {
		nomeJogador = nomeJ;
	}
	
	/* Funções referentes aos territórios do jogador */
	public int getnumTerritoriosJog() {
		return numTerritoriosJog;
	}	
	public void setnumTerritoriosJog(int num) {
		numTerritoriosJog = num;
	}	
	public Territorio[] getListaTerritorios() {
		return Territorios;
	}
	public void setUmTerritorio(Territorio T) {
		Territorios[getnumTerritoriosJog()]=T;
	}
	
	public void retiraTerritorio(Territorio T) {
		
		for (int i=0;i<Territorios.length;i++) {
			if(Territorios[i]!=null) {
				if( T.getNomeTerritorio().contentEquals(Territorios[i].getNomeTerritorio())==true) {
					Territorios[i] =null;
					break;
				}
			}
		}
		numTerritoriosJog--;
	}
	
	
	/* Funções referentes aos exércitos do jogador */
	public void setNumExercitos(int n) {
		numExercitos = n;
	}
	public int getNumExercitos() {
		return numExercitos;
	}
	
	
	
	/* Funções referentes à ordem do jogador */
	public void setordemJogador (int num){
		ordemJogador =  num;
	}
	public int getOrdemJogador() {
		return ordemJogador;
	}
	
	/* Funções referentes à ordem do jogador */
	public void setObjetivo (Objetivo o){
		Ob = o;
	}	
	public Objetivo getObjetivo ()
	{
		return Ob;
	}
	
	public void setUmaCarta(String C, String F) {
		for(int i=0; i < Cartas.length;i++) {
			if(Cartas[i]==null ) {
				Cartas[i] = C;
				Figuras[i] = F;
				break;
			}
		}
	}
	public String[] getCartas() {
		return Cartas;
	}
	public String[] getFiguras() {
		return Figuras;
	}
	
	public void retiraCartaBonus(String NomeCarta) {
		for(int i=0;i<Cartas.length;i++) {
			if(Cartas[i]!=null) {
				if(Cartas[i].contentEquals(NomeCarta)==true) {
					Cartas[i]=null;
					Figuras[i]=null;
					break;
				}
			}
		}
	}

	public int getQtdCartasBonus() {
		int qtd = 0;
		for(int i=0;i<Cartas.length;i++) {
			if(Cartas[i]!=null) {
				qtd++;
			}
		}
		return qtd;
	}
	protected void setlstTerritorios (Territorio [] lst) {
		numTerritoriosJog=lst.length;
		// Reseta os Teritórios //
		for (int i=0;i<Territorios.length;i++) {
			if(Territorios[i]!=null) {
				Territorios[i] = null;
			}
		}
		
		// Adiciona os novos Territórios //
		for(int i=0;i<lst.length;i++) {
			Territorios[i] = lst[i];
		}
		
	}
	
	
}