package com.hcl.day31b;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *  Day :#31
 *  
 * Topic : Core Java
 * 
 * This class is used to order the food and performs add, read and update method
 * 
 * @author Sathya
 *
 */
public class FoodOrderMain {
	ArrayList<FoodOrder> food = new ArrayList<FoodOrder>();

	public static void main(String[] args) {
		FoodOrderMain foodOrderMain = new FoodOrderMain();
		Scanner input = new Scanner(System.in);

		String choice = "quit";
		try {
			System.out.println("Welcome to Food Ordering");
			do {
				System.out.println("Enter the command(add/read/update/quit)");
				choice = input.next();
				switch (choice) {
				case "add":
					foodOrderMain.add();
					break;
				case "read":
					foodOrderMain.read();
					break;
				case "update":
					foodOrderMain.update();
					break;

				default:
					System.out.println("Sorry but " + choice);
				}

			} while (!(choice.equals("quit")));
		}

		catch (Exception e) {
			System.out.println("Valid data must be entered" + e.getMessage());
		}
	}

	public void add() {
		Scanner input = new Scanner(System.in);
		Date dt = new Date();
		System.out.println("Order Owner");
		String orderOwner = input.nextLine();
		System.out.println("Items");
		String items = input.nextLine();

		System.out.println("Status");
		String status = input.nextLine();

		System.out.println("price");
		double price = input.nextDouble();

		System.out.println("place");
		String place = input.next();

		food.add(new FoodOrder(orderOwner, dt, items, status, price, place));

	}

	public void read() {
		Scanner input = new Scanner(System.in);

		System.out.println("List of Food items Ordered:");
		for (FoodOrder fo : food) {
			System.out.println(
					"Order Owner:" + fo.getOrderOwner() + "|Order Date:" + fo.getOrderDate() + "|Items:" + fo.getItems()
							+ "|Status:" + fo.getStatus() + "|Price:" + fo.getPrice() + "|Place:" + fo.getPlace());
		}
	}

	public void update() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Order Owner Name to be Edited:");
		String owner = input.nextLine();
		// if (food.contains(owner)) {

		Date dt = new Date();
		System.out.println("Items");
		String items = input.nextLine();

		System.out.println("Status");
		String status = input.nextLine();

		System.out.println("price");
		double price = input.nextDouble();

		System.out.println("place");
		String place = input.next();
		food.removeIf(e -> e.getOrderOwner().equals(owner));
		food.add(new FoodOrder(owner, dt, items, status, price, place));

		// int index = food.indexOf(owner);
		// food.set(index, new FoodOrder(owner, dt, items, status, price, place));
		System.out.println("Order for " + owner + " has been updated successfully.");

		/*
		 * } else { System.out.println("No items found"); }
		 */
	}
}
