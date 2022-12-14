package Model;

class Territorio {

	private String nomeTerritorio;
	private String donoTerritorio;
	private int numExercitos;
	private String corExercito;
	private String Fronteiras[];
	

	
	
	/* Nome Território */
	protected String getNomeTerritorio() {
		return nomeTerritorio;
	}	
	protected void setNomeTerritorio(String n) {
		nomeTerritorio = n;
	}

	
	/* Jogador dono Território */
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
	// Cor do exército nesse território //
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
		
		Fronteiras = new String[Front.length]; // Alocação de espaço para vetor //
		for(int i=0; i < Front.length; i++) {  // 			Testar 				//
			Fronteiras[i]=Front[i];			
		}
	}
	
	
	
	
}
