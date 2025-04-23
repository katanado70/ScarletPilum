package controller;

import view.CharacterMaintenanceView;
import view.CombatView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreenController {
    public ActionListener createCharacterListener() {
        return new CharacterMaintenanceController.createCharacterListener();
    }

    public ActionListener startCombatListener() {
        return new CombatController().new startCombatListener();
    }
}



