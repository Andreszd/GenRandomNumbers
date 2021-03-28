package Views;

import controllers.ControllerEvents;

import javax.swing.*;
import java.awt.*;

public abstract class Gui extends JFrame {
    protected Container window;
    public Gui(String nameView){
        setTitle(nameView);
        window = getContentPane();
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    abstract public void connectController(ControllerEvents evt) ;
}
