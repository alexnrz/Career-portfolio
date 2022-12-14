package Model;

class Exercito {
	private int qtdExercito;
	private String corExercito;
	private Jogador donoExercito;
	
	
	protected void setQTDExercito(int qtd) {
		qtdExercito = qtd;
	}
	protected int getQTDExercito() {
		return qtdExercito;
	}
	
	
	protected void setCorExercito(String cor) {
		corExercito = cor;
	}
	protected String getCorExercito() {
		return corExercito;
	}
		
	protected void setdonoExercito(Jogador J) {
		donoExercito = J;
	}
	protected Jogador getDonoExercito() {
		return donoExercito;
	}
	
}
