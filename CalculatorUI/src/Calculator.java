import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    // Create components
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;

    double num1, num2, result;
    char operator;

    // Constructor
    public Calculator() {
        // Set frame properties
        setTitle("Calculator");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create text field
        textField = new JTextField();
        textField.setBounds(30, 30, 340, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setEditable(false);
        add(textField);

        // Initialize number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            numberButtons[i].addActionListener(this);
        }

        // Initialize function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        JButton[] functionButtons = {addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton};

        for (JButton button : functionButtons) {
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(this);
        }

        // Set button positions
        addButton.setBounds(30, 100, 80, 80);
        subButton.setBounds(120, 100, 80, 80);
        mulButton.setBounds(210, 100, 80, 80);
        divButton.setBounds(300, 100, 80, 80);


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                numberButtons[i * 3 + j + 1].setBounds(30 + j * 90, 190 + i * 90, 80, 80);
            }
        }

        numberButtons[0].setBounds(30, 370, 80, 80);
        decButton.setBounds(120, 370, 80, 80);
        equButton.setBounds(300, 370, 80, 80);

        delButton.setBounds(300, 190, 80, 80);
        clrButton.setBounds(300, 280, 80, 80);

        // Add buttons to the frame
        for (int i = 0; i < 10; i++) {
            add(numberButtons[i]);
        }

        for (JButton button : functionButtons) {
            add(button);
        }

        // Set layout and visibility
        setLayout(null);
        setVisible(true);
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText() + ".");
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

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
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            String currentText = textField.getText();
            if (!currentText.isEmpty()) {
                textField.setText(currentText.substring(0, currentText.length() - 1));
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        new Calculator();
    }
}