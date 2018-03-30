package fr.pizzeria.services;


import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.StockageException;

public abstract class MenuService {
	public abstract void executeUC(Scanner scanner, PizzaDao dao) throws StockageException;
}
