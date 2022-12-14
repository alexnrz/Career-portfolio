package View;
import Model.*;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/// Observer implementado ///
class CxObjetivos extends JFrame implements ObservadorIF{
	
	
	private String nomes[];
	private JButton[] exibeObjetivo;
	private JFrame frame = new JFrame("Objetivos");
	private JPanel panel = new JPanel();
	
	
	private static CxObjetivos ctrl = null;
	
	public static CxObjetivos getCxObjetivos(int qtd) {
		
		if(ctrl == null) {
			ctrl = new CxObjetivos(qtd);
		}
		return ctrl;		
	}
	
	private CxObjetivos(int qtdJogador) {
		
		frame.setLayout(new FlowLayout());
		nomes = new String[qtdJogador];
		
		nomes = Ctrl.getInstance().registra(this).getNomesJogadores();
		
        JFrame.setDefaultLookAndFeelDecorated(true);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout boxlayout = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		

		frame.setSize(250,50*qtdJogador);
		frame.setLocation(1472, 135);
		exibeObjetivo = new JButton[qtdJogador];
		
		for ( int i=0; i < qtdJogador;i++) {
			exibeObjetivo[i] = new JButton("Objetivos do Jogador: "+nomes[i]);
			exibeObjetivo[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			exibeObjetivo[i].addMouseListener(getMouseListener(nomes[i]));
			panel.add(exibeObjetivo[i]);
		}
		
		
        frame.add(panel);
        frame.setVisible(true);
        
		
	}
	
	private static MouseListener getMouseListener(String nome)
	{
		return new MouseAdapter()
		{
			@Override			
			public void mouseClicked( MouseEvent e )
			{
				System.out.println("JOGADOR OBJETIVO ALVO: "+nome);
				new CxExibeObjetivo(nome);
				
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
		System.out.println("CxObjetivos notificado");
		
		for( int i=0;i<exibeObjetivo.length;i++) {
			exibeObjetivo[i].removeAll();
			panel.remove(exibeObjetivo[i]);
		}
		
		frame.remove(panel);		
		nomes = o.getNomesJogadores();		
		
		for ( int i=0;i<nomes.length;i++) {
			exibeObjetivo[i] = new JButton("Objetivos do Jogador: "+nomes[i]);
			exibeObjetivo[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			exibeObjetivo[i].addMouseListener(getMouseListener(nomes[i]));
			panel.add(exibeObjetivo[i]);
		}
		
		frame.add(panel);
		frame.validate();
		frame.repaint();		
		
		
	}


	

	

}
