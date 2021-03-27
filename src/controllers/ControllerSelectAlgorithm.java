package controllers;

import Views.Gui;
import Views.Principal;



public class ControllerSelectAlgorithm {
    private ControllerEvents evt;
    private Principal vprincipal;
    public ControllerSelectAlgorithm(Gui view){
        vprincipal = (Principal) view;
        evt = new ControllerEvents(vprincipal.getReferenceJCombobox(), this);
    }
    public void selectedAlgorithm(String name){
        System.out.println("execute algorithm.." + name);
        vprincipal.changeTextTitle(name);
        vprincipal.reloadComponents();
    }
    public ControllerEvents getReferenceEvtController(){
        return evt;
    }

}
