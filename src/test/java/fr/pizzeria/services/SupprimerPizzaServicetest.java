package fr.pizzeria.services;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.SavePizzaException;

public class SupprimerPizzaServicetest {
    
    @Rule
    public TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();  
    
    @Test
    public void testExecuteUC() throws SavePizzaException{        
        SupprimerPizzaService delMenu = new SupprimerPizzaService();
        PizzaMemDao dao = new PizzaMemDao();
        
        systemInMock.provideLines("PEP");
		delMenu.executeUC(new Scanner(System.in), dao);
    }
}