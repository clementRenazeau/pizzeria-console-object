package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService{
	public void executeUC(Scanner scanner, PizzaMemDao dao){
		String b, c;
		double d;
		System.out.println("Ajout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code :");
		b = scanner.next();
		System.out.println("Veuillez saisir le nom (sans espace) :");
		c = scanner.next();
		System.out.println("Veuillez saisir le prix : ");
		d = Double.parseDouble(scanner.next());
		dao.saveNewPizza(new Pizza(b, c, d));
	}
}
