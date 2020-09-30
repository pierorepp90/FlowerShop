package com.crud.controller;

import java.util.List;

/**
 * totally public class that controls the application 
 * and uses a manager to invoke all the necessary 
 * methods for the functioning of the program.
 * this class does not have access to any 
 * model(domain) class.
 * @author FaunoGuazina & pierorepp90
 *
 */
public final class BusinessController {

	private final StockManager manager;

	/**
	 * empty and only constructor
	 */
	public BusinessController() {
		manager = new StockManager();
	}

	/**
	 * method for building a store
	 * @param name string
	 */
	public void createBusiness(String name) {
		manager.createBusiness(name);
	}

	/**
	 * method that returns a list of all stores stored in the database
	 * @return ArrayList
	 */
	public List<?> getAllBusiness() {
		return manager.getAllBusiness();
	}

	/**
	 * method used to select a particular store from the database
	 * @param store string of shop name or code id
	 * @return Object from Object class
	 */
	public Object getStore(String store) {
		return manager.findBusiness(store);
	}

	/**
	 * method that builds a product of type Decoration and adds it to a certain store
	 * @param material enum class object
	 * @param price double value
	 * @param Store string of store name or code id
	 */
	public void createDecoration(String name, Material material, double price, String Store) {
		manager.createDecoration(name, material.toString(), price, Store);
	}

	/**
	 * method that builds a product of type Flower and adds it to a certain store
	 * @param colour enum class object
	 * @param price double value
	 * @param Store string of store name or code id
	 */
	public void createFlower(String name, Color colour, double price, String Store) {
		manager.createFlower(name, colour.toString(), price, Store);
	}

	/**
	 * method that builds a product of type Tree and adds it to a certain store
	 * @param height double value
	 * @param price double value
	 * @param Store string of store name or code id
	 */
	public void createTree(String name, double height, double price, String Store) {
		manager.createTree(name, height, price, Store);
	}

	/**
	 * method that details all store inventory separated by category:
	 * Decoration, Flower, Tree.
	 * @param Store string of store name or code id
	 */
	public void showStock(String Store) {
		manager.showStock(Store);
	}

	/**
	 * enumerated class that specific type of decoration material.
	 * restricted the creation to available materials.
	 * @author FaunoGuazina & pierorepp90
	 *
	 */
	public enum Material {
		Plastic, Wood;
	}

	/**
	 * enumerated class that specific type of flower color.
	 * restricted the creation to available colors.
	 * @author FaunoGuazina & pierorepp90
	 *
	 */
	public enum Color {
		Red, Green, Blue, Yellow;
	}
}
