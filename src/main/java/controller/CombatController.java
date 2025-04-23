package controller;

import refactoredFiles.LoadCharacter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

public class CombatController {
    private JFrame combatFrame;
    private JPanel combatPane;
    private TreeMap<Integer, String> listCharactersMap = new TreeMap<Integer, String>();

    public ActionListener heroAttackButtonListener() {
        return new heroAttackButtonListener();
    }

    public ActionListener heroDefendButtonListener() {
        return new heroDefendButtonListener();
    }

    public ActionListener loadHeroListener() {
        return new loadHeroListener();
    }

    public ActionListener switchHeroListener() {
        return new switchHeroListener();
    }

    public ActionListener updateHeroListener() {
        return new updateHeroListener();
    }

    public ActionListener makeNewHeroListener() {
        return new makeNewHeroListener();
    }

    public ActionListener goToHomeListener() {
        return new goToHomeListener();
    }

    public class startCombatListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){

            new view.CombatView().combatStart();
            //JOptionPane.showMessageDialog(frame,
            //        "This will open the refactoredFiles.Combat page.",
            //        "Place holder message",
            //        JOptionPane.WARNING_MESSAGE);
        }
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
