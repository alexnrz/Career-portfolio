package View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class CxPerguntaDeslocamento extends JFrame {

	private static JFrame frame = new JFrame();
	private static JRadioButton btSim = new JRadioButton("Sim");
	private static JRadioButton btNao = new JRadioButton("Não");
	
	private static CxPerguntaDeslocamento ctrl = null;
	
	public static CxPerguntaDeslocamento getCxPerguntaDeslocamento() {
		if (ctrl==null) {
			ctrl = new CxPerguntaDeslocamento();
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
	
	private CxPerguntaDeslocamento() {
		frame.setTitle("Deseja deslocar seus Exércitos?");
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
		ControlaView.getInicializaView().setRespostaDesloca(r);
		if (r.equals("Sim")==true) {
			JOptionPane.showMessageDialog(null, "Selecione o território distribuidor",null,JOptionPane.INFORMATION_MESSAGE);
			ControlaView.getInicializaView().setFaseJogada(5);
			//ControlaView.getInicializaView().inicializaControleJogadas(5, ControlaView.getInicializaView().getJogAlvo());
			
			
		}
		else {
			ControlaView.getInicializaView().setRespostaDesloca("Nao");
			ControlaView.getInicializaView().setFaseJogada(6);
			ControlaView.getInicializaView().inicializaControleJogadas(6, ControlaView.getInicializaView().getJogAlvo());
		}
		frame.remove(btSim);
		frame.remove(btNao);
		frame.repaint();
		frame.setVisible(false);
	}
	
	
}
