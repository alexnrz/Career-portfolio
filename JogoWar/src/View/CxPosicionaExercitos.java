package View;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Model.ObservadoIF;
import Model.ObservadorIF;

class CxPosicionaExercitos extends JFrame implements ObservadorIF{

	private static JFrame frame = new JFrame();
	private static JLabel labelQtd = new JLabel();
	private static JRadioButton[] lstButtons;
	private ButtonGroup bg = new ButtonGroup();
	private static int totalEx = -1;
	private static String listaTerritorios[];
	
	private static CxPosicionaExercitos ctrl =null;
	
	public static CxPosicionaExercitos getCxPosicionaExercitos(int Ex, String[] lst) {
		frame.repaint();
		frame.validate();
		frame.setVisible(true);
		
		listaTerritorios = lst;
		if (totalEx ==-1) {
			totalEx=Ex;
		}
		else {
			totalEx = totalEx-Ex;
		}
		
		if(ctrl==null) {
			
			
			labelQtd = new JLabel();
			frame.add(labelQtd);
			ctrl = new CxPosicionaExercitos();
		}
		if (totalEx == 0) {
			 JOptionPane.showMessageDialog(null,"Todos os Exércitos foram posicionados"); 
			 // Passa a jogadda //
			 CxPerguntaAtkOuNao.getCxPerguntaAtkOuNao();
			 totalEx=-1;
			 ctrl = null;
			 frame.repaint();
			 frame.dispose();
			 frame.removeAll();
			 frame = new JFrame();
		}
		labelQtd.setText("Quantidade disponível: "+totalEx );
		labelQtd.setBounds(0, 0, 150, 25);
		
		
		return ctrl;
	}
			
	private CxPosicionaExercitos () {
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Posicionamento dos Exércitos");
		frame.setSize(250,20*listaTerritorios.length);		
		frame.setLocationRelativeTo(null);
		frame.repaint();
		frame.validate();
		
		lstButtons = new JRadioButton[listaTerritorios.length];
		
		for (int i=0;i<listaTerritorios.length;i++) {
			if (listaTerritorios[i]!=null) {
				lstButtons[i] = new JRadioButton();
				lstButtons[i].setText(listaTerritorios[i]);
				lstButtons[i].setSize(100, 30);
				lstButtons[i].addMouseListener(getMouseListener(totalEx ,listaTerritorios[i],listaTerritorios));
				bg.add(lstButtons[i]);
				frame.add(lstButtons[i],BorderLayout.CENTER);
			}
			
			
		}
		
		frame.setVisible(true);		
		
	} 
	
	private static MouseListener getMouseListener(int qtdEx,String territorioAlvo,String[] listaTerritorios)	{
			return new MouseAdapter()
			{
				@Override			
				public void mouseClicked( MouseEvent e )
				{
					
					CxDefineQtdExercitos.getCxDefineQtdExercitos(qtdEx,territorioAlvo,listaTerritorios);
					frame.repaint();
					frame.validate();
					
				}
			};
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
		totalEx = -1;
		// TODO Auto-generated method stub
		
	}

	
					
}



