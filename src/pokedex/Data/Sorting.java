package pokedex.Data;

import java.util.*;

public class Sorting {

    // Specific searches


    public static Pokemon searchPokemon(String search) {
        String name = search.trim().substring(0, 1).toUpperCase() + search.substring(1);
        for (Pokemon o : DataBank.Pokedex) {
            if (Objects.equals(name, o.getName())) {
                return o;
            }
        }
        System.err.println("Could not find that pokemon: " + name);
        return null;
    }

    public static Pokemon searchPokemonID(Integer ID) {
        int id = Math.abs(ID);
        for (Pokemon o : DataBank.Pokedex) {
            if (id == o.getId()) {
                return o;
            }
        }
        System.err.println("Could not find that pokemon id: " + id);
        return null;
    }
}


    // Number compares

    class totalPoints implements Comparator<Pokemon> {
        public int compare(Pokemon o1, Pokemon o2) {
            return Double.compare(o1.getTotalPoints(), o2.getTotalPoints());
        }
    }

    class healthPoints implements Comparator<Pokemon> {
        public int compare(Pokemon o1, Pokemon o2) {
            return Double.compare(o1.getHealthPoints(), o2.getHealthPoints());
        }
    }

    class Attack implements Comparator<Pokemon> {
        public int compare(Pokemon o1, Pokemon o2) {
            return Double.compare(o1.getAttack(), o2.getAttack());
        }
    }

    class Defense implements Comparator<Pokemon> {
        public int compare(Pokemon o1, Pokemon o2) {
            return Double.compare(o1.getDefense(), o2.getDefense());
        }
    }

    class specialAttack implements Comparator<Pokemon> {
    public int compare(Pokemon o1, Pokemon o2) {
        return Double.compare(o1.getSpecialAttack(), o2.getSpecialAttack());
         }
    }

    class specialDefense implements Comparator<Pokemon> {
        public int compare(Pokemon o1, Pokemon o2) {
            return Double.compare(o1.getSpecialDefense(), o2.getSpecialDefense());
        }
    }

    class speed implements Comparator<Pokemon> {
        public int compare(Pokemon o1, Pokemon o2) {
            return Double.compare(o1.getSpeed(), o2.getSpeed());
        }
    }

    class Generation implements Comparator<Pokemon> {
        public int compare(Pokemon o1, Pokemon o2) {
            return Double.compare(o2.getGeneration(), o1.getGeneration());
        }
    }
    class Level implements Comparator<Pokemon> {
        public int compare(Pokemon o1, Pokemon o2) {
            return Double.compare(o2.getLevel(), o1.getLevel());
        }
    }





