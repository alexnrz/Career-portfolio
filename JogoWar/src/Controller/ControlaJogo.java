package Controller;
//Alex Nascimento Rodrigues 
//Pedro de Aguiar Alves da Silva Menezes

import java.io.File;
import java.io.IOException;

import Model.*;
import View.*;

// Padrão Singleton //
public class ControlaJogo {
	
	
	private static int jogDaVez =0;
	private int conquistouTerritorio = 0;
	private int ganhou=0;

	int qtdJogadores;
	
	
	// Main //
	public static void main(String[] args) {	
		ControlaView.getInicializaView().iniciaPartida();		
	}
	
	private static ControlaJogo ctrl = null;
	
	private ControlaJogo() {}	
	
	public static ControlaJogo getControlaJogo() {
		if ( ctrl ==null) {
			ctrl=new ControlaJogo();
		}
		
		return ctrl;		
		 
	}	
		
	// Passa a Vez do Jogador //
	public void setJogDaVez() {
		
		
		Acoes.getAcoes().AtualizaOb();
		jogDaVez++;
		// Último jogador da rodada //
		if (jogDaVez == qtdJogadores) {
			jogDaVez=0;
		}
		
		
		
	}
	public int getJogDaVez() {
		return jogDaVez;
	}
	public void atualizaOb() {
		Acoes.getAcoes().AtualizaOb();
	}
	
	// Métodos para utilização do Model //	
	public boolean inicializaPartida() {
		boolean resposta;
		
		
		 resposta = Acoes.getAcoes().inicializaJogo();
		
		if ( resposta == false) {
			System.out.println("Erro ao iniciar o jogo no Controller");
		}
		 
		
		return true;
	}
	 
	
	public int recebeEx(int posjogAlvo) {
		
		int qtdEx = Acoes.getAcoes().recebeExercitos(Acoes.getAcoes().getJogadorAlvo(posjogAlvo));
		return qtdEx;
	}
	
	
	
	
	
	// Definições Inicias da partida: Nomes dos jogadores, Cores e 
	// a quantidade de jogadores
	public void setQtdJogadores(int qtd) {
		qtdJogadores = qtd;
		Acoes.getAcoes().setQtdJogadores(qtd);
	}
	

	
	public boolean verificaCoresNomes(String[] cor, String[] nomes) {
		
		boolean a[] = new boolean[cor.length];
		
		for (int i=0;i<cor.length;i++) {
			a[i] = false;
		}
		
		for (int i=0;i<cor.length;i++) {
		
			switch(cor[i]) {
			
			case "preto":
				a[i] =  true;break;
			case "Preto":
				a[i] =  true;break;
				
			case "azul":
				a[i] =  true;break;
			case "Azul":
				a[i] =  true;break;
				
			case "verde":
				a[i] =  true;break;
			case "Verde":
				a[i] =  true;break;
				
			case "branco":
				a[i] =  true;break;
			case "Branco":
				a[i] =  true;break;
				
			case "amarelo":
				a[i] =  true;break;
			case "Amarelo":
				a[i] =  true;break;
				
			case "vermelho":
				a[i] =  true;break;
			case "Vermelho":
				a[i] =  true;break;
				
			}
		}
		
		for (int i=0;i<cor.length;i++) {
			
			if (a[i] == false) {
				return false;
			}
		}
		
		for(int i=0;i<nomes.length;i++) {
			for(int j=0;j<nomes.length;j++) {
				if (i!=j) {
					if(nomes[i].contentEquals(nomes[j])==true) {
						return false;
					}
				}
			}
		}		
		
		
		return true;
	}
	
	// Dados //
	public void setResultadoDados(int Dado1[], int Dado2[]) {
		Acoes.getAcoes().setDadoAtk(Dado1);
		Acoes.getAcoes().setDadoDef(Dado2);
	}
	

	public int getResultadoDado() {
		 
		int Valor =	Acoes.getAcoes().getResultadoDado();
		
		return Valor;
		 
		 
		 
	}
	public void realizaAtaque(String TerritorioAtk, String TerritorioDef, String corJogadorAtk ) {
		Acoes.getAcoes().realizaAtaque(TerritorioAtk, TerritorioDef, corJogadorAtk);
	}
	
	
	public void adicionaExercitosTerritorio(int qtdEx, String territorioAlvo) {
		Acoes.getAcoes().getListaTerritorios();
	}
	
	public boolean verificaAtaque(String territorioAtacante, String territorioDefensor, String corJogAtk) {
		
		if (Acoes.getAcoes().validaAtaque(territorioAtacante, territorioDefensor, corJogAtk)==false) {
			return false;
		}
		
		return true;
	}
	
	public void setConquistouTerritorio(int n) {
		conquistouTerritorio = n;
	}
	public int getConquistouTerritorio() {
		return conquistouTerritorio;
	}
	
	public void setGanhou(int n) {
		ganhou=n;
	}
	
	public boolean getGanhou() {
		if(ganhou==1) {
			return true;			
		}
		else return false;
	}
	
	public void saveGame (File f) throws IOException {
		Acoes.getAcoes().saveGame(f);
	}
	
	public void loadData(File f) {
		Acoes.getAcoes().loadData(f);
	}
	public void setDaVez(int jog) {
        jogDaVez = jog;
    }

}
