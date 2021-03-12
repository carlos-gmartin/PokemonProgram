package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Start extends JFrame implements ActionListener, MouseListener {

    public JFrame startFrame = new GameFrame();
    JButton startButton = new JButton();

    ImageIcon startIcon = new ImageIcon("Pokemon/src/resources/images/menus/pokeballHover.png");
    ImageIcon startIconHover = new ImageIcon("Pokemon/src/resources/images/menus/pokeball.png");

    public Start(){
        // Start button //
        startButton.setText("...Start game...");
        startButton.setFont(new Font("Serif", Font.BOLD, 50));
        startButton.setForeground(new Color(0xFF37474F,true));
        startButton.setSize(1400,700);
        startButton.addMouseListener(this);
        startButton.addActionListener(this);
        startButton.setHorizontalTextPosition(JLabel.CENTER);
        startButton.setVerticalTextPosition(JLabel.BOTTOM);
        Tools.setButton(startButton);
        startButton.setVisible(true);
        startFrame.setLayout(null);
        startFrame.add(startButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == startButton){
            System.out.println("GUI initialized...");
            startButton.setVisible(false);
            startFrame.remove(startButton);
            startFrame.dispose();

            Menu menuMenu = new Menu();
            try {
                menuMenu.displayGUI();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        startButton.setIcon(startIconHover);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        startButton.setIcon(startIcon);
    }
}
