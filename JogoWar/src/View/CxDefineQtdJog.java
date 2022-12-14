package View;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import Controller.ControlaJogo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;


/// Não necessita de Observer ///
// Alterar para não deixar público ///
class CxDefineQtdJog extends JFrame  {
	
	private static JFrame frame = new JFrame();
	private JLabel qtdJogador;	
	
	public CxDefineQtdJog() {
		super("Quantidade de Jogadores");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,100);		 
		frame.setLocationRelativeTo(null);
		ButtonGroup bg = new ButtonGroup();
		
		qtdJogador = new JLabel("Quantidade de Jogadores:");		
		frame.add(qtdJogador);
		JRadioButton[] lstButtons = new JRadioButton[6];
		
		for (int i =2;i<7;i++) {
			lstButtons[i-2] = new JRadioButton();
			lstButtons[i-2].setText(Integer.toString(i));
			lstButtons[i-2].setSize(100, 30);
			bg.add(lstButtons[i-2]);
			frame.add(lstButtons[i-2],BorderLayout.CENTER);
			
		}
		lstButtons[0].addActionListener((ActionEvent e) -> abrirNovoFrame(Integer.parseInt(lstButtons[0].getText())));
		lstButtons[1].addActionListener((ActionEvent e) -> abrirNovoFrame(Integer.parseInt(lstButtons[1].getText())));
		lstButtons[2].addActionListener((ActionEvent e) -> abrirNovoFrame(Integer.parseInt(lstButtons[2].getText())));
		lstButtons[3].addActionListener((ActionEvent e) -> abrirNovoFrame(Integer.parseInt(lstButtons[3].getText())));
		lstButtons[4].addActionListener((ActionEvent e) -> abrirNovoFrame(Integer.parseInt(lstButtons[4].getText())));

		
		frame.setVisible(true);
	}

    private void abrirNovoFrame(int qtdJog) {
    	ControlaJogo.getControlaJogo().setQtdJogadores(qtdJog);
    	ControlaView.getInicializaView().setQtdJogadores(qtdJog);
    	new CxDefineNomeEcor(qtdJog);
    	//SwingUtilities.invokeLater(() -> { ControlaJogo.getControlaJogo().defineNomeEcor(); });    	
    	
    	frame.dispose();
    }
    
	
	
}
