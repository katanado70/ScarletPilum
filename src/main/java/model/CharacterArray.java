package model;

public class CharacterArray{
    private String name;
    private int points;
    private int strength;
    private int dexterity;
    private int constitution;
    private double attack;
    private double defense;
    private double damage;
    private double hitPoints;
    private String element;

    public CharacterArray(String pName, int pPoints, int pStrength, int pDexterity,
                          int pConstitution, double pAttack, double pDefense,
                          double pDamage, double pHitPoints, String pElement){
        name = pName;
        points = pPoints;
        strength = pStrength;
        dexterity = pDexterity;
        constitution = pConstitution;
        attack = pAttack;
        defense = pDefense;
        damage = pDamage;
        hitPoints = pHitPoints;
        element = pElement;
    }

    public String toFile(){
        return name + " " + points + " " + strength + " " + dexterity + " " + constitution + " " +
                attack + " " + defense + " " + damage + " " + hitPoints + " " + element;
    }

    public String getName(){
        return name;
    }

    public int getPoints(){
        return points;
    }

    public int getStrength(){
        return strength;
    }

    public int getDexterity(){
        return dexterity;
    }

    public int getConstitution(){
        return constitution;
    }

    public double getAttack(){
        return attack;
    }

    public double getDefense(){
        return defense;
    }

    public double getDamage(){
        return damage;
    }

    public double getHitPoints(){
        return hitPoints;
    }

    public String getElement(){
        return element;
    }
}
