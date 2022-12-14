package View;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import Model.Acoes;

/// Não necessita de Observer ///
class CxExibeObjetivo extends JFrame{
	
	private String imgObjetivo = "/Img/war_carta_objetivo_grande.png";
	private String[] obj = new String[2];
	
	public CxExibeObjetivo(String nomeJogador)  {
		
		ImagePanel imagePanel1= new ImagePanel(imgObjetivo);
		this.setContentPane(imagePanel1);
		this.setTitle("Carta Objetivo");
		this.setSize(353,581);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		
		JTextArea textArea = new JTextArea();
		
		textArea.setSize(297,340);
		textArea.setLocation(23, 108);
		textArea.setEditable(false);
		textArea.setBackground(new Color(1,1,1,0));
		String ObjetivoC[][] = new String[2][2]; 
				
		ObjetivoC = Acoes.getAcoes().getObjetivosJogador(nomeJogador);
		
		if (ObjetivoC[0][0]=="nenhum") {
			obj[0] = "Não necessário";
		}
		else {
			obj[0]=ObjetivoC[0][0];
		}
		if (ObjetivoC[0][1] == null || ObjetivoC[0][1].equals("0")==true ||ObjetivoC[0][1].equals("1")==true) {
			obj[1] = "qualquer quantidade de";
		}
		else {
			obj[1] = ObjetivoC[0][1];
		}
		
		
		
		
		if (ObjetivoC[1][0] == null) {
			textArea.setText("\n\n Destruir o Exército: "+obj[0]+"\n"
					 +" Possuir "+obj[1]+" Territórios no total\n"
					 +" Conquistar os Continentes: Não necessário"
			);
		}
		else {
			
			textArea.setText("\n\n Destruir o Exército: "+obj[0]+"\n"
					 +" Possuir "+obj[1]+" Territórios no total\n"
					 +" Conquistar os Continentes: "+ObjetivoC[1][0]+"\n\t\t"+ObjetivoC[1][1]
			);
		}
		
		
		this.add(textArea);
		this.setResizable(false);
		
		
		
		
		
		
		
	}

	

}
