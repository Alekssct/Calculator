package calc;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Calculator {

	JPanel windowContent;
	JTextField displayField;
	JButton buttonPoint;
	JButton buttonEqual;
	JButton buttonMinus;
	JButton buttonPlus;
	JButton buttonMultiply;
	JButton buttonDevide;
	JButton buttonReset;
	JPanel panelWest;
	JPanel panelCenter;
	JPanel panelEast;

	Calculator() {
		windowContent = new JPanel();
		BorderLayout bl = new BorderLayout();
		windowContent.setLayout(bl);

		displayField = new JTextField(20);
		displayField.setHorizontalAlignment(JTextField.RIGHT);
		windowContent.add("North", displayField);

		// Создание западной панели
		buttonReset = new JButton("C");
		panelWest = new JPanel();
		GridLayout g0 = new GridLayout(1, 1);
		panelWest.setLayout(g0);
		panelWest.add(buttonReset);
		windowContent.add("West", panelWest);

		// Создание центральной панели
		JButton[] button = new JButton[10];
		for (int i = 0; i < 10; i++) {
			button[i] = new JButton("" + i);
		}
		buttonPoint = new JButton(".");
		buttonEqual = new JButton("=");

		panelCenter = new JPanel();
		GridLayout g1 = new GridLayout(4, 3);
		panelCenter.setLayout(g1);

		for (int i = 1; i < 10; i++) {
			panelCenter.add(button[i]);
		}
		panelCenter.add(button[0]);
		panelCenter.add(buttonPoint);
		panelCenter.add(buttonEqual);

		windowContent.add("Center", panelCenter);

		// Создание восточной панели
		buttonMinus = new JButton("-");
		buttonPlus = new JButton("+");
		buttonMultiply = new JButton("*");
		buttonDevide = new JButton("/");

		panelEast = new JPanel();
		GridLayout g2 = new GridLayout(4, 1);
		panelEast.setLayout(g2);

		panelEast.add(buttonPlus);
		panelEast.add(buttonMinus);
		panelEast.add(buttonMultiply);
		panelEast.add(buttonDevide);

		windowContent.add("East", panelEast);

		JFrame frame = new JFrame("Calculator");
		frame.setContentPane(windowContent);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		CalculatorEngine calcEng = new CalculatorEngine(this);
		for (int i = 0; i < 10; i++) {
			button[i].addActionListener(calcEng);
		}
		buttonPoint.addActionListener(calcEng);
		buttonEqual.addActionListener(calcEng);
		buttonPlus.addActionListener(calcEng);
		buttonMinus.addActionListener(calcEng);
		buttonMultiply.addActionListener(calcEng);
		buttonDevide.addActionListener(calcEng);
		buttonReset.addActionListener(calcEng);
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}
}
