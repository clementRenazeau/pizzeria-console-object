package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements PizzaDao {
	private List<Pizza> listOfPizza= new ArrayList<Pizza>();
	
	public PizzaMemDao(){
		listOfPizza.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		listOfPizza.add(new Pizza("REIN", "La_Reine", 11.50, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza("FRO", "La_4_Fromages", 12.00, CategoriePizza.SANS_VIANDE));
		listOfPizza.add(new Pizza("CAN", "La_Cannibale", 12.50, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza("SAV", "La_Savoyarde", 13.00, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza("ORI", "L'Orientale", 13.50, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza("IND", "L'Indienne", 14.00, CategoriePizza.VIANDE));
	}

	public List<Pizza> findAllPizzas() {
		return listOfPizza;
	}

	public void saveNewPizza(Pizza pizza) {
		listOfPizza.add(pizza);	
	}

	public Pizza findPizzaByCode(String codePizza){
		for(Pizza p: findAllPizzas()){
			if(p!=null && p.getCode()!=null && p.getCode().equals(codePizza)){
				return p;
			}
		}
		return null;
	}
	
	public void updatePizza(String codePizza, Pizza pizza) {
		listOfPizza.set(findPizzaByCode(codePizza).getId(), pizza);
	}

	public void deletePizza(String codePizza) {
		if(pizzaExists(codePizza)){
			listOfPizza.remove(findPizzaByCode(codePizza));
		}
	}

	public boolean pizzaExists(String codePizza) {
		for(Pizza p: findAllPizzas()){
			if(p!=null && p.getCode()!=null && p.getCode().equals(codePizza)){
				return true;
			}
		}
		return false;
	}

}
