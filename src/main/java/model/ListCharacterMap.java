import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class ListCharacterMap{
    private JFrame scarFrame;
    private int characterNumber = 0;
    private String characterString = "";

    public ListCharacterMap(int cNumber, String cName){
        characterNumber = cNumber;
        characterString = cName;
    }

    /*public TreeMap<Integer, String> getListCharactersMap() {
        return ListCharactersMap;
    }*/

    public TreeMap<Integer, String> readCharacterClass() {
        File characterList = new File("characterList.txt");

        TreeMap<Integer,String> listCharactersMap = new TreeMap<Integer, String>();
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
            JOptionPane.showMessageDialog(scarFrame, "I/O error in file\n\n" +
                            "This program will close",
                    "I/O Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        return listCharactersMap;
    }
}
