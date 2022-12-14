package Model;


class Continente {

	private String nomeContinente;
	private int numTerritorios;
	private Territorio []T;
	
	/* Nome Continente */
	protected String getNomeContinente() {
		return nomeContinente;
	}
	protected void setNomeContinente(String nomeC) {
		nomeContinente = nomeC;
	}
	
	
	/* Número de Territórios no Continente */
	protected int getNumTerritorios() {
		return numTerritorios;
	}
	protected void setNumTerritorios(int numT) {
		numTerritorios = numT;
	}
	
	/* Territórios presentes no Continente */
	protected Territorio[] getTerritoriosContinente() {
		return T;
	}
	
	protected void setTerritoriosContinente(Territorio[] Territorios) {
		T = new Territorio[getNumTerritorios()]; // Aloca o vetor de territórios //
		
		for(int i=0; i < getNumTerritorios(); i++) {
			T[i] = Territorios[i];
		}
		
		
	}
	
	
	
	
	
	
}
