package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.ControlaJogo;

class CxSaveGame extends JFrame{


    private static JFrame frame = new JFrame();
    private static CxSaveGame ctrl = null;
    

    public static CxSaveGame getCxSaveGame() {
        if (ctrl==null) {
            ctrl = new CxSaveGame();
        }

        return ctrl;
    }

    private CxSaveGame() {

        frame.setTitle("Save Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,2));

        frame.setBounds(1470, 700, 285, 80);

        JButton saveButton = new JButton();
        saveButton.setText("Salvar Jogo");
        saveButton.setSize(55,45);
        saveButton.addActionListener((ActionEvent e) -> {
			try {
				saveGame();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        frame.add(saveButton);
        frame.setVisible(true);

    }

    public void saveGame() throws IOException {
    	 FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("TEXT FILES","txt","text"); 
         JFileChooser fileChooser = new JFileChooser();

         fileChooser.setFileFilter(fileFilter);
         fileChooser.setAcceptAllFileFilterUsed(false);

         int option = fileChooser.showDialog(fileChooser, "Salvar");

         if (option == JFileChooser.APPROVE_OPTION) 
         	ControlaJogo.getControlaJogo().saveGame(fileChooser.getSelectedFile());
    }

}
