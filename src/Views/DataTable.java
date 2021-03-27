package Views;

import controllers.ControllerEvents;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class DataTable extends Gui {
    private JPanel body;
    private DefaultTableModel modelnumbers;
    private JTable table ;
    String nombreColumnas[] = {"Nro Randoms"};
    public DataTable(String nameView) {
        super(nameView);
        modelnumbers = new DefaultTableModel(null, nombreColumnas);


        table = new JTable(modelnumbers);
        body = new JPanel();
        body.setLayout(new FlowLayout());
        window.add(new JScrollPane(table), BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void connectController(ControllerEvents evt) {

    }
}
