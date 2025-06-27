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
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensures the application closes properly
        window.setSize(400,550);
        window.setLayout(null);

        text = new JTextField();
        text.setBounds(50,25,300,50);
        text.setFont(new Font("Arial", Font.PLAIN, 35));
        text.setEditable(false);
        text.setHorizontalAlignment(JTextField.RIGHT);

        // Assigning buttons from the functions ArrayList for clarity
        addition = new JButton("+");
        subtraction = new JButton("-");
        multiplication = new JButton("*");
        division = new JButton("/");
        decimal = new JButton(".");
        equ = new JButton("=");
        delete = new JButton("Delete");
        clr = new JButton("Clear");

        functions.add(addition);
        functions.add(subtraction);
        functions.add(multiplication);
        functions.add(division);
        functions.add(decimal);
        functions.add(equ);
        functions.add(delete);
        functions.add(clr);

        for (JButton btn : functions) {
            btn.addActionListener(this);
            btn.setFocusable(false);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
        }

        for (int i = 0; i < 10; i++){
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(this);
            btn.setFocusable(false);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            numButtons.add(btn);
        }

        delete.setBounds(50,430,145,50);
        clr.setBounds(205,430,145,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        // Adding buttons to the panel in a standard calculator layout
        panel.add(numButtons.get(1));
        panel.add(numButtons.get(2));
        panel.add(numButtons.get(3));
        panel.add(addition);
        panel.add(numButtons.get(4));
        panel.add(numButtons.get(5));
        panel.add(numButtons.get(6));
        panel.add(subtraction);
        panel.add(numButtons.get(7));
        panel.add(numButtons.get(8));
        panel.add(numButtons.get(9));
        panel.add(multiplication);
        panel.add(decimal);
        panel.add(numButtons.get(0));
        panel.add(equ);
        panel.add(division);

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
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons.get(i)) {
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimal) {
            if (!text.getText().contains(".")) {
                text.setText(text.getText().concat("."));
            }
        }
        if (e.getSource() == addition) {
            num1 = Double.parseDouble(text.getText());
            operator = '+';
            text.setText("");
        }
        if (e.getSource() == subtraction) {
            num1 = Double.parseDouble(text.getText());
            operator = '-';
            text.setText("");
        }
        if (e.getSource() == multiplication) {
            num1 = Double.parseDouble(text.getText());
            operator = '*';
            text.setText("");
        }
        if (e.getSource() == division) {
            num1 = Double.parseDouble(text.getText());
            operator = '/';
            text.setText("");
        }
        if (e.getSource() == equ) {
            num2 = Double.parseDouble(text.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        text.setText("Error");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            text.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clr) {
            text.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }
        if (e.getSource() == delete) {
            String string = text.getText();
            text.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                text.setText(text.getText() + string.charAt(i));
            }
        }
    }
}