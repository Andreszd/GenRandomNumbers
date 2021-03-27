package controllers;

import Views.DataTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerEvents implements ItemListener, ActionListener {
    private JComboBox<String> jComboBox;
    private JTextField reftextField;
    private ControllerSelectAlgorithm refController;
    public ControllerEvents(JComboBox<String> jComboBox,
                            ControllerSelectAlgorithm refController,
                            JTextField reftextField){
        this.jComboBox = jComboBox;
        this.refController = refController;
        this.reftextField = reftextField;
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
        String textSelected = (String) jComboBox.getSelectedItem();
        String value = reftextField.getText();
        //verify fields
        if(verifyTextField(value)){
            DataTable d1 = new DataTable(textSelected, refController.algorithmCuadradosMedios(value, 10));
        }else{

        }
    }
    public Boolean verifyTextField(String value){
        Boolean flag = true;
        System.out.println(isNumber(value));
        if(!(!isEmpty(value) && isNumber(value))){
            System.out.println("verify all fields");
            flag = false;
        }
        return flag;
    }
    public boolean isEmpty(String value){
        return value.length() == 0;
    }
    public boolean isNumber(String value){
        Pattern pat =  Pattern.compile("\\d*");
        Matcher mat = pat.matcher(value);
        return mat.matches();
    }
}
