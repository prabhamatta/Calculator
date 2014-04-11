package calculator;

public class Calculator {

	// OPERATOR state constant.
	private final int OPR = 0;
	// Operator buttons set state to OPR.
	// NUMERIC state constant.
	private final int ERR = 3;
	private final int MEM = 2;
	private final int NUM = 1;
	// Digit buttons set state to NUM.
	// The current state of the calculator.
	private int state;

	// Remembered number.
	private int num1;

	// Remembered operator.
	private char op1;

	// Operators are: + - * / =.
	// New number (number currently being entered).
	private int num2; // if state == OPR, num2 is undefined.

	private int mem; // memory

	public Calculator() {
		num1 = 0;
		op1 = '=';
		num2 = 0;
		state = OPR;
		mem = 0;
	}

	// Updates this calculator, when a digit is entered.
	public void enterDigit(char digit) {

		if (state == NUM) {
			String s = digit + "";
			num2 = num2 * 10 + Integer.parseInt(s);
			state = NUM;
		} else if (state == OPR) {
			String s = "" + digit;
			num2 = Integer.parseInt(s);
			state = NUM;
		} else {
			String s = digit + "";

			num2 = num2 * 10 + Integer.parseInt(s);
			state = NUM;

		}

	}

	// Updates this calculator, when an operator is entered.
	public void enterOperator(char op2) {

		if (state == NUM && op1 == 47 && num2 == 0) {
			state = ERR;

		}

		if (state == NUM) {

			if (op1 == 43) {
				num1 = num1 + num2;

			} else if (op1 == 45) {
				num1 = num1 - num2;
			} else if (op1 == 47) {
				num1 = num1 / num2;
			} else if (op1 == 42) {
				num1 = num1 * num2;
			} else if (op1 == 61) {
				num1 = num2;
			}

			op1 = op2;
			state = OPR;

		} else if (state == OPR)
			op1 = op2;
		else if (state == MEM) {
			num1 = mem;
			op1 = op2;
			state = OPR;

		}

	}

	// Returns the text to show in the display.
	public String getDisplayText() {
		String s = "";

		if (state == NUM) {
			if (op1 != 61) {

				s = "" + num1 + op1 + num2;
			} else {
				s = "" + num2;
			}
		}

		if (state == OPR) {
			if (num1 != 0) {
				s = "" + num1 + op1;
				num2 = 0;
			} else {
				s = "" + num1;
			}
		}

		if (state == MEM) {

			s = readMemory() + "";

		}

		if (state == ERR) {
			s = "ERR: Division by 0";

		}

		return s;
	}

	public void clearMemory() {
		mem = 0;
	}

	public int readMemory() {
		state = MEM;
		num2 = 0;
		return mem;
	}

	public void saveInMemory() {
		if (state == OPR)
			mem = num1;
		else

			mem = num2;
	}

	public void addToMemory() {

		if (state == OPR)
			mem = mem + num1;
		else
			mem = mem + num2;
	}

	public void reset() {
		num1 = 0;
		op1 = '=';
		num2 = 0;
		state = OPR;

	}

	public void clearNumber() {

		if (state == MEM) {
			num2 = 0;
			state = NUM;

		} else if (state == NUM) {
			num2 = 0;
			state = OPR;
		}

	}

	public void removeDigit() {

		if (state == NUM)
			if (num2 != 0) {
				if (num2 / 10 == 0) {
					state = OPR;
				}
				num2 = num2 / 10;

			}

	}

	public void changeSign() {
		if (state == OPR) {
			num1 = num1 - 2 * num1;
		} else {
			num2 = num2 - 2 * num2;

		}
	}
}