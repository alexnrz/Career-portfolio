package View;
import Model.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


class CxExibeOrdemJogadores extends JFrame implements ObservadorIF {
	
	private JFrame frame = new JFrame();
	private JButton btNomes[];
	private String[] Nomes = Ctrl.getInstance().registra(this).getNomesJogadores();
	private String[] Cores = Ctrl.getInstance().registra(this).getCoresJogadores();
	
	private static CxExibeOrdemJogadores ctrl = null;
	
	public static CxExibeOrdemJogadores getCxExibeOrdemJogadores() {
		if(ctrl==null) {
			ctrl = new CxExibeOrdemJogadores();
			
		}
		return ctrl;
	}	
	
	private CxExibeOrdemJogadores() {
		frame.setTitle("Ordem dos Jogadores");
		frame.setBounds(200,140, 250, Nomes.length*50);
		frame.setLayout(new GridLayout(Nomes.length,1));
		

		btNomes = new JButton[Nomes.length];
		
		for (int i=0;i<Nomes.length;i++) {
			btNomes[i] = new JButton(i+1+"º  Nome: "+Nomes[i]+" - Cor: "+Cores[i]);
			btNomes[i].setSize(50, 50);
			frame.add(btNomes[i]);
		}	
		
		frame.setVisible(true);
		
	}

	@Override
	public void add(ObservadorIF o) {
		// TODO Auto-generated method stub		
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
	
	@Override
	public void not(ObservadoIF o) {
		
		System.out.println("CxExibeOrdemJogadores notificado");
		
		for (int i=0;i<btNomes.length;i++) {
			frame.remove(btNomes[i]);
		}
		
		
		Nomes = o.getNomesJogadores();
		Cores = o.getCoresJogadores();
		
		for (int i=0;i<Nomes.length;i++) {
			btNomes[i] = new JButton(i+1+"º  Nome: "+Nomes[i]+" - Cor: "+Cores[i]);
			btNomes[i].setSize(50, 50);
			frame.add(btNomes[i]);
		}
		
		frame.validate();
		frame.repaint();

		
	}



}
