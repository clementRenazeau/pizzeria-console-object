package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("viande"), POISSON("poisson"), SANS_VIANDE("sans viande");
	
	private String name;
	
	private CategoriePizza(String name){
		this.name=name;
	}	
	public String getName(){
		return name;
	}	
	public static boolean exists(String chaine){
		for(CategoriePizza categorie: values()){
			if(categorie.name().equals(chaine)){
				return true;
			}
		}
		return false;
	}
}
