package View;
import java.awt.*;
import javax.swing.*;

class CxNovoJogo extends JFrame{

	private static final long serialVersionUID = 1L;

	private String imgMenu = "/Img/bgconfiguracao.png";
	private JButton btnJogar;

	public CxNovoJogo() {
		// utilize como container um painel próprio para renderizar uma imagem de fundo
		ImagePanel imagePanel = new ImagePanel(imgMenu);
		this.setContentPane(imagePanel);

		this.setTitle("Novo Jogo");
		this.setSize(410, 685);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		btnJogar = new JButton("");
		btnJogar.setBounds(0, 0, 100, 30);
		btnJogar.setOpaque(false);
		btnJogar.setContentAreaFilled(false);
		btnJogar.setBorderPainted(false);

		btnJogar.addActionListener(event -> pressionouBtnJogar());

		JPanel painel = new JPanel();
		painel.setOpaque(false); // o container do botão também tem que ser transparente
		painel.setLayout(new GridLayout(1, 1));
		painel.setBounds(0, 55, 235, 45);
		painel.add(btnJogar);

		this.add(painel);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(3);

	}

	private void pressionouBtnJogar() {
		ControlaView.getInicializaView().inicilizaInfosIniciais();
		dispose();
	}


}




