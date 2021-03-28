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
    public void selectedAlgorithm(String itemSelected){
        System.out.println("execute algorithm.." + itemSelected);
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
    public ArrayList<String []> algorithmProductosMedios(String firstSeed, String secondSeed, int cant){
        ArrayList<String []> numbersGenerated = new ArrayList<>();
        long res;
        int sizeString, sizeX2, aux;
        String x2, numberGenerated;
        int parsedIntegerFirstSeed = Integer.parseInt(firstSeed);
        int parsedIntegerSecondSeed = Integer.parseInt(secondSeed);
        sizeString = firstSeed.length();
        if(firstSeed.length() <= 3){
            System.out.println("error of seed");
        }
        for (int i = 0; i < cant; i++) {
            res = parsedIntegerFirstSeed*parsedIntegerSecondSeed;
            x2 = Long.toString(res);
            sizeX2 = x2.length();
            aux = (sizeX2 - sizeString) / 2;
            numberGenerated = x2.substring(aux, aux + sizeString);
            parsedIntegerFirstSeed = parsedIntegerSecondSeed;
            parsedIntegerSecondSeed = Integer.parseInt(numberGenerated);
            numbersGenerated.add(new String[]{""+i, numberGenerated});
        }
        return numbersGenerated;
    }
    public ArrayList<String []> algorithmMultiplicadorConstante(String firstSeed, String constant, int cant){
        ArrayList<String []> numbersGenerated = new ArrayList<>();
        long res;
        int sizeString, sizeX2, aux;
        String x2, numberGenerated;
        int parsedIntegerFirstParam = Integer.parseInt(firstSeed);
        int parsedIntegerSecondParam = Integer.parseInt(constant);
        sizeString = firstSeed.length();
        if(firstSeed.length() <= 3){
            System.out.println("error of seed");
        }
        for (int i = 0; i < cant; i++) {
            res = parsedIntegerFirstParam*parsedIntegerSecondParam;
            x2 = Long.toString(res);
            sizeX2 = x2.length();
            aux = (sizeX2 - sizeString) / 2;
            numberGenerated = x2.substring(aux, aux + sizeString);
            parsedIntegerFirstParam = Integer.parseInt(numberGenerated);
            numbersGenerated.add(new String[]{""+i, numberGenerated});
        }
        return numbersGenerated;
    }
    public ArrayList<String []> algorithmCongrencialMixto(String seed,
                                                          String constantA,
                                                          String constanteAditive,
                                                          String module,
                                                          int cant){
        ArrayList<String []> numbersGenerated = new ArrayList<>();
        int intSeed = Integer.parseInt(seed);
        int intConstantA = Integer.parseInt(constantA);
        int intConstantAditive = Integer.parseInt(constanteAditive);
        int intmodule = Integer.parseInt(module);

        int firstOperation;
        int secondOperation;
        int numberGenerated;
        for(int i = 0; i < cant ; i++){
            firstOperation = intConstantA*intSeed;
            secondOperation = firstOperation + intConstantAditive;
            numberGenerated = secondOperation % intmodule;
            numbersGenerated.add(new String[]{""+i, numberGenerated+""});
            intSeed = numberGenerated;
        }
        return numbersGenerated;
    }
    public ArrayList<String []> algorithmCongrencialMultiplicativo(String seed,
                                                          String constantA,
                                                          String module,
                                                          int cant){
        ArrayList<String []> numbersGenerated = new ArrayList<>();
        int intSeed = Integer.parseInt(seed);
        int intConstantA = Integer.parseInt(constantA);
        int intmodule = Integer.parseInt(module);

        int firstOperation;
        int numberGenerated;
        for(int i = 0; i < cant ; i++){
            firstOperation = intConstantA*intSeed;
            numberGenerated = firstOperation % intmodule;
            numbersGenerated.add(new String[]{""+i, numberGenerated+""});
            intSeed = numberGenerated;
        }
        return numbersGenerated;
    }
    public ArrayList<String []> algorithmBlum(String seed,
                                              String constantP,
                                              String constantQ,
                                              int cant){
        ArrayList<String []> numbersGenerated = new ArrayList<>();
        int intseed = Integer.parseInt(seed);
        int intp = Integer.parseInt(constantP);
        int intq = Integer.parseInt(constantQ);

        int firstOperation;
        int module;
        int numberGenerated;
        for (int i = 0; i < cant ; i++) {
            firstOperation = (int)Math.pow(intseed, 2);
            module = intp*intq;
            numberGenerated = firstOperation % module;
            numbersGenerated.add(new String []{""+i, ""+numberGenerated});
            intseed = numberGenerated;
        }
        return numbersGenerated;
    }
}
