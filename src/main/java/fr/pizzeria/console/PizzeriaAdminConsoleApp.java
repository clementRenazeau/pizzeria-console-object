package fr.pizzeria.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lowagie.text.DocumentException;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.services.MenuService;
import fr.pizzeria.services.MenuServiceFactory;

public class PizzeriaAdminConsoleApp {
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
    //public static final String RESULT = "c:/Users/ETY1/Desktop/javaAO/tp2/hello.pdf";
	public static void main(String[] args){ 
		Scanner questionUser = new Scanner(System.in);
		PizzaDao dao= new PizzaMemDao();
		
		/*try {
			new createPdf(RESULT);
		} catch (DocumentException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		LOG.info("Bonjour sur le menu de contrôle de la Pizzeria !");
		while(true){
			LOG.info("1. Lister les Pizzas.");
			LOG.info("2. Ajouter une nouvelle pizza");
			LOG.info("3. Mettre à jour une pizza");
			LOG.info("4. Supprimer une pizza");
			LOG.info("99. Sortir");
		int a = Integer.parseInt(questionUser.next());	
		MenuService service=MenuServiceFactory.getInstance(a);
		if(a!=99){
			try {
				service.executeUC(questionUser, dao);
			} catch (StockageException e) {
				LOG.error(e.getMessage());
			}
		}

		else{
			LOG.info("Aurevoir \u2639");
			break;
		}
		}
	}

}
