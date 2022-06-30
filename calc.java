

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class calc implements ActionListener{

	JFrame frame; 
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton Button_addition,Button_subtraction,Button_multiplication,Button_division;
	JButton Button_decimal, Button_equalsto, Button_del, Button_clear, Button_neg;
	JPanel panel;
	
	Font myFont = new Font("Arial",Font.BOLD,33);
	
	double number1=0,number2=0,result=0;
	char operator;
	
	calc(){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		textfield.setBackground(Color.CYAN);
		Border border_t =  BorderFactory.createLineBorder(Color.WHITE, 4, true);
		textfield.setBorder(border_t);
		
		Button_addition = new JButton("+");
		Button_subtraction = new JButton("-");
		Button_multiplication = new JButton("*");
		Button_division = new JButton("/");
		Button_decimal = new JButton(".");
		Button_equalsto = new JButton("=");
		Button_del = new JButton("Del");
		Button_clear = new JButton("Cle");
		Button_neg = new JButton("(-)");
		
		functionButtons[0] = Button_addition;
		functionButtons[1] = Button_subtraction;
		functionButtons[2] = Button_multiplication;
		functionButtons[3] = Button_division;
		functionButtons[4] = Button_decimal;
		functionButtons[5] = Button_equalsto;
		functionButtons[6] = Button_del;
		functionButtons[7] = Button_clear;
		functionButtons[8] = Button_neg;
		
		for(int i =0;i<9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		Button_neg.setBounds(50,430,100,50);
		Button_del.setBounds(150,430,100,50);
		Button_clear.setBounds(250,430,100,50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(5,4,10,10));
		panel.setBackground(Color.blue);
		Border border = BorderFactory.createLineBorder(Color.WHITE, 6);
		panel.setBorder(border);

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(Button_addition);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(Button_subtraction);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(Button_multiplication);
		panel.add(Button_decimal);
		panel.add(numberButtons[0]);
		panel.add(Button_equalsto);
		panel.add(Button_division);
		
		frame.add(panel);
		frame.add(Button_neg);
		frame.add(Button_del);
		frame.add(Button_clear);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		calc calcs = new calc();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==Button_decimal) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==Button_addition) {
			number1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==Button_subtraction) {
			number1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==Button_multiplication) {
			number1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==Button_division) {
			number1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==Button_equalsto) {
			number2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=number1+number2;
				break;
			case'-':
				result=number1-number2;
				break;
			case'*':
				result=number1*number2;
				break;
			case'/':
				result=number1/number2;
				break;
			}
			textfield.setText(String.valueOf(result));
			number1=result;
		}
		if(e.getSource()==Button_clear) {
			textfield.setText("");
		}
		if(e.getSource()==Button_del) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==Button_neg) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}
}