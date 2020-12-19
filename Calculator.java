//15-1 Homework Part-1
//Zawaad M Shah
//zmshah16@ole.augie.edu
//Calculator.java
//Desc:  A simple calculator for doing addition, subtraction, multiplication, and division
//Input: The user selects +, -, *, / via a GUI, then enters 2 numbers via an input box. The
//       user can repeatedly use the calculator until the user close the GUI window
//Output:The result of the specified expression displayed in a message box
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator extends JFrame implements ActionListener
{
      private JButton btnAdd=new JButton("+");
      private JButton btnSubtract=new JButton("-");
      private JButton btnMultiply=new JButton("*");
      private JButton btnDivide=new JButton("/");
      private JButton btnSqrt=new JButton("sqrt");
      public Calculator()
      {
            addControls();
            registerListeners();
            setTitle("Calculator");
            setSize(600, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
      }
      public void addControls()
      {
            setLayout(new GridLayout(1, 5));
            add(btnAdd);
            add(btnSubtract);
            add(btnMultiply);
            add(btnDivide);
            add(btnSqrt);
      }
      public void registerListeners()
      {
            btnAdd.addActionListener(this);
            btnSubtract.addActionListener(this);
            btnMultiply.addActionListener(this);
            btnDivide.addActionListener(this);
            btnSqrt.addActionListener(this);
      }
      //Input: User enters 2 numbers via input dialogs
      //Output:The result of the operation indicated by the button clicked applied to the
      //       input numbers displayed in a message box
      public void actionPerformed(ActionEvent e)
      {
            if(e.getSource()!=btnSqrt)
            {
               String oper1=JOptionPane.showInputDialog(null, "Operand 1", 0.0);
               String oper2=JOptionPane.showInputDialog(null, "Operand 2", 0.0);
               double num1=Double.parseDouble(oper1);
               double num2=Double.parseDouble(oper2);
               double result=0.0;
               if((e.getSource()==btnDivide)&&(oper2.equals("0")||oper2.equals("0.0")))
                  JOptionPane.showMessageDialog(null, "Cannot divide by 0", "Error", 
                                                JOptionPane.ERROR_MESSAGE);
               else if(e.getSource()==btnAdd)
               {
                       result=num1+num2;
                       JOptionPane.showMessageDialog(null, oper1+"+"+oper2+"="+result);
               }
               else if(e.getSource()==btnSubtract)
               {
                       result=num1-num2;
                       JOptionPane.showMessageDialog(null, oper1+"-"+oper2+"="+result);
               }
               else if(e.getSource()==btnMultiply)
               {
                       result=num1*num2;
                       JOptionPane.showMessageDialog(null, oper1+"*"+oper2+"="+result);
               }
               else if(e.getSource()==btnDivide)
               {
                       result=num1/num2;
                       JOptionPane.showMessageDialog(null, oper1+"/"+oper2+"="+result);
               }
            }
            else if(e.getSource()==btnSqrt)
            {
                    String oper1=JOptionPane.showInputDialog(null, "Operand 1", 0.0);
                    double num=Double.parseDouble(oper1);
                    if(oper1.startsWith("-"))
                       JOptionPane.showMessageDialog(null, "Cannot sqrt "+oper1, "Error", 
                                                     JOptionPane.ERROR_MESSAGE);
                    else
                    {
                       double result=Math.sqrt(num);
                       JOptionPane.showMessageDialog(null, "sqrt("+oper1+")="+result);
                    }
            }
      }
      public static void main(String[] args)
      {
            Calculator f=new Calculator();
      }
}