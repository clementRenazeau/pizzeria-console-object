package fr.pizzeria.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService{
	private static final Logger LOGLIS = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	public void executeUC(Scanner scanner, PizzaDao dao){
		List<Pizza> local = dao.findAllPizzas();
		LOGLIS.info("Liste des pizzas");
		for(Pizza pizza : local){
			LOGLIS.info(pizza.toString());
		}
	}
}
