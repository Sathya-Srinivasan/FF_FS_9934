package com.hcl.day31b;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * Day :#31
 * 
 * Topic : Core Java
 * 
 * This class is used to order the food and performs methods like add, read and
 * update method
 * 
 * @author Sathya
 *
 */
public class FoodOrderMain {
	ArrayList<FoodOrder> food = new ArrayList<FoodOrder>();
	 static Logger log = Logger.getLogger(FoodOrderMain.class.getName());  
	public static void main(String[] args) {
		FoodOrderMain foodOrderMain = new FoodOrderMain();
		Scanner input = new Scanner(System.in);

		String choice = "quit";
		try {
			System.out.println("Welcome to Food Ordering");
			do {
				System.out.println("Enter the command(add/read/update/delete/quit)");
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
				case "delete":
					foodOrderMain.delete();
					break;
				default:
					System.out.println("Sorry " + choice);
				}

			} while (!(choice.equals("Not Available")));
		}

		catch (Exception e) {
			System.out.println("Give valid items" + e.getMessage());
		}
	}

	/*
	 * This method is used to add food details like Order owner, Items, Status,
	 * Price, Place
	 * 
	 * @param input
	 */

	public void add() {
		Scanner input = new Scanner(System.in);

		Date dt = new Date();
		System.out.println("Order Owner");
		String orderOwner = input.nextLine();
		System.out.println("items");
		String items = input.nextLine();

		System.out.println("status");
		String status = input.nextLine();

		System.out.println("price");
		double price = input.nextDouble();

		System.out.println("place");
		String place = input.next();

		food.add(new FoodOrder(orderOwner, dt, items, status, price, place));

	}

	/*
	 * This method is used to read the list of food items which have been ordered.
	 * 
	 * @param input
	 */

	public void read() {
		Scanner input = new Scanner(System.in);

		System.out.println("List of Food items Ordered:");

		for (FoodOrder fo : food) {
			System.out.println("Order Owner:" + fo.getOrderOwner());
			System.out.println("Order Date:" + fo.getOrderDate());
			System.out.println("Items:" + fo.getItems());
			System.out.println("Status:" + fo.getStatus());
			System.out.println("Price:" + fo.getPrice());
			System.out.println("Place:" + fo.getPlace());

		}
	}

	/*
	 * This method is used to update the food order details
	 * 
	 * @param input
	 */
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

		food.add(new FoodOrder(owner, dt, items, status, price, place));

		System.out.println("Order for " + owner + " has been updated successfully.");

		/*
		 * food.removeIf(e -> e.getOrderOwner().equals(owner)); } else {
		 * System.out.println("No items found"); }
		 */
	}

	public void delete() {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Order Owner Name to be deleted:");
		String items = input.nextLine();
		// if (food.contains(owner)) {

		// Date dt = new Date();
		// System.out.println("Items");
		// String items = input.nextLine();
		/*
		 * System.out.println("Status"); String status = input.nextLine();
		 * 
		 * System.out.println("price"); double price = input.nextDouble();
		 * 
		 * System.out.println("place"); String place = input.next();
		 */

		food.removeIf(e -> e.getOrderOwner().equals(items));

		System.out.println("Order for " + items + " has been deleted successfully.");

	}
}