package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {

	Calculator parent;
	char selectedAction = ' ';
	double currentResult = 0;

	CalculatorEngine(Calculator parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e) {

		// Получаем источник события
		JButton clickedButton = (JButton) e.getSource();

		// Получаем текст с дисплея
		String displayTextField = parent.displayField.getText();

		double displayValue = 0;

		// Получаем число с дисплея, если он не пустой
		if (!"".equals(displayTextField)) {
			displayValue = Double.parseDouble(displayTextField);
		}

		Object src = e.getSource();

		// Для каждого арифметического действия
		// сохраняем действие и число
		if (src == parent.buttonPlus) {
			selectedAction = '+';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonMinus) {
			selectedAction = '-';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonMultiply) {
			selectedAction = '*';
			currentResult = displayValue;
			parent.displayField.setText("");
		} else if (src == parent.buttonDevide) {
			selectedAction = '/';
			currentResult = displayValue;
			parent.displayField.setText("");
			
		} else if (src == parent.buttonEqual) {
			// От выбора арифметического действия показываем результат
			if (selectedAction == '+') {
				currentResult += displayValue;
				parent.displayField.setText("" + currentResult);
			} else if (selectedAction == '-') {
				currentResult -= displayValue;
				parent.displayField.setText("" + currentResult);
			} else if (selectedAction == '*') {
				currentResult *= displayValue;
				parent.displayField.setText("" + currentResult);
			} else if (selectedAction == '/') {
				currentResult /= displayValue;
				parent.displayField.setText("" + currentResult);
			}
		// Сброс результата	
		} else if (src == parent.buttonReset) {
			currentResult = 0;
			parent.displayField.setText(""); 
		} else {
			// Получаем надпись на кнопке
			String clickedButtonLabel = clickedButton.getText();
			parent.displayField.setText(displayTextField + clickedButtonLabel);
		}
	}
}
