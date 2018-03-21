package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements PizzaDao {
	private static List<Pizza> listOfPizza= new ArrayList<Pizza>();
	
	static{
		listOfPizza.add(new Pizza(0, "PEP", "Pépéroni", 12.50));
		listOfPizza.add(new Pizza("MAR", "Margherita", 14.00));
		listOfPizza.add(new Pizza("REIN", "La_Reine", 11.50));
		listOfPizza.add(new Pizza("FRO", "La_4_Fromages", 12.00));
		listOfPizza.add(new Pizza("CAN", "La_Cannibale", 12.50));
		listOfPizza.add(new Pizza("SAV", "La_Savoyarde", 13.00));
		listOfPizza.add(new Pizza("ORI", "L'Orientale", 13.50));
		listOfPizza.add(new Pizza("IND", "L'Indienne", 14.00));
	}

	public List<Pizza> findAllPizzas() {
		return listOfPizza;
	}

	public void saveNewPizza(Pizza pizza) {
		listOfPizza.add(pizza);	
	}

	public Pizza findPizzaByCode(String codePizza) {
		int place=0;
		while(!listOfPizza.get(place).getCode().contentEquals(codePizza)){
			++place;
		}
		return listOfPizza.get(place);
	}
	
	public void updatePizza(String codePizza, Pizza pizza) {
		listOfPizza.set(findPizzaByCode(codePizza).getId(), pizza);
	}

	public void deletePizza(String codePizza) {
		listOfPizza.remove(findPizzaByCode(codePizza));
	}

	public boolean pizzaExists(String codePizza) {
		int place=0;
		while(!listOfPizza.get(place).getCode().contentEquals(codePizza) 
				&& (place<listOfPizza.size()-1)){
			++place;
		}
		return (listOfPizza.get(place).getCode().contentEquals(codePizza))?true:false;
	}

}
