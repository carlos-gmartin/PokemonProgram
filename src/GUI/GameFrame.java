package GUI;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    ImageIcon pokeballIcon = new ImageIcon("Pokemon/src/resources/images/menus/pokeball.png");

    public GameFrame(){

        this.getContentPane().setBackground(new Color(0xFFD0FCF3, true));
        this.setIconImage(pokeballIcon.getImage());
        this.setTitle("Pokedex");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400,700);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

}
