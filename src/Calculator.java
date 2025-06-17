import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Calculator {

    JFrame window;
    JTextField text;
    JButton [] buttons = new JButton[10];
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
        text.setBounds(50,25,250,50);
        text.setEditable(false);

        window.add(text);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();


    }
}