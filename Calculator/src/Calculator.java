import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;

public class Calculator extends JPanel implements ActionListener {
	// initialize all UI features
	public static final String HEX = "HEX";
	public static final String DEC = "DEC";
	public static final String OCT = "OCT";
	public static final String BIN = "BIN";

	public static final int QWORD = 64;
	public static final int DWORD = 32;
	public static final int WORD = 16;
	public static final int BYTE = 8;

	JLabel calcTag = new JLabel("Programmer");

	JButton numSize = new JButton("QWORD");
	JButton num1 = new JButton("1");
	JButton num2 = new JButton("2");
	JButton num3 = new JButton("3");
	JButton num4 = new JButton("4");
	JButton num5 = new JButton("5");
	JButton num6 = new JButton("6");
	JButton num7 = new JButton("7");
	JButton num8 = new JButton("8");
	JButton num9 = new JButton("9");
	JButton num0 = new JButton("0");
	JButton numA = new JButton("A");
	JButton numB = new JButton("B");
	JButton numC = new JButton("C");
	JButton numD = new JButton("D");
	JButton numE = new JButton("E");
	JButton numF = new JButton("F");

	JButton decimal = new JButton(".");
	JButton clearEntery = new JButton("CE");
	JButton clear = new JButton("C");
	JButton modulous = new JButton("Mod");
	JButton backspace = new JButton("\u232B");
	JButton divide = new JButton("÷");
	JButton multiply = new JButton("×");
	JButton subtract = new JButton("−");
	JButton addition = new JButton("+");
	JButton equals = new JButton("=");
	JButton flipSign = new JButton("±");
	JButton leftPhr = new JButton("(");
	JButton rightPhr = new JButton(")");
	JButton menuLines = new JButton("\u2630");

	JButton upButton = new JButton("↑");
	JButton lshButton = new JButton("Lsh");
	JButton rshButton = new JButton("Rsh");
	JButton orButton = new JButton("Or");
	JButton xorButton = new JButton("Xor");
	JButton notButton = new JButton("Not");
	JButton andButton = new JButton("And");
	JButton keyPad1 = new JButton("⢿⠇");
	JButton keyPad2 = new JButton("⠣⠃");
	JButton memorySvae = new JButton("MS");
	JButton memory = new JButton("M");

	JTextField numField = new JTextField();
	JTextField savedField = new JTextField();

	JButton hexField = new JButton();
	JButton decField = new JButton();
	JButton octField = new JButton();
	JButton binField = new JButton();
	JButton hexSelected = new JButton();
	JButton decSelected = new JButton();
	JButton octSelected = new JButton();
	JButton binSelected = new JButton();

