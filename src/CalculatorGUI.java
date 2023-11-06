import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberBtns;
    private JButton addBtn, subBtn, mulBtn, divBtn, eqBtn, clrBtn;
    private double firstNumber, secondNumber, result;
    private String operator;

    public CalculatorGUI() {
        setTitle("Calculator");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField, BorderLayout.NORTH);

        numberBtns = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberBtns[i] = new JButton(String.valueOf(i));
            numberBtns[i].setFont(new Font("Arial", Font.PLAIN, 24));
            numberBtns[i].addActionListener(this);
        }

        addBtn = new JButton("+");
        addBtn.setFont(new Font("Arial", Font.PLAIN, 24));
        addBtn.addActionListener(this);
        subBtn = new JButton("-");
        subBtn.setFont(new Font("Arial", Font.PLAIN, 24));
        subBtn.addActionListener(this);
        mulBtn = new JButton("*");
        mulBtn.setFont(new Font("Arial", Font.PLAIN, 24));
        mulBtn.addActionListener(this);
        divBtn = new JButton("/");
        divBtn.setFont(new Font("Arial", Font.PLAIN, 24));
        divBtn.addActionListener(this);
        eqBtn = new JButton("=");
        eqBtn.setFont(new Font("Arial", Font.PLAIN, 24));
        eqBtn.addActionListener(this);
        clrBtn = new JButton("C");
        clrBtn.setFont(new Font("Arial", Font.PLAIN, 24));
        clrBtn.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        buttonPanel.add(numberBtns[1]);
        buttonPanel.add(numberBtns[2]);
        buttonPanel.add(numberBtns[3]);
        buttonPanel.add(addBtn);
        buttonPanel.add(numberBtns[4]);
        buttonPanel.add(numberBtns[5]);
        buttonPanel.add(numberBtns[6]);
        buttonPanel.add(subBtn);
        buttonPanel.add(numberBtns[7]);
        buttonPanel.add(numberBtns[8]);
        buttonPanel.add(numberBtns[9]);
        buttonPanel.add(mulBtn);
        buttonPanel.add(clrBtn);
        buttonPanel.add(numberBtns[0]);
        buttonPanel.add(eqBtn);
        buttonPanel.add(divBtn);

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        String buttonText = source.getText();

        if (buttonText.matches("[0-9]")) {
            textField.setText(textField.getText() + buttonText);
        } else if (!buttonText.equals("=") && !buttonText.equals("C")) {
            firstNumber = Double.parseDouble(textField.getText());
            operator = buttonText;
            textField.setText("");
        } else if (buttonText.equals("=")) {
            secondNumber = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
            }
            textField.setText(String.valueOf(result));
        } else if (buttonText.equals("C")) {
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorGUI());
    }

}