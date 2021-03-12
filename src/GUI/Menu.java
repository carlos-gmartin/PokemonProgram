/**
 *
 *  Pokemon HOME menu GUI
 *
 *  Pokedex
 *  -Search,ID and name working, Diplay all pokemon images.menus.icons.
 *  -Missing browser all pokemon and filter systems.
 *
 *  -Issues with search for images.menus.icons as ID is different for some images
 *   Such as "15 - mega.png"
 *
 *  Game
 *  - Game development has started.
 *
 *  Settings
 *  -Not yet implemented.
 *
 *  @author Carlos Gerardo Martin
 *  @version 1.2
 *  @since   2021-3-3
 */

package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Menu implements ActionListener, MouseListener {

    private final GameFrame menuFrame = new GameFrame();

    JPanel panelLeft = new JPanel();
    JPanel panelCenter = new JPanel();
    JPanel panelRight = new JPanel();

    JButton dataB = new JButton();
    JButton startB = new JButton();
    JButton settingB = new JButton();

    ImageIcon dataIcon = new ImageIcon("Pokemon/src/resources/images/menus/searchPokemonPicture.jpg");
    ImageIcon startIcon = new ImageIcon("Pokemon/src/resources/images/menus/startGameIcon.jpg");
    ImageIcon settingsIcon = new ImageIcon("Pokemon/src/resources/images/menus/settingsIcon.jpg");


    void displayGUI() throws Exception {

        menuFrame.setLayout(new BorderLayout());

        panelCenter.setBackground(Color.BLACK);
        panelLeft.setBackground(Color.BLACK);
        panelRight.setBackground(Color.BLACK);

        menuFrame.add(panelCenter, BorderLayout.CENTER);
        menuFrame.add(panelLeft, BorderLayout.WEST);
        menuFrame.add(panelRight, BorderLayout.EAST);

        dataB.setBounds(0,0,350,700);
        startB.setBounds(0,0,700,700);
        settingB.setBounds(0,0,350,700);

        dataB.setIcon(dataIcon);
        startB.setIcon(startIcon);
        settingB.setIcon(settingsIcon);
        dataB.addActionListener(this);

        Tools.setButton(dataB);
        Tools.setButton(startB);
        Tools.setButton(settingB);

        panelLeft.add(dataB);
        panelCenter.add(startB);
        panelRight.add(settingB);

        panelCenter.setLayout(new BorderLayout());
        panelLeft.setLayout(new BorderLayout());
        panelRight.setLayout(new BorderLayout());

        panelCenter.setPreferredSize(new Dimension(700,700));
        panelLeft.setPreferredSize(new Dimension(350,700));
        panelRight.setPreferredSize(new Dimension(350,700));
    }

    void pokedex() throws IOException{

        JPanel searchPanel = new JPanel();
        JPanel infoPanel = new JPanel();
        JPanel tablePanel = new JPanel();

        menuFrame.setLayout(new BorderLayout());
        menuFrame.add(searchPanel,BorderLayout.NORTH);
        menuFrame.add(infoPanel, BorderLayout.EAST);
        menuFrame.add(tablePanel, BorderLayout.CENTER);

        searchPanel.setBackground(new Color(0xFFD0FCF3,true));
        infoPanel.setBackground(new Color(0xFFD0FCF3,true));
        tablePanel.setBackground(new Color(0xFFD0FCF3,true));

        searchPanel.setLayout(null);
        infoPanel.setLayout(null);
        tablePanel.setLayout(null);

        searchPanel.setPreferredSize(new Dimension(1400,100));
        infoPanel.setPreferredSize(new Dimension(600,600));
        tablePanel.setPreferredSize(new Dimension(800,600));

        Pokedex p = new Pokedex();

        // searchPanel

        searchPanel.add(p.entry);
        searchPanel.add(p.idEntry);
        searchPanel.add(p.status);
        searchPanel.add(p.submit);
        searchPanel.add(p.searchIdLabel);
        searchPanel.add(p.searchNameLabel);
        searchPanel.add(p.searchAll);

        // Pokemon info mini table

        tablePanel.add(p.id);
        tablePanel.add(p.name);
        tablePanel.add(p.type1);
        tablePanel.add(p.type2);
        tablePanel.add(p.totalPoints);
        tablePanel.add(p.healthPoints);
        tablePanel.add(p.attack);
        tablePanel.add(p.defense);
        tablePanel.add(p.specialAttack);
        tablePanel.add(p.specialDefense);
        tablePanel.add(p.speed);
        tablePanel.add(p.generation);
        tablePanel.add(p.legendary);

        tablePanel.add(p.idP);
        tablePanel.add(p.nameP);
        tablePanel.add(p.type1P);
        tablePanel.add(p.type2P);
        tablePanel.add(p.totalPointsP);
        tablePanel.add(p.healthPointsP);
        tablePanel.add(p.attackP);
        tablePanel.add(p.defenseP);
        tablePanel.add(p.specialAttackP);
        tablePanel.add(p.specialDefenseP);
        tablePanel.add(p.speedP);
        tablePanel.add(p.generationP);
        tablePanel.add(p.legendaryP);

        // imagePanel
        infoPanel.add(p.pokemonImage);
        infoPanel.add(p.pokemonCaption);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dataB){

            System.out.println("Pokedex Open");

            panelLeft.setVisible(false);
            panelRight.setVisible(false);
            panelCenter.setVisible(false);
            dataB.setVisible(false);
            startB.setVisible(false);
            settingB.setVisible(false);

            try {
                pokedex();
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
