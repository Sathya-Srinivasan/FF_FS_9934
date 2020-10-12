package com.hcl.day30;

import java.util.ArrayList;

import com.hcl.day29.MiniBank;

/**
 * Topic : Core Java
 * 
 * This class is used to fund transfer operation
 * 
 * @author Sathya
 *
 */
public class TransferThread {

	private double TransferAmount;
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
	public TransferThread(Account acn, double transferAmount, long accountNumber, ArrayList<MiniBank> bankList) {
		this.obj = acn;
		this.accountNumber = accountNumber;
		this.TransferAmount = transferAmount;
		miniBank = bankList;
	}

}
