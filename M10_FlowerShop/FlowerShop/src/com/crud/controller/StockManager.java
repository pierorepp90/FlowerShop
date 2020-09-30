package com.crud.controller;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.crud.persistence.BusinessRepository;

import com.crud.domain.Business;
import com.crud.domain.Decoration;
import com.crud.domain.Flower;
import com.crud.domain.ObjectForSale;
import com.crud.domain.Tree;


/**
 * @author FaunoGuazina & pierorepp90
 *
 */
final class StockManager {

	private final BusinessRepository repository = new BusinessRepository();

	/**
	 * basic, empty and only constructor.
	 */
	StockManager() {
	}

	/**
	 * method for building a store
	 * @param name string
	 */
	void createBusiness(String name) {
		repository.addBusiness(Factory.createBusiness(name));
	}
	
	/**
	 * method that returns a list of all stores stored in the database
	 * @return ArrayList of Business class
	 */
	public List<Business> getAllBusiness() {
		return repository.getAllBusiness();
	}
	
	/**
	 * method used to select a particular store from the database
	 * @param Store string of shop name or code id
	 * @return Business object
	 */
	Business findBusiness(String Store) {
		Business store = null;														//instantiates the variable to be returned
		try {																		//try
			Stream<Business> s = repository.getAllBusiness().stream();				//instantiate a stream from the database list
			s = (Store.chars().allMatch(Character::isDigit))						//ternary checks whether the string entered with only numbers
					? s.filter(b -> b.getId() == Integer.parseInt(Store))			//true: search store by id code
							: s.filter(b -> b.getName().equalsIgnoreCase(Store));	//false: true: search store by name
			store = s.findFirst().get();											//assigns the store the variable that will be returned
		} catch (Exception e) {														//catch
		System.out.println("NoSuchElementException: Store not founded!");			//print the error
		}
		return store;
	}

	/**
	 * method that builds a product of type Decoration and adds it to a certain store
	 * @param material string of material
	 * @param price double value
	 * @param Store string of store name or code id
	 */
	void createDecoration(String name, String material, double price, String Store) {
		Business store = findBusiness(Store);
		if (store != null) {
			store.addStock(Factory.createDecoration(name, material, price));
		}
	}

	/**
	 * method that builds a product of type Flower and adds it to a certain store
	 * @param color string of color
	 * @param price double value
	 * @param Store string of store name or code id
	 */
	void createFlower(String name, String color, double price, String Store) {
		Business store = findBusiness(Store);
		if (store != null) {
			store.addStock(Factory.createFlower(name, color, price));
		}
	}

	/**
	 * method that builds a product of type Tree and adds it to a certain store
	 * @param height double value of height
	 * @param price double value
	 * @param Store string of store name or code id
	 */
	void createTree(String name, double height, double price, String Store) {
		Business store = findBusiness(Store);
		if (store != null) {
			store.addStock(Factory.createTree(name, height, price));
		}
	}

	/**
	 * method that details all store inventory separated by category:
	 * Decoration, Flower, Tree.
	 * @param Store string of store name or code id
	 */
	void showStock(String Store) {
		Business store = findBusiness(Store);											//store instance
		if (store !=  null) {															//check if not null
			System.out.println("\n=================================================\n");//header printing
			
			System.out.println("Stock of " + store.getName() + 							//header printing
					" | Total amount Items: " + store.getStock().size());
			
			printTypeStock("Decoration", store, new Decoration("", "", 0));					//product stock printing decoration
			printTypeStock("Flowers", store, new Flower("", "", 0));						//product stock printing flowers
			printTypeStock("Tree", store, new Tree("", 0, 0));								//product stock printing trees
			
			System.out.println("\n=================================================\n");//footer printing
		}
	}
	
	/**
	 * internal method that prevents code repetition for printing stock
	 * @param type string of Decoration, Flower, Tree.
	 * @param store object of Business class
	 * @param item empty product instance for class comparison
	 */
	private void printTypeStock(String type, Business store, ObjectForSale item) {
		List<ObjectForSale> stock = store.getStock().stream()				//list from the store object stream
				.filter(x -> x.getClass().equals(item.getClass()))			//stock filtering from the item class
				.collect(Collectors.toList());								//string to list conversion
		System.out.println("\n" + type + ": " + stock.size() + " items");	//header print
		stock.forEach(System.out::println);									//stock print
	}

	/**
	 * internal and private class that acts as an object factory
	 * for Business, Decoration, Flower, Tree objects.
	 * @author FaunoGuazina & pierorepp90
	 *
	 */
	private static class Factory {

		static Business createBusiness(String name) {
			return new Business(name);
		}

		static Decoration createDecoration(String name, String material, double price) {
			return new Decoration(name, material, price);
		}

		static Flower createFlower(String name, String colour, double price) {
			return new Flower(name, colour, price);
		}

		static Tree createTree(String name, double height, double price) {
			return new Tree(name, height, price);
		}
	}

}
