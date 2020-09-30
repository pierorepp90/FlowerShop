package com.crud.persistence;

import com.crud.domain.Business;

import java.util.ArrayList;
import java.util.List;

/**
 * class that stores the shops created for selling flowers
 * @author FaunoGuazina & pierorepp90
 *
 */
public final class BusinessRepository {

	private static List<Business> stores;

	//Constructor
	public BusinessRepository() {
		stores = new ArrayList<>();
	}

	//Getter
	public List<Business> getAllBusiness() {
		return new ArrayList<>(stores);
	}

	//method that adds a store to the database
	public void addBusiness(Business store) {
		if (store != null) {
			stores.add(store);
		} else {
			System.out.println("Store cannot be created!");
		}
	}

}
