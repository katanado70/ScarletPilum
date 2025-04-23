package controller;

import view.LoadCharacterView;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class CharacterMaintenanceController {
    private static JFrame ccFrame;
    private static TreeMap<String, String> characterMap = new TreeMap<String, String>();
    private TreeMap<Integer, String> listCharactersMap = new TreeMap<Integer, String>();

    private static JTextField pointsText = new JTextField();
    private static JTextField nameText = new JTextField();
    private static JTextField strText = new JTextField();
    private static JTextField dexText = new JTextField();
    private static JTextField constText = new JTextField();

    private static JTextField attackField = new JTextField();
    private static JTextField defenseField = new JTextField();
    private static JTextField damageField = new JTextField();
    private static JTextField hpField = new JTextField();

    private static JCheckBox fireBox;
    private static JCheckBox earthBox;
    private static JCheckBox airBox;
    private static JCheckBox waterBox;

    private String fullCharacter;

    public DocumentListener nameDocumentListener() {
        return new nameDocumentListener();
    }

    public ActionListener strUpButtonListener() {
        return new strUpButtonListener();
    }

    public ActionListener strDownButtonListener() {
        return new strDownButtonListener();
    }

    public ActionListener dexUpButtonListener() {
        return new dexUpButtonListener();
    }

    public ActionListener dexDownButtonListener() {
        return new dexDownButtonListener();
    }

    public ActionListener constUpButtonListener() {
        return new constUpButtonListener();
    }

    public ActionListener constDownButtonListener() {
        return new constDownButtonListener();
    }

    public ActionListener fireBoxListener() {
        return new fireBoxListener();
    }

    public ActionListener earthBoxListener() {
        return new earthBoxListener();
    }

    public ActionListener airBoxListener() {
        return new airBoxListener();
    }

    public ActionListener waterBoxListener() {
        return new waterBoxListener();
    }

    public ActionListener saveCharacterListener() {
        return new saveCharacterListener();
    }

    public ActionListener updateCharacterListener() {
        return new updateCharacterListener();
    }

    public ActionListener resetCharacterListener() {
        return new resetCharacterListener();
    }

    public ActionListener startCombatListener() {
        return new startCombatListener();
    }

    public static class createCharacterListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {

            view.CharacterMaintenanceView.startCharacter();
        }
    }

    private class strUpButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ae){
            int nowPoints = Integer.parseInt(pointsText.getText());
            int nowStr = Integer.parseInt(strText.getText());

            if (nowPoints >= 1){
                nowPoints = nowPoints - 1;
                nowStr = nowStr + 1;

                pointsText.setText(Integer.toString(nowPoints));
                strText.setText(Integer.toString(nowStr));
                calculateSecondaryStats();
                characterMap.replace("points", Integer.toString(nowPoints));
                characterMap.replace("strength",Integer.toString(nowStr));
            }
            else {
                JOptionPane.showMessageDialog(ccFrame,
                        "There are not enough Points.",
                        "Not Enough Points",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class strDownButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            int nowPoints = Integer.parseInt(pointsText.getText());
            int nowStr = Integer.parseInt(strText.getText());

            if (nowStr > 1){
                nowPoints = nowPoints + 1;
                nowStr = nowStr - 1;

                pointsText.setText(Integer.toString(nowPoints));
                strText.setText(Integer.toString(nowStr));
                calculateSecondaryStats();
                characterMap.replace("points", Integer.toString(nowPoints));
                characterMap.replace("strength",Integer.toString(nowStr));
            }
            else {
                JOptionPane.showMessageDialog(ccFrame,
                        "Strength can not drop below 1",
                        "Not Enough Points",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class dexUpButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            int nowPoints = Integer.parseInt(pointsText.getText());
            int nowDex = Integer.parseInt(dexText.getText());

            if (nowPoints >= 1){
                nowPoints = nowPoints - 1;
                nowDex = nowDex + 1;

                pointsText.setText(Integer.toString(nowPoints));
                dexText.setText(Integer.toString(nowDex));
                calculateSecondaryStats();
                characterMap.replace("points", Integer.toString(nowPoints));
                characterMap.replace("dexterity",Integer.toString(nowDex));
            }
            else {
                JOptionPane.showMessageDialog(ccFrame,
                        "There are not enough Points.",
                        "Not Enough Points",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class dexDownButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            int nowPoints = Integer.parseInt(pointsText.getText());
            int nowDex = Integer.parseInt(dexText.getText());

            if (nowDex > 1){
                nowPoints = nowPoints + 1;
                nowDex = nowDex - 1;

                pointsText.setText(Integer.toString(nowPoints));
                dexText.setText(Integer.toString(nowDex));
                calculateSecondaryStats();
                characterMap.replace("points", Integer.toString(nowPoints));
                characterMap.replace("dexterity",Integer.toString(nowDex));
            }
            else {
                JOptionPane.showMessageDialog(ccFrame,
                        "Dexterity can not drop below 1.",
                        "Not Enough Points",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class constUpButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            int nowPoints = Integer.parseInt(pointsText.getText());
            int nowConst = Integer.parseInt(constText.getText());

            if (nowPoints >= 1){
                nowPoints = nowPoints - 1;
                nowConst = nowConst + 1;

                pointsText.setText(Integer.toString(nowPoints));
                constText.setText(Integer.toString(nowConst));
                calculateSecondaryStats();
                characterMap.replace("points", Integer.toString(nowPoints));
                characterMap.replace("constitution",Integer.toString(nowConst));
            }
            else {
                JOptionPane.showMessageDialog(ccFrame,
                        "There are not enough Points.",
                        "Not Enough Points",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class constDownButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            int nowPoints = Integer.parseInt(pointsText.getText());
            int nowConst = Integer.parseInt(constText.getText());

            if (nowConst > 1){
                nowPoints = nowPoints + 1;
                nowConst = nowConst - 1;

                pointsText.setText(Integer.toString(nowPoints));
                constText.setText(Integer.toString(nowConst));
                calculateSecondaryStats();
                characterMap.replace("points", Integer.toString(nowPoints));
                characterMap.replace("constitution",Integer.toString(nowConst));
            }
            else {
                JOptionPane.showMessageDialog(ccFrame,
                        "Constition can not drop below 1.",
                        "Not Enough Points",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class nameDocumentListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            characterMap.put("name", nameText.getText());
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            characterMap.put("name", nameText.getText());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            characterMap.put("name", nameText.getText());
        }
    }

    private class fireBoxListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            int nowPoints;
            double nowAttack;

            nowPoints = Integer.parseInt(pointsText.getText());
            nowAttack = Double.parseDouble(damageField.getText());

            if (nowPoints >= 1) {
                if (fireBox.isSelected()) {
                    if (!earthBox.isSelected()) {
                        nowPoints = nowPoints - 1;
                        nowAttack = nowAttack + 2;

                        pointsText.setText(Integer.toString(nowPoints));
                        attackField.setText(Double.toString(nowAttack));

                        characterMap.replace("points", Integer.toString(nowPoints));
                        characterMap.replace("attack",Double.toString(nowAttack));
                        characterMap.replace("fire", Boolean.toString(fireBox.isSelected()));
                    }
                    else {
                        JOptionPane.showMessageDialog(ccFrame,
                                "You have already selected Earth.",
                                "Not Enough Points",
                                JOptionPane.ERROR_MESSAGE);
                        fireBox.setSelected(false);
                    }
                } else {
                    nowPoints = nowPoints + 1;
                    nowAttack = nowAttack - 2;

                    pointsText.setText(Integer.toString(nowPoints));
                    attackField.setText(Double.toString(nowAttack));

                    characterMap.replace("points", Integer.toString(nowPoints));
                    characterMap.replace("attack",Double.toString(nowAttack));
                    characterMap.replace("fire", Boolean.toString(fireBox.isSelected()));
                }
            } else {
                JOptionPane.showMessageDialog(ccFrame,
                        "There are not enough Points.",
                        "Not Enough Points",
                        JOptionPane.ERROR_MESSAGE);
                fireBox.setSelected(false);
            }
        }
    }

    private class earthBoxListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            int nowPoints;
            double nowHp;

            nowPoints = Integer.parseInt(pointsText.getText());
            nowHp = Double.parseDouble(damageField.getText());

            if (nowPoints >= 1) {
                if (earthBox.isSelected()) {
                    if (!waterBox.isSelected()) {
                        nowPoints = nowPoints - 1;
                        nowHp = nowHp + 2;

                        pointsText.setText(Integer.toString(nowPoints));
                        hpField.setText(Double.toString(nowHp));

                        characterMap.replace("points", Integer.toString(nowPoints));
                        characterMap.replace("hitPoints",Double.toString(nowHp));
                        characterMap.replace("earth", Boolean.toString(earthBox.isSelected()));
                    }
                    else {
                        JOptionPane.showMessageDialog(ccFrame,
                                "You have already selected Water.",
                                "Not Enough Points",
                                JOptionPane.ERROR_MESSAGE);
                        earthBox.setSelected(false);
                    }
                } else {
                    nowPoints = nowPoints + 1;
                    nowHp = nowHp - 2;

                    pointsText.setText(Integer.toString(nowPoints));
                    hpField.setText(Double.toString(nowHp));

                    characterMap.replace("points", Integer.toString(nowPoints));
                    characterMap.replace("hitPoints",Double.toString(nowHp));
                    characterMap.replace("earth", Boolean.toString(earthBox.isSelected()));
                }
            } else {
                JOptionPane.showMessageDialog(ccFrame,
                        "There are not enough Points.",
                        "Not Enough Points",
                        JOptionPane.ERROR_MESSAGE);
                earthBox.setSelected(false);
            }
        }
    }

    private class airBoxListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            int nowPoints;
            double nowDefense;

            nowPoints = Integer.parseInt(pointsText.getText());
            nowDefense = Double.parseDouble(defenseField.getText());

            if (nowPoints >= 1) {
                if (airBox.isSelected()) {
                    if (!fireBox.isSelected()) {
                        nowPoints = nowPoints - 1;
                        nowDefense = nowDefense + 2;

                        pointsText.setText(Integer.toString(nowPoints));
                        defenseField.setText(Double.toString(nowDefense));

                        characterMap.replace("points", Integer.toString(nowPoints));
                        characterMap.replace("defense",Double.toString(nowDefense));
                        characterMap.replace("air", Boolean.toString(airBox.isSelected()));
                    }
                    else {
                        JOptionPane.showMessageDialog(ccFrame,
                                "You have already selected Fire.",
                                "Not Enough Points",
                                JOptionPane.ERROR_MESSAGE);
                        airBox.setSelected(false);
                    }
                } else {
                    nowPoints = nowPoints + 1;
                    nowDefense = nowDefense - 2;

                    pointsText.setText(Integer.toString(nowPoints));
                    defenseField.setText(Double.toString(nowDefense));

                    characterMap.replace("points", Integer.toString(nowPoints));
                    characterMap.replace("defense",Double.toString(nowDefense));
                    characterMap.replace("air", Boolean.toString(airBox.isSelected()));
                }
            } else {
                JOptionPane.showMessageDialog(ccFrame,
                        "There are not enough Points.",
                        "Not Enough Points",
                        JOptionPane.ERROR_MESSAGE);
                airBox.setSelected(false);
            }
        }
    }

    private class waterBoxListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            int nowPoints;
            double nowDamage;

            nowPoints = Integer.parseInt(pointsText.getText());
            nowDamage = Double.parseDouble(damageField.getText());

            if (nowPoints >= 1) {
                if (waterBox.isSelected()) {
                    if (!airBox.isSelected()) {
                        nowPoints = nowPoints - 1;
                        nowDamage = nowDamage + 2;

                        pointsText.setText(Integer.toString(nowPoints));
                        damageField.setText(Double.toString(nowDamage));

                        characterMap.replace("points", Integer.toString(nowPoints));
                        characterMap.replace("damage",Double.toString(nowDamage));
                        characterMap.replace("water", Boolean.toString(waterBox.isSelected()));
                    }
                    else {
                        JOptionPane.showMessageDialog(ccFrame,
                                "You have already selected Air.",
                                "Not Enough Points",
                                JOptionPane.ERROR_MESSAGE);
                        waterBox.setSelected(false);
                    }
                } else {
                    nowPoints = nowPoints + 1;
                    nowDamage = nowDamage - 2;

                    pointsText.setText(Integer.toString(nowPoints));
                    damageField.setText(Double.toString(nowDamage));

                    characterMap.replace("points", Integer.toString(nowPoints));
                    characterMap.replace("damage",Double.toString(nowDamage));
                    characterMap.replace("water", Boolean.toString(waterBox.isSelected()));
                }
            } else {
                JOptionPane.showMessageDialog(ccFrame,
                        "There are not enough Points.",
                        "Not Enough Points",
                        JOptionPane.ERROR_MESSAGE);
                waterBox.setSelected(false);
            }
        }
    }

    public static void calculateSecondaryStats(){
        int currentStr = Integer.parseInt(strText.getText());
        int currentDex = Integer.parseInt(dexText.getText());
        int currentConst = Integer.parseInt(constText.getText());

        double newAttack;
        double newDefense;
        double newDamage;
        double newHp;

        newAttack = currentDex + (currentStr * 0.5);
        newDefense = currentConst + (currentDex * 0.5);
        newDamage = currentStr + (currentDex * 0.5);
        newHp = currentConst + (currentStr * 0.5);

        attackField.setText(Double.toString(newAttack));
        defenseField.setText(Double.toString(newDefense));
        damageField.setText(Double.toString(newDamage));
        hpField.setText(Double.toString(newHp));

        characterMap.replace("attack", Double.toString(newAttack));
        characterMap.replace("defense",Double.toString(newDefense));
        characterMap.replace("damage",Double.toString(newDamage));
        characterMap.replace("hitPoints", Double.toString(newHp));
    }

    /*private class saveCharacterListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            characterMap.put("name", nameText.getText());

            try{
                //FileWriter writeFile = new FileWriter(  nameText.getText() + ".txt");
                FileWriter writeFile = new FileWriter(characterMap.get("name") + ".txt");
                writeFile.write(getCharacterString());
                writeFile.close();

                JOptionPane.showMessageDialog(ccFrame,
                        "Character Saved.",
                        "Saved Message",
                        JOptionPane.WARNING_MESSAGE);
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog(ccFrame,
                        "File already exists.",
                        "File Exists",
                        JOptionPane.WARNING_MESSAGE);
            }

            try {
                String nameForList = nameText.getText() + "\n";
                FileWriter characterList = new FileWriter("characterList.txt", true);
                characterList.write(nameForList);
                characterList.close();
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog(ccFrame,
                        "Problems with the Character List.",
                        "File does not Exist",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }*/

    private class saveCharacterListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            characterMap.put("name", nameText.getText());
            String characterName = characterMap.get("name");
            String fileName = "data/" + characterName + ".txt";

            //Ensure data directory exists
            File dataDir = new File("data");
            if (!dataDir.exists()){
                dataDir.mkdir();
            }

            //Write character details to its own file
            try (FileWriter writeFile = new FileWriter(fileName)) {
                writeFile.write(getCharacterString());

                JOptionPane.showMessageDialog(ccFrame,
                        "Character Saved.",
                        "Saved Message",
                        JOptionPane.WARNING_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(ccFrame,
                        "Failed to save character.",
                        "I/O Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            File characterListFile = new File("data/characterList.txt");

            try (FileWriter characterList = new FileWriter(characterListFile, true)) {
                characterList.write(characterName + "\n");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(ccFrame,
                "Problems updating the Character List",
                "I/O Error",
                JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static class
    updateCharacterListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            /*ccFrame = new JFrame("Scarlet Pilum");
            ccFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            characterPane = (JPanel)ccFrame.getContentPane();

            RefactoredFiles.LoadCharacter ld = new RefactoredFiles.LoadCharacter();
            ld.updateCharacterContent();

            ccFrame.setSize(600, 500);
            ccFrame.setVisible(true);

            createCharacterMap();*/

            view.LoadCharacterView ld = new LoadCharacterView();
            ld.startLoadCharacter();
        }
    }

    private static class startCombatListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            JOptionPane.showMessageDialog(ccFrame,
                    "This will open the view.CombatView page.",
                    "Place holder message",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private static class resetCharacterListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            pointsText.setText("30");
            nameText.setText("");
            nameText.setEditable(true);
            strText.setText("1");
            dexText.setText("1");
            constText.setText("1");
            fireBox.setSelected(false);
            earthBox.setSelected(false);
            airBox.setSelected(false);
            waterBox.setSelected(false);

            calculateSecondaryStats();
        }
    }

    public String getCharacterString(){
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

    public static void setCharacter(){
        //String name = characterMap.get("name");

        nameText.setText(characterMap.get("name"));
        nameText.setEditable(false);
        pointsText.setText(characterMap.get("points"));
        strText.setText(characterMap.get("strength"));
        dexText.setText(characterMap.get("dexterity"));
        constText.setText(characterMap.get("constitution"));
        fireBox.setSelected(Boolean.parseBoolean(characterMap.get("fire")));
        earthBox.setSelected(Boolean.parseBoolean(characterMap.get("earth")));
        airBox.setSelected(Boolean.parseBoolean(characterMap.get("air")));
        waterBox.setSelected(Boolean.parseBoolean(characterMap.get("water")));
        attackField.setText(characterMap.get("attack"));
        defenseField.setText(characterMap.get("defense"));
        damageField.setText(characterMap.get("damage"));
        hpField.setText(characterMap.get("hitPoints"));
    }



    public static void createCharacterMap(){
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
    }

    public static void readCharacterClass(String loadName) {
        File characterInfo = new File("data/" + loadName + ".txt");
        if (!characterInfo.exists()){
            JOptionPane.showMessageDialog(ccFrame,
                    "Character file not found.",
                    "Missing File",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
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
            /*JOptionPane.showMessageDialog(ccFrame, "I/O error in file\n\n" +
                            "This program will close",
                    "I/O Error",
                    JOptionPane.ERROR_MESSAGE);*/
            JOptionPane.showMessageDialog(null,
                    "Program will now close.\n\nError: " + e.toString(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
