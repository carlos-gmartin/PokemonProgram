/**
  ____         _
 |  _ \  ___  | | __ ___  _ __ ___    ___   _ __
 | |_) |/ _ \ | |/ // _ \| '_ ` _ \  / _ \ | '_ \
 |  __/| (_) ||   <|  __/| | | | | || (_) || | | |
 |_|    \___/ |_|\_\\___||_| |_| |_| \___/ |_| |_|

 The pokemon database, currently working on a pokemon database
 structure, storing and sorting through the pokedex.

 -- New pokemonHunt coming soon --

  @author  Carlos Gerardo Martin
 * @version 1.2
 * @since   2021-3-3
 */

package GUI;

import pokedex.Data.DataBank;
import pokedex.Data.Sorting;

import javax.xml.crypto.Data;

public class Main {

    public static void main(String[] args) {
        // Read pokedex txt file
        DataBank.readDatabase("Pokemon/src/pokedex/Data/pokedex.txt");
        // Title sequence
        DataBank.title();

        new Start();
        // GUI

    }
}
