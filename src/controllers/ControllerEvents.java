package controllers;

import Views.DataTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerEvents implements ItemListener, ActionListener {
    private JComboBox<String> jComboBox;
    private JTextField reftextField;
    private ControllerSelectAlgorithm refController;
    private JTextField reftextField2;
    public ControllerEvents(JComboBox<String> jComboBox,
                            ControllerSelectAlgorithm refController,
                            JTextField reftextField,
                            JTextField reftextField2){
        this.jComboBox = jComboBox;
        this.refController = refController;
        this.reftextField = reftextField;
        this.reftextField2 = reftextField2;
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
        String cant = reftextField2.getText();
        //verify fields
        if(verifyTextField(value) && verifyTextField(cant)){
            OpenGuiDepedenceTypeAlgorithm(textSelected,value, Integer.parseInt(cant));
        }
    }
    public void OpenGuiDepedenceTypeAlgorithm(String textSelected, String seed, int cant ){
        String constantA, aditiveConstant, module;
        ArrayList<String []> numbersGenerated;
        switch (textSelected){
            case "Cuadrados Medios":
                numbersGenerated = refController.algorithmCuadradosMedios(seed, cant);
                if (numbersGenerated.size() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "the parameters do not comply with the restrictions imposed by the algorithm");
                }else{
                    new DataTable(textSelected, numbersGenerated);
                }
                break;
            case "Productos Medios":
                String secondSeed = requestAParam("Add a second seed", "seed");

                numbersGenerated = refController.algorithmProductosMedios(seed, secondSeed, cant);
                if (numbersGenerated.size() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "the parameters do not comply with the restrictions imposed by the algorithm");
                }else{
                    new DataTable(textSelected, numbersGenerated);
                }
                break;
            case "Multiplicador Constante":
                String constant = requestAParam("Add a constant A ", "constant");
                numbersGenerated = refController.algorithmMultiplicadorConstante(seed, constant, cant);
                if (numbersGenerated.size() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "the parameters do not comply with the restrictions imposed by the algorithm");
                }else {
                    new DataTable(textSelected, numbersGenerated);
                }

                break;
            case "Congruencial Mixto":
                constantA = requestAParam("Add a constant A ", "constant");
                aditiveConstant = requestAParam("Add a constant aditive C ", "constant");
                module = requestAParam("Add module ", "module");
                numbersGenerated = refController.algorithmCongrencialMixto(seed, constantA,
                        aditiveConstant, module, cant);
                if (numbersGenerated.size() == 0){
                    JOptionPane.showMessageDialog(null,
                            "the parameters do not comply with the restrictions imposed by the algorithm");
                }else{
                    new DataTable(textSelected, numbersGenerated);
                }
                break;
            case "Congruencial Multiplicativo":
                constantA = requestAParam("Add a constant A ", "constant");
                module = requestAParam("Add module ", "module");
                new DataTable(textSelected, refController.algorithmCongrencialMultiplicativo(seed,
                        constantA, module, cant));
                break;
            case "Congruencial Aditivo":
                String twoSeed = requestAParam("Add a second seed", "seed");
                String thirdSeed = requestAParam("Add a third seed", "seed");
                String fourSeed = requestAParam("Add a four seed", "seed");
                String fiveSeed = requestAParam("Add a five seed", "seed");
                module = requestAParam("Add a module ", "module");
                new DataTable(textSelected,
                        refController.algorithmCongruencialAditivo(seed, twoSeed,thirdSeed, fourSeed, fiveSeed, module, 20));
                break;
            case "Congruencial Cuadratico":
                String a = requestAParam("Add a constant A", "constant A");
                String b = requestAParam("Add a constant B", "constant B");
                String c = requestAParam("Add a constant C", "constant C");
                String m = requestAParam("Add a constant module", "constant module");
                numbersGenerated = refController.algorithmCongruencialCuadratico(seed,
                        a, b,c,m, cant);
                if (numbersGenerated.size() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "the parameters do not comply with the restrictions imposed by the algorithm");
                }else{
                    new DataTable(textSelected, numbersGenerated);
                }
                break;
            case "Blum, Blum y Shud":
                String p = requestAParam("Add a constant P", "constant P");
                String q = requestAParam("Add a constant Q", "constant Q");
                new DataTable(textSelected, refController.algorithmBlum(seed,
                        p, q, cant));
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
            JOptionPane.showMessageDialog(null, "verify all fields");
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
