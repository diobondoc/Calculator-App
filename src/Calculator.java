import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Calculator implements ActionListener {

    JFrame window;
    JTextField text;
    JButton [] numButtons = new JButton[10];
    JButton[] functions = new JButton[8];
    JButton addition, subtraction, multiplication, division, decimal, equ, delete, clr;
    JPanel panel;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator(){
        window = new JFrame("Calculator");
        window.setSize(400,500);
        window.setLayout(null);

        text = new JTextField();
        text.setBounds(70,25,250,50);
        text.setEditable(false);

        addition = new JButton("+");
        subtraction = new JButton("-");
        multiplication = new JButton("*");
        division = new JButton("/");
        decimal = new JButton(".");
        equ = new JButton("=");
        delete = new JButton("Delete");
        clr = new JButton("Clear");

        functions[0] = addition;
        functions[1] = subtraction;
        functions[2] = multiplication;
        functions[3] = division;
        functions[4] = decimal;
        functions[5] = equ;
        functions[6] = delete;
        functions[7] = clr;

        for (int i = 0; i < 8; i++){
            functions[i].addActionListener(this);
            functions[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++){
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFocusable(false);
        }

        delete.setBounds(50,380,145,50);
        clr.setBounds(205,380,145,50);

        window.add(delete);
        window.add(clr);
        window.add(text);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}