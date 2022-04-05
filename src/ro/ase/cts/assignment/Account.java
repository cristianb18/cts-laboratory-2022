package ro.ase.cts.assignment;

import ro.ase.cts.assignment.exceptions.ValueException;

public class Account {
	private double	loan_value,rate;	
	private int	daysActive,account_Type;
	private static final int STANDARD=0,BUDGET=1,PREMIUM=2,SUPER_PREMIUM=3;
	
	public double getLoan() {
		return loan_value;
	}
	
	public double getRate() {
		return this.rate;
	}
	
	public double getMonthlyRate() {
		return loan_value*rate;
	}
	
	public void setValue(double value) throws Exception {
		if(value<0)
			throw new ValueException("Value is too small");
		else
		{
			loan_value = value;
		}
	}
	
	public void printLoan() {
		System.out.println("The loan value is " + this.loan_value);
	}
	
	public void printRate() {
		System.out.println("The rate is "+rate);	
	}
	
	@Override
	public String toString() {
		return "Loan: "+this.loan_value+"; rate: "+this.rate+"; days active:"+daysActive+"; Type: "+account_Type+";";
	}
	
	public void print() {
		System.out.println("This is an account");
	}

	public static double calculate(Account[] accounts)
	{
		double totalFee=0.0;
		Account	account;
		for	(int i=0;i<accounts.length;i++)	{
				account=accounts[i];
				if(account.account_Type==Account.PREMIUM||account.account_Type==Account.SUPER_PREMIUM)	
					totalFee+=.0125	* (account.loan_value*Math.pow(account.rate,(account.daysActive/365)) - account.loan_value);
		}
		return	totalFee;
	}

	public Account(double value, double rate, int account_Type) throws Exception {
		setValue(value);
		this.rate = rate;
		this.account_Type = account_Type;
	}
	
	
}
