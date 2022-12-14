package View;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controller.ControlaJogo;
import Model.*;

// Observer e Singleton implementados //
class CxTabuleiro extends JFrame implements ObservadorIF{
	
	private String imgTerritorios = "/Img/war_tabuleiro_mapa.png";
	private static String corJog;
	private static CxTabuleiro ctrl = null;
	private static JFrame frame = new JFrame();
	private static JPanel []listPanel = new JPanel[51]; 
	
	
	
	public static CxTabuleiro getCxTabuleiro() {
		if( ctrl == null) {
			ctrl = new CxTabuleiro();
		}
		
		return ctrl;
	}
	
	private CxTabuleiro() {
		
		ImagePanel imagePanel1 = new ImagePanel(imgTerritorios);
		frame.setContentPane(imagePanel1);
		frame.setTitle("Tabuleiro");
		frame.setSize(1024,768);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(3);
		
		////////////////////////////
		////////América do Norte////
		////////////////////////////
		/////// ALASCA /////////
		
		listPanel[0] = new JPanel();
		listPanel[0].setName( "Alasca" );
		listPanel[0].setBackground( Color.RED );
		listPanel[0].setOpaque(true); // Deixa invisivel //
		listPanel[0].setLayout(new GridLayout(1, 1));
		listPanel[0].setBounds( 90, 125, 20, 20 );
		listPanel[0].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[0]);
		
