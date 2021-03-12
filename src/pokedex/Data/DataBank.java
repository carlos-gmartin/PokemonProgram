package pokedex.Data;

import java.io.*;
import java.util.ArrayList;

public class DataBank {

    public static final ArrayList<Pokemon> Pokedex = new ArrayList<>();
    int commaCount;

    public static void readDatabase(String file){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null){
                Pokemon pokemon = new Pokemon(line);
                storeDatabase(pokemon);
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e) {
            System.err.println("Error has occurred");
            e.printStackTrace();
        }
    }
    private static void storeDatabase(Pokemon pokemon){
        DataBank.Pokedex.add(pokemon);
    }

    public static void sortingMethods(String sortType, ArrayList<Pokemon> Array) {
        String sort = sortType.toLowerCase().trim();
        switch (sort) {
            case "totalpoints", "total points" -> Array.sort(new totalPoints());
            case "healthpoints", "health points" -> Array.sort(new healthPoints());
            case "attack" -> Array.sort(new Attack());
            case "defense" -> Array.sort(new Defense());
            case "specialattack", "special attack" -> Array.sort(new specialAttack());
            case "specialdefense", "special defense" -> Array.sort(new specialDefense());
            case "speed" -> Array.sort(new speed());
            case "level" -> Array.sort(new Level());
            case "generation" -> Array.sort(new Generation());
        }
    }

    public static void printArray(ArrayList<Pokemon> Array) {
        for (Object o : Array) {
            System.out.println(o);
        }
    }
    public static void printLines(Integer amount) {
        for (int i = 0; i < amount ; i++) {
            System.out.println("==================================================");
        }
    }

    public static void title(){
        printLines(2);
        System.out.println("""
                 ____         _
                |  _ \\  ___  | | __ ___  _ __ ___    ___   _ __
                | |_) |/ _ \\ | |/ // _ \\| '_ ` _ \\  / _ \\ | '_ \\
                |  __/| (_) ||   <|  __/| | | | | || (_) || | | |
                |_|    \\___/ |_|\\_\\\\___||_| |_| |_| \\___/ |_| |_|""".indent(1));

        printLines(2);
        System.out.println("There are currently " + Pokedex.get(Pokedex.size()-1).getId() + " pokemon in this database." );
    }


    public static void main(String[] args) {
        // testing
        DataBank.readDatabase("Pokemon\\src\\pokedex\\pokedex.txt");

        sortingMethods("attack", DataBank.Pokedex);
        System.out.println(Pokedex);

        DataBank.printLines(7);
        DataBank.printLines(7);
        DataBank.printLines(7);

        sortingMethods("defense", DataBank.Pokedex);
        System.out.println(Pokedex);



    }
}

