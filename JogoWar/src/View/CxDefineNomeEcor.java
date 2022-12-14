package View;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Controller.ControlaJogo;
import Model.Ctrl;
import Model.ObservadoIF;
import Model.ObservadorIF;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

/// Não necessita de Observer ///
class CxDefineNomeEcor extends JFrame implements ObservadorIF  {
	
	private JTextField caixaNome[], caixaCor[];
	private JButton Enviar = new JButton("Enviar");
	private JLabel lbNomeJog,lbCorJog;
	
	public CxDefineNomeEcor(int qtd) {
		super("Informações dos Jogadores");
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,100*qtd);
		setLocationRelativeTo(null);
		
		
		caixaNome = new JTextField[qtd];
		caixaCor = new JTextField[qtd];	
			
		JTextArea textF = new JTextArea("Cores disponíveis: Preto - Azul - Verde - Branco - Amarelo - Vermelho");
		textF.setEditable(false);
		add(textF);
		for( int i=0; i < qtd;i++) {	
			lbNomeJog = new JLabel("Nome do Jogador "+(i+1)+": ");		
			add(lbNomeJog);
			
			caixaNome[i] = new JTextField(20);
			add(caixaNome[i]);
			lbCorJog = new JLabel("Cor do Jogador "+(i+1)+":     ");
			add(lbCorJog);
			
			caixaCor[i] = new JTextField(20);
			add(caixaCor[i]);
		}
	
		Enviar.addActionListener((ActionEvent e) -> 
				enviarNomeCor(qtd)
		);
		add(Enviar);
		
		setVisible(true);
	}
	


	private void enviarNomeCor(int qtd) {
		
		String []cores = new String[caixaCor.length];
		String []nomes = new String[caixaNome.length];
		for (int i=0;i<cores.length;i++) {
			cores[i] = caixaCor[i].getText();
			nomes[i] = caixaNome[i].getText();
			
		}
		if (ControlaJogo.getControlaJogo().verificaCoresNomes(cores,nomes) == true) {
			for(int i=0; i < qtd; i++) {
				
				Ctrl.getInstance().registra(this).setCores(caixaCor[i].getText());
				Ctrl.getInstance().registra(this).setNomes(caixaNome[i].getText());
			}
			
			ControlaJogo.getControlaJogo().inicializaPartida();
			ControlaView.getInicializaView().inicializaTabuleiro();
			dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Cores ou Nomes não disponíveis",null,JOptionPane.INFORMATION_MESSAGE);
			
		}

		
		
		
		
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
		System.out.println("CxDefineNomeEcor notificado");
		// TODO Auto-generated method stub
		
	}






	

}
