package com.hcl.day30;

import java.util.ArrayList;

import com.hcl.day29.MiniBank;

/**
 * Topic : Core Java
 * 
 * This class is used to to withdraw operation
 * 
 * @author Sathya
 *
 */
public class WithdrawThread implements Runnable {
	private Account obj;
	private double withdrawAmount;
	private int accountNumber;
	ArrayList<MiniBank> miniBank;

	/**
	 * This is a parameterized constructor which is created for the class. This
	 * consists of fields like object which is created for the synchronized class
	 * and the money to be given.
	 * 
	 * @param obj
	 * @param amount
	 * @param accountNumber
	 */

	public WithdrawThread(Account ac, double withdrawAmount, int accountNumber, ArrayList<MiniBank> banklist) {

		obj = ac;
		this.withdrawAmount = withdrawAmount;
		this.accountNumber = accountNumber;
		miniBank = banklist;

	}

	/*
	 * 
	 * This is the overridden method from thread class which is used for execution
	 * of small process in a single process.
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		obj.withdraw(withdrawAmount, accountNumber, miniBank);
	}

}
