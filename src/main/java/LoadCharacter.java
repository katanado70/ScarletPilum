import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class LoadCharacter extends CharacterMaintenance{
    private JFrame loadFrame;
    private JPanel loadPane;
    //private TreeMap<String, String> characterMap = new TreeMap<String, String>();
    private TreeMap<Integer, String> listCharactersMap = new TreeMap<Integer, String>();
    //private ScarletTools scar = new ScarletTools();
    //update buttons and labels
    private JLabel previousLabel;
    private JButton previousButton = new JButton("Previous");
    private JButton characterOneButton;
    private JButton characterTwoButton;
    private JButton characterThreeButton;
    private JButton characterFourButton;
    private JButton characterFiveButton;
    private JButton forwardButton = new JButton("Next");

    public void startLoadCharacter(){
        loadFrame = new JFrame("Scarlet Pilum");
        loadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadPane = (JPanel)loadFrame.getContentPane();
        loadPane.setPreferredSize(new Dimension(600,500));

        //LoadCharacter ld = new LoadCharacter();
        updateLoadContent();

        loadFrame.setSize(600, 500);
        loadFrame.setVisible(true);

        //createCharacterMap();
    }

    public void combatLoadCharacter(){
        loadFrame = new JFrame("Scarlet Pilum");
        loadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadPane = (JPanel)loadFrame.getContentPane();
        loadPane.setPreferredSize(new Dimension(600,500));

        //LoadCharacter ld = new LoadCharacter();
        updateLoadContent();

        loadFrame.setSize(600, 500);
        loadFrame.setVisible(true);

        //createCharacterMap();
    }

    public void updateLoadContent() {
        loadPane = (JPanel)loadFrame.getContentPane();
        loadPane.setLayout(new BorderLayout(6,6));

        makeLoadNorthRegion();
        makeLoadPlayerWestRegion();
    }

    public void makeLoadNorthRegion(){
        JLabel imgLabel = new JLabel(new ImageIcon("Penguins4.jpg"),JLabel.CENTER);
        loadPane.add(imgLabel, BorderLayout.NORTH);

    }

    public void makeLoadPlayerWestRegion(){
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(7,1));
        Panel.setBorder(BorderFactory.createTitledBorder("Select a Character:"));
        Panel.setPreferredSize(new Dimension(200,300));
        //panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        //panel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));

        readCharacterClass();

        int listLength = listCharactersMap.size();

        String hitoZero = listCharactersMap.get(0);
        String one = listCharactersMap.get(1);
        String hitoTwo = listCharactersMap.get(2);
        String hitoThree = listCharactersMap.get(3);
        String hitoFour = listCharactersMap.get(4);

        //back button
        //character 1 - 5
        //forward button

        JPanel previousHito = new JPanel();
        previousHito.setLayout(new BoxLayout(previousHito,BoxLayout.X_AXIS));
        previousHito.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        previousButton = new JButton("Previous");
        previousButton.addActionListener(new previousCharacterListener());
        previousHito.add(previousButton);
        Panel.add(previousHito);

        JPanel characterOnePanel = new JPanel();
        characterOnePanel.setLayout(new BoxLayout(characterOnePanel,BoxLayout.X_AXIS));
        characterOnePanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        characterOneButton = new JButton(hitoZero);
        characterOneButton.addActionListener(new characterOneListener());
        characterOnePanel.add(characterOneButton);
        Panel.add(characterOnePanel);

        JPanel characterTwoPanel = new JPanel();
        characterTwoPanel.setLayout(new BoxLayout(characterTwoPanel,BoxLayout.X_AXIS));
        characterTwoPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        characterTwoButton = new JButton(one);
        characterTwoButton.addActionListener(new characterTwoListener());
        characterTwoPanel.add(characterTwoButton);
        Panel.add(characterTwoPanel);

        JPanel characterThreePanel = new JPanel();
        characterThreePanel.setLayout(new BoxLayout(characterThreePanel,BoxLayout.X_AXIS));
        characterThreePanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        characterThreeButton = new JButton(hitoTwo);
        characterThreeButton.addActionListener(new characterThreeListener());
        characterThreePanel.add(characterThreeButton);
        Panel.add(characterThreePanel);

        JPanel characterFourPanel = new JPanel();
        characterFourPanel.setLayout(new BoxLayout(characterFourPanel,BoxLayout.X_AXIS));
        characterFourPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        characterFourButton = new JButton(hitoThree);
        characterFourButton.addActionListener(new characterFourListener());
        characterFourPanel.add(characterFourButton);
        Panel.add(characterFourPanel);

        JPanel characterFivePanel = new JPanel();
        characterFivePanel.setLayout(new BoxLayout(characterFivePanel,BoxLayout.X_AXIS));
        characterFivePanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        characterFiveButton = new JButton(hitoFour);
        characterFiveButton.addActionListener(new characterFiveListener());
        characterFivePanel.add(characterFiveButton);
        Panel.add(characterFivePanel);

        JPanel forwardHito = new JPanel();
        forwardHito.setLayout(new BoxLayout(forwardHito,BoxLayout.X_AXIS));
        forwardHito.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        forwardButton= new JButton("Next");
        forwardButton.addActionListener(new forwardCharacterListener());
        forwardHito.add(forwardButton);
        Panel.add(forwardHito);

        loadPane.add(Panel, BorderLayout.WEST);
    }

    private class previousCharacterListener implements ActionListener {
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

    private class forwardCharacterListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(loadFrame,
                    "forward to the next 5",
                    "Under construction",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void readCharacterClass() {
        File characterList = new File("characterList.txt");

        listCharactersMap = new TreeMap<Integer, String>();
        try{
            int ch = 0;
            Scanner scan = new Scanner(characterList);
            while (scan.hasNext()){
                String name = scan.next();
                listCharactersMap.put(ch, name);
                ch++;
            }
            scan.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(loadFrame, "I/O error in file\n\n" +
                            "This program will close",
                    "I/O Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void updateContentLoader(String loadName){

        /*loadFrame = new JFrame("Scarlet Pilum");
        loadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadPane = (JPanel)loadFrame.getContentPane();

        CharacterMaintenance cm = new CharacterMaintenance();
        //cm.makeCharacterCreationContent();
        cm.startCharacter();

        loadFrame.setSize(600, 500);
        loadFrame.setVisible(true);

        cm.readCharacterClass(loadName);

        cm.setCharacter();*/

        CharacterMaintenance cm = new CharacterMaintenance();
        cm.startCharacter(loadName);
    }

}

