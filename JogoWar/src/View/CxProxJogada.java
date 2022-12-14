package View;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.ControlaJogo;

class CxProxJogada extends JFrame{
	
	private static JFrame frame = new JFrame();
	private static int faseRodada;
	private static int jogRodada;
	
	private static CxProxJogada ctrl = null;
	
	public static CxProxJogada getCxProxJogada(int fase,int jog) {
		
		if (ctrl==null) {
			ctrl = new CxProxJogada();
		}
		frame.repaint();
		frame.setVisible(true);
		faseRodada= fase;
		jogRodada = jog;
		return ctrl;
	}
	
	private CxProxJogada() {		
		
		frame.setTitle("Próxima Jogada");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		frame.setLayout(new GridLayout(1,2));
		
		frame.setBounds(1470, 480, 285, 135);
		
		JButton proxButton = new JButton();
		proxButton.setIcon(new ImageIcon(getClass().getResource( "/Img/war_btnProxJogada.png")));
		proxButton.setSize(55,45);
		proxButton.addActionListener((ActionEvent e) -> proxJogada());
		frame.add(proxButton);
		frame.setVisible(true);		
		
	}
	
	public void proxJogada() {
		
		if(faseRodada == 1) {
			CxRecebeExercitos.getCxRecebeExercitos(jogRodada);
			System.out.println("FASE 1 - O Jogador recebe os exércitos");
			frame.setVisible(false);
			
			
		}
		
		if (faseRodada == 2) {
			
			
			ControlaView.getInicializaView().setFaseJogada(2);
			JOptionPane.showMessageDialog(null, "Fase de Ataque!"); 

			JOptionPane.showMessageDialog(null, "Selecione o território atacante",null,JOptionPane.INFORMATION_MESSAGE);
			frame.setVisible(false);

		}
		
		if(faseRodada == 4) {
			frame.repaint();
			frame.setVisible(false);
			
			CxPerguntaDeslocamento.getCxPerguntaDeslocamento();
			System.out.println("FASE 4 - O Jogador Desloca seus Exércitos");
			
		}
				
		if (faseRodada == 6) {
			System.out.println("FASE 6 - Fim da Rodada");
			JOptionPane.showMessageDialog(null, "Fim da Rodada!",null,JOptionPane.INFORMATION_MESSAGE);
			
			ControlaJogo.getControlaJogo().setJogDaVez();			
			System.out.println("JOG DA VEM EM PROX: "+ControlaJogo.getControlaJogo().getJogDaVez());
			ControlaView.getInicializaView().setJogAlvo(ControlaJogo.getControlaJogo().getJogDaVez());
			ControlaView.getInicializaView().inicializaControleJogadas(7, ControlaView.getInicializaView().getJogAlvo());
			
			frame.repaint();
			frame.setVisible(false);
		}	
		if (faseRodada == 7) {
			System.out.println("FASE 7 - Reset");
			ControlaView.getInicializaView().inicializaControleJogadas(1, ControlaView.getInicializaView().getJogAlvo());

			frame.repaint();
			//frame.setVisible(false);
		}
	}

}



