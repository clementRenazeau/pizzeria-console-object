package fr.pizzeria.services;


import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;

public abstract class MenuService {
	public abstract void executeUC(Scanner scanner, PizzaMemDao dao);
}
