package com.hcl.day29;

import java.util.Scanner;
import java.io.Serializable;

/**
 * Topic : Core Java
 * 
 * This class declares the bank details like account older name, their account
 * number and the balance in their account and this is obtained from user and
 * set it to particular variable.
 * 
 * @author Sathya
 *
 */
public class MiniBank implements Serializable {
	private int accountNumber;
	private String name;
	private double balance;
	// private double withdraw;
	// private double deposit;

	/**
	 * This is a parameterized constructor which is used to assign variables
	 * 
	 * @param accountNumber
	 * @param name
	 * @param balance
	 * @param withdraw
	 * @param deposit
	 */
	/**
	 */
	public MiniBank(int accountNumber, String Name, double balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		// this.withdraw = withdraw;
		// this.deposit = deposit;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the withdraw
	 */
	/*
	 * public double getWithdraw() { return withdraw; } /**
	 * 
	 * @param withdraw the withdraw to set
	 */
	/*
	 * public void setWithdraw(double withdraw) { this.withdraw = withdraw; } /**
	 * 
	 * @return the deposit
	 */
	/*
	 * public double getDeposit() { return deposit; } /**
	 * 
	 * @param deposit the deposit to set
	 */
	// public void setDeposit(double deposit) {
	// this.deposit = deposit;
}