		/////// CALGARY /////////
		listPanel[1] = new JPanel();
		listPanel[1].setName( "Calgary" );
		listPanel[1].setBackground( Color.RED );
		listPanel[1].setOpaque(true); // Deixa invisivel //
		listPanel[1].setLayout(new GridLayout(1, 1));
		listPanel[1].setBounds( 180, 135, 20, 20 );
		listPanel[1].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[1]);
		
		/////// GROELANDIA /////////
		listPanel[2] = new JPanel();
		listPanel[2].setName( "Groelandia" );
		listPanel[2].setBackground( Color.RED );
		listPanel[2].setOpaque(true); // Deixa invisivel //
		listPanel[2].setLayout(new GridLayout(1, 1));
		listPanel[2].setBounds( 305, 95, 20, 20 );
		listPanel[2].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[2]);
		
		/////// VANCOUVER /////////
		listPanel[3] = new JPanel();
		listPanel[3].setName( "Vancouver" );
		listPanel[3].setBackground( Color.RED );
		listPanel[3].setOpaque(true); // Deixa invisivel //
		listPanel[3].setLayout(new GridLayout(1, 1));
		listPanel[3].setBounds( 150, 175, 20, 20 );
		listPanel[3].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[3]);
		
		/////// QUEBEC /////////
		listPanel[4] = new JPanel();
		listPanel[4].setName( "Quebec" );
		listPanel[4].setBackground( Color.RED );
		listPanel[4].setOpaque(true); // Deixa invisivel //
		listPanel[4].setLayout(new GridLayout(1, 1));
		listPanel[4].setBounds( 265, 175, 20, 20 );
		listPanel[4].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[4]);
		
		
		/////// CALIFORNIA /////////
		listPanel[5] = new JPanel();
		listPanel[5].setName( "California" );
		listPanel[5].setBackground( Color.RED );
		listPanel[5].setOpaque(true); // Deixa invisivel //
		listPanel[5].setLayout(new GridLayout(1, 1));
		listPanel[5].setBounds( 110, 240, 20, 20 );
		listPanel[5].addMouseListener( getMouseListener() );		
		
		frame.add(listPanel[5]);
		
		/////// TEXAS /////////
		listPanel[6] = new JPanel();
		listPanel[6].setName( "Texas" );
		listPanel[6].setBackground( Color.RED );
		listPanel[6].setOpaque(true); // Deixa invisivel //
		listPanel[6].setLayout(new GridLayout(1, 1));
		listPanel[6].setBounds( 160, 240, 20,20  );
		listPanel[6].addMouseListener( getMouseListener() );		
		
		frame.add(listPanel[6]);
		
		/////// NOVA YORK /////////
		listPanel[7] = new JPanel();
		listPanel[7].setName( "Nova York" );
		listPanel[7].setBackground( Color.RED );
		listPanel[7].setOpaque(true); // Deixa invisivel //
		listPanel[7].setLayout(new GridLayout(1, 1));
		listPanel[7].setBounds( 205, 240, 20, 20 );
		listPanel[7].addMouseListener( getMouseListener() );		
		
		frame.add(listPanel[7]);
		frame.setDefaultCloseOperation(3);
		
		/////// MEXICO /////////
		listPanel[8] = new JPanel();
		listPanel[8].setName( "Mexico" );
		listPanel[8].setBackground( Color.RED );
		listPanel[8].setOpaque(true); // Deixa invisivel //
		listPanel[8].setLayout(new GridLayout(1, 1));
		listPanel[8].setBounds( 140, 335, 20, 20 );
		listPanel[8].addMouseListener( getMouseListener() );		
		
		frame.add(listPanel[8]);
		
		////////////////////////////
		////////América do Sul//////
		////////////////////////////
		
		/////// VENEZUELA /////////
		listPanel[9] = new JPanel();
		listPanel[9].setName( "Venezuela" );
		listPanel[9].setBackground( Color.GREEN );
		listPanel[9].setOpaque(true); // Deixa invisivel //
		listPanel[9].setLayout(new GridLayout(1, 1));
		listPanel[9].setBounds( 190, 405, 20, 20 );
		listPanel[9].addMouseListener( getMouseListener() );		
		
		frame.add(listPanel[9]);
		
		
		/////// PERU /////////
		listPanel[10] = new JPanel();
		listPanel[10].setName( "Peru" );
		listPanel[10].setBackground( Color.GREEN );
		listPanel[10].setOpaque(true); // Deixa invisivel //
		listPanel[10].setLayout(new GridLayout(1, 1));
		listPanel[10].setBounds( 230, 460, 20, 20 );
		listPanel[10].addMouseListener( getMouseListener() );		
		
		frame.add(listPanel[10]);
		
		
		/////// ARGENTINA /////////
		listPanel[11] = new JPanel();
		listPanel[11].setName( "Argentina" );
		listPanel[11].setBackground( Color.GREEN );
		listPanel[11].setOpaque(true); // Deixa invisivel //
		listPanel[11].setLayout(new GridLayout(1, 1));
		listPanel[11].setBounds( 265, 510, 20, 20 );
		listPanel[11].addMouseListener( getMouseListener() );		
		
		frame.add(listPanel[11]);
		
		
		/////// BRASIL /////////

		listPanel[12] = new JPanel();
		listPanel[12].setName( "Brasil" );
		listPanel[12].setBackground( Color.GREEN );
		//Brasil.setOpaque(true); // Deixa invisivel //
		listPanel[12].setLayout(new GridLayout(1, 1));
		listPanel[12].setBounds( 275, 420, 20, 20 );
		listPanel[12].addMouseListener( getMouseListener() );		
		
		frame.add(listPanel[12]);
		//////////////

		
		////////////////////////////
		///////////Europa///////////
		////////////////////////////
		
		/////// Reino Unido/////////
		listPanel[13] = new JPanel();
		listPanel[13].setName( "Reino Unido" );
		listPanel[13].setBackground( Color.BLUE );
		listPanel[13].setOpaque(true); // Deixa invisivel //
		listPanel[13].setLayout(new GridLayout(1, 1));
		listPanel[13].setBounds( 445, 155, 20, 20 );
		listPanel[13].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[13]);
		
		
		/////// Suecia //////////////
		listPanel[14] = new JPanel();
		listPanel[14].setName( "Suecia" );
		listPanel[14].setBackground( Color.BLUE );
		listPanel[14].setOpaque(true); // Deixa invisivel //
		listPanel[14].setLayout(new GridLayout(1, 1));
		listPanel[14].setBounds( 520, 125, 20, 20 );
		listPanel[14].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[14]);
		frame.setDefaultCloseOperation(3);
		
		/////// Espanha /////////////
		listPanel[15] = new JPanel();
		listPanel[15].setName( "Espanha" );
		listPanel[15].setBackground( Color.BLUE );
		listPanel[15].setOpaque(true); // Deixa invisivel //
		listPanel[15].setLayout(new GridLayout(1, 1));
		listPanel[15].setBounds( 430, 260, 20, 20 );
		listPanel[15].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[15]);
		
		/////// Franca /////////////
		listPanel[16] = new JPanel();
		listPanel[16].setName( "Franca" );
		listPanel[16].setBackground( Color.BLUE );
		listPanel[16].setOpaque(true); // Deixa invisivel //
		listPanel[16].setLayout(new GridLayout(1, 1));
		listPanel[16].setBounds( 470, 225, 20, 20 );
		listPanel[16].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[16]);
		
		
		/////// Italia /////////////
		listPanel[17] = new JPanel();
		listPanel[17].setName( "Italia" );
		listPanel[17].setBackground( Color.BLUE );
		listPanel[17].setOpaque(true); // Deixa invisivel //
		listPanel[17].setLayout(new GridLayout(1, 1));
		listPanel[17].setBounds( 525, 212, 20, 20 );
		listPanel[17].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[17]);
		
		
		/////// Romenia /////////////
		listPanel[18] = new JPanel();
		listPanel[18].setName( "Romenia" );
		listPanel[18].setBackground( Color.BLUE );
		listPanel[18].setOpaque(true); // Deixa invisivel //
		listPanel[18].setLayout(new GridLayout(1, 1));
		listPanel[18].setBounds( 565, 240, 20, 20 );
		listPanel[18].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[18]);
		
		
		/////// Polonia /////////////
		listPanel[19] = new JPanel();
		listPanel[19].setName( "Polonia" );
		listPanel[19].setBackground( Color.BLUE );
		listPanel[19].setOpaque(true); // Deixa invisivel //
		listPanel[19].setLayout(new GridLayout(1, 1));
		listPanel[19].setBounds( 555, 185, 20, 20 );
		listPanel[19].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[19]);
		
		
		/////// Ucrania /////////////
		listPanel[20] = new JPanel();
		listPanel[20].setName( "Ucrania" );
		listPanel[20].setBackground( Color.BLUE );
		listPanel[20].setOpaque(true); // Deixa invisivel //
		listPanel[20].setLayout(new GridLayout(1, 1));
		listPanel[20].setBounds( 583, 215, 20, 20 );
		listPanel[20].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[20]);
		
		
		////////////////////////////
		//////// Asia ///////////////
		////////////////////////////
		/////// Letonia /////////////
		listPanel[21] = new JPanel();
		listPanel[21].setName( "Letonia" );
		listPanel[21].setBackground( Color.ORANGE );
		listPanel[21].setOpaque(true); // Deixa invisivel //
		listPanel[21].setLayout(new GridLayout(1, 1));
		listPanel[21].setBounds( 650, 175, 20, 20 );
		listPanel[21].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[21]);
		
		/////// Estonia /////////////
		listPanel[22] = new JPanel();
		listPanel[22].setName( "Estonia" );
		listPanel[22].setBackground( Color.ORANGE );
		listPanel[22].setOpaque(true); // Deixa invisivel //
		listPanel[22].setLayout(new GridLayout(1, 1));
		listPanel[22].setBounds( 655, 125, 20, 20 );
		listPanel[22].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[22]);
		
		/////// Russia /////////////
		listPanel[23] = new JPanel();
		listPanel[23].setName( "Russia" );
		listPanel[23].setBackground( Color.ORANGE );
		listPanel[23].setOpaque(true); // Deixa invisivel //
		listPanel[23].setLayout(new GridLayout(1, 1));
		listPanel[23].setBounds( 750, 135, 20, 20 );
		listPanel[23].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[23]);
		
		/////// Siberia /////////////
		listPanel[24] = new JPanel();
		listPanel[24].setName( "Siberia" );
		listPanel[24].setBackground( Color.ORANGE );
		listPanel[24].setOpaque(true); // Deixa invisivel //
		listPanel[24].setLayout(new GridLayout(1, 1));
		listPanel[24].setBounds( 860, 135, 20, 20 );
		listPanel[24].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[24]);
		
		
		/////// Cazaquistao /////////////
		listPanel[25] = new JPanel();
		listPanel[25].setName( "Cazaquistao" );
		listPanel[25].setBackground( Color.ORANGE );
		listPanel[25].setOpaque(true); // Deixa invisivel //
		listPanel[25].setLayout(new GridLayout(1, 1));
		listPanel[25].setBounds( 800, 200, 20, 20 );
		listPanel[25].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[25]);
		
		
		/////// Turquia /////////////
		listPanel[26] = new JPanel();
		listPanel[26].setName( "Turquia" );
		listPanel[26].setBackground( Color.ORANGE );
		listPanel[26].setOpaque(true); // Deixa invisivel //
		listPanel[26].setLayout(new GridLayout(1, 1));
		listPanel[26].setBounds( 700, 225, 20, 20 );
		listPanel[26].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[26]);
		
		
		/////// Mongolia /////////////
		listPanel[27] = new JPanel();
		listPanel[27].setName( "Mongolia" );
		listPanel[27].setBackground( Color.ORANGE );
		listPanel[27].setOpaque(true); // Deixa invisivel //
		listPanel[27].setLayout(new GridLayout(1, 1));
		listPanel[27].setBounds( 835, 235, 20, 20 );
		listPanel[27].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[27]);
		
		/////// Japao /////////////
		listPanel[28] = new JPanel();
		listPanel[28].setName( "Japao" );
		listPanel[28].setBackground( Color.ORANGE );
		listPanel[28].setOpaque(true); // Deixa invisivel //
		listPanel[28].setLayout(new GridLayout(1, 1));
		listPanel[28].setBounds( 923, 250, 20, 20 );
		listPanel[28].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[28]);
		
		
		/////// Siria /////////////
		listPanel[29] = new JPanel();
		listPanel[29].setName( "Siria" );
		listPanel[29].setBackground( Color.ORANGE );
		listPanel[29].setOpaque(true); // Deixa invisivel //
		listPanel[29].setLayout(new GridLayout(1, 1));
		listPanel[29].setBounds( 655, 265, 20, 20 );
		listPanel[29].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[29]);
		
		
		/////// Paquistao /////////////
		listPanel[30] = new JPanel();
		listPanel[30].setName( "Paquistao" );
		listPanel[30].setBackground( Color.ORANGE );
		listPanel[30].setOpaque(true); // Deixa invisivel //
		listPanel[30].setLayout(new GridLayout(1, 1));
		listPanel[30].setBounds( 725, 290, 20, 20 );
		listPanel[30].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[30]);
			
		/////// China /////////////
		listPanel[31] = new JPanel();
		listPanel[31].setName( "China" );
		listPanel[31].setBackground( Color.ORANGE );
		listPanel[31].setOpaque(true); // Deixa invisivel //
		listPanel[31].setLayout(new GridLayout(1, 1));
		listPanel[31].setBounds( 775, 265, 20, 20 );
		listPanel[31].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[31]);
		
		
		/////// Coreia do Norte /////////////
		listPanel[32] = new JPanel();
		listPanel[32].setName( "Coreia do Norte" );
		listPanel[32].setBackground( Color.ORANGE );
		listPanel[32].setOpaque(true); // Deixa invisivel //
		listPanel[32].setLayout(new GridLayout(1, 1));
		listPanel[32].setBounds( 850, 285, 20, 20 );
		listPanel[32].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[32]);
		
		
		/////// Coreia do Sul /////////////
		listPanel[33] = new JPanel();
		listPanel[33].setName( "Coreia do Sul" );
		listPanel[33].setBackground( Color.ORANGE );
		listPanel[33].setOpaque(true); // Deixa invisivel //
		listPanel[33].setLayout(new GridLayout(1, 1));
		listPanel[33].setBounds( 850, 310, 20, 17 );
		listPanel[33].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[33]);
		
		
		/////// Tailandia /////////////
		listPanel[34] = new JPanel();
		listPanel[34].setName( "Tailandia" );
		listPanel[34].setBackground( Color.ORANGE );
		listPanel[34].setOpaque(true); // Deixa invisivel //
		listPanel[34].setLayout(new GridLayout(1, 1));
		listPanel[34].setBounds( 875, 335, 20, 20 );
		listPanel[34].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[34]);
		
		
		/////// Bangladesh /////////////
		listPanel[35] = new JPanel();
		listPanel[35].setName( "Bangladesh" );
		listPanel[35].setBackground( Color.ORANGE );
		listPanel[35].setOpaque(true); // Deixa invisivel //
		listPanel[35].setLayout(new GridLayout(1, 1));
		listPanel[35].setBounds( 825, 350, 20, 20 );
		listPanel[35].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[35]);
		
		
		/////// India /////////////
		listPanel[36] = new JPanel();
		listPanel[36].setName( "India" );
		listPanel[36].setBackground( Color.ORANGE );
		listPanel[36].setOpaque(true); // Deixa invisivel //
		listPanel[36].setLayout(new GridLayout(1, 1));
		listPanel[36].setBounds( 780, 350, 20, 20 );
		listPanel[36].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[36]);
		
		
		/////// Ira /////////////
		listPanel[37] = new JPanel();
		listPanel[37].setName( "Ira" );
		listPanel[37].setBackground( Color.ORANGE );
		listPanel[37].setOpaque(true); // Deixa invisivel //
		listPanel[37].setLayout(new GridLayout(1, 1));
		listPanel[37].setBounds( 695, 310, 20, 20 );
		listPanel[37].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[37]);
		
		
		/////// Iraque /////////////
		listPanel[38] = new JPanel();
		listPanel[38].setName( "Iraque" );
		listPanel[38].setBackground( Color.ORANGE );
		listPanel[38].setOpaque(true); // Deixa invisivel //
		listPanel[38].setLayout(new GridLayout(1, 1));
		listPanel[38].setBounds( 660, 315, 20, 20 );
		listPanel[38].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[38]);		
		
		
		/////// Jordania /////////////
		listPanel[39] = new JPanel();
		listPanel[39].setName( "Jordania" );
		listPanel[39].setBackground( Color.ORANGE );
		listPanel[39].setOpaque(true); // Deixa invisivel //
		listPanel[39].setLayout(new GridLayout(1, 1));
		listPanel[39].setBounds( 605, 325, 20, 20 );
		listPanel[39].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[39]);
		
		
		/////// Arabia Saudita /////////////
		listPanel[40] = new JPanel();
		listPanel[40].setName( "Arabia Saudita" );
		listPanel[40].setBackground( Color.ORANGE );
		listPanel[40].setOpaque(true); // Deixa invisivel //
		listPanel[40].setLayout(new GridLayout(1, 1));
		listPanel[40].setBounds( 660, 380, 20, 20 );
		listPanel[40].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[40]);
		
		
		
		////////////////////////////
		////////Africa//////////////
		////////////////////////////
		
		/////// Argelia /////////////
		listPanel[41] = new JPanel();
		listPanel[41].setName( "Argelia" );
		listPanel[41].setBackground( Color.MAGENTA );
		listPanel[41].setOpaque(true); // Deixa invisivel //
		listPanel[41].setLayout(new GridLayout(1, 1));
		listPanel[41].setBounds( 460, 350, 20, 20 );
		listPanel[41].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[41]);
		
		
		/////// Egito /////////////
		listPanel[42] = new JPanel();
		listPanel[42].setName( "Egito" );
		listPanel[42].setBackground( Color.MAGENTA );
		listPanel[42].setOpaque(true); // Deixa invisivel //
		listPanel[42].setLayout(new GridLayout(1, 1));
		listPanel[42].setBounds( 550, 355, 20, 20 );
		listPanel[42].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[42]);
		
		
		/////// Nigeria /////////////
		listPanel[43] = new JPanel();
		listPanel[43].setName( "Nigeria" );
		listPanel[43].setBackground( Color.MAGENTA );
		listPanel[43].setOpaque(true); // Deixa invisivel //
		listPanel[43].setLayout(new GridLayout(1, 1));
		listPanel[43].setBounds( 500, 400, 20, 20 );
		listPanel[43].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[43]);
		
		
		/////// Angola /////////////
		listPanel[44] = new JPanel();
		listPanel[44].setName( "Angola" );
		listPanel[44].setBackground( Color.MAGENTA );
		listPanel[44].setOpaque(true); // Deixa invisivel //
		listPanel[44].setLayout(new GridLayout(1, 1));
		listPanel[44].setBounds( 540, 470, 20, 20 );
		listPanel[44].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[44]);
		
		
		/////// Somalia /////////////
		listPanel[45] = new JPanel();
		listPanel[45].setName( "Somalia" );
		listPanel[45].setBackground( Color.MAGENTA );
		listPanel[45].setOpaque(true); // Deixa invisivel //
		listPanel[45].setLayout(new GridLayout(1, 1));
		listPanel[45].setBounds( 600, 445, 20, 20 );
		listPanel[45].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[45]);
		
		
		/////// Africa do Sul /////////////
		listPanel[46] = new JPanel();
		listPanel[46].setName( "Africa do Sul" );
		listPanel[46].setBackground( Color.MAGENTA );
		listPanel[46].setOpaque(true); // Deixa invisivel //
		listPanel[46].setLayout(new GridLayout(1, 1));
		listPanel[46].setBounds( 565, 530, 20, 20 );
		listPanel[46].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[46]);
		
		
		////////////////////////////
		//////// Oceania/////////////
		////////////////////////////
	//	//////// Perth /////////////		
		listPanel[47] = new JPanel();
		listPanel[47].setName( "Perth" );
		listPanel[47].setBackground( Color.GRAY );
		listPanel[47].setOpaque(true); // Deixa invisivel //
		listPanel[47].setLayout(new GridLayout(1, 1));
		listPanel[47].setBounds( 790, 550, 20, 20 );
		listPanel[47].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[47]);
		
		
		//	//////// Australia /////////////		
		listPanel[48] = new JPanel();
		listPanel[48].setName( "Australia" );
		listPanel[48].setBackground( Color.GRAY );
		listPanel[48].setOpaque(true); // Deixa invisivel //
		listPanel[48].setLayout(new GridLayout(1, 1));
		listPanel[48].setBounds( 845, 565, 20, 20 );
		listPanel[48].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[48]);
		
		
		//	//////// Nova Zelandia /////////////		
		listPanel[49] = new JPanel();
		listPanel[49].setName( "Nova Zelandia" );
		listPanel[49].setBackground( Color.GRAY );
		listPanel[49].setOpaque(true); // Deixa invisivel //
		listPanel[49].setLayout(new GridLayout(1, 1));
		listPanel[49].setBounds( 912, 590, 20, 20 );
		listPanel[49].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[49]);
		
		frame.setVisible(true);
		
		//	//////// Indonesia /////////////		
		listPanel[50] = new JPanel();
		listPanel[50].setName( "Indonesia" );
		listPanel[50].setBackground( Color.GRAY );
		listPanel[50].setOpaque(true); 
		listPanel[50].setLayout(new GridLayout(1, 1));
		listPanel[50].setBounds( 875, 468, 20, 20 );
		listPanel[50].addMouseListener( getMouseListener() );
		
		frame.add(listPanel[50]);
		
		setExercitosIniciais();
		
		frame.setVisible(true);
		
	}

	private static MouseListener getMouseListener()
	{
		return new MouseAdapter()
		{
			@Override
			public void mouseClicked( MouseEvent e )
			{
				if (ControlaView.getInicializaView().getFaseCtrl()<4 || ControlaView.getInicializaView().getFaseCtrl() > 5 ) {
					System.out.println( ( ( JComponent ) e.getSource() ).getName() );
					int qtdExercitos =	Ctrl.getInstance().registra(getCxTabuleiro()).getNumExercitos(( ( JComponent ) e.getSource() ).getName());

					String dono = Ctrl.getInstance().registra(getCxTabuleiro()).getCorDonoTerritorio( ( ( JComponent ) e.getSource() ).getName());

					String msg = "Quantidade de Exércitos: "+qtdExercitos+"\nCor do Dono: "+dono;
					JOptionPane.showMessageDialog(null, msg,( ( JComponent ) e.getSource() ).getName(),JOptionPane.INFORMATION_MESSAGE);
				}
				
				// Se ele decidiu atacar //
				if (ControlaView.getInicializaView().getRespostaAtk().contentEquals("Sim")==true) {
					switch(ControlaView.getInicializaView().getFaseCtrl()) {
						case 2:
							corJog = Ctrl.getInstance().registra(getCxTabuleiro()).getCorDonoTerritorio( ( ( JComponent ) e.getSource() ).getName());
							// Define QtdExAtk //
							ControlaView.getInicializaView().setQtdExAtk(Ctrl.getInstance().registra(getCxTabuleiro()).getNumExercitos(( ( JComponent ) e.getSource() ).getName()));
							
							setAtacante(( ( JComponent ) e.getSource() ).getName());
							JOptionPane.showMessageDialog(null, "Selecione o território defensor",null,JOptionPane.INFORMATION_MESSAGE);
	
							break;
						case 3:
							
							// Define QtdExDef //
							ControlaView.getInicializaView().setQtdExDef(Ctrl.getInstance().registra(getCxTabuleiro()).getNumExercitos(( ( JComponent ) e.getSource() ).getName()));
							setDefensor(( ( JComponent ) e.getSource() ).getName());
							break;			
					}
				}
				else if ( ControlaView.getInicializaView().getFaseCtrl()==5) {
					
					if (ControlaView.getInicializaView().getTerritorioDistribuidor()==null) {
						ControlaView.getInicializaView().setTerritorioDistribuidor( ( (JComponent) e.getSource() ).getName() );
						JOptionPane.showMessageDialog(null, "Selecione o território recebedor",null,JOptionPane.INFORMATION_MESSAGE);

					}
					else if(ControlaView.getInicializaView().getTerritorioRecebedor()==null) {
						ControlaView.getInicializaView().setTerritorioRecebedor( ( (JComponent) e.getSource() ).getName() );
						int qtdExercitos =	Ctrl.getInstance().registra(getCxTabuleiro()).getNumExercitos(ControlaView.getInicializaView().getTerritorioDistribuidor());
						
						CxDefineQtdMover.getCxDefineQtdMover(qtdExercitos,ControlaView.getInicializaView().getTerritorioDistribuidor(),ControlaView.getInicializaView().getTerritorioRecebedor());

					}
					
					
					


				}
				
				
				
				
				
				
				
				
			}
		};
	}
	
	private static void  setAtacante(String territorioAtacante)
	{
		
		JOptionPane.showMessageDialog(null,"Território atacante: "+territorioAtacante,null,JOptionPane.INFORMATION_MESSAGE); 
		ControlaView.getInicializaView().setTerritorioAtk(territorioAtacante);
		ControlaView.getInicializaView().setFaseJogada(3);
		

	}
	private static void setDefensor(String territorioDefensor) {
		ControlaView.getInicializaView().setTerritorioDef(territorioDefensor);
		JOptionPane.showMessageDialog(null,"Território defensor: "+territorioDefensor,null,JOptionPane.INFORMATION_MESSAGE); 
		
		if (ControlaJogo.getControlaJogo().verificaAtaque(ControlaView.getInicializaView().getTerritorioAtk(), territorioDefensor, corJog)==true) {
			System.out.println("O ataque pode ser realizado");
			// Seta a cor do jogador Atacante //
			ControlaView.getInicializaView().setCorAtk(corJog);
			// Apresenta a tela para jogar os dados //
			int dAtk = ControlaView.getInicializaView().getQtdExAtk()-1;
			int dDef = ControlaView.getInicializaView().getQtdExDef();
			if ( dAtk > 3) {
				dAtk =3;
			}
			if ( dDef > 3) {
				dDef = 3;
			}
			
			new CxExibeDados(dAtk, dDef);
			//ControlaView.getInicializaView().setFaseJogada(4);
		}
		else {
			System.out.println("O ataque não pode ser realizado");
			CxPerguntaAtkOuNao.getCxPerguntaAtkOuNao();
			ControlaView.getInicializaView().setFaseJogada(1);
			//JOptionPane.showMessageDialog(null, "Selecione o território atacante",null,JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}

	public void setExercitosIniciais() {
		
		Color a = null;
		
		for (int i=0;i<51;i++) {
			a = Ctrl.getInstance().registra(this).getCorTerritorioJava(listPanel[i].getName());
			listPanel[i].setBackground(a);
			
		}
		
		frame.repaint();
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
		System.out.println("CxTabuleiro notificado");
		
		for(int i=0;i<listPanel.length;i++) {
			if(listPanel[i].getName()==ControlaView.getInicializaView().getTerritorioDef()) {
				listPanel[i].setBackground(o.getCorTerritorioJava(ControlaView.getInicializaView().getTerritorioDef()));
				break;
			}
		}
		
		
		
		
		
		
	}
	



}
