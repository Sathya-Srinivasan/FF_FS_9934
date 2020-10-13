package com.hcl.day29a;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.hcl.day29.*;

/**
 * Day#:29
 * 
 * Topic : Core Java
 * 
 * This class is used to get the bankAccount and display the balance
 * 
 * @author Sathya
 *
 *
 */
public class MiniBankMain {
	ArrayList<MiniBank> banklist = new ArrayList<MiniBank>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MiniBankMain bank = new MiniBankMain();
		// Scanner input = new Scanner(system.in);

		/*
		 * try { FileInputStream fos = new FileInputStream("C:\\minibank.txt");
		 * ObjectInputStream oos = new ObjectInputStream(fos); bank.banklist =
		 * (ArrayList) oos.readObject(); oos.close(); fos.close(); }catch(Exception e) {
		 * System.out.println("Error in reading file" + e.getMessage()); }
		 */

		String choice = "quit";
		try {
			System.out.println("Welcome to MiniBank");
			do {
				System.out.println("Enter the command(add/balance/withdraw/deposit/fundTransfer/quit");
				choice = input.next();
				switch (choice) {
				case "add":
					bank.add(input);
					break;
				case "balance":
					bank.balance(input);
					break;
				case "withdraw":
					bank.withdraw(input);
					break;
				case "deposit":
					bank.deposit(input);
					break;
				case "fundTransfer":
					bank.fundTransfer(input);
					break;
				case "quit":
					System.out.println("Good Bye");
					break;
				default:
					System.out.println("Sorry but " + choice + " is not a valic command.Please try again. ");
				}

			} while (!(choice.equals("quit")));
		}
		/*
		 * input.close(); try { FileOutputStream fos = new
		 * FileOutputStream("C:miinibank.txt"); ObjectOutputStream oos = new
		 * ObjectOutputStream(fos); oos.writeObject(bank.banklist); oos.close();
		 * fos.close(); System.out.println("Account details are successfully inserted");
		 * }
		 */
		catch (Exception e) {
			System.out.println("Valid data must be entered" + e.getMessage());
		}
	}

	private void fundTransfer(Scanner input) {
		System.out.println("From Account");
		int fromAccount = input.nextInt();
		if (checkAccount(fromAccount)) {
			System.out.println("Amount to be transfered");
			int amount = input.nextInt();
			System.out.println("To Account");
			int toAccount = input.nextInt();
			if (checkAccount(toAccount)) {
				Account obj = new Account();
				WithdrawThread wThread = new WithdrawThread(obj, amount, fromAccount, banklist);
				Thread thread = new Thread(wThread, "ATM");
				thread.start();
				System.out.println("Sender's withdrawl is Successfull");
				DepositThread dThread = new DepositThread(obj, amount, toAccount, banklist);
				Thread thread1 = new Thread(dThread, "ATM");
				thread1.start();
				System.out.println("Receiver's deposit is Successfull");
			} else {
				System.out.println("No");
			}

		} else {
			System.out.println("No");
		}

	}

	/**
	 * This method is used for getting the input from the user
	 * 
	 * @param input
	 */

	public void add(Scanner input) {
		System.out.println("AccountNumber");
		int accountNumber = input.nextInt();
		System.out.println("Name:");
		String name = input.next();
		double balance = 0;
		try {
			System.out.println("Balance($) : ");
			balance = input.nextDouble();
		} catch (Exception e) {
			System.out.println("Please enter the valid balance");
		}

		banklist.add(new MiniBank(accountNumber, name, balance));
	}

	/**
	 * This Balance Method is used to check the balanceof the user
	 * 
	 * @param input
	 * 
	 * @return
	 * 
	 */

	void balance(Scanner input) {
		DecimalFormat form = new DecimalFormat("#,###.00");
		System.out.println("AccountNumber");
		int accountNumber = Integer.parseInt(input.nextLine());
		for (MiniBank bank : banklist) {
			if (bank.getAccountNumber() == accountNumber) {
				System.out.println(
						bank.getAccountNumber() + "  " + bank.getName() + "  " + form.format(bank.getBalance()));
			} else {
				System.out.println("No account exists");
			}
		}
		return;
	}

	/**
	 * 
	 * This withdraw method is used to withdraw the amount from the user's account
	 * number
	 * 
	 * @param input
	 */
	void withdraw(Scanner input) {
		System.out.println("Account Number");
		int accountNumber = input.nextInt();

		for (MiniBank bank : banklist) {

			if (bank.getAccountNumber() == accountNumber) {
				System.out.println("Withdrawl amount:");
				double withdrawAmt = input.nextDouble();
				Account obj = new Account();
				WithdrawThread wThread = new WithdrawThread(obj, withdrawAmt, accountNumber, banklist);
				Thread thread = new Thread(wThread, "ATM");
				thread.start();
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println("Exception occured" + e);
				}

			}
		}

	}

	/**
	 * 
	 * This deposit method is used to deposit the amount to the user's account
	 * number
	 * 
	 * @param input
	 */
	public void deposit(Scanner input) {
		System.out.println("Account Number");
		int accountNumber = input.nextInt();

		for (MiniBank bank : banklist) {

			if (bank.getAccountNumber() == accountNumber) {
				System.out.println("Deposit amount:");
				double depositAmount = input.nextDouble();
				Account obj = new Account();
				DepositThread dThread = new DepositThread(obj, depositAmount, accountNumber, banklist);
				Thread thread = new Thread(dThread, "ATM");
				thread.start();
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println("Exceptiom occured" + e);
				}

			}
		}
	}

	/**
	 * This method is used checking whether the account number is valid or not
	 * 
	 * @param accountNumber
	 */

	private boolean checkAccount(int accountNumber) {
		for (MiniBank list : banklist) {
			if (list.getAccountNumber() == accountNumber) {
				return true;
			}
		}
		return false;
	}
	
	
	interface Bank{
		/**
		 * This method is used for making the account to null so that it goes to inactive
		 * 
		 * @param
		 */
		
		
		public default boolean closeAccount(MiniBank a)  { 
			try{
		
			a.setInActive(true);
			System.out.println("Account is closed");
			return true;
		}catch(Exception e) {
			System.out.println("Error in closing account");
		}
			return false;
	}
	}
}
