package GUI;

import pokedex.Data.DataBank;
import pokedex.Data.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllPokemonWindow implements ActionListener {

    public JButton button;

    public AllPokemonWindow(){

        JFrame pokeFrame = new JFrame();

        ImageIcon pokeballIcon = new ImageIcon("Pokemon/src/resources/images/menus/pokeball.png");

        pokeFrame.setIconImage(pokeballIcon.getImage());
        pokeFrame.setTitle("Pokebrowse");
        pokeFrame.setSize(700,700);
        pokeFrame.setVisible(true);
        pokeFrame.setLocationRelativeTo(null);
        pokeFrame.setResizable(false);
        pokeFrame.setLayout(new BorderLayout());

        JPanel pokemonGridPanel = new JPanel();
        JPanel pokemonSortByPanel = new JPanel();

        pokemonGridPanel.setBackground(Color.PINK);
        pokemonSortByPanel.setBackground(new Color(0xFFD0FCF3,true));

        pokeFrame.add(pokemonSortByPanel,BorderLayout.NORTH);
        pokeFrame.add(pokemonGridPanel, BorderLayout.CENTER);

        // Scroll bar
        JScrollPane scrollPane = new JScrollPane(pokemonGridPanel);
        scrollPane.setHorizontalScrollBar(null);
        pokeFrame.getContentPane().add(scrollPane);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());

        FlowLayout experimentLayout = new FlowLayout(FlowLayout.LEADING);
        pokemonSortByPanel.setLayout(null);
        pokemonGridPanel.setLayout(experimentLayout);

        pokemonSortByPanel.setPreferredSize(new Dimension(700,100));
        pokemonGridPanel.setPreferredSize(new Dimension(700,5300));

        // Pokemon images.menus.icons loop.
        for (int index = 0; index < DataBank.Pokedex.size(); index++) {
            button = new JButton();
            Pokemon pokemon = DataBank.Pokedex.get(index);
            Tools.setButton(button);
            Tools.setPokemonImage(pokemon,button, 60,60);
            button.setBounds(0, 0, 60, 60);
            button.setToolTipText("<html>" +
                    "<h4 style=\"color:red;\"> ID:  " + pokemon.getId() + "</h4>" +
                    "<h4> Name:  "+ pokemon.getName() +"</h4>" +
                    "<h4> Gen:  " + pokemon.getGeneration() +"</h4>" +
                                "</html>");
            pokemonGridPanel.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
