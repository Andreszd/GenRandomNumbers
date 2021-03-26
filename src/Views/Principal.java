package Views;

import javax.swing.*;
import java.awt.*;

public class Principal extends Gui{
    private JPanel header;
    private JPanel body;

    private JLabel title;
    private JLabel text;

    private JButton btn;
    private JComboBox<String> listAlg;

    public Principal(String nameView) {
        super("Principal");
        initializeComponents();
        renderComponents();
        setLayout();
        setVisible(true);
    }
    private void initializeCombobox() {
        listAlg.addItem("item1");
        listAlg.addItem("item2");
    }

    private void initializeComponents(){
        title = new JLabel("Title");
        text = new JLabel("txt");

        btn = new JButton("press on");

        listAlg = new JComboBox();
        initializeCombobox();
        listAlg.setPreferredSize(new Dimension(100, 30));

        header = new JPanel();
        body = new JPanel();

        header.setBackground(Color.BLUE);
        body.setBackground(Color.CYAN);
    }
    private void setLayout(){
        header.setLayout(new FlowLayout());
        header.add(title);
        header.add(listAlg);
        body.add(text);
    }

    private void renderComponents(){
        window.add(header, BorderLayout.NORTH);
        window.add(body, BorderLayout.CENTER);
    }

    private GridBagConstraints positionElements(int x, int y, GridBagConstraints c){
        c.gridwidth=1;
        c.weightx=1;
        c.weighty=1;

        c.gridx=x;
        c.gridy=y;
        return c;
    }
}
