package Model;

class Territorio {

	private String nomeTerritorio;
	private String donoTerritorio;
	private int numExercitos;
	private String corExercito;
	private String Fronteiras[];
	

	
	
	/* Nome Territ�rio */
	protected String getNomeTerritorio() {
		return nomeTerritorio;
	}	
	protected void setNomeTerritorio(String n) {
		nomeTerritorio = n;
	}

	
	/* Jogador dono Territ�rio */
	protected String getdonoTerritorio() {
		return donoTerritorio;
	}
	protected void setdonoTerritorio(String donoT) {
		donoTerritorio = donoT;
	}
	
	/* Exercitos */
	protected void setNumExercitos(int num) {
		numExercitos = num;
	}
	protected int getnumExercitos() {
		return numExercitos;
	} 
	// Cor do ex�rcito nesse territ�rio //
	protected void setCorExercito(String cor) {
		corExercito = cor;
	}
	protected String getCorExercito() {
		return corExercito; 
	}
	
	
	/* Fronteiras */
	protected String[] getFronteiras() {
		return Fronteiras;
	}
	
	protected void setFronteiras(String[] Front) {
		
		Fronteiras = new String[Front.length]; // Aloca��o de espa�o para vetor //
		for(int i=0; i < Front.length; i++) {  // 			Testar 				//
			Fronteiras[i]=Front[i];			
		}
	}
	
	
	
	
}
