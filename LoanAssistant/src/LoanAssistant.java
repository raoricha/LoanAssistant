
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class LoanAssistant extends JFrame {

	JLabel loanBal = new JLabel();
	JTextField loanBalText = new JTextField();
	JLabel interestRate = new JLabel();
	JTextField interestRateText = new JTextField();
	JLabel noOfPay = new JLabel();
	JTextField noOfPayText = new JTextField();
	JLabel monthlyPay = new JLabel();
	JTextField monthlyPayText = new JTextField();
	JButton paymentBtn = new JButton();
	JButton monthsBtn = new JButton();
	JButton computePay = new JButton();
	JButton newLoan = new JButton();
	JLabel loanAnal = new JLabel();
	JTextArea loanAnalText = new JTextArea();
	JButton exitBtn = new JButton();
	
	Font myFont = new Font("Arial",Font.PLAIN,16);
	boolean compute = true;
	
	
	public LoanAssistant() {
		setTitle("Loan Assistant");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitForm(evt);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc;
		loanBal.setText("Loan Balance");
		loanBal.setFont(myFont);
		gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10 ,10 ,0 ,0);
		getContentPane().add(loanBal,gbc);
		loanBalText.setPreferredSize(new Dimension(100,25));
		loanBalText.setHorizontalAlignment(SwingConstants.RIGHT);
		loanBalText.setFont(myFont);
		gbc = new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.insets = new Insets(10 ,10 ,0 ,10);
		getContentPane().add(loanBalText,gbc);
		loanBalText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loanBalTextActionPerformed(e);
			}
		});
		
		interestRate.setText("Interest Rate");
		interestRate.setFont(myFont);
		gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10 ,10 ,0 ,0);
		getContentPane().add(interestRate,gbc);
		interestRateText.setPreferredSize(new Dimension(100,25));
		interestRateText.setHorizontalAlignment(SwingConstants.RIGHT);
		interestRateText.setFont(myFont);
		loanBalText.setFont(myFont);
		gbc = new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.insets = new Insets(10,10,0,10);
		getContentPane().add(interestRateText,gbc);
		interestRateText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interestRateActionPerformed(e);
			}
		});
		
		noOfPay.setText("Number Of Payments");
		noOfPay.setFont(myFont);
		gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10,10,0,0);
		getContentPane().add(noOfPay,gbc);
		noOfPayText.setPreferredSize(new Dimension(100,25));
		noOfPayText.setHorizontalAlignment(SwingConstants.RIGHT);
		noOfPayText.setFont(myFont);
		gbc = new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.insets = new Insets(10,10,0,10);
		getContentPane().add(noOfPayText,gbc);
		noOfPayText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noOfPayActionPerformed(e);
			}
		});
		
		monthlyPay.setText("Monthly Payment");
		monthlyPay.setFont(myFont);
		gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10,10,0,0);
		getContentPane().add(monthlyPay,gbc);
		monthlyPayText.setPreferredSize(new Dimension(100,25));
		monthlyPayText.setHorizontalAlignment(SwingConstants.RIGHT);
		monthlyPayText.setFont(myFont);
		gbc = new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=3;
		gbc.insets = new Insets(10,10,0,10);
		getContentPane().add(monthlyPayText,gbc);
		monthlyPayText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monthlyPayActionPerformed(e);
			}
		});
		
		
		computePay.setText("Compute Monthly Payment");
		gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.gridwidth=2;
		gbc.insets = new Insets(10,0,0,0);
		getContentPane().add(computePay,gbc);
		computePay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				computePayActionPerformed(e);
			}
		});
		
		newLoan.setText("New Loan Analysis");
		newLoan.setEnabled(false);
		gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=5;
		gbc.gridwidth=2;
		gbc.insets = new Insets(10,10,10,0);
		getContentPane().add(newLoan,gbc);
		newLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newLoanActionPerformed(e);
			}
		});
		
		paymentBtn.setText("X");
		paymentBtn.setFocusable(false);
		gbc = new GridBagConstraints();
		gbc.gridx=2;
		gbc.gridy=2;
		gbc.insets = new Insets(10,0,0,0);
		getContentPane().add(paymentBtn,gbc);
		paymentBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				paymentBtnActionPerformed(e);
			}
		});
		
		monthsBtn.setText("X");
		monthsBtn.setFocusable(false);
		gbc = new GridBagConstraints();
		gbc.gridx=2;
		gbc.gridy=3;
		gbc.insets = new Insets(10,0,0,0); 
		getContentPane().add(monthsBtn,gbc);
		monthsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monthsBtnActionPerformed(e);
			}
		});
		
		loanAnal.setText("Loan Analysis:");
		loanAnal.setFont(myFont);
		gbc = new GridBagConstraints();
		gbc.gridx=3;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.WEST;
		gbc.insets = new Insets(0,10,0,0);
		getContentPane().add(loanAnal,gbc);
		
		loanAnalText.setPreferredSize(new Dimension(250,150));
		loanAnalText.setFont(new Font("Courier New", Font.PLAIN, 14));
		loanAnalText.setFocusable(false);
		loanAnalText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		gbc = new GridBagConstraints();
		gbc.gridx=3;
		gbc.gridy=1;
		gbc.gridheight=4;
		gbc.insets = new Insets(0,10,0,10);
		getContentPane().add(loanAnalText,gbc);
		
		exitBtn.setText("Exit");
		gbc = new GridBagConstraints();
		gbc.gridx=3;
		gbc.gridy=5;
		getContentPane().add(exitBtn,gbc);
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitBtnActionPerformed(e);
			}
		});
		
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)(0.5*(screenSize.width-getWidth())),(int)(0.5*(screenSize.height-getHeight())),
				getWidth(),getHeight());
		monthsBtn.doClick();

	}

	private void newLoanActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(compute) {
			monthlyPayText.setText("");
		}
		else {
			noOfPayText.setText("");
		}
		loanAnalText.setText("");
		computePay.setEnabled(true);
		newLoan.setEnabled(false);
		loanBalText.requestFocus();
	}

	private void exitForm(WindowEvent evt) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	
	private void exitBtnActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	
	private void computePayActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		double balance, interest, payment;
		int months;
		double monthlyInterest, multiplier;
		double loanBalance, finalPayment;
		if (validateInput(loanBalText))
		{
		balance =
		Double.valueOf(loanBalText.getText()).doubleValue();
		}
		else
		{
		JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct.", "Balance Input Error", JOptionPane.DEFAULT_OPTION,
		JOptionPane.INFORMATION_MESSAGE);
		return;
		}
		if (validateInput(interestRateText))
		{
		interest =
		Double.valueOf(interestRateText.getText()).doubleValue();
		}
		else
		{
		JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct.", "Interest Input Error", JOptionPane.DEFAULT_OPTION,
		JOptionPane.INFORMATION_MESSAGE);
		return;
		}
		monthlyInterest = interest / 1200;
		if (compute)
		{
		// Compute loan payment
		if (validateInput(noOfPayText))
		{
		months =
		Integer.valueOf(noOfPayText.getText()).intValue();
		}
		else
		{
		JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct.", "Number of Payments Input Error",
		JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
		return;
		}
		if (interest == 0)
		{
		payment = balance / months;
		}
		else
		{
		multiplier = Math.pow(1 + monthlyInterest, months);
		payment = balance * monthlyInterest * multiplier / (multiplier - 1);
		}
		monthlyPayText.setText(new DecimalFormat("0.00").format(payment));
		}
		else
		{
		// Compute number of payments
		if (validateInput(monthlyPayText))
		{
		payment =
		Double.valueOf(monthlyPayText.getText()).doubleValue();
		if (payment <= (balance * monthlyInterest + 1.0))
		{
		if (JOptionPane.showConfirmDialog(null, "Minimum payment must be $" +
		new DecimalFormat("0.00").format((int)(balance * monthlyInterest + 1.0)) + "\n" + "Do you want to use the minimum payment?", "Input Error", JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
		{
		monthlyPayText.setText(new DecimalFormat("0.00").format((int)(balance *
		monthlyInterest + 1.0)));
		payment =
		Double.valueOf(monthlyPayText.getText()).doubleValue();
		}
		else
		{
		monthlyPayText.requestFocus();
		return;
		}
		}
		}
		else
		{
		JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment entry.\nPlease correct.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
		JOptionPane.INFORMATION_MESSAGE);
		return;
		}
		if (interest == 0)
		{
		months = (int)(balance / payment);
		}
		else
		{
		months = (int)((Math.log(payment) - Math.log(payment - balance * monthlyInterest)) /
		Math.log(1 + monthlyInterest));
		}
		noOfPayText.setText(String.valueOf(months));
		}
		// reset payment prior to analysis to fix at two decimals
		payment = Double.valueOf(monthlyPayText.getText()).doubleValue();
		// show analysis
		loanAnalText.setText("Loan Balance: $" + new
		DecimalFormat("0.00").format(balance));
		loanAnalText.append("\n" + "Interest Rate: " + new
		DecimalFormat("0.00").format(interest) + "%");
		// process all but last payment
		loanBalance = balance;
		for (int paymentNumber = 1; paymentNumber <= months - 1; paymentNumber++)
		{
			loanBalance += loanBalance * monthlyInterest - payment;
		}
		// find final payment
		finalPayment = loanBalance;
		if (finalPayment > payment)
		{
		// apply one more payment
			loanBalance += loanBalance * monthlyInterest - payment;
			finalPayment = loanBalance;
			months++;
			noOfPayText.setText(String.valueOf(months));
		}
		loanAnalText.append("\n\n" + String.valueOf(months - 1) + " Payments of $" + new
		DecimalFormat("0.00").format(payment));
		loanAnalText.append("\n" + "Final Payment of: $" + new
		DecimalFormat("0.00").format(finalPayment));
		loanAnalText.append("\n" + "Total Payments: $" + new
		DecimalFormat("0.00").format((months - 1) * payment + finalPayment));
		loanAnalText.append("\n" + "Interest Paid $" + new 
				DecimalFormat("0.00").format((months - 1) * payment + finalPayment - balance));
		computePay.setEnabled(false);
		newLoan.setEnabled(true);
		newLoan.requestFocus();
	}
	
	private boolean validateInput(JTextField tf) {
		String s = tf.getText().trim();
		boolean hasDecimal = false;
		boolean isValid = true;
		if(s.length()==0) {
			isValid = false;
		}
		else {
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)>='0' && s.charAt(i)<='9') {
					continue;
				}
				else if(s.charAt(i)=='.'&& !hasDecimal) {
					hasDecimal = true;
				}
				else {
					isValid = false;
				}
			}
		}
		tf.setText(s);
		if(!isValid) {
			tf.requestFocus();
		}
		return isValid;
	}
	
	private void loanBalTextActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		loanBalText.transferFocus();
	}

	private void interestRateActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		interestRateText.transferFocus();
	}

	private void noOfPayActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		noOfPayText.transferFocus();
	}

	private void monthlyPayActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		monthlyPayText.transferFocus();
	}
	
	private void monthsBtnActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			compute = true;
			monthlyPayText.setBackground(new Color(255,255,118));
			monthlyPayText.setText("");
			monthsBtn.setVisible(false);
			monthlyPayText.setFocusable(false);
			monthlyPayText.setEditable(false);
			noOfPayText.setBackground(Color.WHITE);
			noOfPayText.setFocusable(true);
			noOfPayText.setEditable(true);
			paymentBtn.setVisible(true);
			computePay.setText("Compute Monthly Payment");
			loanBalText.requestFocus();
	}
	
	private void paymentBtnActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			compute = false;
			noOfPayText.setBackground(new Color(255,255,118));
			noOfPayText.setText("");
			noOfPayText.setFocusable(false);
			noOfPayText.setEditable(false);
			paymentBtn.setVisible(false);
			monthlyPayText.setBackground(Color.WHITE);
			monthlyPayText.setFocusable(true);
			monthlyPayText.setEditable(true);
			monthsBtn.setVisible(true);
			computePay.setText("Compute Number of Payments");
			loanBalText.requestFocus();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new LoanAssistant().setVisible(true);
	}

}
