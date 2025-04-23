package refactoredFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

public class Combat {
    private JFrame combatFrame;
    private JPanel combatPane;
    //private TreeMap<String, String> characterMap = new TreeMap<String, String>();
    private TreeMap<Integer, String> listCharactersMap = new TreeMap<Integer, String>();
    //private ScarletTools scar = new ScarletTools();
    //update buttons and labels


    public void combatStart(){
        combatFrame = new JFrame("Scarlet Pilum");
        combatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        combatPane = (JPanel)combatFrame.getContentPane();
        combatPane.setPreferredSize(new Dimension(600,500));

        makeCombatContent();

        combatFrame.setSize(600, 500);
        combatFrame.setVisible(true);
    }

    private void makeCombatContent(){
        combatPane.setLayout(new BorderLayout());
        combatPane.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));

        makeCombatNorthRegion();
        makeCombatWestRegion();
        makeCombatCenterRegion();
        makeCombatEastRegion();
        makeCombatSouthRegion();

    }

    private void makeCombatNorthRegion(){
        JLabel imgLabel = new JLabel(new ImageIcon("Penguins4.jpg"),JLabel.CENTER);
        combatPane.add(imgLabel, BorderLayout.NORTH);
    }

    private void makeCombatWestRegion(){
        /*player label
        player hit points
        image
        attack Defend buttons or load button?
            greyed out if no character loaded
         */
        JLabel nameLabel;
        JLabel heroHitPoints;
        JLabel displayHitPoints;
        JButton heroAttackButton;
        JButton heroDefendButton;

        JPanel heroPanel = new JPanel();
        heroPanel.setLayout(new GridLayout(4,1));
        //heroPanel.setBorder(BorderFactory.createTitledBorder("Character Statistics"));
        heroPanel.setBorder(BorderFactory.createTitledBorder("Hero"));
        heroPanel.setPreferredSize(new Dimension(225, 100));

        JPanel heroNamePanel = new JPanel();
        heroPanel.setLayout(new BoxLayout(heroPanel,BoxLayout.Y_AXIS));
        heroPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        //heroPanel.add(heroPanel);
        nameLabel = new JLabel("Character Name");
        heroNamePanel.add(nameLabel);
        heroPanel.add(heroNamePanel);

        JPanel heroHpPanel = new JPanel();
        heroHpPanel.setLayout(new BoxLayout(heroHpPanel, BoxLayout.X_AXIS));
        heroHpPanel.setBorder(BorderFactory.createEmptyBorder());
        //heroHpPanel.add(heroPanel);
        heroHitPoints = new JLabel("Hit Points: ");
        displayHitPoints = new JLabel("00");
        //heroHitPoints.setText("0");
        //heroHitPoints.setEditable(false);
        heroHpPanel.add(heroHitPoints);
        heroHpPanel.add(displayHitPoints);
        //panel.add(heroHpPanel);
        heroPanel.add(heroHpPanel);

        JPanel heroPicPanel = new JPanel();
        heroPicPanel.setLayout(new BoxLayout(heroPicPanel, BoxLayout.X_AXIS));
        heroPicPanel.setBorder(BorderFactory.createEmptyBorder());
        JLabel heroImgLabel = new JLabel(new ImageIcon(""),JLabel.CENTER);
        //panel.add(heroPicPanel);
        heroPicPanel.add(heroImgLabel);
        heroPanel.add(heroPicPanel);

        JPanel heroOptionPanel = new JPanel();
        heroOptionPanel.setLayout(new BoxLayout(heroOptionPanel, BoxLayout.X_AXIS));
        heroOptionPanel.setBorder(BorderFactory.createEmptyBorder());
        heroAttackButton = new JButton("Attack");
        heroAttackButton.addActionListener(new heroAttackButtonListener());
        heroOptionPanel.add(heroAttackButton);
        heroDefendButton = new JButton("Defend");
        heroDefendButton.addActionListener(new heroDefendButtonListener());
        heroOptionPanel.add(heroDefendButton);
        heroPanel.add(heroOptionPanel);

        combatPane.add(heroPanel, BorderLayout.WEST);
    }

    private class heroAttackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(combatFrame,
                    "This will attack",
                    "Attack",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private class heroDefendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(combatFrame,
                    "This will defend",
                    "Defend",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void makeCombatCenterRegion(){
        /*Turn counter centered
        image space
         */
        JLabel whatTurn;
        JLabel displayTurn;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));
        //panel.setBorder(BorderFactory.createTitledBorder("Character Statistics"));
        panel.setBorder(BorderFactory.createEmptyBorder());
        //panel.setPreferredSize(new Dimension(225, 100));

        JPanel turnCounterPanel = new JPanel();
        turnCounterPanel.setLayout(new BoxLayout(turnCounterPanel, BoxLayout.X_AXIS));
        turnCounterPanel.setBorder(BorderFactory.createEmptyBorder());
        whatTurn = new JLabel("Turn: ");
        displayTurn = new JLabel("1");
        //whatTurn.setEditable(false);
        turnCounterPanel.add(whatTurn);
        turnCounterPanel.add(displayTurn);
        panel.add(turnCounterPanel);

        JPanel fightPicPanel = new JPanel();
        fightPicPanel.setLayout(new BoxLayout(fightPicPanel, BoxLayout.X_AXIS));
        fightPicPanel.setBorder(BorderFactory.createEmptyBorder());
        JLabel fightImgLabel = new JLabel(new ImageIcon(""),JLabel.CENTER);
        fightPicPanel.add(fightImgLabel);
        panel.add(fightPicPanel);

        combatPane.add(panel, BorderLayout.CENTER);
    }

    private void makeCombatEastRegion(){
        /*Monster Name
        image
        Hit Point counter
         */
        JLabel monsterNameLabel;
        JLabel monsterHpLabel;
        JLabel displayMonsterHpLabel;

        JPanel monsterPanel = new JPanel();
        monsterPanel.setLayout(new GridLayout(5,1));
        //panel.setBorder(BorderFactory.createTitledBorder("Character Statistics"));
        monsterPanel.setBorder(BorderFactory.createTitledBorder("Monster"));
        monsterPanel.setPreferredSize(new Dimension(225, 100));

        JPanel monsterNamePanel = new JPanel();
        monsterNamePanel.setLayout(new BoxLayout(monsterNamePanel,BoxLayout.X_AXIS));
        monsterNamePanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        //monsterNamePanel.add(monsterPanel);
        monsterNameLabel = new JLabel("Monster Name");
        monsterNamePanel.add(monsterNameLabel);
        monsterPanel.add(monsterNamePanel);

        JPanel monsterPicPanel = new JPanel();
        monsterPicPanel.setLayout(new BoxLayout(monsterPicPanel, BoxLayout.X_AXIS));
        monsterPicPanel.setBorder(BorderFactory.createEmptyBorder());
        JLabel monsterImgLabel = new JLabel(new ImageIcon(""),JLabel.CENTER);
        monsterPanel.add(monsterPicPanel);

        JPanel monsterHpPanel = new JPanel();
        monsterHpPanel.setLayout(new BoxLayout(monsterHpPanel,BoxLayout.X_AXIS));
        monsterHpPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        //monsterHpPanel.add(panel);
        monsterHpLabel = new JLabel("Hit Points: ");
        displayMonsterHpLabel = new JLabel("00");
        monsterHpPanel.add(monsterHpLabel);
        monsterHpPanel.add(displayMonsterHpLabel);
        monsterPanel.add(monsterHpLabel);

        combatPane.add(monsterPanel, BorderLayout.EAST);
    }

    private void makeCombatSouthRegion(){
        /*load character button
            if character is already loaded this will reset character
                can not do during combat
                can not load the same character
            store which monster the character should fight on character
        Update character
        make new character
        Return to home
         */
        JButton loadCharacterButton;
        JButton switchCharacterButton;
        JButton updateCharacterButton;
        JButton makeNewCharacterButton;
        JButton goToHomeButton;

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Options"));
        panel.setPreferredSize(new Dimension(50, 100));
        //panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);

        loadCharacterButton = new JButton("Load Character");
        loadCharacterButton.addActionListener(new loadHeroListener());
        panel.add(loadCharacterButton);

        switchCharacterButton = new JButton("Switch Characters");
        switchCharacterButton.addActionListener(new switchHeroListener());
        panel.add(switchCharacterButton);

        updateCharacterButton = new JButton("Update Character");
        updateCharacterButton.addActionListener(new updateHeroListener());
        panel.add(updateCharacterButton);

        makeNewCharacterButton = new JButton("Make a new Character");
        makeNewCharacterButton.addActionListener(new makeNewHeroListener());
        panel.add(makeNewCharacterButton);

        goToHomeButton = new JButton("Go to Home");
        goToHomeButton.addActionListener(new goToHomeListener());
        panel.add(goToHomeButton);

        combatPane.add(panel, BorderLayout.SOUTH);

    }

    private class loadHeroListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            /*JOptionPane.showMessageDialog(combatFrame,
                    "This will load the hero",
                    "load",
                    JOptionPane.ERROR_MESSAGE);*/

            LoadCharacter ld = new LoadCharacter();
            ld.startLoadCharacter();
        }
    }

    private class switchHeroListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(combatFrame,
                    "This will load a different hero",
                    "switch",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private class updateHeroListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(combatFrame,
                    "This will go to update character",
                    "update",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private class makeNewHeroListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(combatFrame,
                    "This will go to home",
                    "home",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private class goToHomeListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(combatFrame,
                    "This will load the hero",
                    "load",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void combatCalculator(){
        /*Player choice Attack or Defend
        Display choice in center panel?
        if attack add bonus to attack
            display attack pose in center
        if defend add bonus to defense
            display defense pose in center

        (consider bonuses for element vs element with avatar rules)

        calculate attack versus defense
        if successful change monsters hit points

        Monster attacks
        calculate attack versus players modified defense
        if successful update players displayed hit points

        if monster hit points hits zero first
            display you win!
            update character points with win amount(1-5 points?)
        if player hit points hits zero first
            display you lose!
            update character points with lose amount (1?)

        probably choice to fight again or load different character
            fight again load next monster
            load character goes to combat load choice
         */
    }

}

