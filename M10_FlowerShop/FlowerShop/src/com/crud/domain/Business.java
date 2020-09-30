package com.crud.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * class that builds an object that points to a store and its stock.
 * Each object has a unique and integer id,
 * a name in string format, a stock storage list.
 * @author FaunoGuazina & pierorepp90
 *
 */
public class Business {

    private String name;
    private List<ObjectForSale> stock = new ArrayList<>();
    private int id;
    private static int counterId = 1;
    
    /**
     * only constructor:
     * has id assignment mechanism.
     * @param name string
     */
    public Business(String name){
        this.name = name;
        id = counterId;
        Business.counterId++;
    }
    
    //Getter and Setters
    public int getId() {
    	return id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ObjectForSale> getStock() {
		return stock;
	}

	public void setStock(List<ObjectForSale> stock) {
		this.stock = stock;
	}
	
	//method that adds a product to the stock
	public void addStock(ObjectForSale itemStock) {
		stock.add(itemStock);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Business [name=");
		builder.append(name);
		builder.append(", stock=");
		builder.append(stock.size());
		builder.append(" itens]");
		return builder.toString();
	}
    
    
    
}
