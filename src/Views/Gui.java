package Views;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    protected Container window;
    public Gui(String nameView){
        setTitle(nameView);
        window = getContentPane();
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
