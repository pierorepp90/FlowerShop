package com.front.view;

import com.front.domain.Window;
import com.crud.controller.BusinessController;
import com.crud.controller.BusinessController.Color;
import com.crud.controller.BusinessController.Material;

@SuppressWarnings("unused") // for console tests
public abstract class MainApp {

	public static void main(String[] args) {
		Window w = new Window();
		w.setVisible(true);

		//CONSOLE TESTS AVAIBLE
/*	
		BusinessController c = new BusinessController();		//controller instance
		c.createBusiness("Navarro");							//store creation
		c.getAllBusiness().forEach(System.out::println);		//show stock: zeroed for now 
		c.createDecoration("Decor1", Material.Plastic, 20.0, "1");		//products creations: 
		c.createFlower("Rose", Color.Blue, 5.0, "1");
		c.createTree("Roble", 1.5, 33.50, "naVaRro");
		c.createFlower("Jacinto", Color.Red, 2.0, "NAVARRO");
		c.createDecoration("Decor2", Material.Wood, 10.0, "navarro");
		c.createTree("Primavera", 2.3, 50.75, "1");
		c.createFlower("jasmin", Color.Yellow, 3.0, "Navarro");
		c.createTree("Erro", 1.5, 33.50, "one");						//product creation: with error!
		c.getAllBusiness().forEach(System.out::println);		//show stock: fully now 
		c.showStock("one");										//stock detailing
		c.showStock("1");										//stock detailing: with error!
*/	

	}

}
