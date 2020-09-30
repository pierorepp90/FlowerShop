package com.crud.domain;

/**
 * class that builds a tree product.
 * extends class ObjectForSale,
 * increments the height attribute.
 * @author FaunoGuazina & pierorepp90
 *
 */
public class Tree extends ObjectForSale {

    public double height;

    /**
     * only constructor
     * @param height double value
     * @param price double value (super constructor)
     */
    public Tree(String name, double height,double price){
        super(name, price);
        this.height = height;
    }
    
    //Getter and Setter
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Tree [" + "ID=" + getId() + ", Name=" + getName() + ", Height=" + height + ", Price=" + getPrice() + "]";
	}
    
}
