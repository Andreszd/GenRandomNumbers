package controllers;

import Views.Gui;
import Views.Principal;

import javax.swing.*;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.regex.Matcher;


public class ControllerSelectAlgorithm {
    private ControllerEvents evt;
    private Principal vprincipal;
    public ControllerSelectAlgorithm(Gui view){
        vprincipal = (Principal) view;
        evt = new ControllerEvents(vprincipal.getReferenceJCombobox(),
                        this, vprincipal.getReferenceJTexField(),
                vprincipal.getReferenceJTexField2() );
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
            JOptionPane.showMessageDialog(null, "seed shouldnt has less than 4 digits");
            return numbersGenerated;
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
            JOptionPane.showMessageDialog(null, "seed shouldnt has less than 4 digits");
            return numbersGenerated;
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
            JOptionPane.showMessageDialog(null, "seed shouldnt has less than 4 digits");
            return numbersGenerated;
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
        String size;

        int firstOperation;
        int secondOperation;
        int numberGenerated;

        //valdation params
        if(intConstantA%2 == 0){
            JOptionPane.showMessageDialog(null, "constant A should be even");
            return numbersGenerated;
        }
        if(intConstantAditive%2 == 0){
            JOptionPane.showMessageDialog(null, "constant A is should be even");
            return numbersGenerated;
        }
        if(intmodule < intConstantAditive && intmodule < intConstantA && intmodule < intSeed){
            JOptionPane.showMessageDialog(null, "module is less than any param ");
            return numbersGenerated;
        }
        for(int i = 0; i < cant ; i++){
            firstOperation = intConstantA*intSeed;
            secondOperation = firstOperation + intConstantAditive;
            numberGenerated = secondOperation % intmodule;
            numbersGenerated.add(new String[]{""+i, numberGenerated+""});
            intSeed = numberGenerated;
        }
        size = findPeriod(numbersGenerated);
        JOptionPane.showMessageDialog(null, "size is "+ size);
        return numbersGenerated;
    }
    private String findPeriod(ArrayList<String []> numbers){
        String integerinitial = numbers.get(0)[1];
        for (int i = 1; i < numbers.size(); i++) {
            if(integerinitial.equals(numbers.get(i)[1])){
                return i+"";
            }
        }
        return "not found size";
    }
    public ArrayList<String []> algorithmCongrencialMultiplicativo(String seed,
                                                          String constantA,
                                                          String module,
                                                          int cant){
        ArrayList<String []> numbersGenerated = new ArrayList<>();
        int intSeed = Integer.parseInt(seed);
        int intConstantA = Integer.parseInt(constantA);
        int intmodule = Integer.parseInt(module);
        String size;

        int firstOperation;
        int numberGenerated;
        for(int i = 0; i < cant ; i++){
            firstOperation = intConstantA*intSeed;
            numberGenerated = firstOperation % intmodule;
            numbersGenerated.add(new String[]{""+i, numberGenerated+""});
            intSeed = numberGenerated;
        }
        size = findPeriod(numbersGenerated);
        JOptionPane.showMessageDialog(null, "size is "+ size);
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
    public ArrayList<String []> algorithmCongruencialCuadratico(String seed,
                                                                String a,
                                                                String b,
                                                                String c,
                                                                String module,
                                                                int size){
        ArrayList<String []> numbersGenerated = new ArrayList<>();
        int inta = Integer.parseInt(a);
        int intb = Integer.parseInt(b);
        int intc = Integer.parseInt(c);
        int intmodule = Integer.parseInt(module);
        int intSeed = Integer.parseInt(seed);

        int firstOperation;
        int numberGenerated;
        //valdation params
        if(inta%2 != 0 && intc %2 == 0 && (intb - inta)%4 != 1 && !isRangeM(intmodule)){
            return numbersGenerated;
        }
        for (int i = 0; i < size; i++) {
            firstOperation = inta*(int)Math.pow(intSeed, 2) + intb*intSeed + intc;
            numberGenerated = firstOperation % intmodule;
            numbersGenerated.add(new String []{""+i, ""+numberGenerated});
            intSeed = numberGenerated;
        }

        return numbersGenerated;
    }
    public ArrayList<String []> algorithmCongruencialAditivo(String firstSeed,
                                                             String secondSeed,
                                                             String thridSeed,
                                                             String fourSeed,
                                                             String fiveSeed,
                                                             String module,
                                                             int size){
        ArrayList<String []> numbersGenerated = new ArrayList<>();
        int param1 = Integer.parseInt(firstSeed);
        int param2 = Integer.parseInt(secondSeed);
        int param3 = Integer.parseInt(thridSeed);
        int param4 = Integer.parseInt(fourSeed);
        int param5 = Integer.parseInt(fiveSeed);
        int param6 = Integer.parseInt(module);

        int numberGenerated, firstOperation;

        ArrayList<Integer> seeds = new ArrayList<>();
        seeds.add(param1);
        seeds.add(param2);
        seeds.add(param3);
        seeds.add(param4);
        seeds.add(param5);

        for (int i = 0; i < size; i++) {

            firstOperation = seeds.get(i) + seeds.get(seeds.size() - 1);
            numberGenerated = firstOperation % param6;
            seeds.add(numberGenerated);
            numbersGenerated.add(new String []{""+i, ""+numberGenerated});
        }

        return numbersGenerated;
    }
   private boolean isRangeM(int param){
        int aux;
        for (int i = 0; i < 20; i++) {
            aux = (int)Math.pow(2, i);
            if(aux == param){
                return  true;
            }
        }
        return false;
    }
}
