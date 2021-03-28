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
            String itemSelected = (String) jComboBox.getSelectedItem();
            refController.selectedAlgorithm(itemSelected);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("clicked");
        String textSelected = (String) jComboBox.getSelectedItem();
        String value = reftextField.getText();
        //verify fields
        if(verifyTextField(value)){
            OpenGuiDepedenceTypeAlgorithm(textSelected, value);
        }
    }
    public void OpenGuiDepedenceTypeAlgorithm(String textSelected, String seed){
        String constantA, aditiveConstant, module;

        switch (textSelected){
            case "Cuadrados Medios":
                new DataTable(textSelected, refController.algorithmCuadradosMedios(seed, 10));
                break;
            case "Productos Medios":
                Boolean flag = true;
                String seed2 = "";
                while(flag){
                    seed2 = JOptionPane.showInputDialog("Add a second seed");
                    if(isNumber(seed2)){
                        flag = false;
                    }else{
                        JOptionPane.showMessageDialog(null, "seed is not a number");
                    }
                }
                new DataTable(textSelected, refController.algorithmProductosMedios(seed, seed2, 10));
                break;
            case "Multiplicador Constante":
                String constant = requestAParam("Add a constant A ", "constant");
                new DataTable(textSelected, refController.algorithmMultiplicadorConstante(seed, constant, 10));
                break;
            case "Congruencial Mixto":
                constantA = requestAParam("Add a constant A ", "constant");
                aditiveConstant = requestAParam("Add a constant aditive ", "constant");
                module = requestAParam("Add module ", "module");
                new DataTable(textSelected, refController.algorithmCongrencialMixto(seed,
                        constantA, aditiveConstant, module, 10));
                break;
            case "Congruencial Multiplicativo":
                constantA = requestAParam("Add a constant A ", "constant");
                module = requestAParam("Add module ", "module");
                new DataTable(textSelected, refController.algorithmCongrencialMultiplicativo(seed,
                        constantA, module, 10));
                break;
            case "Congruencial Aditivo":

                break;
            case "Congruencial Cuadratico":
                String a = requestAParam("Add a constant A", "constant A");
                String b = requestAParam("Add a constant B", "constant B");
                String c = requestAParam("Add a constant C", "constant C");
                String g = requestAParam("Add a constant G", "constant G");

                break;
            case "Blum, Blum y Shud":
                String p = requestAParam("Add a constant P", "constant P");
                String q = requestAParam("Add a constant Q", "constant Q");
                new DataTable(textSelected, refController.algorithmBlum(seed,
                        p, q, 10));
                break;
        }
    }
    private void verifyConstantsForAlgCC(String param, String typeParam){
        boolean flag;
        switch (typeParam){
            case "a":
                flag = true;
                while(flag){
                    int parseA = Integer.parseInt(param);
                    if(parseA % 2 == 0){
                        flag = false;
                    }else{
                        JOptionPane.showMessageDialog(null, "constant A is not a par");
                    }
                    param = JOptionPane.showInputDialog("Add a constant A");
                }
                break;
            case "c":
                flag = true;
                while(flag){
                    int parseC = Integer.parseInt(param);
                    if(parseC % 2 != 0){
                        flag = false;
                    }else{
                        JOptionPane.showMessageDialog(null, "constant C is not a impar");
                    }
                    param = JOptionPane.showInputDialog("Add a constant C");
                }
                break;

        }
    }
    private String requestAParam(String message, String nameParam){
        Boolean flag = true;
        String param = "";
        while(flag){
            param = JOptionPane.showInputDialog(message);
            if(isNumber(param) && !isEmpty(param)){
                flag = false;
            }else{
                JOptionPane.showMessageDialog(null, nameParam+" is not a number");
            }
        }
        return param;
    }
    public Boolean verifyTextField(String value){
        Boolean flag = true;
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
