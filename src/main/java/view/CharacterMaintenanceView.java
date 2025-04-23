package view;

import model.CharacterMap;
import model.ListCharacterMap;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.TreeMap;

public class CharacterMaintenanceView {
    private static JFrame ccFrame;
    private static JPanel characterPane;
    //private TreeMap<String, String> characterMap = new TreeMap<String, String>();
    private model.CharacterMap characterMap = new model.CharacterMap();
    //private TreeMap<Integer, String> listCharactersMap = new TreeMap<Integer, String>();
    private model.ListCharacterMap listCharacterMap = new ListCharacterMap();
    //private ScarletTools scar = new ScarletTools();
    //Character Creation text fields
    private static JButton startCombatButton;
    private static JTextField pointsText = new JTextField();
    private static JTextField nameText = new JTextField();
    private static JTextField strText = new JTextField();
    private static JTextField dexText = new JTextField();
    private static JTextField constText = new JTextField();
    private static JLabel pointsLabel = new JLabel("Points");
    private static JLabel nameLabel = new JLabel("Name        ");
    private static JLabel strLabel = new JLabel("Strength            ");
    private static JLabel dexLabel = new JLabel("Dexterity           ");
    private static JLabel constLabel = new JLabel("Constitution     ");
    private JButton blank1 = new JButton();
    private JButton blank2 = new JButton();
    private JButton blank3 = new JButton();
    private JButton blank4 = new JButton();
    //Character secondary stats
    private static JTextField attackField = new JTextField();
    private static JTextField defenseField = new JTextField();
    private static JTextField damageField = new JTextField();
    private static JTextField hpField = new JTextField();
    private static JLabel attackLabel = new JLabel("Attack     ");
    private static JLabel defenseLabel = new JLabel("Defense  ");
    private static JLabel damageLabel = new JLabel("Damage  ");
    private static JLabel hpLabel = new JLabel("HP            ");
    //full character string
    private String fullCharacter;
    //update buttons and labels
    private JLabel previousLabel;
    //private JButton previousButton = new JButton("Previous");
    //private JButton characterOneButton;
    //private JButton characterTwoButton;
    //private JButton characterThreeButton;
    //private JButton characterFourButton;
    //private JButton characterFiveButton;
    //private JButton forwardButton = new JButton("Next");

    public static int add(int x, int y){
        return x + y;
    }

    public static void startCharacter(){
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

        controller.CharacterMaintenanceController.readCharacterClass(loadName);
        controller.CharacterMaintenanceController.setCharacter();
    }

    private static void makeCharacterCreationContent() {
        characterPane = (JPanel)ccFrame.getContentPane();
        characterPane.setLayout(new BorderLayout(6,6));

        makeNorthRegion();
        makeCharacterCreationWestRegion();
        makeCharacterCreationCenterRegion();
        makeCharacterCreationEastRegion();
        makeCharacterCreationSouthRegion();

        //scar.calculateSecondaryStats(characterMap.get("strength"), characterMap.get("dexterity"), characterMap.get("constitution"));
    }

    public static void makeNorthRegion(){
        //JLabel imgLabel = new JLabel(new ImageIcon("Penguins4.jpg"),JLabel.CENTER);
        //JLabel imgLabel = new JLabel(new ImageIcon("Penguins4.jpg"),JLabel.CENTER);
        //characterPane.add(imgLabel, BorderLayout.NORTH);
        URL imageUrl = CharacterMaintenanceView.class.getResource("/Penguins4.jpg");
        System.out.println("Image URL is: " + imageUrl);
        if (imageUrl == null) {
            //System.out.println("Image not found. is not in the src/main/resources folder. ");
            //return;
            throw new RuntimeException("Image not found. is not in the src/main/resources/Penguins4.jpg folder. ");
        }
        JLabel imgLabel = new JLabel(new ImageIcon(imageUrl),JLabel.CENTER);
        characterPane.add(imgLabel, BorderLayout.NORTH);
    }

