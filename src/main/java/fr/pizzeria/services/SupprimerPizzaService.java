package fr.pizzeria.services;

import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService extends MenuService{
	private static final Logger LOGSUP = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	public void executeUC(Scanner scanner, PizzaDao dao){
		List<Pizza> local = dao.findAllPizzas();
		LOGSUP.info("Suppression d'une pizza");
		LOGSUP.info("Liste des pizzas");
		for(Pizza pizza : local){
			LOGSUP.info(pizza.toString());
		}
		String b;
		LOGSUP.info("Veuillez choisir le code de la pizza à supprimer");
		b = scanner.next();
		if(dao.pizzaExists(b)){
			dao.deletePizza(b);
		}

	}
}
