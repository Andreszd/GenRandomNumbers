package controllers;

import Views.DataTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControllerEvents implements ItemListener, ActionListener {
    private JComboBox<String> jComboBox;
    private ControllerSelectAlgorithm refController;
    public ControllerEvents(JComboBox<String> jComboBox, ControllerSelectAlgorithm refController){
        this.jComboBox = jComboBox;
        this.refController = refController;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED){
            String content = (String) jComboBox.getSelectedItem();
            refController.selectedAlgorithm(content);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("clicked");
        DataTable d1 = new DataTable("ola");
    }
}
