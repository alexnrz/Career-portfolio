package Model;

import java.awt.Color;

public interface ObservadoIF {
	
	public void add(ObservadorIF o);
	public void remove(ObservadorIF o);
	
	public int get(int i);
	
	public String[] getNomesJogadores();
	public String[] getCoresJogadores();
	public int getNumExercitos(String nomeTerritorio);
	public String getCorDonoTerritorio(String nomeTerritorio);
	public String[] getListaTerritoriosString(int posJogAlvo);
	public Color getCorTerritorioJava(String nomeTerritorio);
	public void adicionaExercitoTerritorio(int qtd, String territorioAlvo);
	public boolean DeslocaExercitos(String territorioDoador,String territorioRecebedor, int qtdExRetirar);
	public void setCores(String cor);
	public void setNomes(String nm);
	public void setQtdJogadores(int n);
	public String distribuiCartaBonus(int jogAlvo );
	public int realizaTrocaCartas(int jogAlvo);
	public int getQtdCartasBonusJogador(int jogAlvo);

}
