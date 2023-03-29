package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class View extends JFrame {

    private JPanel mainPanel;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JButton derButton;
    private JButton itgButton;
    private TextField firstTxtFld;
    private TextField secondTxtFld;
    private JTextArea outTxt;

    public View(){

        int wButton = 70;
        int hButton = 55;
        Font font = new Font("Times New Roman", Font.ITALIC, 17);

        setSize(350,450);
        setTitle("Calculator");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //====== BUTTONS
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        itgButton = new JButton("∫");
        derButton = new JButton("d/dx");

        addButton.setPreferredSize(new Dimension(wButton,hButton));
        subButton.setPreferredSize(new Dimension(wButton,hButton));
        mulButton.setPreferredSize(new Dimension(wButton,hButton));
        divButton.setPreferredSize(new Dimension(wButton,hButton));
        itgButton.setPreferredSize(new Dimension(wButton,hButton));
        derButton.setPreferredSize(new Dimension(wButton,hButton));

        addButton.setFont(font);
        subButton.setFont(font);
        mulButton.setFont(font);
        divButton.setFont(font);
        itgButton.setFont(font);
        derButton.setFont(font);

        JPanel buttons = new JPanel();
        buttons.add(addButton);
        buttons.add(mulButton);
        buttons.add(itgButton);
        buttons.add(subButton);
        buttons.add(divButton);
        buttons.add(derButton);
        buttons.setLayout(new GridLayout(2,3,10,10));

        //===== INPUT
        firstTxtFld = new TextField("+2x^2+1.5", 20);
        secondTxtFld = new TextField("+1+5x+3", 20);

        JLabel firstPolyLabel= new JLabel(" 1st Polynomial:  ");
        JLabel secondPolyLabel= new JLabel("2nd Polynomial: ");
        firstPolyLabel.setFont(font);
        secondPolyLabel.setFont(font);


        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JPanel txtNlabelPanel1 = new JPanel();
        txtNlabelPanel1.add(firstPolyLabel);
        txtNlabelPanel1.add(firstTxtFld);
        JPanel txtNlabelPanel2 = new JPanel();
        txtNlabelPanel2.add(secondPolyLabel);
        txtNlabelPanel2.add(secondTxtFld);

        inputPanel.add(txtNlabelPanel1);
        inputPanel.add(txtNlabelPanel2);

        Font fontForm = new Font("Times New Roman", Font.ITALIC, 14);
        Label form = new Label("\nForm: +2x^2-5.3x-1.4", Label.CENTER);
        form.setFont(fontForm);
        inputPanel.add((new JPanel()).add(form));

        JPanel defPanel = new JPanel();
        defPanel.add(inputPanel);


        //===== OUTPUT

        JPanel outputPanel = new JPanel();
        JPanel textPanel = new JPanel();
        outTxt = new JTextArea(" ------- ");

        textPanel.add(outTxt);
        outputPanel.add(textPanel);


        //===== MAIN
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        mainPanel.add(buttons, BorderLayout.SOUTH);
        mainPanel.add(outputPanel, BorderLayout.CENTER);
        mainPanel.add(defPanel, BorderLayout.NORTH);

        add(mainPanel);
        setVisible(true);
    }

    public void addButtonListener(ActionListener e){
        this.addButton.addActionListener(e);
    }

    public void subButtonListener(ActionListener e){
        this.subButton.addActionListener(e);
    }

    public void mulButtonListener(ActionListener e){
        this.mulButton.addActionListener(e);
    }

    public void divButtonListener(ActionListener e){
        this.divButton.addActionListener(e);
    }

    public void itgButtonListener(ActionListener e){
        this.itgButton.addActionListener(e);
    }

    public void derButtonListener(ActionListener e){
        this.derButton.addActionListener(e);
    }

    public void setOutTxt(String str){
        this.outTxt.setText(str);
    }

    public String getFirstTxt(){
        return firstTxtFld.getText();
    }

    public String getSecondTxt(){
        return secondTxtFld.getText();
    }

    public TextField getSecondTxtFld(){
        return this.secondTxtFld;
    }
}
