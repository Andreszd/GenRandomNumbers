package Views;

import controllers.ControllerEvents;
import controllers.ControllerSelectAlgorithm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Principal extends Gui{
    private JPanel header;
    private JPanel body;

    private JLabel title;
    private JLabel text;

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
        algorithms.addItem("item1");
        algorithms.addItem("item2");
    }

    private void initializeComponents(){
        title = new JLabel("Select any algorithm");
        text = new JLabel("txt");

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

        body.add(text, positionElements(0,0, grid));
        body.add(btnGenerated, positionElements(0, 1, grid));

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
}
