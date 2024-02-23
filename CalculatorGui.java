import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;


public class CalculatorGui extends JFrame implements ActionListener
{
    // instance variables - replace the example below with your own
    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton equalsButton, clearButton, dotButton;
    private JButton sinButton, cosButton, tanButton;
    private JButton themeButton;
    
    private Calculator calculator;

    /**
     * Constructor for objects of class CalculatorGui
     */
    public CalculatorGui(Calculator calculator)
    {
        // initialise instance variables
        this.calculator = calculator;
        
        setTitle("Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 65));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++)
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setPreferredSize(new Dimension(50, 50));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            numberButtons[i].addActionListener(this);
        }
        
        
        operatorButtons = new JButton[4];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");
        for (JButton button: operatorButtons) {
            button.setPreferredSize(new Dimension(50, 50));
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(this);
        }
        
        equalsButton = new JButton("=");
        equalsButton.setPreferredSize(new Dimension(50, 50));
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 20));
        equalsButton.addActionListener(this);
        
        clearButton = new JButton("C");
        clearButton.setPreferredSize(new Dimension(50, 50));
        clearButton.setFont(new Font("Arial", Font.PLAIN, 20));
        clearButton.addActionListener(this);
        
        dotButton = new JButton(".");
        dotButton.setPreferredSize(new Dimension(50, 50));
        dotButton.setFont(new Font("Arial", Font.PLAIN, 20));
        dotButton.addActionListener(this);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        sinButton = new JButton("sin");
        sinButton.addActionListener(this);
        sinButton.setFont(new Font("Arial", Font.PLAIN, 20));
        
        
        cosButton = new JButton("cos");
        cosButton.addActionListener(this);
        cosButton.setFont(new Font("Arial", Font.PLAIN, 20));
               
        
        tanButton = new JButton("tan");
        tanButton.addActionListener(this);
        tanButton.setFont(new Font("Arial", Font.PLAIN, 20));
        
        themeButton = new JButton("💡");
        themeButton.addActionListener(this);
        themeButton.setFont(new Font("Arial", Font.PLAIN, 20));
        
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(operatorButtons[0]);
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(operatorButtons[1]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(operatorButtons[2]);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(equalsButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(dotButton);
        buttonPanel.add(operatorButtons[3]);
        buttonPanel.add(sinButton);
        buttonPanel.add(cosButton);
        buttonPanel.add(tanButton);
        buttonPanel.add(themeButton);
        

         
        
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
        {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    display.setText(display.getText() + i);
                    return;
                }
            }
            
            if (e.getSource() == clearButton) {
                display.setText("");
                calculator.setFirstOperand(0);
                calculator.setSecondOperand(0);
                calculator.setOperator("");
                return;
            }
            
            if (e.getSource() == equalsButton) {
                calculator.setSecondOperand(Double.parseDouble(display.getText()));
                double result = calculator.performOperation();
                display.setText(String.valueOf(result));
                calculator.setFirstOperand(result);
                calculator.setOperator("");
                return;
                
            }
            
            for (int i = 0; i < 4; i++) {
                if (e.getSource() == operatorButtons[i]) {
                    calculator.setFirstOperand(Double.parseDouble(display.getText()));
                    calculator.setOperator(operatorButtons[i].getText());
                    display.setText("");
                    return;
                }
            }
        }
    
    public static void main(String[] args)
        {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
            SwingUtilities.invokeLater(() -> {
                Calculator calculator = new Calculator();
                CalculatorGui calculatorGui = new CalculatorGui(calculator);
                calculatorGui.setVisible(true);
            });
        }
}
