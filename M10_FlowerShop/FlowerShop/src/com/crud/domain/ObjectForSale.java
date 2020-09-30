package com.crud.domain;

/**
 * basic abstract class that acts as an umbrella for products.
 * consists of integer id and double price.
 * @author FaunoGuazina & pierorepp90
 *
 */
public abstract class ObjectForSale {

	private String name;
    private double price;
    private int id;
    private static int counterId = 1;

    /**
     * only constructor:
     * has id assignment mechanism.
     * @param price double value
     * @param name string value
     */
    public ObjectForSale(String name, double price){
        this.name = name;
        this.price = price;
        id = counterId;
        ObjectForSale.counterId++;
    }
    
    //Getters and Setter
    public int getId() {
    	return id;
    }

    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price) {
    	this.price = price;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
