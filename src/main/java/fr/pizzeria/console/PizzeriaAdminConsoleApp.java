package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.services.*;
import fr.pizzeria.dao.*;

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
		if(a==1){
			service.executeUC(questionUser, dao);
		}
		if(a==2){
			service.executeUC(questionUser, dao);
		}
		if(a==3){
			service.executeUC(questionUser, dao);
		}
		if(a==4){
			service.executeUC(questionUser, dao);
		}
		if(a==99){
			System.out.println("Aurevoir \u2639");
			break;
		}
		}
	}
}
