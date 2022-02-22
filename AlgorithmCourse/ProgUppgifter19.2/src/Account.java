
//*******************************************************
// Account.java
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, charge a fee to, and print a summary of the account.
//*******************************************************
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Account implements Comparable<Object>
{
	private double balance;
	private String acctNum;

	// ----------------------------------------------
	// Constructor -- initializes balance, owner, and account number
	// ----------------------------------------------
	public Account(String number, double initBal)
	{
		balance = initBal;
		acctNum = number;
	}

	// ----------------------------------------------
	// Checks to see if balance is sufficient for withdrawal.
	// If so, decrements balance by amount; if not, prints message.
	// ----------------------------------------------
	public String withdraw(double amount)
	{
		String info = "Insufficient funds";
		if (balance >= amount)
		{
			balance = balance - amount;
			info = "Succeeded, the new balance is : " + balance;
		}

		return info;
	}

	// ----------------------------------------------
	// Adds deposit amount to balance.
	// ----------------------------------------------
	public String deposit(double amount)
	{
		String info = "";
		if (amount < 0)
			info = " Wrong amount";
		else
		{
			balance = balance + amount;
			info = " Succeeded, the new balance is: " + balance;
		}

		return info;
	}

	// ----------------------------------------------
	// Returns balance.
	// ----------------------------------------------
	public double getBalance()
	{
		return balance;
	}

	// ----------------------------------------------
	// Returns a string containing the name, account number, and balance.
	// ----------------------------------------------
	public String toString()
	{
		return " Numer: " + acctNum + " Balance: " + balance;
	}

	// ----------------------------------------------
	// Returns accoutn number.
	// ----------------------------------------------

	public String getAcctNum()
	{
		return acctNum;
	}

	public boolean equals(Object other)
	{
		if (acctNum.equals(other))
		{
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] arg)
	{

		MyArrayList<Account> mylist = new MyArrayList<Account>();
		
		
		mylist.add(new Account("1111111111", 1000));
		mylist.add(new Account("1111111112", 2000));
		mylist.add(new Account("1111111120", 5000));
		mylist.add(new Account("1111122193", 50));
		
		Iterator<Account> iterlist = mylist.iterator();
		
		while(iterlist.hasNext()) {
			System.out.println(iterlist.next().deposit((Math.random()*4001)+1000));
			
		}
		//Collections.sort(mylist);
		//The method sort(List<T>) in the type Collections is not applicable for the arguments (MyArrayList<Account>).
		

	}

	@Override
	public int compareTo(Object o)
	{
		if (balance == ((Account)o).getBalance())
		{
			return 0;
		}else if(balance < ((Account)o).getBalance())
		{
			return -1;
		}
		return 1;
	}
}