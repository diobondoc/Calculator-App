import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator implements ActionListener {

    JFrame window;
    JTextField text;
    ArrayList<JButton> numButtons = new ArrayList<>();
    ArrayList<JButton> functions = new ArrayList<>();
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

        String[] funcTexts = {"+", "-", "*", "/", ".", "=", "Delete", "Clear"};

        for (String label : funcTexts){
            JButton btn = new JButton(label);
            btn.addActionListener(this);
            btn.setFocusable(false);
            functions.add(btn);
        }

        for (int i = 0; i < 10; i++){
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(this);
            btn.setFocusable(false);
            numButtons.add(btn);
        }

        delete = functions.get(6);
        clr = functions.get(7);

        delete.setBounds(50,400,145,50);
        clr.setBounds(205,400,145,50);

        panel = new JPanel();
        panel.setBounds(50,90,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numButtons.get(1));
        panel.add(numButtons.get(2));
        panel.add(numButtons.get(3));
        panel.add(functions.get(0)); // addition
        panel.add(numButtons.get(4));
        panel.add(numButtons.get(5));
        panel.add(numButtons.get(6));
        panel.add(functions.get(1)); // subtraction
        panel.add(numButtons.get(7));
        panel.add(numButtons.get(8));
        panel.add(numButtons.get(9));
        panel.add(functions.get(2)); // multiplication
        panel.add(functions.get(3)); // division
        panel.add(functions.get(4)); // decimal
        panel.add(numButtons.get(0));
        panel.add(functions.get(5)); // equal

        window.add(panel);
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
        // your action code here
    }
}