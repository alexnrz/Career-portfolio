package View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Model.Ctrl;
import Model.ObservadoIF;
import Model.ObservadorIF;

class CxDefineQtdMover extends JFrame implements ObservadorIF{
	private static JFrame frame = new JFrame();
	private static JTextField caixa = new JTextField(2);
	private static int qtdExTerritorio = 0;
	
	private static CxDefineQtdMover ctrl = null;
	
	public static CxDefineQtdMover getCxDefineQtdMover (int qtd, String territorioDoador, String territorioRecebedor) {
		
		if (ctrl==null) {
			ctrl = new CxDefineQtdMover(territorioDoador,territorioRecebedor);
		}
		
		qtdExTerritorio = qtd;
		frame.setVisible(true);
		caixa.setText("");
		return ctrl;
	}
	
	private CxDefineQtdMover(String territorioDoador, String territorioRecebedor) {
		
		frame.setLayout(new FlowLayout());
		frame.setBounds(800, 400, 300, 100);
		frame.setTitle("Movimento dos Exércitos");	
		JLabel label = new JLabel("Quantidade:");
		
		caixa.setBounds(200, 60, 140, 40);
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(200, 182, 90, 30);
		btnEnviar.addActionListener((ActionEvent e) -> abrirNovoFrame(Integer.parseInt(caixa.getText()),qtdExTerritorio,territorioDoador,territorioRecebedor));
		
		frame.add(label);
		frame.add(caixa);
		frame.add(btnEnviar);
		frame.setVisible(true);
		
		
	}
	private void abrirNovoFrame(int qtdExRetirar,int qtdExTerritorio,String territorioDoador, String territorioRecebedor) {
		
		System.out.println("EX RETIRAR "+ qtdExRetirar + "EX NO TERRITORIO "+qtdExTerritorio);
		
		if (qtdExRetirar > qtdExTerritorio-1 || qtdExRetirar <= 0) {
			JOptionPane.showMessageDialog(null, "Quantidade indisponível",null,JOptionPane.INFORMATION_MESSAGE);
			ControlaView.getInicializaView().setTerritorioDistribuidor(null);
			ControlaView.getInicializaView().setTerritorioRecebedor(null);
			ControlaView.getInicializaView().setFaseJogada(4);
			ControlaView.getInicializaView().inicializaControleJogadas(4, ControlaView.getInicializaView().getJogAlvo());
		
			frame.setVisible(false);
		}
		else{
			if (Ctrl.getInstance().registra(this).DeslocaExercitos(territorioDoador, territorioRecebedor, qtdExRetirar)==false) {
				JOptionPane.showMessageDialog(null, "O deslocamento não pôde ser realizado!",null,JOptionPane.INFORMATION_MESSAGE);
				
			}
			ControlaView.getInicializaView().setTerritorioDistribuidor(null);
			ControlaView.getInicializaView().setTerritorioRecebedor(null);
			ControlaView.getInicializaView().setFaseJogada(4);
			ControlaView.getInicializaView().inicializaControleJogadas(4, ControlaView.getInicializaView().getJogAlvo());
			
			frame.setVisible(false);
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
		// TODO Auto-generated method stub
		
	}
}
