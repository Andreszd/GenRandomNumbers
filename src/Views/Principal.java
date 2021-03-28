package Views;

import controllers.ControllerEvents;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Principal extends Gui{
    private JPanel header;
    private JPanel body;

    private JLabel title;
    private JLabel text;

    private JTextField textfield;
    private JTextField textfield2;

    private JButton btnGenerated;
    private DefaultTableModel numbersTable;
    private DataTable personalityTable;

    private JComboBox<String> algorithms;

    public Principal(String nameView) {
        super("Principal");
        initializeComponents();
        renderComponents();
        setLayout();
        setVisible(true);
    }

    @Override
    public void connectController(ControllerEvents evt) {
        algorithms.addItemListener(evt);
        btnGenerated.addActionListener(evt);
    }

    private void initializeCombobox() {
        algorithms.addItem("Cuadrados Medios");
        algorithms.addItem("Productos Medios");
        algorithms.addItem("Multiplicador Constante");
        algorithms.addItem("Congruencial Mixto");
        algorithms.addItem("Congruencial Multiplicativo");
        algorithms.addItem("Congruencial Aditivo");
        algorithms.addItem("Congruencial Cuadratico");
        algorithms.addItem("Blum, Blum y Shud");
    }

    private void initializeComponents(){
        title = new JLabel("Select any algorithm");
        text = new JLabel("Add a seed");

        textfield = new JTextField(10);
        textfield2 = new JTextField(10);

        btnGenerated = new JButton("Generate");
        btnGenerated.setBounds(10, 10 ,100, 200);

        //personalityTable = new DataTable();
        //numbersTable = new JTable(personalityTable);
        numbersTable = new DefaultTableModel();
        numbersTable.addColumn("count");
        numbersTable.addColumn("numbers");


        algorithms = new JComboBox();
        initializeCombobox();
        //algorithms.setPreferredSize(new Dimension(100, 30));

        header = new JPanel();
        body = new JPanel();

        body.setPreferredSize(new Dimension(300, 200));
        //header.setBackground(Color.BLUE);
        //body.setBackground(Color.GRAY);
    }
    public void changeTextTitle(String newText){
        text.setText(newText);
    }
    public void reloadComponents(){

        body.removeAll();
        setLayout();
        body.updateUI();//metodos necesarios para renderizar componentes
        body.repaint();
    }

    private void setLayout(){
        header.setLayout(new FlowLayout());
        header.add(title);
        header.add(algorithms);

        GridBagConstraints grid = new GridBagConstraints();
        body.setLayout(new GridBagLayout());

        body.add(title, positionElements(0, 0, grid));
        body.add(algorithms, positionElements(1, 0, grid));

        body.add(text, positionElements(0, 1, grid));
        body.add(textfield, positionElements(1,1, grid));

        body.add(btnGenerated, positionElements(1, 2, grid));

    }

    private void renderComponents(){
        window.add(header, BorderLayout.NORTH);
        window.add(body, BorderLayout.CENTER);
        //window.add(new JScrollPane(numbersTable), BorderLayout.SOUTH);
    }

    private GridBagConstraints positionElements(int x, int y, GridBagConstraints c){
        c.gridwidth=1;
        c.weightx=1;
        c.weighty=1;

        c.gridx=x;
        c.gridy=y;
        return c;
    }
    public void setContentTitle(String newString){
        title.setText(newString);
    }

    public JComboBox<String> getReferenceJCombobox(){
        return algorithms;
    }

    public JTextField getReferenceJTexField(){ return textfield; }

    public void removeRowSeed(){
        body.remove(text);
        body.remove(textfield);
    }
}
