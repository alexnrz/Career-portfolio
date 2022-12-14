package Model;

public class Ctrl {
	
	private static Ctrl ctrl = null;
	
	public static Ctrl getInstance() {
		if(ctrl==null) {
			ctrl = new Ctrl();
		}
		return ctrl;		
	}
	
	public ObservadoIF registra(ObservadorIF o) {
		
		Acoes.getAcoes().add(o);
		
		return Acoes.getAcoes();
	}

}