	JPanel calcFace = new JPanel();
	// creates GUI
	public Calculator() {
		createGUIItems();
	}
	// creates GUI
	private void createGUIItems() {
		
		calcTag.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuLines.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 22));

		calcFace.setBackground(SystemColor.control);
		calcFace.setBorder(new EmptyBorder(5, 5, 5, 5));
		// disable buttons that should be disabled initially 
		hexSelected.setEnabled(false);
		decSelected.setEnabled(false);
		octSelected.setEnabled(false);
		binSelected.setEnabled(false);

		decimal.setEnabled(false);
		numA.setEnabled(false);
		numB.setEnabled(false);
		numC.setEnabled(false);
		numD.setEnabled(false);
		numE.setEnabled(false);
		numF.setEnabled(false);

		memory.setEnabled(false);
		
		// formats the various fields
		numField.setEditable(false);
		numField.setFont(new Font("Segoe UI", 0, 30));
		numField.setHorizontalAlignment(JTextField.RIGHT);
		numField.setText("0");
		numField.setBorder(BorderFactory.createEmptyBorder());

		savedField.setEditable(false);
		savedField.setFont(new Font("Segoe UI", 1, 10));
		savedField.setHorizontalAlignment(JTextField.RIGHT);
		savedField.setBorder(BorderFactory.createEmptyBorder());


		hexField.setFont(new Font("monospaced", Font.PLAIN, 10));
		hexField.setBackground(SystemColor.menu);
		hexField.setHorizontalAlignment(JTextField.LEFT);
		hexField.setText(HEX + "   0");
		hexField.setBorder(BorderFactory.createEmptyBorder());
		hexSelected.setBorder(BorderFactory.createEmptyBorder());
		hexSelected.setBackground(SystemColor.menu);


		decField.setFont(new Font("monospaced", Font.PLAIN, 10));
		decField.setBackground(SystemColor.menu);
		decField.setHorizontalAlignment(JTextField.LEFT);
		decField.setText(DEC + "   0");
		decField.setBorder(BorderFactory.createEmptyBorder());
		decSelected.setBorder(BorderFactory.createEmptyBorder());
		decSelected.setBackground(Color.BLUE);


		octField.setFont(new Font("monospaced", Font.PLAIN, 10));
		octField.setBackground(SystemColor.menu);
		octField.setHorizontalAlignment(JTextField.LEFT);
		octField.setText(OCT + "   0");
		octField.setBorder(BorderFactory.createEmptyBorder());
		octSelected.setBorder(BorderFactory.createEmptyBorder());
		octSelected.setBackground(SystemColor.menu);


		binField.setFont(new Font("monospaced", Font.PLAIN, 10));
		binField.setBackground(SystemColor.menu);
		binField.setHorizontalAlignment(JTextField.LEFT);
		binField.setText(BIN + "   0");
		binField.setBorder(BorderFactory.createEmptyBorder());
		binSelected.setBorder(BorderFactory.createEmptyBorder());
		binSelected.setBackground(SystemColor.menu);

		JLabel calculatorLabel = new JLabel();
		calculatorLabel.setFont(new Font("Tahoma", 1, 24));
		calculatorLabel.setForeground(new Color(0, 204, 102));
		calculatorLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		// gets rid of borders
		menuLines.setBorder(BorderFactory.createEmptyBorder());
		upButton.setBorder(BorderFactory.createEmptyBorder());
		lshButton.setBorder(BorderFactory.createEmptyBorder());
		rshButton.setBorder(BorderFactory.createEmptyBorder());
		orButton.setBorder(BorderFactory.createEmptyBorder());
		xorButton.setBorder(BorderFactory.createEmptyBorder());
		notButton.setBorder(BorderFactory.createEmptyBorder());
		andButton.setBorder(BorderFactory.createEmptyBorder());
		keyPad1.setBorder(BorderFactory.createEmptyBorder());
		keyPad2.setBorder(BorderFactory.createEmptyBorder());
		memorySvae.setBorder(BorderFactory.createEmptyBorder());
		memory.setBorder(BorderFactory.createEmptyBorder());
		numSize.setBorder(BorderFactory.createEmptyBorder());

		// remove the effects of a clicked button
		menuLines.setFocusPainted(false);
		numSize.setFocusPainted(false);
		hexField.setFocusPainted(false);
		decField.setFocusPainted(false);
		octField.setFocusPainted(false);
		binField.setFocusPainted(false);
		num1.setFocusPainted(false);
		num2.setFocusPainted(false);
		num3.setFocusPainted(false);
		num4.setFocusPainted(false);
		num5.setFocusPainted(false);
		num6.setFocusPainted(false);
		num7.setFocusPainted(false);
		num8.setFocusPainted(false);
		num9.setFocusPainted(false);
		num0.setFocusPainted(false);
		numA.setFocusPainted(false);
		numB.setFocusPainted(false);
		numC.setFocusPainted(false);
		numD.setFocusPainted(false);
		numE.setFocusPainted(false);
		numF.setFocusPainted(false);
		decimal.setFocusPainted(false);
		clearEntery.setFocusPainted(false);
		clear.setFocusPainted(false);
		modulous.setFocusPainted(false);
		backspace.setFocusPainted(false);
		divide.setFocusPainted(false);
		multiply.setFocusPainted(false);
		subtract.setFocusPainted(false);
		addition.setFocusPainted(false);
		equals.setFocusPainted(false);
		flipSign.setFocusPainted(false);
		leftPhr.setFocusPainted(false);
		rightPhr.setFocusPainted(false);
		upButton.setFocusPainted(false);
		lshButton.setFocusPainted(false);
		rshButton.setFocusPainted(false);
		orButton.setFocusPainted(false);
		xorButton.setFocusPainted(false);
		notButton.setFocusPainted(false);
		andButton.setFocusPainted(false);
		keyPad1.setFocusPainted(false);
		keyPad2.setFocusPainted(false);
		memorySvae.setFocusPainted(false);
		memory.setFocusPainted(false);
		
		// changes colour of buttons
		menuLines.setBackground(SystemColor.control);
		numSize.setBackground(SystemColor.control);
		num1.setBackground(SystemColor.text);
		num2.setBackground(SystemColor.text);
		num3.setBackground(SystemColor.text);
		num4.setBackground(SystemColor.text);
		num5.setBackground(SystemColor.text);
		num6.setBackground(SystemColor.text);
		num7.setBackground(SystemColor.text);
		num8.setBackground(SystemColor.text);
		num9.setBackground(SystemColor.text);
		num0.setBackground(SystemColor.text);
		numA.setBackground(SystemColor.text);
		numB.setBackground(SystemColor.text);
		numC.setBackground(SystemColor.text);
		numD.setBackground(SystemColor.text);
		numE.setBackground(SystemColor.text);
		numF.setBackground(SystemColor.text);
		decimal.setBackground(SystemColor.menu);
		clearEntery.setBackground(SystemColor.menu);
		clear.setBackground(SystemColor.menu);
		modulous.setBackground(SystemColor.menu);
		backspace.setBackground(SystemColor.menu);
		divide.setBackground(SystemColor.menu);
		multiply.setBackground(SystemColor.menu);
		subtract.setBackground(SystemColor.menu);
		addition.setBackground(SystemColor.menu);
		equals.setBackground(SystemColor.menu);
		flipSign.setBackground(SystemColor.menu);
		leftPhr.setBackground(SystemColor.menu);
		rightPhr.setBackground(SystemColor.menu);
		upButton.setBackground(SystemColor.menu);
		lshButton.setBackground(SystemColor.menu);
		rshButton.setBackground(SystemColor.menu);
		orButton.setBackground(SystemColor.menu);
		xorButton.setBackground(SystemColor.menu);
		notButton.setBackground(SystemColor.menu);
		andButton.setBackground(SystemColor.menu);
		keyPad1.setBackground(SystemColor.menu);
		keyPad2.setBackground(SystemColor.menu);
		memorySvae.setBackground(SystemColor.menu);
		memory.setBackground(SystemColor.menu);

		// sets the font for each button
		numSize.setFont(new Font("Segoe UI", Font.BOLD, 14));
		num1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		num2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		num3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		num4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		num5.setFont(new Font("Segoe UI", Font.BOLD, 20));
		num6.setFont(new Font("Segoe UI", Font.BOLD, 20));
		num7.setFont(new Font("Segoe UI", Font.BOLD, 20));
		num8.setFont(new Font("Segoe UI", Font.BOLD, 20));
		num9.setFont(new Font("Segoe UI", Font.BOLD, 20));
		num0.setFont(new Font("Segoe UI", Font.BOLD, 20));
		numA.setFont(new Font("Segoe UI", Font.BOLD, 12));
		numB.setFont(new Font("Segoe UI", Font.BOLD, 12));
		numC.setFont(new Font("Segoe UI", Font.BOLD, 12));
		numD.setFont(new Font("Segoe UI", Font.BOLD, 12));
		numE.setFont(new Font("Segoe UI", Font.BOLD, 12));
		numF.setFont(new Font("Segoe UI", Font.BOLD, 12));
		decimal.setFont(new Font("Segoe UI", Font.BOLD, 14));
		clearEntery.setFont(new Font("Segoe UI", Font.BOLD, 14));
		clear.setFont(new Font("Segoe UI", Font.BOLD, 14));
		modulous.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		backspace.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		divide.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		multiply.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		subtract.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		addition.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		equals.setFont(new Font("Segoe UI", Font.BOLD, 14));
		flipSign.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		leftPhr.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rightPhr.setFont(new Font("Segoe UI", Font.BOLD, 14));
		upButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 30));
		lshButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		rshButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		orButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		xorButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		notButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		andButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		keyPad1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		keyPad2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		memorySvae.setFont(new Font("Segoe UI", Font.BOLD, 14));
		memory.setFont(new Font("Segoe UI", Font.BOLD, 14));

		// places all the UI on the panel
		calcFace.setLayout(null);
		menuLines.setBounds(0, 0, 50, 50);

		calcTag.setBounds(50, 0, 300, 50);

		numField.setHorizontalAlignment(SwingConstants.RIGHT);
		numField.setBounds(10, 64, 281, 41);

		savedField.setHorizontalAlignment(SwingConstants.RIGHT);
		savedField.setBounds(10, 39, 281, 30);

		hexSelected.setBounds(0, 115, 5, 10);
		hexField.setBounds(10, 110, 300, 23);
		decSelected.setBounds(0, 143, 5, 10);
		decField.setBounds(10, 138, 300, 23);
		octSelected.setBounds(0, 171, 5, 10);
		octField.setBounds(10, 166, 300, 23);
		binSelected.setBounds(0, 199, 5, 10);
		binField.setBounds(10, 194, 300, 23);

		numA.setBounds(5, 314, 52, 37);
		numB.setBounds(58, 314, 52, 37);
		numC.setBounds(5, 352, 52, 37);
		numD.setBounds(58, 352, 52, 37);
		numE.setBounds(5, 390, 52, 37);
		numF.setBounds(58, 390, 52, 37);

		num9.setBounds(217, 314, 52, 37);
		num8.setBounds(164, 314, 52, 37);
		num7.setBounds(111, 314, 52, 37);
		num6.setBounds(217, 352, 52, 37);
		num5.setBounds(164, 352, 52, 37);
		num4.setBounds(111, 352, 52, 37);
		num3.setBounds(217, 390, 52, 37);
		num2.setBounds(164, 390, 52, 37);
		num1.setBounds(111, 390, 52, 37);
		num0.setBounds(164, 428, 52, 37);

		leftPhr.setBounds(5, 428, 52, 37);
		rightPhr.setBounds(58, 428, 52, 37);
		flipSign.setBounds(111, 428, 52, 37);
		decimal.setBounds(217, 428, 52, 37);
		clearEntery.setBounds(111, 276, 52, 37);
		clear.setBounds(164, 276, 52, 37);
		modulous.setBounds(58, 276, 52, 37);
		backspace.setBounds(217, 276, 52, 37);
		divide.setBounds(270, 276, 52, 37);
		multiply.setBounds(270, 314, 52, 37);
		subtract.setBounds(270, 352, 52, 37);
		addition.setBounds(270, 390, 52, 37);
		equals.setBounds(270, 428, 52, 37);

		upButton.setBounds(5, 276, 52, 37);
		lshButton.setBounds(5, 238, 52, 37);
		rshButton.setBounds(58, 238, 52, 37);
		orButton.setBounds(111, 238, 52, 37);
		xorButton.setBounds(164, 238, 52, 37);
		notButton.setBounds(217, 238, 52, 37);
		andButton.setBounds(270, 238, 52, 37);

		keyPad1.setBounds(5, 219, 52, 18);
		keyPad2.setBounds(58, 219, 52, 18);
		memorySvae.setBounds(217, 219, 52, 18);
		memory.setBounds(270, 219, 52, 18);
		numSize.setBounds(121, 219, 83, 18);

		// adds all the UI features
		calcFace.add(calcTag);
		calcFace.add(menuLines);
		calcFace.add(numField);
		calcFace.add(savedField);
		calcFace.add(hexSelected);
		calcFace.add(decSelected);
		calcFace.add(octSelected);
		calcFace.add(binSelected);
		calcFace.add(hexField);
		calcFace.add(decField);
		calcFace.add(octField);
		calcFace.add(binField);
		calcFace.add(num9);
		calcFace.add(num8);
		calcFace.add(num7);
		calcFace.add(num6);
		calcFace.add(num5);
		calcFace.add(num4);
		calcFace.add(num3);
		calcFace.add(num2);
		calcFace.add(num1);
		calcFace.add(num0);
		calcFace.add(numA);
		calcFace.add(numB);
		calcFace.add(numC);
		calcFace.add(numD);
		calcFace.add(numE);
		calcFace.add(numF);
		calcFace.add(leftPhr);
		calcFace.add(rightPhr);
		calcFace.add(flipSign);
		calcFace.add(decimal);
		calcFace.add(clearEntery);
		calcFace.add(clear);
		calcFace.add(modulous);
		calcFace.add(backspace);
		calcFace.add(divide);
		calcFace.add(multiply);
		calcFace.add(subtract);
		calcFace.add(addition);
		calcFace.add(equals);
		calcFace.add(upButton);
		calcFace.add(lshButton);
		calcFace.add(rshButton);
		calcFace.add(orButton);
		calcFace.add(xorButton);
		calcFace.add(notButton);
		calcFace.add(andButton);
		calcFace.add(keyPad1);
		calcFace.add(keyPad2);
		calcFace.add(memorySvae);
		calcFace.add(memory);
		calcFace.add(numSize);

		// adds listeners to buttons that need it
		num0.addActionListener(this);
		num1.addActionListener(this);
		num2.addActionListener(this);
		num3.addActionListener(this);
		num4.addActionListener(this);
		num5.addActionListener(this);
		num6.addActionListener(this);
		num7.addActionListener(this);
		num8.addActionListener(this);
		num9.addActionListener(this);

		numA.addActionListener(this);
		numB.addActionListener(this);
		numC.addActionListener(this);
		numD.addActionListener(this);
		numE.addActionListener(this);
		numF.addActionListener(this);

		clearEntery.addActionListener(this);
		clear.addActionListener(this);
		backspace.addActionListener(this);

		flipSign.addActionListener(this);

		decField.addActionListener(this);
		octField.addActionListener(this);
		hexField.addActionListener(this);
		binField.addActionListener(this);

		numSize.addActionListener(this);

		modulous.addActionListener(this);
		divide.addActionListener(this);
		multiply.addActionListener(this);
		subtract.addActionListener(this);
		addition.addActionListener(this);

		leftPhr.addActionListener(this);
		rightPhr.addActionListener(this);
		equals.addActionListener(this);
	}

	// initialize variables needed for the buttons
	boolean numPressed = false;
	boolean zeroPressed = true;
	boolean isHex = false;
	boolean isDec = true;
	boolean isOct = false;
	boolean isBin = false;
	static int counter = 0;
	int wordType = QWORD;
	ArrayList<String> savedNums = new ArrayList<String>();
	int numOpen = 0;
	int wasNum = 10;
	
	// buttons that display a text on screen
	private void zeroButton(ActionEvent evt) {

		if (!numPressed)
			numField.setText("");
		zeroPressed = true;
		numField.setText(numField.getText() + "0");
	}

	private void oneButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "1");
	}

	private void twoButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "2");
	}

	private void threeButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "3");
	}

	private void fourButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "4");
	}

	private void fiveButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "5");
	}

	private void sixButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "6");
	}

	private void sevenButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "7");
	}

	private void eightButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "8");
	}

	private void nineButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "9");
	}

	private void aButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "A");
	}

	private void bButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "B");
	}

	private void cButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "C");
	}

	private void dButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "D");
	}

	private void eButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "E");
	}

	private void fButton(ActionEvent evt) {
		if (!numPressed)
			numField.setText("");
		numPressed = true;
		numField.setText(numField.getText() + "F");
	}
	// buttons that clear the text
	private void clearButton(ActionEvent evt) {
		numField.setText("0");
		savedNums.clear();
		savedField.setText("");
		numPressed = false;
		zeroPressed = true;
	}

	private void clearEnteryButton(ActionEvent evt) {
		numField.setText("0");
		savedField.setText("");
		numPressed = false;
		zeroPressed = true;
	}

	private void backspaceButton(ActionEvent evt) {
		try {
			numField.setText(numField.getText(0, numField.getText().length() - 1));
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (numField.getText().isEmpty() || (numField.getText().length() == 1 && negative)) {
			numField.setText("0");
			numPressed = false;
			negative = false;
			zeroPressed = true;
		}
	}
	// shows whether current value is negative
	boolean negative = false;

	// flips the sign of the number between positive and negative
	private void flipSignButton(ActionEvent evt) {
		if (numPressed && isDec) {
			if (negative) {
				numField.setText(numField.getText().substring(1));
				negative = false;
			} else {
				numField.setText("-" + numField.getText());
				negative = true;
			}
		} else if (numPressed && isHex) {
			String decVal = Long.toString(Long.parseUnsignedLong(numField.getText(), 16));
			if (negative) {
				decVal = decVal.substring(1);
				negative = false;
			} else {
				decVal = "-" + decVal;
				negative = true;
			}
			numField.setText(Long.toHexString(Long.parseLong(decVal)).toUpperCase());
		} else if (numPressed && isOct) {
			String decVal = Long.toString(Long.parseUnsignedLong(numField.getText(), 8));
			if (negative) {
				decVal = decVal.substring(1);
				negative = false;
			} else {
				decVal = "-" + decVal;
				negative = true;
			}
			numField.setText(Long.toOctalString(Long.parseLong(decVal)));
		} else if (numPressed && isBin) {
			String decVal = Long.toString(Long.parseUnsignedLong(numField.getText(), 2));
			if (negative) {
				decVal = decVal.substring(1);
				negative = false;
			} else {
				decVal = "-" + decVal;
				negative = true;
			}
			numField.setText(Long.toBinaryString(Long.parseLong(decVal)));
		}
	}

	// buttons that change the number base of the calculator
	private void hexButton(ActionEvent evt) {
		if (isHex)
			return;
		hexSelected.setBackground(Color.BLUE);
		decSelected.setBackground(SystemColor.control);
		octSelected.setBackground(SystemColor.control);
		binSelected.setBackground(SystemColor.control);
		isHex = true;
		isDec = false;
		isOct = false;
		isBin = false;
		num2.setEnabled(true);
		num3.setEnabled(true);
		num4.setEnabled(true);
		num5.setEnabled(true);
		num6.setEnabled(true);
		num7.setEnabled(true);
		num8.setEnabled(true);
		num9.setEnabled(true);
		numA.setEnabled(true);
		numB.setEnabled(true);
		numC.setEnabled(true);
		numD.setEnabled(true);
		numE.setEnabled(true);
		numF.setEnabled(true);
		numPressed = false;
		numField.setText(hexField.getText().substring(6));
	}

	private void decButton(ActionEvent evt) {
		if (isDec)
			return;
		decSelected.setBackground(Color.BLUE);
		hexSelected.setBackground(SystemColor.control);
		octSelected.setBackground(SystemColor.control);
		binSelected.setBackground(SystemColor.control);
		isHex = false;
		isDec = true;
		isOct = false;
		isBin = false;
		num2.setEnabled(true);
		num3.setEnabled(true);
		num4.setEnabled(true);
		num5.setEnabled(true);
		num6.setEnabled(true);
		num7.setEnabled(true);
		num8.setEnabled(true);
		num9.setEnabled(true);
		numA.setEnabled(false);
		numB.setEnabled(false);
		numC.setEnabled(false);
		numD.setEnabled(false);
		numE.setEnabled(false);
		numF.setEnabled(false);
		numPressed = false;
		numField.setText(decField.getText().substring(6));
	}

	private void octButton(ActionEvent evt) {
		if (isOct)
			return;
		octSelected.setBackground(Color.BLUE);
		decSelected.setBackground(SystemColor.control);
		hexSelected.setBackground(SystemColor.control);
		binSelected.setBackground(SystemColor.control);
		isHex = false;
		isDec = false;
		isOct = true;
		isBin = false;
		num2.setEnabled(true);
		num3.setEnabled(true);
		num4.setEnabled(true);
		num5.setEnabled(true);
		num6.setEnabled(true);
		num7.setEnabled(true);
		num8.setEnabled(false);
		num9.setEnabled(false);
		numA.setEnabled(false);
		numB.setEnabled(false);
		numC.setEnabled(false);
		numD.setEnabled(false);
		numE.setEnabled(false);
		numF.setEnabled(false);
		numPressed = false;
		numField.setText(octField.getText().substring(6));
	}

	private void binButton(ActionEvent evt) {
		if (isBin)
			return;
		binSelected.setBackground(Color.BLUE);
		decSelected.setBackground(SystemColor.control);
		octSelected.setBackground(SystemColor.control);
		hexSelected.setBackground(SystemColor.control);
		isHex = false;
		isDec = false;
		isOct = false;
		isBin = true;
		num2.setEnabled(false);
		num3.setEnabled(false);
		num4.setEnabled(false);
		num5.setEnabled(false);
		num6.setEnabled(false);
		num7.setEnabled(false);
		num8.setEnabled(false);
		num9.setEnabled(false);
		numA.setEnabled(false);
		numB.setEnabled(false);
		numC.setEnabled(false);
		numD.setEnabled(false);
		numE.setEnabled(false);
		numF.setEnabled(false);
		numPressed = false;
		numField.setText(binField.getText().substring(6));
	}
	// tracks the current word type the calculator is on
	int count = 1;
	// changes the size type of the calculator
	private void wordButton(ActionEvent evt) {

		if (count < 5) {
			boolean loopagain = false;
			do {
				loopagain = false;
				switch (count) {
				case 0:
					numSize.setText("QWORD");
					wordType = QWORD;
					count++;
					break;
				case 1:
					numSize.setText("DWORD");
					wordType = DWORD;
					count++;
					break;
				case 2:
					numSize.setText("WORD");
					wordType = WORD;
					count++;
					break;
				case 3:
					numSize.setText("BYTE");
					wordType = BYTE;
					count++;
					break;
				default:
					count = 0;
					loopagain = true;
				}
			} while (loopagain);
		}
	}

	// these buttons prints the operation and puts numbers into a stack
	private void additionButton(ActionEvent evt) {
		if (!(numPressed || zeroPressed) && savedNums.size() > 1) {
			savedNums.remove(savedNums.size() - 1);
			savedNums.add(addition.getText());
			return;
		}
		if (!(savedNums.size() > 1 && savedNums.get(savedNums.size() - 1) == rightPhr.getText()))
			savedNums.add(numField.getText());
		savedNums.add(addition.getText());
		numPressed = false;
		zeroPressed = false;
		negative = false;
	}

	private void subButton(ActionEvent evt) {
		if (!(numPressed || zeroPressed)) {
			savedNums.remove(savedNums.size() - 1);
			savedNums.add(subtract.getText());
			return;
		}
		if (!(savedNums.size() > 1 && savedNums.get(savedNums.size() - 1) == rightPhr.getText()))
			savedNums.add(numField.getText());
		savedNums.add(subtract.getText());
		numPressed = false;
		zeroPressed = false;
		negative = false;
	}

	private void multButton(ActionEvent evt) {
		if (!(numPressed || zeroPressed)) {
			savedNums.remove(savedNums.size() - 1);
			savedNums.add(multiply.getText());
			return;
		}
		if (!(savedNums.size() > 1 && savedNums.get(savedNums.size() - 1) == rightPhr.getText()))
			savedNums.add(numField.getText());
		savedNums.add(multiply.getText());
		numPressed = false;
		zeroPressed = false;
		negative = false;
	}

	private void divButton(ActionEvent evt) {
		if (!(numPressed || zeroPressed)) {
			savedNums.remove(savedNums.size() - 1);
			savedNums.add(divide.getText());
			return;
		}
		if (!(savedNums.size() > 1 && savedNums.get(savedNums.size() - 1) == rightPhr.getText()))
			savedNums.add(numField.getText());
		savedNums.add(divide.getText());
		numPressed = false;
		zeroPressed = false;
		negative = false;
	}

	private void modButton(ActionEvent evt) {
		if (!(numPressed || zeroPressed)) {
			savedNums.remove(savedNums.size() - 1);
			savedNums.add(modulous.getText());
			return;
		}
		if (!(savedNums.size() > 1 && savedNums.get(savedNums.size() - 1) == rightPhr.getText()))
			savedNums.add(numField.getText());
		savedNums.add(modulous.getText());
		numPressed = false;
		zeroPressed = false;
		negative = false;
	}
	
	// these handle the phr by tracking the amount of open phr using the numOpen variable
	private void openPhrButton(ActionEvent evt) {
		if (numOpen > 25)
			return;
		if (savedNums.size() > 1 && savedNums.get(savedNums.size() - 1) == rightPhr.getText())
			savedNums.add(multiply.getText());
		savedNums.add(leftPhr.getText());
		numOpen++;
		numPressed = false;
		zeroPressed = true;
	}

	private void closePhrButton(ActionEvent evt) {
		if (numOpen == 0)
			return;
		if (savedNums.get(savedNums.size() - 1) == rightPhr.getText()) {
			savedNums.add(rightPhr.getText());
			numOpen--;
			return;
		}
		savedNums.add(numField.getText());

		savedNums.add(rightPhr.getText());
		numOpen--;
		numPressed = false;
		zeroPressed = true;
	}
	
	
	// This button gives the answer to the calculation
	private void equalsButton(ActionEvent evt) {
		String temp = "";
		savedNums.add(numField.getText());
		while (numOpen > 0)
			closePhr();


		if (wasNum == 16) {
			for (int i = 0; i < savedNums.size(); i++) {
				if (Character.isDigit(savedNums.get(i).charAt(0)) || Character.isLetter(savedNums.get(i).charAt(0))){
					savedNums.set(i, Long.toString(Long.parseUnsignedLong(savedNums.get(i), 16)));
				}
			}
		}
		if (wasNum == 8) {
			for (int i = 0; i < savedNums.size(); i++) {
				if (Character.isDigit(savedNums.get(i).charAt(0))){
					savedNums.set(i, Long.toString(Long.parseUnsignedLong(savedNums.get(i), 8)));
				}
			}
		}
		if (wasNum == 2) {
			for (int i = 0; i < savedNums.size(); i++) {
				if (Character.isDigit(savedNums.get(i).charAt(0))){
					savedNums.set(i, Long.toString(Long.parseUnsignedLong(savedNums.get(i), 2)));
				}
			}
		}
		
		for (int i = 0; i < savedNums.size(); i++)
			temp += savedNums.get(i);
		savedField.setText(temp);
		String ans = Long.toString(EvaluateExpression.evaluateExpression(savedField.getText()));
		
		if (wasNum == 16) {
			ans = Long.toHexString(Long.parseLong(ans)).toUpperCase();
		}
		if (wasNum == 8) {
			ans = Long.toOctalString(Long.parseLong(ans));
		}
		if (wasNum == 2) {
			ans = Long.toBinaryString(Long.parseLong(ans));
		}
		
		numField.setText(ans);
		savedNums.clear();
	}
	
	// This is a special close phr for the equals method that only prints closed phr
	private void closePhr() {
		savedNums.add(rightPhr.getText());
		numOpen--;
		numPressed = false;
		zeroPressed = true;
	}
	
	// handles all the actions performed
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == num0)
			zeroButton(e);
		if (e.getSource() == num1)
			oneButton(e);
		if (e.getSource() == num2)
			twoButton(e);
		if (e.getSource() == num3)
			threeButton(e);
		if (e.getSource() == num4)
			fourButton(e);
		if (e.getSource() == num5)
			fiveButton(e);
		if (e.getSource() == num6)
			sixButton(e);
		if (e.getSource() == num7)
			sevenButton(e);
		if (e.getSource() == num8)
			eightButton(e);
		if (e.getSource() == num9)
			nineButton(e);
		if (e.getSource() == numA)
			aButton(e);
		if (e.getSource() == numB)
			bButton(e);
		if (e.getSource() == numC)
			cButton(e);
		if (e.getSource() == numD)
			dButton(e);
		if (e.getSource() == numE)
			eButton(e);
		if (e.getSource() == numF)
			fButton(e);
		if (isHex && numField.getText().length() > 16 && wordType == QWORD)
			backspaceButton(e);
		if (isDec && numField.getText().length() > 18 && wordType == QWORD)
			backspaceButton(e);
		if (isOct && numField.getText().length() > 21 && wordType == QWORD)
			backspaceButton(e);
		if (isBin && numField.getText().length() > 64 && wordType == QWORD)
			backspaceButton(e);

		if (isHex && numField.getText().length() > 8 && wordType == DWORD)
			backspaceButton(e);
		if (isDec && numField.getText().length() > 9 && wordType == DWORD)
			backspaceButton(e);
		if (isOct && numField.getText().length() > 11 && wordType == DWORD)
			backspaceButton(e);
		if (isBin && numField.getText().length() > 32 && wordType == DWORD)
			backspaceButton(e);

		if (isHex && numField.getText().length() > 4 && wordType == WORD)
			backspaceButton(e);
		if (isDec && numField.getText().length() > 4 && wordType == WORD)
			backspaceButton(e);
		if (isOct && numField.getText().length() > 6 && wordType == WORD)
			backspaceButton(e);
		if (isBin && numField.getText().length() > 16 && wordType == WORD)
			backspaceButton(e);

		if (isHex && numField.getText().length() > 2 && wordType == BYTE)
			backspaceButton(e);
		if (isDec && numField.getText().length() > 2 && wordType == BYTE)
			backspaceButton(e);
		if (isOct && numField.getText().length() > 3 && wordType == BYTE)
			backspaceButton(e);
		if (isBin && numField.getText().length() > 8 && wordType == BYTE)
			backspaceButton(e);

		if (e.getSource() == clearEntery)
			clearEnteryButton(e);
		if (e.getSource() == clear)
			clearButton(e);
		if (e.getSource() == backspace)
			backspaceButton(e);
		if (e.getSource() == flipSign)
			flipSignButton(e);
		if (e.getSource() == decField)
			decButton(e);
		if (e.getSource() == hexField)
			hexButton(e);
		if (e.getSource() == octField)
			octButton(e);
		if (e.getSource() == binField)
			binButton(e);
		if (e.getSource() == numSize)
			wordButton(e);

		if (e.getSource() == addition)
			additionButton(e);
		if (e.getSource() == subtract)
			subButton(e);
		if (e.getSource() == multiply)
			multButton(e);
		if (e.getSource() == divide)
			divButton(e);
		if (e.getSource() == modulous)
			modButton(e);
		if (e.getSource() == leftPhr)
			openPhrButton(e);
		if (e.getSource() == rightPhr)
			closePhrButton(e);
		if (e.getSource() == equals)
			equalsButton(e);

		// handles the different number bases for the different fields
		if (isDec) {
			decField.setText(DEC + "   " + numField.getText());

			String hexVal = Long.toHexString(Long.parseLong(numField.getText())).toUpperCase();
			hexField.setText(HEX + "   " + hexVal);
			String octVal = Long.toOctalString(Long.parseLong(numField.getText()));
			octField.setText(OCT + "   " + octVal);
			String binVal = Long.toBinaryString(Long.parseLong(numField.getText()));
			binField.setText(BIN + "   " + binVal);
			
			if (wasNum == 16) {
				for (int i = 0; i < savedNums.size(); i++) {
					if (Character.isDigit(savedNums.get(i).charAt(0)) || Character.isLetter(savedNums.get(i).charAt(0))){
						savedNums.set(i, Long.toString(Long.parseUnsignedLong(savedNums.get(i), 16)));
					}
				}
			}
			if (wasNum == 8) {
				for (int i = 0; i < savedNums.size(); i++) {
					if (Character.isDigit(savedNums.get(i).charAt(0))){
						savedNums.set(i, Long.toString(Long.parseUnsignedLong(savedNums.get(i), 8)));
					}
				}
			}
			if (wasNum == 2) {
				for (int i = 0; i < savedNums.size(); i++) {
					if (Character.isDigit(savedNums.get(i).charAt(0))){
						savedNums.set(i, Long.toString(Long.parseUnsignedLong(savedNums.get(i), 2)));
					}
				}
			}
			
			
			
			
			wasNum = 10;
		}
		if (isHex) {
			hexField.setText(HEX + "   " + numField.getText());

			String decVal = Long.toString(Long.parseUnsignedLong(numField.getText(), 16));
			decField.setText(DEC + "   " + decVal);
			String octVal = Long.toOctalString(Long.parseUnsignedLong(numField.getText(), 16));
			octField.setText(OCT + "   " + octVal);
			String binVal = Long.toBinaryString(Long.parseUnsignedLong(numField.getText(), 16));
			binField.setText(BIN + "   " + binVal);
			
			if (wasNum == 10) {
				for (int i = 0; i < savedNums.size(); i++) {
					if (Character.isDigit(savedNums.get(i).charAt(0)) || savedNums.get(i).charAt(0) == '-'){
						savedNums.set(i, Long.toHexString(Long.parseLong(savedNums.get(i))).toUpperCase());
					}
				}
			}
			if (wasNum == 8) {
				for (int i = 0; i < savedNums.size(); i++) {
					if (Character.isDigit(savedNums.get(i).charAt(0))){
						savedNums.set(i, Long.toHexString(Long.parseUnsignedLong(savedNums.get(i), 8)).toUpperCase());
					}
				}
			}
			if (wasNum == 2) {
				for (int i = 0; i < savedNums.size(); i++) {
					if (Character.isDigit(savedNums.get(i).charAt(0))){
						savedNums.set(i, Long.toHexString(Long.parseUnsignedLong(savedNums.get(i), 2)).toUpperCase());
					}
				}
			}
			
			
			wasNum = 16;
		}
		if (isOct) {
			octField.setText(OCT + "   " + numField.getText());

			String hexVal = Long.toHexString(Long.parseUnsignedLong(numField.getText(), 8)).toUpperCase();
			hexField.setText(HEX + "   " + hexVal);
			String decVal = Long.toString(Long.parseUnsignedLong(numField.getText(), 8));
			decField.setText(DEC + "   " + decVal);
			String binVal = Long.toBinaryString(Long.parseUnsignedLong(numField.getText(), 8));
			binField.setText(BIN + "   " + binVal);
			
			if (wasNum == 16) {
				for (int i = 0; i < savedNums.size(); i++) {
					if (Character.isDigit(savedNums.get(i).charAt(0)) || Character.isLetter(savedNums.get(i).charAt(0))){
						savedNums.set(i, Long.toOctalString(Long.parseUnsignedLong(savedNums.get(i), 16)));
					}
				}
			}
			if (wasNum == 10) {
				for (int i = 0; i < savedNums.size(); i++) {
					if (Character.isDigit(savedNums.get(i).charAt(0)) || savedNums.get(i).charAt(0) == '-'){
						savedNums.set(i, Long.toOctalString(Long.parseLong(savedNums.get(i))));
					}
				}
			}
			if (wasNum == 2) {
				for (int i = 0; i < savedNums.size(); i++) {
					if (Character.isDigit(savedNums.get(i).charAt(0))){
						savedNums.set(i, Long.toOctalString(Long.parseUnsignedLong(savedNums.get(i), 2)));
					}
				}
			}
			
			wasNum = 8;
		}
		if (isBin) {
			binField.setText(BIN + "   " + numField.getText());

			String hexVal = Long.toHexString(Long.parseUnsignedLong(numField.getText(), 2)).toUpperCase();
			hexField.setText(HEX + "   " + hexVal);
			String octVal = Long.toOctalString(Long.parseUnsignedLong(numField.getText(), 2));
			octField.setText(OCT + "   " + octVal);
			String decVal = Long.toString(Long.parseUnsignedLong(numField.getText(), 2));
			decField.setText(DEC + "   " + decVal);
			
			if (wasNum == 16) {
				for (int i = 0; i < savedNums.size(); i++) {
					if (Character.isDigit(savedNums.get(i).charAt(0)) || Character.isLetter(savedNums.get(i).charAt(0))){
						savedNums.set(i, Long.toBinaryString(Long.parseUnsignedLong(savedNums.get(i), 16)));
					}
				}
			}
			if (wasNum == 8) {
				for (int i = 0; i < savedNums.size(); i++) {
					if (Character.isDigit(savedNums.get(i).charAt(0))){
						savedNums.set(i, Long.toBinaryString(Long.parseUnsignedLong(savedNums.get(i), 8)));
					}
				}
			}
			if (wasNum == 10) {
				for (int i = 0; i < savedNums.size(); i++) {
					if (Character.isDigit(savedNums.get(i).charAt(0)) || savedNums.get(i).charAt(0) == '-'){
						savedNums.set(i, Long.toBinaryString(Long.parseLong(savedNums.get(i))));
					}
				}
			}
			wasNum = 2;
		}
		
		
		
		
		// turns what is stored in the stack to a string that is shown in a field
		String temp = "";
		for (int i = 0; i < savedNums.size(); i++)
			temp += savedNums.get(i);
		savedField.setText(temp);
	}

	// gets the calculator panel
	public JPanel getPanel() {
		return calcFace;
	}

	public static void main(String[] args) {
		// initializes and adds the calculator frame to users desktop
		Calculator calc = new Calculator();
		JFrame calcFrame = new JFrame();
		
		calcFrame.setTitle("Calculator");
		calcFrame.setBounds(100, 100, 332, 504);
		calcFrame.setBackground(SystemColor.menu);
		calcFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		calcFrame.setResizable(false);
		calcFrame.setVisible(true);
		calcFrame.setContentPane(calc.getPanel());
		calcFrame.add(calc);

	}

}

