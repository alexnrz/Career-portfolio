package View;

import javax.swing.JFrame;

class CxExibeCartaBonus extends JFrame {
	
	
	private static String imgCarta;
	private static ImagePanel imgPanel;
	private static JFrame frame = new JFrame();
	
	private static CxExibeCartaBonus ctrl = null;
	
	public static CxExibeCartaBonus getCxExibeCartaBonus(String nomeCarta) {
		if(ctrl == null) {
			ctrl = new CxExibeCartaBonus();
		}
		else {
			ctrl= new CxExibeCartaBonus();
		}
		
		nomeCarta = nomeCarta.toLowerCase();
		nomeCarta = nomeCarta.replace(" ", "");
		imgCarta = "/Img/war_carta_"+nomeCarta+".png";
		System.out.println("IMG CARTA: "+ imgCarta);
		imgPanel = new ImagePanel(imgCarta);
		frame.setContentPane(imgPanel);
		frame.repaint();
		return ctrl;
	}
	
	
	
	
	private CxExibeCartaBonus() {
		
		frame.setTitle("Carta Bônus Recebida");
		frame.setSize(140,225);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
	}
	
	
	

}
