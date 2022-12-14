package View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import Model.Ctrl;
import Model.ObservadoIF;
import Model.ObservadorIF;

class CxPerguntaTroca extends JFrame implements ObservadorIF{
	
	private static JFrame frame = new JFrame();
	private static JRadioButton btSim = new JRadioButton("Sim");
	private static JRadioButton btNao = new JRadioButton("Não");
	
	private static CxPerguntaTroca ctrl = null;
	
	public static CxPerguntaTroca getCxPerguntaTroca() {
		
		if(ctrl==null) {
			ctrl = new CxPerguntaTroca();
		}
		else {
			btSim = new JRadioButton("Sim");
			btNao = new JRadioButton("Não");
			btSim.addActionListener((ActionEvent e) -> resposta("Sim"));		
			btNao.addActionListener((ActionEvent e) -> resposta("Nao"));
			frame.add(btSim);
			frame.add(btNao);
		}
		
		frame.repaint();
		frame.setVisible(true);
		
		return ctrl;
	}
	
	private CxPerguntaTroca() {	
		
		frame.setTitle("Troca de Cartas");
		frame.setLayout(new FlowLayout());
		frame.setSize(350,150);
		frame.setBounds(800,400,350,150);
		
		btSim = new JRadioButton("Sim");
		btNao = new JRadioButton("Não");
		btSim.addActionListener((ActionEvent e) -> resposta("Sim"));		
		btNao.addActionListener((ActionEvent e) -> resposta("Nao"));
		btSim.setSize(300, 70);
		btNao.setSize(300, 70);
		frame.add(btSim);
		frame.add(btNao);
		frame.setVisible(true);
		
		
		
		
		
		
	}
	
	private static void resposta(String r) {
		if (r.equals("Sim")==true) {		

			Ctrl.getInstance().registra(CxPerguntaTroca.getCxPerguntaTroca()).realizaTrocaCartas(ControlaView.getInicializaView().getJogAlvo());
			
		}
		
		frame.remove(btSim);
		frame.remove(btNao);
		frame.repaint();
		frame.setVisible(false);

		
		ControlaView.getInicializaView().inicializaControleJogadas(7, ControlaView.getInicializaView().getJogAlvo());
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
		// TODO Auto-generated method stub
		
	}
	
	
	

}
