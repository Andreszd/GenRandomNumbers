package Views;

import controllers.ControllerEvents;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class DataTable extends Gui {

    private DefaultTableModel modelnumbers;
    private JTable table ;
    private ArrayList<String []> data;
    String nombreColumnas[] = {"Nro","Nro Randoms"};
    public DataTable(String nameView, ArrayList<String []> data) {
        super(nameView);
        this.data = data;
        modelnumbers = new DefaultTableModel(null, nombreColumnas);

        fillTable();
        table = new JTable(modelnumbers);
        window.add(new JScrollPane(table), BorderLayout.CENTER);
        setVisible(true);
    }
    public void fillTable(){
        for (int i = 0 ; i < data.size() ; i++){
            modelnumbers.addRow(data.get(i));
        }
    }
    @Override
    public void connectController(ControllerEvents evt) {

    }
}
