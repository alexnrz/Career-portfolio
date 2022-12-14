package View;
import Model.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.ControlaJogo;


class CxRecebeExercitos extends JFrame implements ObservadorIF {
	
	private static JFrame frame = new JFrame();
	private static int posJogAlvo;
	private static String S[];
	private static JButton recebeButton = new JButton();
	private static int flag = 0;
	
	private static CxRecebeExercitos ctrl = null;
	public static CxRecebeExercitos getCxRecebeExercitos(int pos) {
		
		if (ctrl==null) {
			frame.setLayout(new FlowLayout());
			frame.setTitle("Recebimento de Exércitos");
			frame.setSize(350, 70);
			frame.setLocation(1470, 620);
			frame.setVisible(true);
			ctrl = new CxRecebeExercitos();
		}
		else if(flag == 1) {
			recebeButton.repaint();
			recebeButton.addActionListener((ActionEvent e) -> recebeExercitos());
			recebeButton.setVisible(true);
			flag = 0;
			frame.setVisible(true);
			frame.repaint();
		}
		frame.repaint();
		frame.validate();
		S = Ctrl.getInstance().registra(ctrl).getListaTerritoriosString(posJogAlvo);
		posJogAlvo = pos;
		return ctrl;
		
	}
		
		
	private CxRecebeExercitos() {
		S = Ctrl.getInstance().registra(this).getListaTerritoriosString(posJogAlvo);		//	//	//	//	//	//

		JButton recebeButton = new JButton();
		recebeButton.setText("Receber Exércitos");
		recebeButton.addActionListener((ActionEvent e) -> recebeExercitos());
		recebeButton.setVisible(true);
		frame.add(recebeButton);
		
	}
	
	public static void recebeExercitos() {
		ControlaJogo.getControlaJogo().atualizaOb();
		frame.setVisible(false);
		int qtd = ControlaJogo.getControlaJogo().recebeEx(posJogAlvo);
		System.out.println("Jogador "+posJogAlvo+" recebendo exercitos");
		String str = "O Jogador recebeu "+qtd+" exércitos";
		JOptionPane.showMessageDialog(null, str,null,JOptionPane.INFORMATION_MESSAGE); 
		
		recebeButton.setVisible(false);
		S = Ctrl.getInstance().registra(ctrl).getListaTerritoriosString(posJogAlvo);

		ControlaView.getInicializaView().setQtdEx(qtd);	
		CxPosicionaExercitos.getCxPosicionaExercitos(qtd, S);
		flag = 1;
		
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
		System.out.println("CxRecebeExercitos notificado - Jogador da Rodada: "+ControlaView.getInicializaView().getJogAlvo());
		S = o.getListaTerritoriosString(ControlaView.getInicializaView().getJogAlvo());
		
		// TODO Auto-generated method stub
		
	}


}
