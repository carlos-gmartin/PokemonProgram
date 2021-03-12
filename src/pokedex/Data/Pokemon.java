package pokedex.Data;


import java.util.ArrayList;

public class Pokemon {

    // Fields

    private final int id;
    private final String name;
    private final String type1;
    private String type2;
    private double totalPoints;
    private double healthPoints;
    private double attack;
    private double defense;
    private double specialAttack;
    private double specialDefense;
    private double speed;
    private final int generation;
    private final boolean legendary;
    private int level;

    // constructors

    public Pokemon(String line){


        ArrayList<String> split = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder builder = new StringBuilder();

        for (char character : line.toCharArray()){
            if (character == ','){
                if (inQuotes) {
                    builder.append(character);
                }
                else {
                    split.add(builder.toString());
                    builder = new StringBuilder();
                }
            }
            else if (character == '\"'){
                inQuotes = !inQuotes;
            }
            else{
                builder.append(character);
            }
        }
        split.add(builder.toString());

        if(split.get(3).equals("")){
            this.type2 = "Null";
        }

        this.id = Integer.parseInt(split.get(0));
        this.name = split.get(1);
        this.type1 = split.get(2);
        this.type2 = split.get(3);
        this.totalPoints = Integer.parseInt(split.get(4));
        this.healthPoints = Double.parseDouble(split.get(5));
        this.attack = Double.parseDouble(split.get(6));
        this.defense = Double.parseDouble(split.get(7));
        this.specialAttack = Double.parseDouble(split.get(8));
        this.specialDefense = Double.parseDouble(split.get(9));
        this.speed = Double.parseDouble(split.get(10));
        this.generation = Integer.parseInt(split.get(11));
        this.legendary = Boolean.parseBoolean(split.get(12));
        int level = 0;

    }

    // accessor and mutators

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public double getHealthPoints() {
        return healthPoints;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefense() {
        return defense;
    }

    public double getSpecialAttack() {
        return specialAttack;
    }

    public double getSpecialDefense() {
        return specialDefense;
    }

    public double getSpeed() {
        return speed;
    }

    public double getGeneration() {
        return generation;
    }

    public boolean isLegendary() {
        return legendary;
    }

    public int getLevel(){
        return level;
    }


    // Methods


    @Override
    public String toString() {
        return  "\n" +
                "id = " + id         +    "\n"+
                "name  = " + name    +    "\n"+
                "type1 = " + type1  +    "\n"+
                "type2 = " + type2  +    "\n" +
                "totalPoints = " + totalPoints +  "\n" +
                "healthPoints = " + healthPoints +    "\n" +
                "attack = " + attack +    "\n" +
                "defense = " + defense +  "\n" +
                "specialAttack = " + specialAttack +  "\n" +
                "specialDefense = " + specialDefense +    "\n" +
                "speed = " + speed +  "\n" +
                "generation = " + generation +    "\n" +
                "legendary = " + legendary +  "\n" +
                "level = " + level + "\n";
    }

    public void levelUp() {
        this.level++;

        this.healthPoints = this.healthPoints * 1.01;
        this.attack = this.attack * 1.03;
        this.defense = this.defense * 1.03;
        this.specialAttack = this.specialAttack * 1.001;
        this.specialDefense = this.specialDefense * 1.001;
        this.speed = this.speed * 1.03;

        this.totalPoints =
                this.healthPoints + this.attack + this.defense +
                        this.specialAttack + this.specialDefense
                        + this.speed;

    }

        // Level up method +1

    public static void main(String[] args) {



    }
}
