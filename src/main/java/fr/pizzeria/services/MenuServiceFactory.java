package fr.pizzeria.services;


public class MenuServiceFactory{
	public static MenuService getInstance(int param){
		if(param==1){
			return new ListerPizzasService();
		}
		if(param==2){
			return new AjouterPizzaService();
		}
		if(param==3){
			return new ModifierPizzaService();
		}
		if(param==4){
			return new SupprimerPizzaService();
		}
		return null;
	}

}
