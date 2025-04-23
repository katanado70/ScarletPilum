package model;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class CharacterMap{
    private JFrame scarFrame;
    public TreeMap<String, String> characterMap = new TreeMap<String, String>();
    private String name = "";
    private String points = "";
    private String strength = "";
    private String dexterity = "";
    private String constitution = "";
    private String fire = "";
    private String earth = "";
    private String air = "";
    private String water = "";
    private String attack = "";
    private String defense = "";
    private String damage = "";
    private String hitPoints = "";
    private String fullCharacter = "";

    public CharacterMap(String cName, String cPoints, String cStrength, String cDexterity, String cConstitution,
                        String cFire, String cEarth, String cAir, String cWater, String cAttack, String cDefense,
                        String cDamage, String cHitPoints) {
        name = cName;
        points = cPoints;
        strength = cStrength;
        dexterity = cDexterity;
        constitution = cConstitution;
        fire = cFire;
        earth = cEarth;
        air = cAir;
        water = cWater;
        attack = cAttack;
        defense = cDefense;
        damage = cDamage;
        hitPoints = cHitPoints;
    }

    public CharacterMap() {
        readCharacterClass("characterInfo");
    }

    public TreeMap<String, String> getCharacterMap() {
        return characterMap;
    }

    public void readCharacterClass(String loadName) {
        File characterInfo = new File("data" + File.separator + loadName + ".txt");
        String newInfo = "";
        try{
            Scanner scan = new Scanner(characterInfo);
            while (scan.hasNext()){
                characterMap.put("name", scan.next());
                characterMap.put("points", scan.next());
                characterMap.put("strength", scan.next());
                characterMap.put("dexterity", scan.next());
                characterMap.put("constitution", scan.next());
                characterMap.put("fire", scan.next());
                characterMap.put("earth", scan.next());
                characterMap.put("air", scan.next());
                characterMap.put("water", scan.next());
                characterMap.put("attack", scan.next());
                characterMap.put("defense", scan.next());
                characterMap.put("damage", scan.next());
                characterMap.put("hitPoints", scan.next());
            }
            scan.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Program will now close.\n\nError: " + e.toString(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

    }

    /*public String getCharacterString(){
        return fullCharacter = characterMap.get("name") + " " +
                characterMap.get("points") + " " +
                characterMap.get("strength") + " " +
                characterMap.get("dexterity") + " " +
                characterMap.get("constitution") + " " +
                characterMap.get("fire") + " " +
                characterMap.get("earth") + " " +
                characterMap.get("air") + " " +
                characterMap.get("water") + " " +
                characterMap.get("attack") + " " +
                characterMap.get("defense") + " " +
                characterMap.get("damage") + " " +
                characterMap.get("hitPoints");
    }

    public void createCharacterMap(){
        characterMap.put("name", "noName");
        characterMap.put("points", "30");
        characterMap.put("strength", "1");
        characterMap.put("dexterity", "1");
        characterMap.put("constitution", "1");
        characterMap.put("fire", "false");
        characterMap.put("earth", "false");
        characterMap.put("air", "false");
        characterMap.put("water", "false");
        characterMap.put("attack", "1.5");
        characterMap.put("defense", "1.5");
        characterMap.put("damage", "1.5");
        characterMap.put("hitPoints", "1.5");
    }*/
}
