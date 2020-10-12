package com.hcl.day30;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.hcl.day29.MiniBank;

/**
 * Topic : Core Java
 * 
 * This class is used to create the Withdraw, deposit and fund transfer
 * 
 * @author Sathya
 *
 */
public class Account {
	private double balance;
	private int accountNumber;
	private int amount;

	/**
	 * This method is used to get the amount to be withdraw which gets collected
	 * from main method by synchronized it and then it calculates the balance
	 * 
	 * @param balance
	 * @param accountNumber
	 * @param amount
	 */

	public synchronized void withdraw(double withdrawAmount, int accountNumber, ArrayList<MiniBank> banklist) {
		DecimalFormat formatter = new DecimalFormat("#,###.00");
		for (MiniBank bank : banklist) {
			if (bank.getAccountNumber() == accountNumber) {
				if (bank.getBalance() < withdrawAmount) {
					System.out.println("Insufficient amount");
				} else {
					bank.setBalance(bank.getBalance() - withdrawAmount);
					System.out.println(bank.getAccountNumber() + "\t" + bank.getBalance() + "\t$"
							+ formatter.format(bank.getBalance()));
					break;
				}
				System.out.println(" Account does not exists");
			}
		}
	}

	/**
	 * This method is used to get the amount to be deposited which gets collected
	 * from main method by synchronized it and then it calculates the balance
	 * 
	 * @param balance
	 * @param accountNumber
	 * @param amount
	 */

	public void deposit(double depositAmount, long accountNumber, ArrayList<MiniBank> miniBank) {
		DecimalFormat formatter = new DecimalFormat("#,###.00");

		for (MiniBank bank : miniBank) {
			if (bank.getAccountNumber() == accountNumber) {
				bank.setBalance(bank.getBalance() + depositAmount);
			}
			System.out.println(
					bank.getAccountNumber() + "\t" + bank.getName() + "\t$" + formatter.format(bank.getBalance()));

		}

	}

	/**
	 * This method is used to get the amount to be transferd which gets collected
	 * from main method by synchronized it and then it calculates the balance
	 * 
	 * @param balance
	 * @param accountNumber
	 * @param amount
	 */

	public void fundtransfer(double transferAmount, long accountNumber, ArrayList<MiniBank> miniBank) {
		DecimalFormat formatter = new DecimalFormat("#,###.00");
		for (MiniBank bank : miniBank) {
			if (bank.getAccountNumber() == accountNumber) {

				bank.setBalance(bank.getBalance() + transferAmount);
				bank.setBalance(bank.getBalance() - amount);
				System.out.println(bank.getAccountNumber() + "\t" + bank.getBalance() + "\t$"
						+ formatter.format(bank.getBalance()));
			}

			{
				System.out.println("Account does not exists");
			}
		}

	}

}