class EvaluateExpression {

	  /** Evaluate an expression */
	  public static int evaluateExpression(String expression) {
	    // Create operandStack to store operands
	    Stack<Integer> operandStack = new Stack<>();
	  
	    // Create operatorStack to store operators
	    Stack<Character> operatorStack = new Stack<>();
	    // turns Mod into char form
	    expression = expression.replaceAll("Mod", "%");
	    // Insert blanks around (, ), +, -, /, and *
	    expression = insertBlanks(expression);

	    // Extract operands and operators
	    String[] tokens = expression.split(" ");

	    // Phase 1: Scan tokens
	    for (String token: tokens) {
	      if (token.length() == 0) // Blank space
	        continue; // Back to the while loop to extract the next token
	      else if (token.charAt(0) == '+' || token.charAt(0) == '−') {
	        // Process all +, -, *, / in the top of the operator stack 
	        while (!operatorStack.isEmpty() &&
	          (operatorStack.peek() == '+' || 
	           operatorStack.peek() == '−' ||
	           operatorStack.peek() == '×' ||
	           operatorStack.peek() == '÷')) {
	          processAnOperator(operandStack, operatorStack);
	        }

	        // Push the + or - operator into the operator stack
	        operatorStack.push(token.charAt(0));
	      }
	      else if (token.charAt(0) == '×' || token.charAt(0) == '÷' || token.charAt(0) == '%') {
	        // Process all *, / in the top of the operator stack 
	        while (!operatorStack.isEmpty() &&
	          (operatorStack.peek() == '×' ||
	          operatorStack.peek() == '÷' ||
	          operatorStack.peek() == '%')) {
	          processAnOperator(operandStack, operatorStack);
	        }

	        // Push the * or / operator into the operator stack
	        operatorStack.push(token.charAt(0));
	      }
	      else if (token.trim().charAt(0) == '(') {
	        operatorStack.push('('); // Push '(' to stack
	      }
	      else if (token.trim().charAt(0) == ')') {
	        // Process all the operators in the stack until seeing '('
	        while (operatorStack.peek() != '(') {
	          processAnOperator(operandStack, operatorStack);
	        }
	        
	        operatorStack.pop(); // Pop the '(' symbol from the stack
	      }
	      else { // An operand scanned
	        // Push an operand to the stack
	        operandStack.push(new Integer(token));
	      }
	    }

	    // Phase 2: process all the remaining operators in the stack 
	    while (!operatorStack.isEmpty()) {
	      processAnOperator(operandStack, operatorStack);
	    }

	    // Return the result
	    return operandStack.pop();
	  }

	  /** Process one operator: Take an operator from operatorStack and
	   *  apply it on the operands in the operandStack */
	  public static void processAnOperator(
	      Stack<Integer> operandStack, Stack<Character> operatorStack) {
	    char op = operatorStack.pop();
	    int op1 = operandStack.pop();
	    int op2 = operandStack.pop();
	    if (op == '+') 
	      operandStack.push(op2 + op1);
	    else if (op == '−') 
	      operandStack.push(op2 - op1);
	    else if (op == '×') 
	      operandStack.push(op2 * op1);
	    else if (op == '÷') 
	      operandStack.push(op2 / op1);
	    else if (op == '%')
	    	operandStack.push(op2 % op1);
	  }
	  
	  public static String insertBlanks(String s) {
	    String result = "";
	    
	    for (int i = 0; i < s.length(); i++) {
	      if (s.charAt(i) == '(' || s.charAt(i) == ')' || 
	          s.charAt(i) == '+' || s.charAt(i) == '−' ||
	          s.charAt(i) == '×' || s.charAt(i) == '÷' ||
	          s.charAt(i) == '%')
	        result += " " + s.charAt(i) + " ";
	      else
	        result += s.charAt(i);
	    }
	    
	    return result;
	  }
	}

