package Model;

class Objetivo {
	
	
	private String	donoObjetivo;
	private String[] Continentes;
	private String E; // Cor do Ex�rcito a destruir //
	private int QTDTerritorios;

	
	// Continentes necess�rios para atingir o objetivo //
	protected void setContinentes(String[] Cont) {
		if(Cont != null) {
			Continentes = new String[Cont.length];
		}
		Continentes=Cont;
	}	
	protected String[] getContinentes() {
		return Continentes;
	}
	
	// Territ�rios necess�rios para atingir o objetivo //
	protected void setTerritorios(int T) {
		QTDTerritorios=T;
	}	
	protected int getTerritorios() {
		return QTDTerritorios;
	}
	
	// Defini��o do dono do objetivo na partida //
	protected String getDonoObjetivo() {
		return donoObjetivo;
	}	
	protected void setDonoObjetivo(String nomeJogador) {
		donoObjetivo = nomeJogador;
	}
	
	// Cor do Ex�rcito a destruir //
	protected void setExercitos(String Ex) {
		E = Ex;
	}
	protected String getExercitos() {
		return E;
	}
	
	
	

}
 