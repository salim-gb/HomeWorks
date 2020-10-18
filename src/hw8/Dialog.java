package hw8;

import javax.swing.*;

public class Dialog  extends JDialog {

    private GameWindow gameWindow;

    public Dialog(GameWindow gameWindow, String results){
        this.gameWindow = gameWindow;
        setTitle("Результаты");
        setResizable(false);
        setModal(true);

        JTextPane textPane = new JTextPane();
        textPane.setText(results);
        textPane.setBackground(getContentPane().getBackground());
        textPane.setEditable(false);
        add(textPane);

        pack();
    }

}
