package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{
	public void executeUC(Scanner scanner, PizzaMemDao dao) throws UpdatePizzaException{
		String m, b, c, categorie;
		double d;
		System.out.println("Mise à jour d'une pizza");
		System.out.println("Veuillez choisir le code de la pizza à modifier");
		m = scanner.next();
		if(!dao.pizzaExists(m)){
			throw new UpdatePizzaException("Le code de la pizza est erroné ou n'existe pas");
		}
		System.out.println("Veuillez saisir le code :");
		b = scanner.next();
		System.out.println("Veuillez saisir le nom (sans espace) :");
		c = scanner.next();
		System.out.println("Veuillez saisir le prix : ");	
		d = Double.parseDouble(scanner.next());
		if(d<1){
			throw new UpdatePizzaException("Le prix est trop bas ou négatif");
		}
		System.out.println("Quelle categorie : VIANDE, SANS_VIANDE, POISSON ");
		categorie = scanner.next();
		categorie = categorie.toUpperCase();
		categorie = categorie.replace('8', '_');
		if(!CategoriePizza.exists(categorie)){
			throw new UpdatePizzaException("La categorie n'est pas valide");
		}
		dao.updatePizza(m, new Pizza(b,c,d, CategoriePizza.valueOf(categorie)));
	}
}
