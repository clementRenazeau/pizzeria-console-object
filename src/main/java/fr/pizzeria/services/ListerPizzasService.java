package fr.pizzeria.services;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService{
	public void executeUC(Scanner scanner, PizzaMemDao dao){
		List<Pizza> local = dao.findAllPizzas();
		System.out.println("Liste des pizzas");
		for(Pizza pizza : local){
			System.out.println(pizza.getCode() + "->" 
		+ pizza.getLibelle() 
		+ " (" + pizza.getPrix() + ")"
		+ pizza.getCategorie());
		}
	}
}
