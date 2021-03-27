package com.company;

import Views.Gui;
import Views.Principal;
import controllers.ControllerSelectAlgorithm;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Gui main = new Principal("");
        ControllerSelectAlgorithm c = new ControllerSelectAlgorithm(main);
        main.connectController(c.getReferenceEvtController());
    }
}
