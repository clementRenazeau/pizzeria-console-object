package fr.pizzeria.services;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;

public class ModifierPizzaServiceTest {
	
    @Rule
    public TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();  
	
	@Test (expected = UpdatePizzaException.class)
	public void testModifierPizza()throws UpdatePizzaException{
		systemInMock.provideLines("REM");
		PizzaDao mockedDao = Mockito.mock(PizzaDao.class);
		Mockito.when(mockedDao.pizzaExists(Mockito.anyString())).thenReturn(false);
		ModifierPizzaService modServ = new ModifierPizzaService();
		modServ.executeUC(new Scanner(System.in), mockedDao);
	}
}
