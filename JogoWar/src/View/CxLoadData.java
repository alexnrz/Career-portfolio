package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.ControlaJogo;
class CxLoadData extends JFrame{


    private static JFrame frame = new JFrame();
    private static CxLoadData ctrl = null;
    

    public static CxLoadData getCxLoadData() {
        if (ctrl==null) {
            ctrl = new CxLoadData();
        }

        return ctrl;
    }
    
    private CxLoadData() {

        frame.setTitle("Load Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,2));

        
        frame.setBounds(1470, 800, 285, 80);

        JButton loadButton = new JButton();
        loadButton.setText("Carregar Jogo");
        loadButton.setSize(55,45);
        loadButton.addActionListener((ActionEvent e) -> loadData());
        frame.add(loadButton);
        frame.setVisible(true);

    }
    
    public void loadData() {
   	 FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("TEXT FILES","txt","text"); 
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileFilter(fileFilter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int option = fileChooser.showDialog(fileChooser, "Carregar");

        if (option == JFileChooser.APPROVE_OPTION) {
        	ControlaJogo.getControlaJogo().loadData(fileChooser.getSelectedFile());
        }
   }
}