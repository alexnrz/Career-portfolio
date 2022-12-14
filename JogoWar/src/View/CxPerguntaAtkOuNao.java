package View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

class CxPerguntaAtkOuNao extends JFrame{

	private static JFrame frame = new JFrame();
	private static JRadioButton btSim = new JRadioButton("Sim");
	private static JRadioButton btNao = new JRadioButton("Não");
	
	private static CxPerguntaAtkOuNao ctrl = null;
	
	public static CxPerguntaAtkOuNao getCxPerguntaAtkOuNao() {
		if (ctrl==null) {
			ctrl = new CxPerguntaAtkOuNao();
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
	
	private CxPerguntaAtkOuNao() {
		
		frame.setTitle("Deseja realizar um Ataque?");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setLayout(new FlowLayout());
		frame.setBounds(800,400,350,150);
		
		
		
		
		
		
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
			frame.remove(btSim);
			frame.remove(btNao);
			frame.repaint();
			frame.setVisible(false);
			ControlaView.getInicializaView().setRespostaAtk("Sim");
			ControlaView.getInicializaView().inicializaControleJogadas(2, ControlaView.getInicializaView().getJogAlvo());

			
		}
		else {
			frame.remove(btSim);
			frame.remove(btNao);
			frame.repaint();
			frame.setVisible(false);
			ControlaView.getInicializaView().setRespostaAtk("Nao");
			ControlaView.getInicializaView().setFaseJogada(4);
			ControlaView.getInicializaView().inicializaControleJogadas(4, ControlaView.getInicializaView().getJogAlvo());

		}

	}
	
	
}
