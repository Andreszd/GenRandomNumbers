package controllers;

import Views.Gui;
import Views.Principal;

import java.util.ArrayList;
import java.util.regex.Matcher;


public class ControllerSelectAlgorithm {
    private ControllerEvents evt;
    private Principal vprincipal;
    public ControllerSelectAlgorithm(Gui view){
        vprincipal = (Principal) view;
        evt = new ControllerEvents(vprincipal.getReferenceJCombobox(),
                        this, vprincipal.getReferenceJTexField());
    }
    public void selectedAlgorithm(String name){
        System.out.println("execute algorithm.." + name);
        vprincipal.changeTextTitle(name);
        vprincipal.reloadComponents();
    }
    public ControllerEvents getReferenceEvtController(){
        return evt;
    }

    public ArrayList<String []> algorithmCuadradosMedios(String seed, int cant){
        ArrayList<String []> numbersGenerated = new ArrayList<>();
        long resSquaring;
        int sizeString, sizeX2, aux;
        String x2, numberGenerated;
        int parsedInteger = Integer.parseInt(seed);
        sizeString = seed.length();
        if(seed.length() <= 3){
            System.out.println("error of seed");
        }
        for (int i = 0; i < cant; i++) {
            resSquaring = (long)Math.pow(parsedInteger, 2);
            x2 = Long.toString(resSquaring);
            sizeX2 = x2.length();
            aux = (sizeX2 - sizeString) / 2;
            numberGenerated = x2.substring(aux, aux + sizeString);
            parsedInteger = Integer.parseInt(numberGenerated);
            numbersGenerated.add(new String[]{""+i, numberGenerated});
        }
        return numbersGenerated;
    }
}