    private static void makeCharacterCreationWestRegion(){
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
        nameText.getDocument().addDocumentListener(new controller.CharacterMaintenanceController().nameDocumentListener());
        panel.add(namePanel);

        JPanel strPanel = new JPanel();
        strPanel.setLayout(new BoxLayout(strPanel,BoxLayout.X_AXIS));
        strPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        strPanel.add(strLabel);
        strPanel.add(strText);
        strText.setMaximumSize(new Dimension(30,24));
        strText.setEditable(false);
        strText.setText(beginStrValue);
        JButton strUp = new JButton("^");
        strUp.addActionListener(new controller.CharacterMaintenanceController().strUpButtonListener());
        strPanel.add(strUp);
        JButton strDown = new JButton("v");
        strDown.addActionListener(new controller.CharacterMaintenanceController().strDownButtonListener());
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
        JButton dexUp = new JButton("^");
        dexUp.addActionListener(new controller.CharacterMaintenanceController().dexUpButtonListener());
        dexPanel.add(dexUp);
        JButton dexDown = new JButton("v");
        dexDown.addActionListener(new controller.CharacterMaintenanceController().dexDownButtonListener());
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
        JButton constUp = new JButton("^");
        constUp.addActionListener(new controller.CharacterMaintenanceController().constUpButtonListener());
        constPanel.add(constUp);
        JButton constDown = new JButton("v");
        constDown.addActionListener(new controller.CharacterMaintenanceController().constDownButtonListener());
        constPanel.add(constDown);
        panel.add(constPanel);

        characterPane.add(panel, BorderLayout.WEST);
    }

    private static void makeCharacterCreationCenterRegion() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Elemental Affinity"));
        panel.setPreferredSize(new Dimension(50, 200));

        //Elements East box
        JCheckBox fireBox = new JCheckBox("Fire", false);
        fireBox.addActionListener(new controller.CharacterMaintenanceController().fireBoxListener());
        panel.add(fireBox);
        JCheckBox earthBox = new JCheckBox("Earth", false);
        earthBox.addActionListener(new controller.CharacterMaintenanceController().earthBoxListener());
        panel.add(earthBox);
        JCheckBox airBox = new JCheckBox("Air", false);
        airBox.addActionListener(new controller.CharacterMaintenanceController().airBoxListener());
        panel.add(airBox);
        JCheckBox waterBox = new JCheckBox("Water", false);
        waterBox.addActionListener(new controller.CharacterMaintenanceController().waterBoxListener());
        panel.add(waterBox);

        characterPane.add(panel, BorderLayout.CENTER);
    }

    private static void makeCharacterCreationEastRegion() {
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

        controller.CharacterMaintenanceController.createCharacterMap();
        controller.CharacterMaintenanceController.calculateSecondaryStats();

        characterPane.add(panel, BorderLayout.EAST);
    }

    private static void makeCharacterCreationSouthRegion() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Options"));
        panel.setPreferredSize(new Dimension(50, 100));
        //panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);

        //options South region;
        JButton saveCharacterButton = new JButton("Save");
        saveCharacterButton.addActionListener(new controller.CharacterMaintenanceController().saveCharacterListener());
        panel.add(saveCharacterButton);

        JButton updateCharacterButton = new JButton("Update");
        updateCharacterButton.addActionListener(new controller.CharacterMaintenanceController().updateCharacterListener());
        panel.add(updateCharacterButton);

        JButton resetCharacterButton = new JButton("Reset");
        resetCharacterButton.addActionListener(new controller.CharacterMaintenanceController().resetCharacterListener());
        panel.add(resetCharacterButton);

        startCombatButton = new JButton("refactoredFiles.Combat");
        startCombatButton.addActionListener(new controller.CharacterMaintenanceController().startCombatListener());
        panel.add(startCombatButton);

        characterPane.add(panel, BorderLayout.SOUTH);
    }
}
