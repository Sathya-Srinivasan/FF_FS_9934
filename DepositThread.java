package com.hcl.day30;

import java.util.ArrayList;

import com.hcl.day29.MiniBank;

/**
 * Topic : Core Java
 * 
 * This class is used to do deposit operation
 * 
 * @author Sathya
 *
 */
public class DepositThread implements Runnable {
	private double depositAmount;
	private Account obj;
	private long accountNumber;
	ArrayList<MiniBank> miniBank;
	/*
	 * This is a parameterized constructor which is created for the class. This
	 * consists of fields like object which is created for the synchronized class
	 * and the money to be given.
	 * 
	 * @param amount
	 */

	public DepositThread(Account a, double depositAmount, long accountNumber, ArrayList<MiniBank> bankList) {
		this.obj = a;
		this.accountNumber = accountNumber;
		this.depositAmount = depositAmount;
		miniBank = bankList;
	}

	/*
	 * 
	 * This is the overridden method from thread class which is used for execution
	 * of small process in a single process.
	 */
	@Override
	public void run() {
		obj.deposit(depositAmount, accountNumber, miniBank);

	}
	/**
	 * @param obj
	 * @param amount
	 */
}
