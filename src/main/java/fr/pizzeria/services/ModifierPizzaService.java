package fr.pizzeria.services;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{
	private static final Logger LOGMOD = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	public void executeUC(Scanner scanner, PizzaDao dao) throws UpdatePizzaException{
		String m, b, c, categorie;
		double d;
		LOGMOD.info("Mise à jour d'une pizza");
		LOGMOD.info("Veuillez choisir le code de la pizza à modifier");
		m = scanner.next();
		if(!dao.pizzaExists(m)){
			throw new UpdatePizzaException("Le code de la pizza est erroné ou n'existe pas");
		}
		LOGMOD.info("Veuillez saisir le code :");
		b = scanner.next();
		LOGMOD.info("Veuillez saisir le nom (sans espace) :");
		c = scanner.next();
		LOGMOD.info("Veuillez saisir le prix : ");	
		d = Double.parseDouble(scanner.next());
		if(d<1){
			throw new UpdatePizzaException("Le prix est trop bas ou négatif");
		}
		LOGMOD.info("Quelle categorie : VIANDE, SANS_VIANDE, POISSON ");
		categorie = scanner.next();
		categorie = categorie.toUpperCase();
		categorie = categorie.replace('8', '_');
		if(!CategoriePizza.exists(categorie)){
			throw new UpdatePizzaException("La categorie n'est pas valide");
		}
		dao.updatePizza(m, new Pizza(b,c,d, CategoriePizza.valueOf(categorie)));
	}
}
