package com.hcl.day30;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	private double withdrawAmount;

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
	 * Balance Method
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

	void deposit(Scanner input) {
    	  System.out.println("Account Number");
          int accountNumber = input.nextInt();
     	 
     	  for(MiniBank bank :banklist) {
     	 
       		 if(bank.getAccountNumber() == accountNumber)
       		 {
       			 System.out.println("Deposit amount:");
       			 double depositAmount = input.nextDouble();
       			 Account obj = new Account();
       			 DepositThread dThread = new DepositThread(obj, depositAmount, accountNumber, banklist);
       			 Thread thread = new Thread(dThread, "ATM");
       			 thread.start();
       			 try {
       	 			 Thread.sleep(1000);
       	 		 }
       	 		 catch(Exception e)
       	 		 {
       	 			 System.out.println("Exceptiom occured" + e);
       	 		 } 
       			
       		 }
      }
      

     	    void fundtransfer(Scanner input1) {
     		System.out.println("Give Account Number");
     		int fromAccountNumber1 = input.nextInt();
     	int balance = balance(fromAccountNumber1);
     		if(balance !=-1)
     		{
     			System.out.println("To account Number");
     			int toAccountNumber1 = input.nextInt();
     			Account acn = new Account(fromAccountNumber, banklist,balance,toAccountNumber1);
     	 System.out.println("Transfer Amount");
     			TransferThread tThread = new TransferThread(acn, input.nextDouble(), toAccountNumber1, banklist);
     			Thread thread2 = new (tThread, "online");
     					thread2.start();
     					
     		}
     	    }
    	  
      }
}
