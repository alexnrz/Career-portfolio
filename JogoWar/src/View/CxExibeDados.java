package View;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ControlaJogo;

/// Não necessita de Observer ///
 class CxExibeDados extends JFrame{
	
		private static	ImageIcon d1Ataque, d1Defesa; 
		private static JFrame frame;
		private static JLabel labelAtaque1,labelDefesa1;
		private static JButton jogarDadoDef, jogarDadoAtk;
		private static int contAtk = 0;
		private static int contDef = 0;
		private static int[] VetorAtq = new int[3];
		private static int[] VetorDef = new int[3];
		
		
		public CxExibeDados(int qtdDadoAtk, int qtdDadoDef) {
			frame = new JFrame("Dados");
			frame.invalidate(); frame.validate(); frame.repaint(); 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	        frame.setBounds(1467, 330, 320, 150);
	        
	        
	        // Ataque //
	        d1Ataque = new ImageIcon(getClass().getResource( "/Img/dado_desativado.png"));
			JPanel panelAtaque1 = new JPanel();
			labelAtaque1=new JLabel("");
			labelAtaque1.setIcon(d1Ataque);
			panelAtaque1.add(labelAtaque1);
			panelAtaque1.setBounds(0, 0, 35, 35);
			frame.add(panelAtaque1);
			
			
			jogarDadoAtk = new JButton();
			jogarDadoAtk.setText("Ataque");
			jogarDadoAtk.setIcon(new ImageIcon(getClass().getResource( "/Img/war_btnJogarDados.png")));
			jogarDadoAtk.addMouseListener(getMouseListener(1,qtdDadoAtk,qtdDadoDef));
			jogarDadoAtk.setSize(32, 32);
			frame.add(jogarDadoAtk);
			
			
			
			// Defesa //
	        d1Defesa = new ImageIcon(getClass().getResource( "/Img/dado_desativado.png"));
			JPanel panelDefesa1 = new JPanel();
			labelDefesa1=new JLabel("");
			labelDefesa1.setIcon(d1Defesa);
			panelDefesa1.add(labelDefesa1);
			frame.add(panelDefesa1);
			
			jogarDadoDef = new JButton();
			jogarDadoDef.setIcon(new ImageIcon(getClass().getResource( "/Img/war_btnJogarDados.png")));
			jogarDadoDef.setText("Defesa");
			jogarDadoDef.addMouseListener(getMouseListener(2,qtdDadoAtk,qtdDadoDef));
			jogarDadoDef.setVisible(false);
			frame.add(jogarDadoDef);
			
			
			
			
			
			
			frame.setLayout(new GridLayout(2,2));		
			frame.setVisible(true);
	
		}
		
		private static MouseListener getMouseListener(int atkOuDef,int qtdAtk,int qtdDef)
		{
			return new MouseAdapter()
			{
				@Override
				public void mouseClicked( MouseEvent e )
				{
					if(atkOuDef == 1) {
						if (contAtk <= qtdAtk) {
							
							VetorAtq[contAtk] = ControlaJogo.getControlaJogo().getResultadoDado();
							String Sdado1 =  "/Img/dado_ataque_"+VetorAtq[contAtk]+".png";
							contAtk = contAtk + 1;
							d1Ataque =new ImageIcon(getClass().getResource(Sdado1));
							labelAtaque1.setIcon(d1Ataque);
							if(contAtk == qtdAtk) {
								jogarDadoAtk.setVisible(false);
								jogarDadoDef.setVisible(true);
							}
						}
	
						
					}
					if(atkOuDef == 2) {
						
						if (contDef <= qtdDef) {
							VetorDef[contDef] = ControlaJogo.getControlaJogo().getResultadoDado();
							String Sdado1 =  "/Img/dado_defesa_"+VetorDef[contDef]+".png";
							contDef = contDef + 1;
							d1Defesa =new ImageIcon(getClass().getResource(Sdado1));
							labelDefesa1.setIcon(d1Defesa);
							if(contDef==qtdDef) {
								jogarDadoDef.setVisible(false);
								/// Envia as infos dos Dados para o Model pelo Controller //
								
								ControlaJogo.getControlaJogo().setResultadoDados(VetorAtq, VetorDef);
								ControlaJogo.getControlaJogo().realizaAtaque(ControlaView.getInicializaView().getTerritorioAtk(), ControlaView.getInicializaView().getTerritorioDef(), ControlaView.getInicializaView().getCorAtk());
								
								
								// Reseta as informações //
								frame.dispose();
								contAtk=0;
								contDef=0;
								// Volta a jogada para o jogador poder ver os seus exércitos nos territórios //
								ControlaView.getInicializaView().setFaseJogada(1);
								// Pergunta novamente se o jogador deseja atacar //
								CxPerguntaAtkOuNao.getCxPerguntaAtkOuNao();
							}
						}
					}
				}
			};
		}
	
}
	

