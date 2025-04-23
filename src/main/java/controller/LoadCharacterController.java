package controller;

import view.CharacterMaintenanceView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.TreeMap;

public class LoadCharacterController {
    private static JFrame loadFrame;
    private static TreeMap<Integer, String> listCharactersMap = new TreeMap<Integer, String>();
    private JButton previousButton = new JButton("Previous");
    private JButton characterOneButton;
    private JButton characterTwoButton;
    private JButton characterThreeButton;
    private JButton characterFourButton;
    private JButton characterFiveButton;
    private JButton forwardButton = new JButton("Next");

    public ActionListener previousCharacterListener() {
        return new previousCharacterListener();
    }

    public ActionListener characterOneListener() {
        return new characterOneListener();
    }

    public ActionListener characterTwoListener() {
        return new characterTwoListener();
    }

    public ActionListener characterThreeListener() {
        return new characterThreeListener();
    }

    public ActionListener characterFourListener() {
        return new characterFourListener();
    }

    public ActionListener characterFiveListener() {
        return new characterFiveListener();
    }

    public ActionListener forwardCharacterListener() {
        return new forwardCharacterListener();
    }

    private static class previousCharacterListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(loadFrame,
                    "previous set placeholder",
                    "Under construction",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private class characterOneListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            String loadName = characterOneButton.getText();
            updateContentLoader(loadName);
        }
    }

    private class characterTwoListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            String loadName = characterTwoButton.getText();
            updateContentLoader(loadName);
        }
    }

    private class characterThreeListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            String loadName = characterThreeButton.getText();
            updateContentLoader(loadName);
        }
    }

    private class characterFourListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            String loadName = characterFourButton.getText();
            updateContentLoader(loadName);
        }
    }

    private class characterFiveListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            String loadName = characterFiveButton.getText();
            updateContentLoader(loadName);
        }
    }

    private static class forwardCharacterListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(loadFrame,
                    "forward to the next 5",
                    "Under construction",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void readCharacterClass() {
        //File characterList = new File("/characterList.txt");
        //URL characterList = LoadCharacterController.class.getClassLoader().getResource("characterList.txt");
        File characterListFile = new File("data/characterList.txt");
        if (!characterListFile.exists()) {
            JOptionPane.showMessageDialog(loadFrame, "Character list not found in 'data' directory.\n\n" +
                    "This program will clsoe", "File Not Found", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        try (InputStream characterListStream = new FileInputStream(characterListFile);) {

            listCharactersMap = new TreeMap<Integer, String>();
            Scanner scan = new Scanner(characterListStream);
            int ch = 0;

            while (scan.hasNext()) {
                String name = scan.next();
                listCharactersMap.put(ch++, name);
            }
            scan.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Program will now close.\n\nError: " + e.toString(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

    }

    public void updateContentLoader(String loadName){

        /*loadFrame = new JFrame("Scarlet Pilum");
        loadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadPane = (JPanel)loadFrame.getContentPane();

        RefactoredFiles.CharacterMaintenance cm = new RefactoredFiles.CharacterMaintenance();
        //cm.makeCharacterCreationContent();
        cm.startCharacter();

        loadFrame.setSize(600, 500);
        loadFrame.setVisible(true);

        cm.readCharacterClass(loadName);

        cm.setCharacter();*/

        view.CharacterMaintenanceView cm = new CharacterMaintenanceView();
        cm.startCharacter(loadName);
    }
}
