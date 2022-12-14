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

class CxDefineQtdExercitos extends JFrame implements ObservadorIF{
	
	
	private static JFrame frame = new JFrame();
	private static JTextField caixa = new JTextField(2);
	private static int qtdExTotal;
	private static String territorioAlvo;
	private static String listaTerritorios[];
	private static CxDefineQtdExercitos ctrl = null;
	
	public static CxDefineQtdExercitos getCxDefineQtdExercitos (int qtd, String alvo,String[] lst) {
		
		qtdExTotal = qtd;
		territorioAlvo = alvo;
		listaTerritorios = lst;
		if (ctrl==null) {
			ctrl = new CxDefineQtdExercitos();
		}		
		frame.setVisible(true);
		caixa.setText("");
		return ctrl;
	}
	
	
	
	private CxDefineQtdExercitos() {
		frame.setLayout(new FlowLayout());
		frame.setBounds(800, 400, 300, 100);
		frame.setTitle("Posicionamento dos Exércitos");	
		JLabel label = new JLabel("Quantidade:");
		
		caixa.setBounds(200, 60, 140, 40);
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(200, 182, 90, 30);
		btnEnviar.addActionListener((ActionEvent e) -> abrirNovoFrame(Integer.parseInt(caixa.getText()),qtdExTotal,territorioAlvo,listaTerritorios));
		
		frame.add(label);
		frame.add(caixa);
		frame.add(btnEnviar);
		frame.setVisible(true);
		
		
	}
	private void abrirNovoFrame(int qtdExRetirar,int qtdExTotal, String TerritorioAlvo,String[] listaTerritorios) {
	
		if (qtdExRetirar > qtdExTotal || qtdExRetirar < 0 || qtdExTotal-qtdExRetirar < 0) {
			JOptionPane.showMessageDialog(null, "Quantidade indisponível",null,JOptionPane.INFORMATION_MESSAGE);
			frame.setVisible(false);
		}
		else{
			
			Ctrl.getInstance().registra(this).adicionaExercitoTerritorio(qtdExRetirar, TerritorioAlvo);
			
			CxPosicionaExercitos.getCxPosicionaExercitos(qtdExRetirar, listaTerritorios);

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
