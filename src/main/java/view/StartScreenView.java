package view;

import controller.StartScreenController;
import refactoredFiles.Combat;
//import refactoredFiles.Combat;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

public class StartScreenView {
    private JFrame frame;
    private JPanel contentPane;
    //private TreeMap<String, String> characterMap = new TreeMap<String, String>();
    //private TreeMap<Integer, String> listCharactersMap = new TreeMap<Integer, String>();
    private view.CharacterMaintenanceView cc = new CharacterMaintenanceView();
    private view.CombatView combat = new view.CombatView();
    //Buttons
    private JButton createCharacterButton;
    private JButton startCombatButton;
    //private static final String HEADER_IMAGE_PATH = "C:/ScarletPilumProject/ScarletPilum/src/main/resources/Penguins4.jpg";
    //URL imageUrl = getClass().getResource("/Penguins4.jpg");

    public StartScreenView() {
        try {
            cc = new CharacterMaintenanceView();
        } catch (Exception e) {
            System.err.println("Error creating CharacterMaintenanceView:");
            e.printStackTrace();
        }

        try {
            combat = new CombatView();
        } catch (Exception e) {
            System.err.println("Error creating CombatView:");
            e.printStackTrace();
        }
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

    private void makeNorthRegion() {
        //JLabel imgLabel = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Penguins4.jpg"))),JLabel.CENTER);

       URL imageUrl = getClass().getResource("/Penguins4.jpg");
       System.out.println("Image URL is: " + imageUrl);
       if (imageUrl == null) {
           //System.out.println("Image not found. is not in the src/main/resources folder. ");
           //return;
           throw new RuntimeException("Image not found. is not in the src/main/resources/Penguins4.jpg folder. ");
       }
       JLabel imgLabel = new JLabel(new ImageIcon(imageUrl),JLabel.CENTER);
       contentPane.add(imgLabel, BorderLayout.NORTH);
    }

    private void makeStartChoicesWestRegion(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));
        panel.setBorder(BorderFactory.createSoftBevelBorder(2));
        panel.setPreferredSize(new Dimension(150,300));

        createCharacterButton = new JButton("Create Character");
        createCharacterButton.addActionListener(new StartScreenController().createCharacterListener());
        panel.add(createCharacterButton);

        startCombatButton = new JButton("refactoredFiles.Combat");
        startCombatButton.addActionListener(new StartScreenController().startCombatListener());
        panel.add(startCombatButton);

        contentPane.add(panel, BorderLayout.WEST);
    }


}
