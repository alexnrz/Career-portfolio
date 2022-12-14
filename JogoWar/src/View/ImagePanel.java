package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Painel que aceita uma imagem de fundo
 */
public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private final BufferedImage imagem;

	public ImagePanel(String resource) {
		BufferedImage buffer = null;
		try {
			buffer = ImageIO.read(getClass().getResourceAsStream(resource));
		} catch (Exception e) {
			e.printStackTrace();
		}
		imagem = buffer;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Dimension size = getSize();
		g.drawImage(imagem, 0, 0, size.width, size.height, this);
	}
}