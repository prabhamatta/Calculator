package mycalculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame {

	private final static CalculatorFrame frame = new CalculatorFrame();
	private final JPanel pnlContent;

	private JTextField txfDisplay;
	private JButton[] btnDigit;
	private JButton btnAdd, btnSub, btnMul, btnDiv, btnCalc;
	private JButton btnMr, btnMc, btnMs, btnMplus;
	private JButton btnC, btnCe, btnClear, btnChangeSign;
	private DigitController digitCtrl = new DigitController();
	private OperatorController oprCtrl = new OperatorController();
	private MemoryController memCtrl = new MemoryController();
	private SpecialController speCtrl = new SpecialController();

	private Calculator calculator = new Calculator();

	public static void main(String[] args) {

		frame.setTitle("Calculator v1.0");
		frame.setSize(450, 515);
		frame.setLocation(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public CalculatorFrame() {
		int wh = 60; // width and height of buttons
		int sep = 20; // distance between buttons
						// and between buttons and window-border

		pnlContent = (JPanel) this.getContentPane();
		pnlContent.setLayout(null);

		txfDisplay = new JTextField();
		pnlContent.add(txfDisplay);
		txfDisplay.setSize(380, 35);
		txfDisplay.setLocation(20, 20);
		txfDisplay.setEditable(false);
		txfDisplay.setBackground(Color.white);
		txfDisplay.setFont(new Font("arial", Font.PLAIN, 35));
		txfDisplay.setHorizontalAlignment(JTextField.RIGHT);

		btnDigit = new JButton[10];

		int x = 100;
		int y = 155;
		for (int i = 9; i >= 0; i--) {
			btnDigit[i] = new JButton();
			pnlContent.add(btnDigit[i]);
			btnDigit[i].setText("" + i);
			btnDigit[i].setSize(wh, wh);
			btnDigit[i].setLocation(x, y);
			btnDigit[i].addActionListener(digitCtrl);
			btnDigit[i].setFont(new Font("arial", Font.PLAIN, 35));

			x = x + wh + sep;
			if (x > 300) {
				x = 100;
				y = y + wh + sep;
			}
		}

		btnAdd = new JButton("+");
		pnlContent.add(btnAdd);
		btnAdd.setSize(wh, wh);
		btnAdd.setLocation(sep, 75);
		btnAdd.addActionListener(oprCtrl);
		btnAdd.setFont(new Font("arial", Font.PLAIN, 35));

		btnSub = new JButton("-");
		pnlContent.add(btnSub);
		btnSub.setSize(wh, wh);
		btnSub.setLocation(sep, 155);
		btnSub.addActionListener(oprCtrl);
		btnSub.setFont(new Font("arial", Font.PLAIN, 35));

		btnMul = new JButton("*");
		pnlContent.add(btnMul);
		btnMul.setSize(wh, wh);
		btnMul.setLocation(sep, 235);
		btnMul.addActionListener(oprCtrl);
		btnMul.setFont(new Font("arial", Font.PLAIN, 35));

		btnDiv = new JButton("/");
		pnlContent.add(btnDiv);
		btnDiv.setSize(wh, wh);
		btnDiv.setLocation(sep, 315);
		btnDiv.addActionListener(oprCtrl);
		btnDiv.setFont(new Font("arial", Font.PLAIN, 35));

		btnCalc = new JButton("=");
		pnlContent.add(btnCalc);
		btnCalc.setSize(wh, wh);
		btnCalc.setLocation(sep, 395);
		btnCalc.addActionListener(oprCtrl);
		btnCalc.setFont(new Font("arial", Font.PLAIN, 35));

		int e = wh + sep + sep;

		btnMc = new JButton("MC");
		pnlContent.add(btnMc);
		btnMc.setSize(wh, wh);
		btnMc.setLocation(e, 75);
		btnMc.addActionListener(memCtrl);
		btnMc.setFont(new Font("arial", Font.PLAIN, 15));

		e = e + wh + sep;

		btnMr = new JButton("MR");
		pnlContent.add(btnMr);
		btnMr.setSize(wh, wh);
		btnMr.setLocation(e, 75);
		btnMr.addActionListener(memCtrl);
		btnMr.setFont(new Font("arial", Font.PLAIN, 15));

		e = e + wh + sep;

		btnMs = new JButton("MS");
		pnlContent.add(btnMs);
		btnMs.setSize(wh, wh);
		btnMs.setLocation(e, 75);
		btnMs.addActionListener(memCtrl);
		btnMs.setFont(new Font("arial", Font.PLAIN, 15));

		e = e + wh + sep;

		btnMplus = new JButton("M+");
		pnlContent.add(btnMplus);
		btnMplus.setSize(wh, wh);
		btnMplus.setLocation(e, 75);
		btnMplus.addActionListener(memCtrl);
		btnMplus.setFont(new Font("arial", Font.PLAIN, 15));

		btnC = new JButton("C");
		pnlContent.add(btnC);
		btnC.setSize(wh, wh);
		btnC.setLocation(e, 155);
		btnC.addActionListener(speCtrl);
		btnC.setFont(new Font("arial", Font.PLAIN, 17));
		btnC.setForeground(Color.RED);

		btnCe = new JButton("CE");
		pnlContent.add(btnCe);
		btnCe.setSize(wh, wh);
		btnCe.setLocation(e, 235);
		btnCe.addActionListener(speCtrl);
		btnCe.setFont(new Font("arial", Font.PLAIN, 17));
		btnCe.setForeground(Color.RED);

		btnClear = new JButton("<X");
		pnlContent.add(btnClear);
		btnClear.setSize(wh, wh);
		btnClear.setLocation(e, 315);
		btnClear.addActionListener(speCtrl);
		btnClear.setFont(new Font("arial", Font.PLAIN, 17));

		btnChangeSign = new JButton("+/-");
		pnlContent.add(btnChangeSign);
		btnChangeSign.setSize(wh, wh);
		btnChangeSign.setLocation(e, 395);
		btnChangeSign.addActionListener(speCtrl);
		btnChangeSign.setFont(new Font("arial", Font.PLAIN, 17));

	}

	// Controller for digit buttons.
	private class DigitController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i <= 9; i++) {
				if (e.getSource() == btnDigit[i]) {

					char c = btnDigit[i].getText().charAt(0);

					calculator.enterDigit(c);

					txfDisplay.setText(calculator.getDisplayText());

				}
			}
		}
	}

	// Controller for operator buttons.
	private class OperatorController implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnAdd) {

				calculator.enterOperator('+');
				txfDisplay.setText(calculator.getDisplayText());
			}
			if (e.getSource() == btnMul) {

				calculator.enterOperator('*');
				txfDisplay.setText(calculator.getDisplayText());
			}
			if (e.getSource() == btnSub) {

				calculator.enterOperator('-');
				txfDisplay.setText(calculator.getDisplayText());
			}
			if (e.getSource() == btnDiv) {

				calculator.enterOperator('/');
				txfDisplay.setText(calculator.getDisplayText());
			}
			if (e.getSource() == btnCalc) {

				calculator.enterOperator('=');
				txfDisplay.setText(calculator.getDisplayText());

			}
			if (txfDisplay.getText().equals("ERR: Division by 0")) {
				btnDiv.setEnabled(false);
				btnAdd.setEnabled(false);
				btnSub.setEnabled(false);
				btnMul.setEnabled(false);
				btnCalc.setEnabled(false);
				btnMr.setEnabled(false);
				btnMc.setEnabled(false);
				btnMs.setEnabled(false);
				btnMplus.setEnabled(false);
				btnCe.setEnabled(false);
				btnClear.setEnabled(false);
				btnChangeSign.setEnabled(false);
				for (int i = 0; i < 10; i++) {
					btnDigit[i].setEnabled(false);
				}

			}
		}
	}

	private class MemoryController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnMc) {

				calculator.clearMemory();

			}
			if (e.getSource() == btnMr) {
				calculator.readMemory();
				txfDisplay.setText(calculator.getDisplayText());

			}
			if (e.getSource() == btnMs) {

				calculator.saveInMemory();
			}
			if (e.getSource() == btnMplus) {

				calculator.addToMemory();
			}
		}
	}

	private class SpecialController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnC) {
				calculator.reset();
				txfDisplay.setText(calculator.getDisplayText());
				btnDiv.setEnabled(true);
				btnAdd.setEnabled(true);
				btnSub.setEnabled(true);
				btnMul.setEnabled(true);
				btnCalc.setEnabled(true);
				btnMr.setEnabled(true);
				btnMc.setEnabled(true);
				btnMs.setEnabled(true);
				btnMplus.setEnabled(true);
				btnCe.setEnabled(true);
				btnClear.setEnabled(true);
				btnChangeSign.setEnabled(true);
				for (int i = 0; i < 10; i++) {
					btnDigit[i].setEnabled(true);
				}
			}
			if (e.getSource() == btnCe) {
				calculator.clearNumber();
				txfDisplay.setText(calculator.getDisplayText());
			}
			if (e.getSource() == btnClear) {
				calculator.removeDigit();
				txfDisplay.setText(calculator.getDisplayText());

			}
			if (e.getSource() == btnChangeSign) {
				calculator.changeSign();
				txfDisplay.setText(calculator.getDisplayText());
			}
		}
	}
}
