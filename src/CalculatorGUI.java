import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {
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
    }
}