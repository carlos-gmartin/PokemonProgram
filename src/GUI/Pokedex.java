package GUI;

import pokedex.Data.DataBank;
import pokedex.Data.Pokemon;
import pokedex.Data.Sorting;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Pokedex implements ActionListener {

    // Search panel
    public JLabel status;
    public JTextField entry;
    public JTextField idEntry;
    public JButton submit;
    public JLabel searchIdLabel;
    public JLabel searchNameLabel;
    public JButton searchAll;

    // Pokemon table panel
    public JLabel id, name, type1, type2, totalPoints,
            healthPoints, attack, defense,
            specialAttack, specialDefense, speed,
            legendary, generation;

    public JLabel idP, nameP, type1P, type2P, totalPointsP,
            healthPointsP, attackP, defenseP,
            specialAttackP, specialDefenseP, speedP,
            legendaryP, generationP;

    public JButton pokemonImage;
    public JLabel pokemonCaption;

    public Pokemon pokemon;

    public Pokedex() {

        Border blackBorder = BorderFactory.createMatteBorder(0, 0, 3, 0, Color.black);
        Border pinkBorder = BorderFactory.createMatteBorder(0, 0, 3, 0,Color.PINK);

        // Search panel

        status = new JLabel();
        status.setText("status");
        status.setBounds(25, 80, 400, 20);
        status.setFont(new Font("Century Gothic", Font.BOLD, 15));
        status.setForeground(Color.red);

        // Id Label
        searchIdLabel = new JLabel();
        searchIdLabel.setText("Search pokemon ID");
        searchIdLabel.setBounds(25, 0, 300, 40);
        searchIdLabel.setFont(new Font("Century Gothic", Font.BOLD, 15));

        // Id entry
        idEntry = new JTextField();
        idEntry.setBackground(null);
        idEntry.setBounds(25, 30, 220, 40);
        idEntry.setFont(new Font("Century Gothic", Font.BOLD, 15));
        idEntry.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e){
                entry.setText("");
                idEntry.setBorder(pinkBorder);
                entry.setBorder(blackBorder);
            }
        });
        idEntry.setBorder(blackBorder);

        // Name label
        searchNameLabel = new JLabel();
        searchNameLabel.setText("Search pokemon Name");
        searchNameLabel.setBounds(250, 0, 300, 40);
        searchNameLabel.setFont(new Font("Century Gothic", Font.BOLD, 15));

        // Name entry
        entry = new JTextField();
        entry.setBackground(null);
        entry.setBounds(250, 30, 635, 40);
        entry.setFont(new Font("Century Gothic", Font.BOLD, 21));
        entry.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e){
                idEntry.setText("");
                entry.setBorder(pinkBorder);
                idEntry.setBorder(blackBorder);
            }
        });
        entry.setBorder(blackBorder);

        // SearchAll pokemon
        searchAll = new JButton();
        Tools.setSearchButton(searchAll,"Browser Pokemon",1100,20,200,60);
        searchAll.addActionListener(this);

        // Search pokemon
        submit = new JButton();
        Tools.setSearchButton(submit,"Search",900,20,100,40);
        submit.addActionListener(this);


        // Table panel
        // Info labels...
        id = new JLabel();
        Tools.setInfoLabels(id, "ID", 20);
        name = new JLabel();
        Tools.setInfoLabels(name, "Name", 60);
        type1 = new JLabel();
        Tools.setInfoLabels(type1, "Type 1", 100);
        type2 = new JLabel();
        Tools.setInfoLabels(type2, "Type 2", 140);
        totalPoints = new JLabel();
        Tools.setInfoLabels(totalPoints, "Total points", 180);
        healthPoints = new JLabel();
        Tools.setInfoLabels(healthPoints, "Health points", 220);
        attack = new JLabel();
        Tools.setInfoLabels(attack, "Attack", 260);
        defense = new JLabel();
        Tools.setInfoLabels(defense, "Defense", 300);
        specialAttack = new JLabel();
        Tools.setInfoLabels(specialAttack, "Special attack", 340);
        specialDefense = new JLabel();
        Tools.setInfoLabels(specialDefense, "Special defense", 380);
        speed = new JLabel();
        Tools.setInfoLabels(speed, "Speed", 420);
        legendary = new JLabel();
        Tools.setInfoLabels(legendary, "Legendary", 460);
        generation = new JLabel();
        Tools.setInfoLabels(generation, "Generation", 500);

        // Pokemon data labels
        idP = new JLabel();
        Tools.pokemonInfoBox(idP, 20);
        nameP = new JLabel();
        Tools.pokemonInfoBox(nameP, 60);
        type1P = new JLabel();
        Tools.pokemonInfoBox(type1P, 100);
        type2P = new JLabel();
        Tools.pokemonInfoBox(type2P, 140);
        totalPointsP = new JLabel();
        Tools.pokemonInfoBox(totalPointsP, 180);
        healthPointsP = new JLabel();
        Tools.pokemonInfoBox(healthPointsP, 220);
        attackP = new JLabel();
        Tools.pokemonInfoBox(attackP, 260);
        defenseP = new JLabel();
        Tools.pokemonInfoBox(defenseP, 300);
        specialAttackP = new JLabel();
        Tools.pokemonInfoBox(specialAttackP, 340);
        specialDefenseP = new JLabel();
        Tools.pokemonInfoBox(specialDefenseP, 380);
        speedP = new JLabel();
        Tools.pokemonInfoBox(speedP, 420);
        legendaryP = new JLabel();
        Tools.pokemonInfoBox(legendaryP, 460);
        generationP = new JLabel();
        Tools.pokemonInfoBox(generationP, 500);

        // Pokemon image panel

        pokemonImage = new JButton();
        pokemonImage.setBounds(0, -135, 600, 700);
        Tools.setButton(pokemonImage);
        pokemonCaption = new JLabel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {

                String userSearch = entry.getText();
                String idSearch = idEntry.getText();

                System.out.println("Searched id: " + idSearch);
                System.out.println("Searched name: " + userSearch);

                if(idSearch.equals("")){
                    pokemon = Sorting.searchPokemon(userSearch);
                }
                else if (userSearch.equals("")){
                    pokemon = Sorting.searchPokemonID(Integer.valueOf(idSearch));
                }
                if (pokemon != null){
                    idP.setText(String.valueOf(pokemon.getId()));
                    nameP.setText(pokemon.getName());
                    type1P.setText(pokemon.getType1());
                    type2P.setText(pokemon.getType1());
                    totalPointsP.setText(String.valueOf(pokemon.getTotalPoints()));
                    healthPointsP.setText(String.valueOf(pokemon.getHealthPoints()));
                    attackP.setText(String.valueOf(pokemon.getAttack()));
                    defenseP.setText(String.valueOf(pokemon.getDefense()));
                    specialAttackP.setText(String.valueOf(pokemon.getSpecialAttack()));
                    specialDefenseP.setText(String.valueOf(pokemon.getSpecialDefense()));
                    speedP.setText(String.valueOf(pokemon.getSpeed()));
                    legendaryP.setText(String.valueOf(pokemon.isLegendary()));
                    generationP.setText(String.valueOf(pokemon.getGeneration()));


                    Tools.setPokemonImage(pokemon,pokemonImage,600,550);

                    pokemonCaption.setText(pokemon.getName());
                    pokemonCaption.setFont(new Font("Century Gothic", Font.BOLD, 38));
                    pokemonCaption.setBounds(200, 490, 600, 50);

                    status.setText("Found pokemon");
                }
                else{
                    status.setText("Could not find pokemon...ERROR");
                }

            }
            catch (Exception error) {
                status.setText("ERROR insert valid ID or Name");
            }
        }
        if (e.getSource() == searchAll){
            try {
                new AllPokemonWindow();
            }
            catch (Exception ex){
                System.out.println("Failed to open error: " + ex);
            }
        }
    }
}
