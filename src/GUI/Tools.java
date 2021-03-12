package GUI;

import pokedex.Data.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tools {

    // TOOLS FOR GUI CREATION.
    // Create a button generic //
    public static void setButton(JButton button) {
        button.setFocusable(false);
        button.setBorder(null);
        button.setContentAreaFilled(false);
    }

    public static void setInfoLabels(JLabel label, String text,int y){
        label.setText(text + ":");
        label.setBounds(30,y,350,40);
        label.setFont(new Font("Hiragino Kaku Gothic Pro", Font.BOLD, 28));
    }

    public static void pokemonInfoBox(JLabel label, int y){
        label.setBounds(300,y,350,40);
        label.setFont(new Font("Century Gothic", Font.BOLD, 29));
    }
    public static void setPokemonImage(Pokemon pokemon, JButton pokemonPosition, int width, int height){
        String imageID = "Pokemon/src/resources/images/icons/" + pokemon.getId() + ".png";

        // Resize img
        ImageIcon pokemonIcon = new ImageIcon(imageID);
        Image pokemonPic = pokemonIcon.getImage();
        Image newPokemonImg = pokemonPic.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon pokemonIconResized = new ImageIcon(newPokemonImg);

        pokemonPosition.setIcon(pokemonIconResized);
    }

    public static void setSearchButton(JButton button, String text, int x, int y,int width,int height){
        button.setText(text);
        button.setBounds(x, y, width,height );
        button.setFont(new Font("Gill Sans MT",Font.BOLD,16));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.PINK);
        button.setFocusable(false);
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Color.decode("#9f9fe9"));
                button.setRolloverEnabled(true);
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(Color.PINK);
                button.setRolloverEnabled(true);
            }
        });
    }
}
