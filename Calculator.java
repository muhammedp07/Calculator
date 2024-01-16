
/**
 * Write a description of class calculator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Calculator
{
    // instance variables - replace the example below with your own
    private double firstOperand;
    private double secondOperand;
    private String operator;

    /**
     * Constructor for objects of class calculator
     */
    public Calculator()
    {
        // initialise instance variables
        this.firstOperand = 0;
        this.secondOperand = 0;
        this.operator = "";
    }

    public double getFirstOperand()
    {
        return firstOperand;
    }
    
    public void setFirstOperand(double firstOperand)
    {
        this.firstOperand = firstOperand;
    }
    
    public double getSecondOperand()
    {
        return secondOperand;
    }
    
    public void setSecondOperand(double secondOperand)
    {
        this.secondOperand = secondOperand;
    }
    
    public String getOperator()
    {
        return operator;
    }
    
    public void setOperator(String operator)
    {
        this.operator = operator;    
    }
    
    public double sin(double angleInRadians)
    {
        return Math.sin(angleInRadians);
    }
    
    public double cos(double angleInRadians)
    {
        return Math.cos(angleInRadians);
    }
    
    public double tan(double angleInRadians)
    {
        return Math.tan(angleInRadians);
    }
 
    public double performOperation()
    {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand != 0) {
                    return firstOperand / secondOperand; 
                } else {
                    System.out.println("you should know some basic math. Cannot Divide by Zero dumb.");
                    return Double.NaN;
                }   
            default:
                return 0;
        }
    }
    
    
}
