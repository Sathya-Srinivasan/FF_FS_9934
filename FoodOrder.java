package com.hcl.day31b;
import java.util.Date;

/**
 * @author Sathya
 *
 */
public class FoodOrder {
  private Date orderDate;
  private String items;
  private String status;
  private double price;
  private String place;
  private String orderOwner;

/**
 * @param orderDate
 * @param items
 * @param status
 * @param price
 * @param place
 */
public FoodOrder(String orderOwner,Date orderDate, String items, String status, double price, String place) {
	super();
	this.orderOwner = orderOwner;
	this.orderDate = orderDate;
	this.items = items;
	this.status = status;
	this.price = price;
	this.place = place;
}



/**
 * @return the orderOwner
 */
public String getOrderOwner() {
	return orderOwner;
}



/**
 * @param orderOwner the orderOwner to set
 */
public void setOrderOwner(String orderOwner) {
	this.orderOwner = orderOwner;
}



/**
 * @return the orderDate
 */
public Date getOrderDate() {
	return orderDate;
}

/**
 * @param orderDate the orderDate to set
 */
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}

/**
 * @return the items
 */
public String getItems() {
	return items;
}

/**
 * @param items the items to set
 */
public void setItems(String items) {
	this.items = items;
}

/**
 * @return the status
 */
public String getStatus() {
	return status;
}

/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}

/**
 * @return the price
 */
public double getPrice() {
	return price;
}

/**
 * @param price the price to set
 */
public void setPrice(double price) {
	this.price = price;
}

/**
 * @return the place
 */
public String getPlace() {
	return place;
}

/**
 * @param place the place to set
 */
public void setPlace(String place) {
	this.place = place;
}
  
 
}