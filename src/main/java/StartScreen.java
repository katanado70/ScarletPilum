import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class StartScreen {
    private JFrame frame;
    private JPanel contentPane;
    private TreeMap<String, String> characterMap = new TreeMap<String, String>();
    private TreeMap<Integer, String> listCharactersMap = new TreeMap<Integer, String>();
    private CharacterMaintenance cc = new CharacterMaintenance();
    private Combat combat = new Combat();
    //Buttons
    private JButton createCharacterButton;
    private JButton startCombatButton;
    public string dave = "Hi Dave";

    public static void main(String[] args){
        StartScreen gui = new StartScreen();
        gui.start();
    }

    public void start(){
        frame = new JFrame("Scarlet Pilum");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = (JPanel)frame.getContentPane();
        contentPane.setPreferredSize(new Dimension(600,500));

        makeOpeningContent();

        frame.setSize(600, 500);
        frame.setVisible(true);
    }

    private void makeOpeningContent(){
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));

        makeNorthRegion();
        makeStartChoicesWestRegion();
    }

    private void makeNorthRegion(){
        JLabel imgLabel = new JLabel(new ImageIcon("Penguins4.jpg"),JLabel.CENTER);
        contentPane.add(imgLabel, BorderLayout.NORTH);
    }

    private void makeStartChoicesWestRegion(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));
        panel.setBorder(BorderFactory.createSoftBevelBorder(2));
        panel.setPreferredSize(new Dimension(150,300));

        createCharacterButton = new JButton("Create Character");
        createCharacterButton.addActionListener(new createCharacterListener());
        panel.add(createCharacterButton);

        startCombatButton = new JButton("Combat");
        startCombatButton.addActionListener(new startCombatListener());
        panel.add(startCombatButton);

        contentPane.add(panel, BorderLayout.WEST);
    }

    private class createCharacterListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {

            cc.startCharacter();
        }
    }

    private class startCombatListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){

            combat.combatStart();
            //JOptionPane.showMessageDialog(frame,
            //        "This will open the Combat page.",
            //        "Place holder message",
            //        JOptionPane.WARNING_MESSAGE);
        }
    }
}
