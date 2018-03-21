package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.services.*;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.StockageException;

public class PizzeriaAdminConsoleApp {

	
	public static void main(String[] args){ 
		Scanner questionUser = new Scanner(System.in);
		PizzaMemDao dao= new PizzaMemDao();
		
		while(true){
		System.out.println("***** Pizzeria Administration *****"
				+ "\n1. Lister les pizzas"
				+ "\n2. Ajouter une nouvelle pizza"
				+ "\n3. Mettre à jour une pizza"
				+ "\n4. Supprimer une pizza"
				+ "\n99. Sortir");
		int a = Integer.parseInt(questionUser.next());	
		MenuService service=MenuServiceFactory.getInstance(a);
		if(a!=99){
			try {
				service.executeUC(questionUser, dao);
			} catch (StockageException e) {
				System.out.println(e.getMessage());
			}
		}

		else{
			System.out.println("Aurevoir \u2639");
			break;
		}
		}
	}
}
