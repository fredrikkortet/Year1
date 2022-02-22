import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

	private String buttonText[] = { "7", "8", "9", "^", "C", "4", "5", "6", "(", ")", "1", "2", "3", "*", "/", "0", "+",
			"-", "=" };
	private JButton[] buttons = new JButton[19];
	private JTextField expressionField;
	private String exp = "";

	public Calculator() {
		super("Calculator");
		setSize(320, 240);
		expressionField = new JTextField();
		JPanel panel = new JPanel(new GridLayout(4, 5));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonText[i]);
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}
		panel.add(new Label());
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(expressionField, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "C") {
			exp = "";
			expressionField.setText(exp);
		} else if (e.getActionCommand() == "=") {
			expressionField.setText("" + evaluate(infixToPostfix(exp)));
		}

		else {
			exp = exp + e.getActionCommand();
			expressionField.setText(exp);
		}

	}

	public static void main(String[] arg) {

		Calculator calc = new Calculator();
		calc.setVisible(true);

	}

	public static LinkedList<String> infixToPostfix(String exp) {

		Stack<String> stack = new Stack<String>();
		LinkedList<String> list = new LinkedList<String>();
		for (int i = 0; i < exp.length(); i++) {
			String s = exp.charAt(i) + "";
			if (s.equals("+")) {
				while (!stack.isEmpty()) {
					String tkn = stack.pop();
					if (tkn.equals("*") || tkn.equals("/") || tkn.equals("+") || tkn.equals("-") || tkn.equals("^"))
						list.add(tkn);
					else {
						stack.push(tkn);
						break;
					}
				}
				stack.push(s);

			} else if (s.equals("-")) {
				while (!stack.isEmpty()) {
					String tkn = stack.pop();
					if (tkn.equals("*") || tkn.equals("/") || tkn.equals("+") || tkn.equals("-") || tkn.equals("^"))
						list.add(tkn);
					else {
						stack.push(tkn);
						break;
					}
				}
				stack.push(s);
			}

			else if (s.equals("*")) {
				while (!stack.isEmpty()) {
					String tkn = stack.peek();
					if (tkn.equals("*") || tkn.equals("/") || tkn.equals("^")) {
						tkn = stack.pop();
						list.add(tkn);

					} else {
						stack.push(s);
						break;
					}
				}
				if (stack.isEmpty()) {
					stack.push(s);
				}

			} else if (s.equals("/")) {
				while (!stack.isEmpty()) {
					String tkn = stack.peek();
					if (tkn.equals("*") || tkn.equals("/") || tkn.equals("^")) {
						tkn = stack.pop();
						list.add(tkn);

					} else {
						stack.push(s);
						break;
					}
				}
				if (stack.isEmpty()) {
					stack.push(s);
				}

			} else if (s.equals("^")) {

				while (!stack.isEmpty()) {
					String tkn = stack.peek();
					if (tkn.equals("^")) {
						tkn = stack.pop();
						list.add(tkn);

					} else {
						stack.push(s);
						break;
					}
				}
				if (stack.isEmpty()) {
					stack.push(s);
				}

			}

			else if (s.equals("(")) {
				stack.push(s);

			} else if (s.equals(")")) {
				while (!stack.isEmpty()) {
					String tkn = stack.pop();
					if (!tkn.equals("(")) {
						list.add(tkn);
					} else {
						break;
					}
				}

			} else

				list.add(s);
		}

		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}

	public static double evaluate(LinkedList<String> exp) {
		Stack<Double> stack = new Stack<Double>();
		double count;
		double a;
		double b;
		while (!exp.isEmpty()) {
			String s = exp.remove();
			if (s.equals("+")) {
				a = stack.pop();
				b = stack.pop();
				stack.push(b + a);
			} else if (s.equals("*")) {
				a = stack.pop();
				b = stack.pop();
				stack.push(b * a);
			} else if (s.equals("^")) {
				a = stack.pop();
				b = stack.pop();
				stack.push(Math.pow(b, a));
			} else if (s.equals("/")) {
				a = stack.pop();
				b = stack.pop();
				stack.push(b / a);
			} else if (s.equals("-")) {
				a = stack.pop();
				b = stack.pop();
				stack.push(b - a);
			} else
				stack.push(Double.parseDouble(s));
		}
		count = stack.pop();

		return count;
	}

}