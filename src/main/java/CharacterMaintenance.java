import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class CharacterMaintenance{
    private JFrame ccFrame;
    private JPanel characterPane;
    private TreeMap<String, String> characterMap = new TreeMap<String, String>();
    private TreeMap<Integer, String> listCharactersMap = new TreeMap<Integer, String>();
    //private ScarletTools scar = new ScarletTools();
    //Character Creation text fields
    private JButton startCombatButton;
    private JTextField pointsText = new JTextField();
    private JTextField nameText = new JTextField();
    private JTextField strText = new JTextField();
    private JTextField dexText = new JTextField();
    private JTextField constText = new JTextField();
    private JLabel pointsLabel = new JLabel("Points");
    private JLabel nameLabel = new JLabel("Name        ");
    private JLabel strLabel = new JLabel("Strength            ");
    private JLabel dexLabel = new JLabel("Dexterity           ");
    private JLabel constLabel = new JLabel("Constitution     ");
    private JButton strUp;
    private JButton strDown;
    private JButton dexUp;
    private JButton dexDown;
    private JButton constUp;
    private JButton constDown;
    private JButton blank1 = new JButton();
    private JButton blank2 = new JButton();
    private JButton blank3 = new JButton();
    private JButton blank4 = new JButton();
    //Character secondary stats
    private JTextField attackField = new JTextField();
    private JTextField defenseField = new JTextField();
    private JTextField damageField = new JTextField();
    private JTextField hpField = new JTextField();
    private JLabel attackLabel = new JLabel("Attack     ");
    private JLabel defenseLabel = new JLabel("Defense  ");
    private JLabel damageLabel = new JLabel("Damage  ");
    private JLabel hpLabel = new JLabel("HP            ");
    //Elements East box
    private JCheckBox fireBox;
    private JCheckBox earthBox;
    private JCheckBox airBox;
    private JCheckBox waterBox;
    //options South region;
    private JButton saveCharacterButton;
    private JButton updateCharacterButton;
    private JButton resetCharacterButton;
    //full character string
    private String fullCharacter;
    //update buttons and labels
    private JLabel previousLabel;
    private JButton previousButton = new JButton("Previous");
    private JButton characterOneButton;
    private JButton characterTwoButton;
    private JButton characterThreeButton;
    private JButton characterFourButton;
    private JButton characterFiveButton;
    private JButton forwardButton = new JButton("Next");

    public static int add(int x, int y){
        return x + y;
    }

    public void startCharacter(){
        ccFrame = new JFrame("Scarlet Pilum");
        ccFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        characterPane = (JPanel)ccFrame.getContentPane();
        characterPane.setPreferredSize(new Dimension(600,500));

        makeCharacterCreationContent();

        ccFrame.setSize(600, 500);
        ccFrame.setVisible(true);
    }

    public void startCharacter(String loadName){
        ccFrame = new JFrame("Scarlet Pilum");
        ccFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        characterPane = (JPanel)ccFrame.getContentPane();
        characterPane.setPreferredSize(new Dimension(600,500));

        makeCharacterCreationContent();

        ccFrame.setSize(600, 500);
        ccFrame.setVisible(true);

        readCharacterClass(loadName);
        setCharacter();
    }

    void makeCharacterCreationContent() {
        characterPane = (JPanel)ccFrame.getContentPane();
        characterPane.setLayout(new BorderLayout(6,6));

        makeNorthRegion();
        makeCharacterCreationWestRegion();
        makeCharacterCreationCenterRegion();
        makeCharacterCreationEastRegion();
        makeCharacterCreationSouthRegion();

        //scar.calculateSecondaryStats(characterMap.get("strength"), characterMap.get("dexterity"), characterMap.get("constitution"));
    }

    public void makeNorthRegion(){
        JLabel imgLabel = new JLabel(new ImageIcon("Penguins4.jpg"),JLabel.CENTER);
        characterPane.add(imgLabel, BorderLayout.NORTH);
    }

    private void makeCharacterCreationWestRegion(){
        JPanel panel = new JPanel();

        String beginPointsValue = "30";
        String beginStrValue = "1";
        String beginDexValue = "1";
        String beginConstValue = "1";

        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //leftPanel = new JPanel();
        panel.setLayout(new GridLayout(5,1));
        panel.setBorder(BorderFactory.createTitledBorder("Character Statistics"));
        panel.setPreferredSize(new Dimension(225, 100));

        JPanel pointsPanel = new JPanel();
        pointsPanel.setLayout(new BoxLayout(pointsPanel,BoxLayout.X_AXIS));
        pointsPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        pointsPanel.add(pointsText);
        pointsText.setMaximumSize(new Dimension(20,24));
        pointsText.setEditable(false);
        pointsText.setText(beginPointsValue);
        pointsPanel.add(pointsLabel);
        panel.add(pointsPanel);

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel,BoxLayout.X_AXIS));
        namePanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        namePanel.add(nameLabel);
        namePanel.add(nameText);
        nameText.setMaximumSize(new Dimension(140,24));
        nameText.getDocument().addDocumentListener(new nameDocumentListener());
        panel.add(namePanel);

        JPanel strPanel = new JPanel();
        strPanel.setLayout(new BoxLayout(strPanel,BoxLayout.X_AXIS));
        strPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        strPanel.add(strLabel);
        strPanel.add(strText);
        strText.setMaximumSize(new Dimension(30,24));
        strText.setEditable(false);
        strText.setText(beginStrValue);
        strUp = new JButton("^");
        strUp.addActionListener(new strUpButtonListener());
        strPanel.add(strUp);
        strDown = new JButton("v");
        strDown.addActionListener(new strDownButtonListener());
        strPanel.add(strDown);
        panel.add(strPanel);

        JPanel dexPanel = new JPanel();
        dexPanel.setLayout(new BoxLayout(dexPanel,BoxLayout.X_AXIS));
        dexPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        dexPanel.add(dexLabel);
        dexPanel.add(dexText);
        dexText.setMaximumSize(new Dimension(30,24));
        dexText.setEditable(false);
        dexText.setText(beginDexValue);
        dexUp = new JButton("^");
        dexUp.addActionListener(new dexUpButtonListener());
        dexPanel.add(dexUp);
        dexDown = new JButton("v");
        dexDown.addActionListener(new dexDownButtonListener());
        dexPanel.add(dexDown);
        panel.add(dexPanel);

        JPanel constPanel = new JPanel();
        constPanel.setLayout(new BoxLayout(constPanel,BoxLayout.X_AXIS));
        constPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        constPanel.add(constLabel);
        constPanel.add(constText);
        constText.setMaximumSize(new Dimension(30,24));
        constText.setEditable(false);
        constText.setText(beginConstValue);
        constUp = new JButton("^");
        constUp.addActionListener(new constUpButtonListener());
        constPanel.add(constUp);
        constDown = new JButton("v");
        constDown.addActionListener(new constDownButtonListener());
        constPanel.add(constDown);
        panel.add(constPanel);

        characterPane.add(panel, BorderLayout.WEST);
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

    private void makeCharacterCreationEastRegion() {
        String beginAttackValue = "0";
        String beginDefenseValue = "0";
        String beginDamageValue = "0";
        String beginHpValue = "0";

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));
        panel.setBorder(BorderFactory.createTitledBorder("Secondary Statistics"));
        panel.setPreferredSize(new Dimension(100, 200));

        JPanel attackPanel = new JPanel();
        attackPanel.setLayout(new BoxLayout(attackPanel,BoxLayout.X_AXIS));
        attackPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        attackPanel.add(attackLabel);
        attackPanel.add(attackField);
        attackField.setMaximumSize(new Dimension(50,24));
        attackField.setEditable(false);
        attackField.setText(beginAttackValue);
        panel.add(attackPanel);

        JPanel defensePanel = new JPanel();
        defensePanel.setLayout(new BoxLayout(defensePanel,BoxLayout.X_AXIS));
        defensePanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        defensePanel.add(defenseLabel);
        defensePanel.add(defenseField);
        defenseField.setMaximumSize(new Dimension(50,24));
        defenseField.setEditable(false);
        defenseField.setText(beginDefenseValue);
        panel.add(defensePanel);

        JPanel damagePanel = new JPanel();
        damagePanel.setLayout(new BoxLayout(damagePanel,BoxLayout.X_AXIS));
        damagePanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        damagePanel.add(damageLabel);
        damagePanel.add(damageField);
        damageField.setMaximumSize(new Dimension(50,24));
        damageField.setEditable(false);
        damageField.setText(beginDamageValue);
        panel.add(damagePanel);

        JPanel hpPanel = new JPanel();
        hpPanel.setLayout(new BoxLayout(hpPanel,BoxLayout.X_AXIS));
        hpPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        hpPanel.add(hpLabel);
        hpPanel.add(hpField);
        hpField.setMaximumSize(new Dimension(50,24));
        hpField.setEditable(false);
        hpField.setText(beginHpValue);
        panel.add(hpPanel);

        createCharacterMap();
        calculateSecondaryStats();

        characterPane.add(panel, BorderLayout.EAST);
    }

    private void makeCharacterCreationCenterRegion() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Elemental Affinity"));
        panel.setPreferredSize(new Dimension(50, 200));

        fireBox = new JCheckBox("Fire", false);
        fireBox.addActionListener(new fireBoxListener());
        panel.add(fireBox);
        earthBox = new JCheckBox("Earth",false);
        earthBox.addActionListener(new earthBoxListener());
        panel.add(earthBox);
        airBox = new JCheckBox("Air", false);
        airBox.addActionListener(new airBoxListener());
        panel.add(airBox);
        waterBox = new JCheckBox("Water", false);
        waterBox.addActionListener(new waterBoxListener());
        panel.add(waterBox);

        characterPane.add(panel, BorderLayout.CENTER);
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

    public void calculateSecondaryStats(){
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

    private void makeCharacterCreationSouthRegion() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Options"));
        panel.setPreferredSize(new Dimension(50, 100));
        //panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);

        saveCharacterButton = new JButton("Save");
        saveCharacterButton.addActionListener(new saveCharacterListener());
        panel.add(saveCharacterButton);

        updateCharacterButton = new JButton("Update");
        updateCharacterButton.addActionListener(new updateCharacterListener());
        panel.add(updateCharacterButton);

        resetCharacterButton = new JButton("Reset");
        resetCharacterButton.addActionListener(new resetCharacterListener());
        panel.add(resetCharacterButton);

        startCombatButton = new JButton("Combat");
        startCombatButton.addActionListener(new startCombatListener());
        panel.add(startCombatButton);

        characterPane.add(panel, BorderLayout.SOUTH);
    }

    private class saveCharacterListener implements ActionListener{
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
    }

    private class updateCharacterListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            /*ccFrame = new JFrame("Scarlet Pilum");
            ccFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            characterPane = (JPanel)ccFrame.getContentPane();

            LoadCharacter ld = new LoadCharacter();
            ld.updateCharacterContent();

            ccFrame.setSize(600, 500);
            ccFrame.setVisible(true);

            createCharacterMap();*/

            LoadCharacter ld = new LoadCharacter();
            ld.startLoadCharacter();
        }
    }

    /*private void updateCharacterContent() {
        characterPane = (JPanel)ccFrame.getContentPane();
        characterPane.setLayout(new BorderLayout(6,6));
        LoadCharacter ld = new LoadCharacter();
        makeNorthRegion();
        //makeUpdateCharacterWestRegion();
        ld.makeLoadPlayerWestRegion();
    }*/

    /*private void makeUpdateCharacterWestRegion() {
        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayout(7,1));
        updatePanel.setBorder(BorderFactory.createTitledBorder("Select a Character:"));
        updatePanel.setPreferredSize(new Dimension(200,300));
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
        updatePanel.add(previousHito);

        JPanel characterOnePanel = new JPanel();
        characterOnePanel.setLayout(new BoxLayout(characterOnePanel,BoxLayout.X_AXIS));
        characterOnePanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        characterOneButton = new JButton(hitoZero);
        characterOneButton.addActionListener(new characterOneListener());
        characterOnePanel.add(characterOneButton);
        updatePanel.add(characterOnePanel);

        JPanel characterTwoPanel = new JPanel();
        characterTwoPanel.setLayout(new BoxLayout(characterTwoPanel,BoxLayout.X_AXIS));
        characterTwoPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        characterTwoButton = new JButton(one);
        characterTwoButton.addActionListener(new characterTwoListener());
        characterTwoPanel.add(characterTwoButton);
        updatePanel.add(characterTwoPanel);

        JPanel characterThreePanel = new JPanel();
        characterThreePanel.setLayout(new BoxLayout(characterThreePanel,BoxLayout.X_AXIS));
        characterThreePanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        characterThreeButton = new JButton(hitoTwo);
        characterThreeButton.addActionListener(new characterThreeListener());
        characterThreePanel.add(characterThreeButton);
        updatePanel.add(characterThreePanel);

        JPanel characterFourPanel = new JPanel();
        characterFourPanel.setLayout(new BoxLayout(characterFourPanel,BoxLayout.X_AXIS));
        characterFourPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        characterFourButton = new JButton(hitoThree);
        characterFourButton.addActionListener(new characterFourListener());
        characterFourPanel.add(characterFourButton);
        updatePanel.add(characterFourPanel);

        JPanel characterFivePanel = new JPanel();
        characterFivePanel.setLayout(new BoxLayout(characterFivePanel,BoxLayout.X_AXIS));
        characterFivePanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        characterFiveButton = new JButton(hitoFour);
        characterFiveButton.addActionListener(new characterFiveListener());
        characterFivePanel.add(characterFiveButton);
        updatePanel.add(characterFivePanel);

        JPanel forwardHito = new JPanel();
        forwardHito.setLayout(new BoxLayout(forwardHito,BoxLayout.X_AXIS));
        forwardHito.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        forwardButton= new JButton("Next");
        forwardButton.addActionListener(new forwardCharacterListener());
        forwardHito.add(forwardButton);
        updatePanel.add(forwardHito);

        characterPane.add(updatePanel, BorderLayout.WEST);
    }

    private class previousCharacterListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(ccFrame,
                    "previous set placeholder",
                    "Under construction",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    private class characterOneListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            LoadCharacter ld = new LoadCharacter();
            String loadName = characterOneButton.getText();
            ld.updateContentLoader(loadName);
        }
    }

    private class characterTwoListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            LoadCharacter ld = new LoadCharacter();
            String loadName = characterTwoButton.getText();
            ld.updateContentLoader(loadName);
        }
    }

    private class characterThreeListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            LoadCharacter ld = new LoadCharacter();
            String loadName = characterThreeButton.getText();
            ld.updateContentLoader(loadName);
        }
    }

    private class characterFourListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            LoadCharacter ld = new LoadCharacter();
            String loadName = characterFourButton.getText();
            ld.updateContentLoader(loadName);
        }
    }

    private class characterFiveListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            LoadCharacter ld = new LoadCharacter();
            String loadName = characterFiveButton.getText();
            ld.updateContentLoader(loadName);
        }
    }

    private class forwardCharacterListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(ccFrame,
                    "forward to the next 5",
                    "Under construction",
                    JOptionPane.ERROR_MESSAGE);
        }
    }*/

    private class startCombatListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            JOptionPane.showMessageDialog(ccFrame,
                    "This will open the Combat page.",
                    "Place holder message",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    /*private void updateContentLoader(String loadName){

        ccFrame = new JFrame("Scarlet Pilum");
        ccFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        characterPane = (JPanel)ccFrame.getContentPane();

        makeCharacterCreationContent();

        ccFrame.setSize(600, 500);
        ccFrame.setVisible(true);

        readCharacterClass(loadName);
        setCharacter();
    }*/

    private class resetCharacterListener implements ActionListener{
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

    public void setCharacter(){
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
    }


    /*public void readCharacterClass() {
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
            JOptionPane.showMessageDialog(ccFrame, "I/O error in file\n\n" +
                            "This program will close",
                    "I/O Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }*/

    public void readCharacterClass(String loadName) {
        File characterInfo = new File(loadName + ".txt");
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
            JOptionPane.showMessageDialog(ccFrame, "I/O error in file\n\n" +
                            "This program will close",
                    "I/O Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
