package fr.pizzeria.dao;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDaoTest {
	@Test
	public void testFindAllPizzas(){
		PizzaMemDao pizzaFind = new PizzaMemDao();
		Assert.assertNotNull("La liste de Pizzas est null", pizzaFind.findAllPizzas());
	}
	@Test
	public void testSaveNewPizza(){
		Pizza newPizza = new Pizza("CRE", "La_Crevette", 9.0, CategoriePizza.POISSON); 
		PizzaMemDao pizzaSave = new PizzaMemDao();
		pizzaSave.saveNewPizza(newPizza);
		Assert.assertEquals(9, pizzaSave.findAllPizzas().size());
		for(Pizza pizza : pizzaSave.findAllPizzas()){
			Assert.assertNotNull("La pizza "+pizzaSave.findAllPizzas().indexOf(pizza)+" est null", pizza);
		}
	}
	@Test
	public void testFindPizzaByCode(){
		PizzaMemDao pizzaFindByCode = new PizzaMemDao();
		Pizza test1 = pizzaFindByCode.findPizzaByCode("IND");
		Assert.assertEquals(14.0, test1.getPrix(), 0.1);
		Pizza test2 = pizzaFindByCode.findPizzaByCode("DID");
		Assert.assertNull("La pizza test 2 existe", test2);
		
	}
	@Test
	public void testUpdatePizza(){
		PizzaMemDao pizzaUpdate = new PizzaMemDao();
		Pizza test2 = pizzaUpdate.findPizzaByCode("IND");
		Assert.assertEquals(14.0, test2.getPrix(), 0.1);
		int index = pizzaUpdate.findAllPizzas().indexOf(test2);
		Assert.assertEquals(7, index);
		Pizza change = new Pizza("CRE", "La_Crevette", 9.0, CategoriePizza.POISSON);
		pizzaUpdate.updatePizza("IND", change);
		
	}
	@Test
	public void testDeletePizza(){
		PizzaMemDao pizzaDelete = new PizzaMemDao();
		boolean test1 = pizzaDelete.pizzaExists("IND");
		Assert.assertTrue("La pizza test1 n'existe pas", test1);
		pizzaDelete.deletePizza("IND");
		boolean test2 = pizzaDelete.pizzaExists("IND");
		Assert.assertFalse("La pizza test1 n'existe pas", test2);
		
	}
	@Test
	public void testPizzaExists(){
		PizzaMemDao pizzaExists = new PizzaMemDao();
		boolean test1 = pizzaExists.pizzaExists("IND");
		Assert.assertTrue("La pizza test1 n'existe pas", test1);
		boolean test2 = pizzaExists.pizzaExists("DID");
		Assert.assertFalse("La pizza test 2 existe", test2);
	}

}
