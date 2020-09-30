package com.crud.domain;

/**
 * class that builds a decoration product.
 * extends class ObjectForSale,
 * increments the material attribute.
 * @author FaunoGuazina & pierorepp90
 *
 */
public class Decoration extends ObjectForSale {

    private String material;
    
    /**
     * only constructor
     * @param material string
     * @param price double value (super constructor)
     */
    public Decoration(String name, String material, double price){
    	super(name, price);
    	this.material = material;
    }

    //Getter and Setter
	public String getWoodOrPlastic() {
		return material;
	}

	public void setWoodOrPlastic(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Decoration [" + "ID=" + getId() + ", Name=" + getName() + ", Material=" + material + ", Price=" + getPrice() + "]";
	}
    
}
